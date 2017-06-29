package com.example.spring.security.example.security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * Created by pkpk1234 on 2017/6/29.
 */
public class RefererRedirectionAuthenticationSuccessHandler
        extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    public RefererRedirectionAuthenticationSuccessHandler() {
        super();
        setUseReferer(true);
    }

}
