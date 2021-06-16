
package pl.sda.allegroclone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.allegroclone.model.PortalUser;
import pl.sda.allegroclone.model.Role;
import pl.sda.allegroclone.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


     @Autowired
     UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        pl.sda.allegroclone.model.PortalUser portalUser = userRepository.findByLogin(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (portalUser != null) {
            for(Role role : portalUser.getRoles()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
        } else {
            throw new UsernameNotFoundException(username + " is not found");
        }
        return new User(portalUser.getLogin(), portalUser.getPassword(), grantedAuthorities);


    }
}
