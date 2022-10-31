package ru.geekbrains.homework.BootMarket.dao;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;


@Component
public class SessionFactoryMgr {

    private SessionFactory factory;


    @PostConstruct
    public void init() {

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            String script = Files.lines(Path.of("src\\main\\resources\\import.sql")).collect(Collectors.joining(" "));
            session.beginTransaction();
            session.createNativeQuery(script).executeUpdate();
            session.getTransaction().commit();

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            if(session !=null){
                session.close();
            }
        }


    }
    public Session getSession(){
        return factory.getCurrentSession();
    }

    public void shutdown(){
        if(factory!=null){
            factory.close();
        }
    }




}
