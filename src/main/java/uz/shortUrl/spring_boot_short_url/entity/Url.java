package uz.shortUrl.spring_boot_short_url.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Url extends Auditable {

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "path", nullable = false)
    private String path;

    @Column(name = "description", length = 400)
    private String description;

    @Future
    @Column(name = "expired_at", nullable = false)
    private LocalDateTime expiredAt;
}