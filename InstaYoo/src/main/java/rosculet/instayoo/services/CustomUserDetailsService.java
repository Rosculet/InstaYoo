package rosculet.instayoo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rosculet.instayoo.entity.User;
import rosculet.instayoo.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = repository.findUserByUsername(username)
               .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " +
                       username));
       return build(user);
    }

    public User loadUserById(Long id){
        return repository.findUserById(id).orElseThrow(null);
    }

    public static User build(User user) {
        List<GrantedAuthority> authority = user.getRole().stream().map(
                role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
        return new User(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authority
        );
    }
}
