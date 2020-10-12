package ru.sbt.carshow;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.carshow.config.AppConfig;
import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.service.CarShowServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CarShowServiceImpl carShowService = applicationContext.getBean(CarShowServiceImpl.class);

        carShowService.addCar(new Car("Mercedes", "35 AMG 4MATIC", "Black", 3500000));
        carShowService.addCar(new Car("Mercedes", "4MATIC OS", "Black", 4550000));
        carShowService.addCar(new Car("Ferrari", "488 Pista", "Red", 23000000));
        carShowService.addCar(new Car("Ferrari", "F8 Tributo", "Yellow", 28000000));
        carShowService.addCar(new Car("Nissan", "Terrano", "Gray", 890000));
        carShowService.addCar(new Car("Skoda", "OCTAVIA", "Black", 1140000));
        carShowService.addCar(new Car("Skoda", "RAPID", "Blue", 830000));
        carShowService.addCar(new Car("Lada", "Granda", "White", 1000));

        /*customerService.add(new Customer("Андрей", "Иванов", LocalDate.of (1976, 3, 25)));
        customerService.add(new Customer("Илья", "Думаченко",  LocalDate.of (1973, 6, 14)));
        customerService.add(new Customer("Наталья", "Синичкина",  LocalDate.of (1986, 8, 15)));
        customerService.add(new Customer("Владимир", "Орлов",  LocalDate.of (1990, 1, 27)));
        customerService.add(new Customer("Елизавета", "Котова",  LocalDate.of (1991, 7, 2)));
        customerService.add(new Customer("Оксана", "Саратова",  LocalDate.of (1988, 11, 30)));
        customerService.add(new Customer("Александр", "Вертушкин",  LocalDate.of (1978, 3, 16)));
        customerService.add(new Customer("Виктория", "Соколова",  LocalDate.of (1994, 1, 9)));*/

        carShowService.addOrder(
                new Customer("Андрей", "Иванов", LocalDate.of (1976, 3, 25)),
                5L
        );
        carShowService.addOrder(
                new Customer("Илья", "Думаченко",  LocalDate.of (1973, 6, 14)),
                4L
        );
        carShowService.addOrder(
                new Customer("Наталья", "Синичкина",  LocalDate.of (1986, 8, 15)),
                3L
        );
        carShowService.addOrder(
                new Customer("Владимир", "Орлов",  LocalDate.of (1990, 1, 27)),
                7L
        );
        carShowService.addOrder(
                new Customer("Елизавета", "Котова",  LocalDate.of (1991, 7, 2)),
                5L
        );
        carShowService.addOrder(
                new Customer("Елизавета", "Котова",  LocalDate.of (1991, 7, 2)),
                5L
        );
        carShowService.addOrder(
                new Customer("Александр", "Вертушкин",  LocalDate.of (1978, 3, 16)),
                5L
        );
        carShowService.addOrder(
                new Customer("Виктория", "Соколова",  LocalDate.of (1994, 1, 9)),
                5L
        );

        carShowService.addOrder(2L, 5L);
        carShowService.addOrder(2L, 3L);
        carShowService.addOrder(6L, 1L);
        carShowService.addOrder(5L, 1L);

        System.out.println("=========================");

        System.out.println("Клиенты:");
        System.out.println(carShowService.getCustomers());

        System.out.println("Автомобили:");
        System.out.println(carShowService.getCar());

        System.out.println("Заказы:");
        System.out.println(carShowService.getOrder());

        long customerID = 2L;
        Customer customer = carShowService.getCustomer(customerID);
        if(customer != null) {
            System.out.printf("Автомобили клиента %s :", customer.toString());
            List<Car> cars = carShowService.getCustomerCars(customerID);
            System.out.println(cars);
        } else {
            throw new IllegalArgumentException("Несуществующий customerID: " + customerID);
        }

        long carID = 3L;
        Car car = carShowService.getCar(carID);
        if(car != null) {
            System.out.printf("Покупатели автомобиля %s :", car.toString());
            List<Customer> customers = carShowService.getCarBuyers(carID);
            System.out.println(customers);
        } else {
            throw new IllegalArgumentException("Несуществующий carID: " + carID);
        }

        long n = carShowService.countOrders();
        //carShowService.clearOrders();

        System.out.println("=========================");
    }
}
