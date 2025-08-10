package uz.shortUrl.spring_boot_short_url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.shortUrl.spring_boot_short_url.entity.Url;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    @Query("select u from Url u where u.code = ?1 and u.deleted = false")
    Optional<Url> getByCode(String code);
}