package newapi.newapi.services;

import newapi.newapi.models.Members;
import newapi.newapi.models.types.RoleType;
import newapi.newapi.repositories.MembersRepository;
import newapi.newapi.requests.SignUpRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MembersService implements UserDetailsService {
    private MembersRepository membersRepository;

    @Transactional
    public Members signUp(SignUpRequest request) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        return membersRepository.save(request.toEntity());
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<Members> membersWrapper = membersRepository.findByEmail(userEmail);
        Members members = membersWrapper.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(RoleType.ROLE_USER.getCode()));
        return new User(members.getEmail(), members.getPassword(), authorities);
    }
}
