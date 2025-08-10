package uz.shortUrl.spring_boot_short_url.config.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.shortUrl.spring_boot_short_url.entity.AuthUser;
import uz.shortUrl.spring_boot_short_url.repository.AuthUserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<AuthUser> authUser = Optional.ofNullable(authUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username)));
        System.out.println("\r id: "+authUser.get().getId());
        System.out.println("\r username: "+authUser.get().getUsername());
        System.out.println("\r role: ROLE_"+authUser.get().getRole());
        return new UserDetails(authUser.get());

    }
}
