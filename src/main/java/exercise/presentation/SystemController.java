package exercise.presentation;

import exercise.application.SystemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    private final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/memory")
    public String readMemory() {
        return systemService.calculateMemoryUsage();
    }
}
