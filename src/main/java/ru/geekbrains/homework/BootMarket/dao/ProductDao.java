package ru.geekbrains.homework.BootMarket.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework.BootMarket.items.Product;

import java.util.List;


@Component
@Data
@AllArgsConstructor
public class ProductDao implements Dao {



    private SessionFactoryMgr factory;


    @Override
    public Product getByID(Long id) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            Product product =  session.get(Product.class,id);
            session.getTransaction().commit();
            return product;
        }
    }

    @Override
    public List<Product> getItemList() {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            List<Product> products =  session.createQuery("select p from Product p",Product.class).getResultList();
            session.getTransaction().commit();
            return products;
        }
    }


    @Override
    public void removeItem(Long id) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            session.createQuery("delete  Product p where p.id=:id")
                    .setParameter("id",id)
                    .executeUpdate();
            session.getTransaction().commit();

        }

    }

    @Override
    public void addItem(String title, Integer price) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            Product product = new Product();
            product.setPrice(price);
            product.setTitle(title);
            session.saveOrUpdate(product);
            session.getTransaction().commit();

        }
    }

    public void changeCost(Long id, Integer priceDelta) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class,id);
            product.setPrice(product.getPrice()+priceDelta);
            session.getTransaction().commit();

        }

    }
}
