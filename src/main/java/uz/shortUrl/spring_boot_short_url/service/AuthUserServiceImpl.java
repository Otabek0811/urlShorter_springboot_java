package uz.shortUrl.spring_boot_short_url.service;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.shortUrl.spring_boot_short_url.config.security.JwtTokenUtil;
import uz.shortUrl.spring_boot_short_url.dto.auth.AuthUserCreateDto;
import uz.shortUrl.spring_boot_short_url.dto.auth.GenerateTokenRequest;
import uz.shortUrl.spring_boot_short_url.entity.AuthUser;
import uz.shortUrl.spring_boot_short_url.entity.AuthUserOtp;
import uz.shortUrl.spring_boot_short_url.mapper.AuthUserMapper;
import uz.shortUrl.spring_boot_short_url.repository.AuthUserOtpRepository;
import uz.shortUrl.spring_boot_short_url.repository.AuthUserRepository;
import uz.shortUrl.spring_boot_short_url.utils.MailSenderService;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthUserServiceImpl implements AuthUserService{

    private final AuthUserRepository authUserRepository;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthUserMapper authUserMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final AuthUserOtpService authUserOtpService;
    private final MailSenderService mailSenderService;
    private final AuthUserOtpRepository authUserOtpRepository;

    @Override
    public String register(@NotNull AuthUserCreateDto dto) {
        AuthUser authUser = authUserMapper.toAuthUser(dto);

        if (authUserRepository.findByUsername(authUser.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        if (authUserRepository.findByEmail(authUser.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        String encoded = passwordEncoder.encode(authUser.getPassword());
        authUser.setPassword(encoded);
        authUser.setRole("USER");
        AuthUser saved = authUserRepository.save(authUser);

        AuthUserOtp authUserOtp = authUserOtpService.createOtp(saved);
        Map<String, String> map = Map.of(
                "username", authUser.getUsername(),
                "activationUrl", "http://localhost:8080/api/auth/activate/"
                                 +saved.getId()+"?token="+authUserOtp.getCode(),
                "email", authUser.getEmail()
        );
        mailSenderService.sendFreeMarkerMail(map);

        return "Success";
    }

    @Override
    public String generateToken(@NotNull GenerateTokenRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();

        var authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);

        return jwtTokenUtil.generateToken(username);
    }


    @Override
    public Boolean activateAccount(@NonNull String userId, @NonNull String token) {
        AuthUserOtp authUserOtp = authUserOtpRepository.findAuthUserOtpByCodeIgnoreCase(token).orElseThrow(
                () -> new RuntimeException("Invalid token")
        );

        if (authUserOtp.getExpiresAt().isAfter(LocalDateTime.now())) {
            AuthUser authUser = authUserRepository.findById(Long.parseLong(userId)).orElseThrow(
                    () -> new RuntimeException("User not found")
            );
            authUser.setActive(true);
            authUserRepository.save(authUser);
            authUserOtp.setDeleted(true);
            authUserOtpRepository.save(authUserOtp);
            return true;
        }

        return false;
    }
}
