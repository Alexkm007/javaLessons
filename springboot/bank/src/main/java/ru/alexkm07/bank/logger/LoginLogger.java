package ru.alexkm07.bank.logger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoginLogger implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event)
    {
        UserDetails user = (UserDetails) event.getAuthentication().getPrincipal();
        log.info("LOGIN User with name: "+user.getUsername());
    }

    }