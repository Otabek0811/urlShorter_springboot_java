package uz.shortUrl.spring_boot_short_url.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.shortUrl.spring_boot_short_url.dto.auth.AuthUserCreateDto;
import uz.shortUrl.spring_boot_short_url.entity.AuthUser;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-10T21:12:01+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class AuthUserMapperImpl implements AuthUserMapper {

    @Override
    public AuthUser toAuthUser(AuthUserCreateDto authUserCreateDto) {
        if ( authUserCreateDto == null ) {
            return null;
        }

        AuthUser.AuthUserBuilder authUser = AuthUser.builder();

        authUser.username( authUserCreateDto.getUsername() );
        authUser.password( authUserCreateDto.getPassword() );
        authUser.email( authUserCreateDto.getEmail() );

        return authUser.build();
    }
}
