package exercise.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ImageRepository {

    private final List<Image> images = new ArrayList<>();

    public void save(Image image) {
        images.add(image);
    }

    public List<Image> findAll() {
        return new ArrayList<>(images);
    }
}
