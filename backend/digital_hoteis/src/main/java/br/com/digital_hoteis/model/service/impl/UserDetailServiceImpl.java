package br.com.digital_hoteis.model.service.impl;

import br.com.digital_hoteis.model.repository.UserDetailRepository;
import br.com.digital_hoteis.model.service.UserDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailRepository userDetailRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return (email) ->
                userDetailRepository
                        .findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
