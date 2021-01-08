package web.app.part7.musicsGenres;

import org.springframework.stereotype.Component;

@Component
public class RockGenre implements Genre{
    @Override
    public String getName() {
        return "rock";
    }
}
