package uz.shortUrl.spring_boot_short_url.service;


import lombok.NonNull;
import org.springframework.stereotype.Service;
import uz.shortUrl.spring_boot_short_url.dto.UrlCreateDto;
import uz.shortUrl.spring_boot_short_url.entity.Url;

@Service
public interface UrlService {

    Url urlShorten(@NonNull UrlCreateDto dto);
    Url getUrlByCode(@NonNull String code);
}
