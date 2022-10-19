package ru.geekbrains.homework.BootMarket.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework.BootMarket.items.Product;
import ru.geekbrains.homework.BootMarket.services.ProductService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final ProductService productService;

/*    @GetMapping("/productList")
    public String getProductsList(Model model){
        model.addAttribute("products",productService.getProductList());
        return "products.html";
    }*/
    @GetMapping("/products")
    public String getProductByID(Model model, @RequestParam long id){
        model.addAttribute("product",productService.getProductByID(id));
        return "item.html";
    }

    @GetMapping("/products/list")
    @ResponseBody
    public List<Product> getProductList(){
        return productService.getProductList();
    }

    @GetMapping("/products/change")
    @ResponseBody
    public void changePrice(@RequestParam Long id,@RequestParam Integer priceDelta){
        productService.changePrice(id,priceDelta);
    }

    @GetMapping("/products/remove")
    @ResponseBody
    public  void removeProduct(@RequestParam Long id){
        productService.removeProduct(id);
    }

    @PostMapping("products/add")
    @ResponseBody
    public void addProduct(String title,Integer price){
        productService.addProduct(title,price);
    }
}
