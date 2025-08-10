package uz.shortUrl.spring_boot_short_url.config.security;

import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.shortUrl.spring_boot_short_url.entity.AuthUser;

import java.util.Collection;
import java.util.Collections;

@Data
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private Long id;
    private final AuthUser authUser;
    public UserDetails(@NonNull AuthUser authUser) {
        this.authUser = authUser;
        this.id = authUser.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+authUser.getRole()));
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return authUser.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return authUser.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return authUser.isActive();
    }

    @Override
    public boolean isEnabled() {
        return authUser.isActive();
    }

}
