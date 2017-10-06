package ru.omgtu.fitiks.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import ru.omgtu.fitiks.practice.dao.ProductDao;
import ru.omgtu.fitiks.practice.model.Product;

@SpringBootApplication
@ComponentScan
public class ProductDeliverApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ProductDeliverApplication.class, args);
	}

}
