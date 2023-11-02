package br.com.digital_hoteis.model.service.impl;

import br.com.digital_hoteis.model.entity.SignIn;
import br.com.digital_hoteis.model.entity.SignUp;
import br.com.digital_hoteis.model.entity.UserDetail;
import br.com.digital_hoteis.model.repository.UserDetailRepository;
import br.com.digital_hoteis.model.service.AuthenticationService;
import br.com.digital_hoteis.model.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserDetailRepository userDetailRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public String signUp(SignUp request) {
        var user = UserDetail.builder().name(request.getName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole()).build();
        userDetailRepository.save(user);
        return jwtService.generateToken(user);

    }

    @Override
    public String signIn(SignIn request) {
        var authentication = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        authenticationManager.authenticate(authentication);
        var user = userDetailRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        return jwtService.generateToken(user);
    }
}
