package ru.alexkm07.shop.controller;

import org.springframework.web.bind.annotation.*;
import ru.alexkm07.shop.dto.BoxDto;
import ru.alexkm07.shop.dto.ItemDto;
import ru.alexkm07.shop.service.orders.BoxService;

import java.util.List;

@RestController
@RequestMapping("/boxes")
public class BoxController {

    private final BoxService boxService;

    public BoxController(BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping
    public List<BoxDto> getAll(){
        return  boxService.getAll(BoxDto.class);
    }

    @GetMapping("/{id}")
    public BoxDto<ItemDto> get(@PathVariable("id") Long id){
        return boxService.get(id,new BoxDto());
    }



}
