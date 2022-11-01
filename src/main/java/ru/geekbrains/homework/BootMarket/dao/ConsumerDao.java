package ru.geekbrains.homework.BootMarket.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework.BootMarket.items.Consumer;
import ru.geekbrains.homework.BootMarket.items.Product;

import java.util.ArrayList;
import java.util.List;
@Component
@Data
@AllArgsConstructor
public class ConsumerDao {

    private SessionFactoryMgr factory;



    public Consumer getByID(Long id) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            Consumer consumer =  session.get(Consumer.class,id);
            session.getTransaction().commit();
            return consumer;
        }
    }

    public List<Consumer> getItemList() {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            List<Consumer> consumers =  session.createQuery("select с from Consumers c",Consumer.class).
                    getResultList();
            session.getTransaction().commit();
            return consumers;
        }
    }


    public void removeItem(Long id) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            session.createQuery("delete  Consumer c where c.id=:id")
                    .setParameter("id",id)
                    .executeUpdate();
            session.getTransaction().commit();

        }
    }


    public void addItem(String name, Integer cash) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            Consumer consumer = new Consumer();
            consumer.setCash(cash);
            consumer.setName(name);
            session.saveOrUpdate(consumer);
            session.getTransaction().commit();

        }

    }
    public List<Product> getConsProdList(Long consId){
        try(Session session = factory.getSession()){
            session.beginTransaction();
            List<Product> products = new ArrayList<>();
            products.addAll(session.get(Consumer.class,consId).getProducts());
            session.getTransaction().commit();
            return products;
        }
    }
}
