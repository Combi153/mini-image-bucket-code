package exercise.application;

import exercise.domain.Image;
import exercise.domain.ImageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Transactional
@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final S3Service s3Service;

    public void save(MultipartFile file) {
        String imageUrl = s3Service.upload(file);
        imageRepository.save(new Image(imageUrl));
    }

    @Transactional(readOnly = true)
    public List<Image> readAll() {
        return imageRepository.findAll();
    }
}
