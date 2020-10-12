package ru.sbt.carshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.service.CarShowServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/carshow")
public class CarShowController {
    private final CarShowServiceImpl carShowService;
    private int itemPerPage = 10;


    @Autowired
    public CarShowController(CarShowServiceImpl carShowService) {
        this.carShowService = carShowService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomer() {
        return carShowService.getCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable long customerId) {
        return carShowService.getCustomer(customerId);
    }

    @GetMapping("/cars/{customerId}")
    public List<Car> getCustomerCars(@PathVariable long customerId) {
        return carShowService.getCustomerCars(customerId);
    }

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        carShowService.addCustomer(customer);
        return customer;
    }
}
