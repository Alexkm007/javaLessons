package ru.alexkm07.spdata.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.alexkm07.spdata.model.Product;
import ru.alexkm07.spdata.repository.ProductRepository;
import ru.alexkm07.spdata.service.ProductService;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("/product")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("products")
    public String allProducts(Model model){

        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("newproduct")
    public String getFormNewProduct(){
        return "newproduct";
    }

    @PostMapping("newproduct")
    public String newProduct(@ModelAttribute("Product") @Valid Product product, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/product/newproduct";
        }
        productService.save(product);
        return "redirect:/product/products";
    }

    @GetMapping("editproduct")
    public String editProduct(@RequestParam("id") Long id, Model model){
        model.addAttribute("id_product",id);
        model.addAttribute("name_product","\""+productService.productById(id).getName()+"\"");
        return "editproduct";
    }

    @PostMapping("editproduct")
    public String updateProduct(@Valid Product product, BindingResult bindingResult, @RequestParam("id") Long id){
        if(bindingResult.hasErrors()) {
            return "redirect:editproduct?id="+id;
        }
        productService.update(product,id);
        return "redirect:products";
    }

    @GetMapping("deleteproduct")
    public String deleteProduct(@RequestParam("id") Long id){
        productService.delete(id);
        return "redirect:products";
    }

}
