package uz.shortUrl.spring_boot_short_url.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppErrorDto {
    private final String friendlyMessage;
    private final Object developerMessage;
    private final String errorPath;
    private final Integer errorCode;

    public AppErrorDto(String friendlyMessage, String errorPath, Integer errorCode) {
        this.friendlyMessage = friendlyMessage;
        this.developerMessage = null;
        this.errorPath = errorPath;
        this.errorCode = errorCode;
    }

    public AppErrorDto(String friendlyMessage, Object developerMessage, String errorPath, Integer errorCode) {
        this.friendlyMessage = friendlyMessage;
        this.developerMessage = developerMessage;
        this.errorPath = errorPath;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return """
                \n
                *errorPath: %s*
                *errorCode: %s*
                *friendlyMessage: %s*
                *developerMessage:* `%s`
                """.formatted(errorPath, errorCode,friendlyMessage,developerMessage);
    }
}
