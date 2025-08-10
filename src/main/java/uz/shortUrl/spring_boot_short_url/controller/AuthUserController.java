package uz.shortUrl.spring_boot_short_url.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.shortUrl.spring_boot_short_url.dto.auth.AuthUserCreateDto;
import uz.shortUrl.spring_boot_short_url.dto.auth.GenerateTokenRequest;
import uz.shortUrl.spring_boot_short_url.service.AuthUserService;
import uz.shortUrl.spring_boot_short_url.utils.BaseUtils;
import uz.shortUrl.spring_boot_short_url.utils.MailSenderService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthUserController {
    private final AuthUserService authUserService;

    @PostMapping("/generate-token")
    public ResponseEntity<String> generateToken(@Valid GenerateTokenRequest request) {
        return ResponseEntity.ok(authUserService.generateToken(request));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid AuthUserCreateDto request) {
        return ResponseEntity.status(201).body(authUserService.register(request));
    }

    @GetMapping("/activate/{userId}")
    public String activate(@PathVariable String userId, @RequestParam("token") String token) {
        Boolean status = authUserService.activateAccount(userId, token);
        if (!status) {
            ClassPathResource resource = new ClassPathResource("templates/activate_error.html");
            try {
                return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            ClassPathResource resource = new ClassPathResource("templates/activate_success.html");
            try {
                return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
