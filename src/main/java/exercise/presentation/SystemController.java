package exercise.presentation;

import exercise.application.SystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SystemController {

    private final SystemService systemService;

    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/memory")
    public String readMemory() {
        String memory = systemService.calculateMemoryUsage();
        log.info(memory);
        return memory;
    }
}
