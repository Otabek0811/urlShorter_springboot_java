package uz.shortUrl.spring_boot_short_url.service;

import lombok.NonNull;
import uz.shortUrl.spring_boot_short_url.dto.auth.AuthUserCreateDto;
import uz.shortUrl.spring_boot_short_url.dto.auth.GenerateTokenRequest;

public interface AuthUserService {

    String register(@NonNull AuthUserCreateDto dto);

    String generateToken(@NonNull GenerateTokenRequest request);

    Boolean activateAccount(@NonNull String userId, @NonNull String token);

}
