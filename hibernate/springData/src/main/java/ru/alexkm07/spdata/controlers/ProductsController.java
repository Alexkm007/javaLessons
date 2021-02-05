package ru.alexkm07.spdata.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alexkm07.spdata.model.Product;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @GetMapping("/productslist")
    public String allProducts(){
        return "productslist";
    }

}
