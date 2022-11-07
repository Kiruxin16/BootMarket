package ru.geekbrains.homework.BootMarket;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.homework.BootMarket.dao.ProductDao;
import ru.geekbrains.homework.BootMarket.dao.SessionFactoryMgr;
import ru.geekbrains.homework.BootMarket.items.Consumer;
import ru.geekbrains.homework.BootMarket.items.Product;
import ru.geekbrains.homework.BootMarket.services.ConsumerService;
import ru.geekbrains.homework.BootMarket.services.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DaoRun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.homework.BootMarket");
        ProductService productService = context.getBean(ProductService.class);
        ConsumerService consumerService = context.getBean(ConsumerService.class);

        Consumer cons = consumerService.getConsumerByID(1l);
        List<Product> products =consumerService.consProdList(1l);
        List<Consumer> consumers = productService.prodConsList(2l);
        Product product =productService.getProductByID(2l);
        System.out.println("Список продуктов у "+cons.getName()+": ");
        products.stream().forEach(p -> System.out.println(p.getTitle()));
        System.out.println("Список людей купивших "+ product.getTitle() +":");
        consumers.stream().forEach(c -> System.out.println(c.getName()));



        //System.out.println(productService.prodConsList(2l));


    }
}
