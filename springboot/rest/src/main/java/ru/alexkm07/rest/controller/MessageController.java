package ru.alexkm07.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexkm07.rest.exception.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
    private int counter = 4;
    private List<Map<String,String>> messages = new ArrayList<>(){
        {
        add(new HashMap<String,String>(){{put("id","1");put("text","First message");}});
        add(new HashMap<String,String>(){{put("id","2");put("text","Second message");}});
        add(new HashMap<String,String>(){{put("id","3");put("text","Third message");}});
        }
    };


    @GetMapping
    public List<Map<String,String>> list(){
        return messages;
    }

    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id){
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findAny()
                .orElseThrow(NotFoundException::new);
    }
}
