package ru.sbt.carshow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.carshow.config.AppConfig;
import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.service.CarService;
import ru.sbt.carshow.service.CustomerService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        customerService.add(new Customer("Андрей", "Иванов", new Date("25.03.1976")));
        customerService.add(new Customer("Илья", "Думаченко",  new Date("25.03.1976")));
        customerService.add(new Customer("Наталья", "Синичкина",  new Date("25.03.1976")));
        customerService.add(new Customer("Владимир", "Орлов",  new Date("25.03.1976")));
        customerService.add(new Customer("Елизавета", "Котова",  new Date("25.03.1976")));
        customerService.add(new Customer("Оксана", "Саратова",  new Date("25.03.1976")));
        customerService.add(new Customer("Александр", "Вертушкин",  new Date("25.03.1976")));
        customerService.add(new Customer("Сергей", "Захаров",  new Date("25.03.1976")));
        customerService.add(new Customer("Виктория", "Соколова",  new Date("25.03.1976")));

        CarService carService = applicationContext.getBean(CarService.class);
        carService.add(new Car("Mercedes", "35 AMG 4MATIC", "Black", 3500000));
        carService.add(new Car("Mercedes", "4MATIC OS", "Black", 4550000));
        carService.add(new Car("Ferrari", "35 AMG 4MATIC", "Red", 3500000));
        carService.add(new Car("Ferrari", "35 AMG 4MATIC", "Red", 3500000));
        carService.add(new Car("Mercedes", "35 AMG 4MATIC", "Black", 3500000));
        carService.add(new Car("Mercedes", "35 AMG 4MATIC", "Black", 3500000));
        carService.add(new Car("Mercedes", "35 AMG 4MATIC", "Black", 3500000));
        carService.add(new Car("Lada", "35 AMG 4MATIC", "White", 100));

    }
}
