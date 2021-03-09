package ru.alexkm007.mustashe_l18n;

import com.samskivert.mustache.Mustache;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Locale;

@ControllerAdvice
public class InternacionalizationAdvice {


    private final MessageSource message;

    public InternacionalizationAdvice(MessageSource message) {
        this.message = message;
    }

    @ModelAttribute("i18n")
    public Mustache.Lambda i18n(Locale locale){
        return (frag, out) -> {
            String body = frag.execute();
            String message = this.message.getMessage(body, null, locale);
            out.write(message);
        };
    }
}
