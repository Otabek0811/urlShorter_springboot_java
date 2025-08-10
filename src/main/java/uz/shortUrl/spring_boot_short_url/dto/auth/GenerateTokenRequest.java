package uz.shortUrl.spring_boot_short_url.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenerateTokenRequest implements Serializable {
    @NotBlank private String username;
    @NotBlank private String password;
}
