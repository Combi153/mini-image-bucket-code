package exercise.application;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3Service {

    private final AmazonS3 amazonS3;
    private final String bucket;
    private final String domain;
    private final String root;
    private final String directory;

    public S3Service(
            AmazonS3 amazonS3,
            @Value("${cloud.aws.s3.bucket}") String bucket,
            @Value("${file.common.domain}") String domain,
            @Value("${file.common.root}") String root,
            @Value("${file.common.directory}") String directory
    ) {
        this.amazonS3 = amazonS3;
        this.bucket = bucket;
        this.domain = domain;
        this.root = root;
        this.directory = directory;
    }

    public String upload(MultipartFile file) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        String base = root + directory;
        String path = base + file.getOriginalFilename();

        try {
            amazonS3.putObject(bucket, path, file.getInputStream(), metadata);
            return getImageUrl(amazonS3.getUrl(bucket, path).toString(), base);
        } catch (IOException | AmazonServiceException e) {
            throw new RuntimeException("파일을 업로드하지 못했습니다.", e);
        }
    }

    private String getImageUrl(String s3Url, String path) {
        int fileNameStart = s3Url.indexOf(path);
        return domain + s3Url.substring(fileNameStart - 1);
    }
}
