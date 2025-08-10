package uz.shortUrl.spring_boot_short_url;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import uz.shortUrl.spring_boot_short_url.config.security.SessionUser;

import java.util.Optional;

@SpringBootApplication
@EnableAsync
@EnableJpaAuditing
public class SpringBootShortUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShortUrlApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return (args -> {
		});
	}

	@Bean
	public AuditorAware<Long> getAuditor(SessionUser sessionUser) {
		return ()-> Optional.of(sessionUser.id());
	}

}

