package uz.shortUrl.spring_boot_short_url.mapper;

import org.mapstruct.*;
import uz.shortUrl.spring_boot_short_url.dto.UrlCreateDto;
import uz.shortUrl.spring_boot_short_url.entity.Url;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UrlMapper {
    Url toEntity(UrlCreateDto urlCreateDto);

    UrlCreateDto toDto(Url url);
}