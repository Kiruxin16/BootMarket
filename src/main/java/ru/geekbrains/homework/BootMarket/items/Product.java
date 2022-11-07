package ru.geekbrains.homework.BootMarket.items;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @ManyToMany
    @JoinTable(
            name="cons_prod",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="consumer_id")
    )
    private List<Consumer> consumers;




}
