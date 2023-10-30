package br.com.digital_hoteis.model.service;

import br.com.digital_hoteis.model.entity.SignIn;
import br.com.digital_hoteis.model.entity.SignUp;

public interface AuthenticationService {
    String signIn(SignIn request);
    String signUp(SignUp request);
}
