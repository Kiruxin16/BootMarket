package ru.geekbrains.homework.BootMarket.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.homework.BootMarket.services.ProductService;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;

    @GetMapping("/productList")
    public String getProductsList(Model model){
        model.addAttribute("products",productService.getProductList());
        return "products.html";
    }
    @GetMapping("/product")
    public String getProductByID(Model model, @RequestParam long id){
        model.addAttribute("product",productService.getProductByID(id));
        return "item.html";
    }
}
