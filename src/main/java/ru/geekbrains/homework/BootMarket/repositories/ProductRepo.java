package ru.geekbrains.homework.BootMarket.repositories;


import org.springframework.stereotype.Repository;
import ru.geekbrains.homework.BootMarket.dao.Dao;
import ru.geekbrains.homework.BootMarket.items.Product;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ProductRepo  {


    private  List<Product> products;


/*    public void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1l,"Soccer вall",800),
                new Product(2l,"Jump rope", 600),
                new Product(3l,"Punching bag",12000),
                new Product(4l,"Barbell",20000),
                new Product(5l,"Dumbell",8000)
        ));
    }*/

    public Product getByID(Long id){
        return products.stream().filter(p ->p.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<Product> getProductList(){
        return  products;
    }

    public void changeCost(Long id, Integer priceDelta){
        Product tmp =getByID(id);
        tmp.setPrice(tmp.getPrice()+priceDelta);
    }

    public  void removeProduct(Long id){

        products.removeIf(p->p.getId().equals(id));
    }

/*    public void addProduct(String title,Integer price){
        Long id =products.stream().max((p, p1) -> (int)(p.getId()-p1.getId())).get().getId()+1;
        products.add(new Product(id,title,price));
    }*/


}
