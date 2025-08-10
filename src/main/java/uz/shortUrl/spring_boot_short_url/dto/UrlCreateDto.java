package uz.shortUrl.spring_boot_short_url.dto;

import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlCreateDto implements Serializable {
    private String path;
    private String description;

    @Future
    private LocalDateTime expiredAt;

}