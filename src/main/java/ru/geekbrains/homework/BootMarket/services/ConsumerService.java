package ru.geekbrains.homework.BootMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework.BootMarket.dao.ConsumerDao;
import ru.geekbrains.homework.BootMarket.items.Consumer;
import ru.geekbrains.homework.BootMarket.items.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumerService {


    private final ConsumerDao consumerDao;

    public List<Consumer> getConsumerList() {
        return consumerDao.getItemList();
    }

    public Consumer getConsumerByID(Long id){
        return consumerDao.getByID(id);
    }

    public List<Product> consProdList(Long consId){
        return consumerDao.getConsProdList(consId);
    }
}
