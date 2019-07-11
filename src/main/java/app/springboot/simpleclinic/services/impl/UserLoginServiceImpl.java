package app.springboot.simpleclinic.services.impl;

import app.springboot.simpleclinic.models.UserLogin;
import app.springboot.simpleclinic.models.UserLoginDetails;
import app.springboot.simpleclinic.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserLogin userLogin = userLoginRepository.getUserByUsername(s);

        if (null == userLogin) {
            throw new UsernameNotFoundException("User not found!");
        }

        return new UserLoginDetails(userLogin);
    }
}
