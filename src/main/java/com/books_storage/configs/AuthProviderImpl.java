package com.books_storage.configs;

import com.books_storage.entities.Worker;
import com.books_storage.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    private WorkerService workerService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        Worker worker = workerService.getByLastNameAndFirstName(login.split(" ")[0], login.split(" ")[1]);
        if (worker == null) {
            throw new UsernameNotFoundException("User not found");
        }

        String password = authentication.getCredentials().toString();

        if (!passwordEncoder.matches(password, worker.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }

        Collection<GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList("ROLE_" + worker.getRole());

        return new UsernamePasswordAuthenticationToken(worker, null, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
