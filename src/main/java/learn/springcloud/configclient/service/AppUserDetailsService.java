package learn.springcloud.configclient.service;
 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import learn.springcloud.configclient.dao.UserRepo;
import learn.springcloud.configclient.model.AuthUser;
import learn.springcloud.configclient.model.User;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("going to get user : " + userName);
        Optional<User> user = userRepository.findByUserName(userName);
        System.out.println("user.isPresent :  " +user.isPresent());

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(AuthUser::new).get();
    }
}
