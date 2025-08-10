package uz.shortUrl.spring_boot_short_url.service;

import lombok.NonNull;
import uz.shortUrl.spring_boot_short_url.entity.AuthUser;
import uz.shortUrl.spring_boot_short_url.entity.AuthUserOtp;

public interface AuthUserOtpService {

    AuthUserOtp createOtp(@NonNull AuthUser authUserOtp);

}
