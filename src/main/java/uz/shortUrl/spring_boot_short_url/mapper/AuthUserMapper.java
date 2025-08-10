package uz.shortUrl.spring_boot_short_url.mapper;

import org.mapstruct.*;
import uz.shortUrl.spring_boot_short_url.dto.auth.AuthUserCreateDto;
import uz.shortUrl.spring_boot_short_url.entity.AuthUser;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface AuthUserMapper {

    @BeanMapping(unmappedTargetPolicy = ReportingPolicy.IGNORE)
    AuthUser toAuthUser(AuthUserCreateDto authUserCreateDto);

}
