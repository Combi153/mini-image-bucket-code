package exercise.application;

import exercise.domain.Image;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ImageServiceFacade {

    private final ImageService imageService;
    private final S3Service s3Service;

    public void save(MultipartFile file) {
        String imageUrl = s3Service.upload(file);
        imageService.save(new Image(imageUrl));
    }

    public List<Image> readAll() {
        return imageService.readAll();
    }
}
