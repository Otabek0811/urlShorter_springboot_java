package uz.shortUrl.spring_boot_short_url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.shortUrl.spring_boot_short_url.entity.AuthUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByUsername(String username);

    Optional<AuthUser> findByEmail(String email);

    List<AuthUser> findAuthUserByEmail(String email);
}