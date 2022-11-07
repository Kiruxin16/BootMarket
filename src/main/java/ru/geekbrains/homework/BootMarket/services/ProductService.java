package ru.geekbrains.homework.BootMarket.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework.BootMarket.dao.ProductDao;
import ru.geekbrains.homework.BootMarket.items.Consumer;
import ru.geekbrains.homework.BootMarket.items.Product;
import ru.geekbrains.homework.BootMarket.repositories.ProductRepo;


import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;



    public List<Product> getProductList() {
        return productDao.getItemList();
    }

    public Product getProductByID(Long id){
        return productDao.getByID(id);
    }

    public  void changePrice(Long id, Integer priceDelta){
        productDao.changeCost(id,priceDelta);
    }

    public void removeProduct(Long id){
        productDao.removeItem(id);
    }

    public void addProduct(String title,Integer price){
        productDao.addItem(title,price);
    }

    public List<Consumer> prodConsList(Long prodId){
        return productDao.getProdConsList(prodId);
    }






}
