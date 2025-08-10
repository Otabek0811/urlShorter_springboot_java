package uz.shortUrl.spring_boot_short_url.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shortUrl.spring_boot_short_url.dto.UrlCreateDto;
import uz.shortUrl.spring_boot_short_url.entity.Url;
import uz.shortUrl.spring_boot_short_url.mapper.UrlMapper;
import uz.shortUrl.spring_boot_short_url.repository.UrlRepository;
import uz.shortUrl.spring_boot_short_url.utils.BaseUtils;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {
    private final UrlMapper urlMapper;
    private final BaseUtils baseUtils;
    private final UrlRepository urlRepository;

    @Override
    public Url urlShorten(@NonNull UrlCreateDto dto) {
        Url url = urlMapper.toEntity(dto);
        url.setCode(baseUtils.shortUrlCode());

        if (url.getExpiredAt() == null){
            url.setExpiredAt(LocalDateTime.now().plusDays(1));
        }

        return urlRepository.save(url);
    }

    @Override
    public Url getUrlByCode(@NonNull String code) {
        Url url = urlRepository.getByCode(code)
                .orElseThrow(() -> new RuntimeException("Url not found by Code"));

        if (url.getExpiredAt().isBefore(LocalDateTime.now())){
            throw new RuntimeException("Shortened Url is expired");
        }
        return url;
    }
}
