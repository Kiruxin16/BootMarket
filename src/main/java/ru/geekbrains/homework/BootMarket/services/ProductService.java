package ru.geekbrains.homework.BootMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework.BootMarket.items.Product;
import ru.geekbrains.homework.BootMarket.repositories.ProductRepo;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> getProductList() {
        return productRepo.getProductList();
    }

    public Product getProductByID(long id){
        return productRepo.getByID(id);
    }






}
