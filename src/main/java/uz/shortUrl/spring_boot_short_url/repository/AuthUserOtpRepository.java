package uz.shortUrl.spring_boot_short_url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.shortUrl.spring_boot_short_url.entity.AuthUserOtp;

import java.util.Optional;

@Repository
public interface AuthUserOtpRepository extends JpaRepository<AuthUserOtp, Long> {
    @Query("select o from AuthUserOtp o where o.code = ?1 and o.deleted = false")
    Optional<AuthUserOtp> findAuthUserOtpByCodeIgnoreCase(String code);
}
