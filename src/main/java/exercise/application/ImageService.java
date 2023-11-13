package exercise.application;

import exercise.domain.Image;
import exercise.domain.ImageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @CacheEvict(cacheNames = "images")
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Cacheable(cacheNames = "images")
    @Transactional(readOnly = true)
    public List<Image> readAll() {
        return imageRepository.findAll();
    }
}
