package ru.geekbrains.homework.BootMarket.items;


import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumers")
@Data
public class Consumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="cash")
    private int cash;


    @ManyToMany
    @JoinTable(
            name="cons_prod",
            joinColumns = @JoinColumn(name="consumer_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> products;


}
