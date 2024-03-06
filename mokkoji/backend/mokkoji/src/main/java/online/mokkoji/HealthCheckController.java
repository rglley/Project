package online.mokkoji;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("${api.version}")
public class HealthCheckController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}

