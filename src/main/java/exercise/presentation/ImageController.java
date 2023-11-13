package exercise.presentation;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import exercise.application.ImageServiceFacade;
import exercise.domain.Image;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
public class ImageController {

    private final ImageServiceFacade imageServiceFacade;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping(value = "/images", consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public String save(
            @RequestPart(value = "file") MultipartFile file,
            RedirectAttributes redirectAttributes
    ) {
        imageServiceFacade.save(file);
        redirectAttributes.addFlashAttribute("message", "이미지가 성공적으로 업로드 되었습니다.");
        return "redirect:/images";
    }

    @GetMapping("/images")
    public String readAll(Model model) {
        List<Image> images = imageServiceFacade.readAll();
        model.addAttribute("images", images);
        return "images";
    }
}
