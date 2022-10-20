package ru.geekbrains.homework.BootMarket.dao;

import ru.geekbrains.homework.BootMarket.items.Product;

import java.util.List;

public interface Dao {

    public Product getByID(Long id);

    public List<Product> getItemList();

    public  void removeItem(Long id);

    void addItem(String title,Integer price);
}
