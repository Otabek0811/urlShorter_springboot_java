package uz.shortUrl.spring_boot_short_url.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.shortUrl.spring_boot_short_url.entity.AuthUser;
import uz.shortUrl.spring_boot_short_url.entity.AuthUserOtp;
import uz.shortUrl.spring_boot_short_url.repository.AuthUserOtpRepository;
import uz.shortUrl.spring_boot_short_url.repository.AuthUserRepository;
import uz.shortUrl.spring_boot_short_url.utils.BaseUtils;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserOtpServiceImpl implements AuthUserOtpService {
    private final AuthUserOtpRepository authUserOtpRepository;
    private final BaseUtils baseUtils;

    @Override
    public AuthUserOtp createOtp(@NonNull AuthUser authUser) {
        AuthUserOtp build = AuthUserOtp.builder()
                .code(baseUtils.generateCode(authUser.getId()))
                .userID(authUser.getId())
                .expiresAt(LocalDateTime.now().plusMinutes(2) )
                 .build();
        return authUserOtpRepository.save(build);
    }
}
