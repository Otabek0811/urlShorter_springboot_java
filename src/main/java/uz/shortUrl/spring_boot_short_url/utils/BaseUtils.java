package uz.shortUrl.spring_boot_short_url.utils;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@Component
public class BaseUtils {

    private final Base64.Encoder encoder = Base64.getUrlEncoder();

    public String generateCode(Long userID) {
        return encoder.encodeToString((String.valueOf(userID)+ UUID.randomUUID()).getBytes() );
    }

    public String shortUrlCode() {
        return Hashing.murmur3_32_fixed()
                .hashString(UUID.randomUUID().toString(), StandardCharsets.UTF_8)
                .toString();
    }


}
