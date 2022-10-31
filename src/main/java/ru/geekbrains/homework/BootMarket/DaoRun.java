package ru.geekbrains.homework.BootMarket;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.homework.BootMarket.dao.ProductDao;
import ru.geekbrains.homework.BootMarket.services.ConsumerService;
import ru.geekbrains.homework.BootMarket.services.ProductService;

import java.io.File;
import java.io.IOException;

public class DaoRun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.geekbrains.homework.BootMarket");
        ProductService productService = context.getBean(ProductService.class);
        ConsumerService consumerService = context.getBean(ConsumerService.class);

        //System.out.println(consumerService.consProdList(1l));
        System.out.println(productService.prodConsList(2l));


    }
}
