package uz.shortUrl.spring_boot_short_url.config.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.shortUrl.spring_boot_short_url.dto.response.AppErrorDto;

import java.util.*;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
    private final ObjectMapper objectMapper;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {

        String friendlyMessage = "Not Valid Input";
        String errorPath = request.getRequestURI();
        Map<String, List<String>> developerMessage = new HashMap<>();

        for (FieldError fieldError : e.getFieldErrors()) {
            String fieldIdentifier = fieldError.getField();
            String errorMessage = fieldError.getDefaultMessage();
            developerMessage.compute(fieldIdentifier, (s, values)->{

                if(!Objects.isNull(values)){
                    values.add(errorMessage);
                }else{
                    values = new ArrayList<>(Collections.singletonList(errorMessage));
                }
                return values;
            });
        }

        AppErrorDto appErrorDTO = new AppErrorDto(friendlyMessage,developerMessage,errorPath, 400);
        log.error("Validation Error: {}", appErrorDTO);

        return ResponseEntity
                .status(400)
                .body(appErrorDTO);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<AppErrorDto> handleRunTimeException(RuntimeException e, HttpServletRequest request){
        String friendlyMessage = "Not Valid Input";
        String errorPath = request.getRequestURI();
        String developerMessage = e.getMessage();

        AppErrorDto appErrorDTO = new AppErrorDto(friendlyMessage,developerMessage,errorPath, 400);
        log.error("Server Error: {}", appErrorDTO);

        return ResponseEntity
                .status(400)
                .body(appErrorDTO);
    }
}