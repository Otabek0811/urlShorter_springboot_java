package uz.shortUrl.spring_boot_short_url.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreateDto {
    private String username;
    private String password;
    private String email;
}
