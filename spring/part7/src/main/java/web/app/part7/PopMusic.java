package web.app.part7;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class PopMusic implements Music{
    @Override
    public String getSong() {
        return "Madona Rain";
    }
}
