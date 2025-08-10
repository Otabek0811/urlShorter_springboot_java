package uz.shortUrl.spring_boot_short_url.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import uz.shortUrl.spring_boot_short_url.dto.UrlCreateDto;
import uz.shortUrl.spring_boot_short_url.entity.Url;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-10T21:12:01+0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class UrlMapperImpl implements UrlMapper {

    @Override
    public Url toEntity(UrlCreateDto urlCreateDto) {
        if ( urlCreateDto == null ) {
            return null;
        }

        Url.UrlBuilder url = Url.builder();

        url.path( urlCreateDto.getPath() );
        url.description( urlCreateDto.getDescription() );
        url.expiredAt( urlCreateDto.getExpiredAt() );

        return url.build();
    }

    @Override
    public UrlCreateDto toDto(Url url) {
        if ( url == null ) {
            return null;
        }

        UrlCreateDto urlCreateDto = new UrlCreateDto();

        urlCreateDto.setPath( url.getPath() );
        urlCreateDto.setDescription( url.getDescription() );
        urlCreateDto.setExpiredAt( url.getExpiredAt() );

        return urlCreateDto;
    }
}
