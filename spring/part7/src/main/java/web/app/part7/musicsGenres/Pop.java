package web.app.part7.musicsGenres;

import org.springframework.stereotype.Component;

@Component
public class Pop implements Genre{
    @Override
    public String getName() {
        return "Pop";
    }
}
