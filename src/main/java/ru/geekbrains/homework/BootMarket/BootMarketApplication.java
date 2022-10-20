package ru.geekbrains.homework.BootMarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.geekbrains.homework.BootMarket.dao.SessionFactoryMgr;

@SpringBootApplication
public class BootMarketApplication {


	public static void main(String[] args) {
		//ConfigurableApplicationContext cac=null;
		try{
			//cac =
			SpringApplication.run(BootMarketApplication.class, args);

		}catch (Exception e){
			e.printStackTrace();
		}//finally {
			//cac.getBean(SessionFactoryMgr.class).shutdown(); --не прокатило
		//}

	}

}
