package ru.alexkm07.bank.logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.stereotype.Component;
import ru.alexkm07.bank.model.User;

import java.util.List;

@Slf4j
@Component
public class LogoutLogger implements ApplicationListener<SessionDestroyedEvent> {

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        List<SecurityContext> lstSecurityContext = event.getSecurityContexts();
        User user;
        for (SecurityContext securityContext : lstSecurityContext)
        {
            user = (User)securityContext.getAuthentication().getPrincipal();
            log.info("LOG out User: "+user.getUsername());
        }
    }
}

