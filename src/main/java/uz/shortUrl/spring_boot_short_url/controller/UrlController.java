package uz.shortUrl.spring_boot_short_url.controller;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.shortUrl.spring_boot_short_url.dto.UrlCreateDto;
import uz.shortUrl.spring_boot_short_url.entity.Url;
import uz.shortUrl.spring_boot_short_url.service.UrlService;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/url")
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/shorter")
    public ResponseEntity<Url> createShortUrl(@Valid @RequestBody UrlCreateDto dto){
        return ResponseEntity.ok(urlService.urlShorten(dto));
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/redirect/{code}")
    public void redirect(@PathVariable String code, HttpServletResponse httpServletResponse ){
        Url url = urlService.getUrlByCode(code);
        try {
            httpServletResponse.sendRedirect(url.getPath());
        } catch (IOException e) {
            throw new RuntimeException("httpServletResponse -> redirect: "+e.getMessage());
        }
    }
}
