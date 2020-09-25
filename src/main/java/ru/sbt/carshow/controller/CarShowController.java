package ru.sbt.carshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sbt.carshow.model.Car;
import ru.sbt.carshow.model.Customer;
import ru.sbt.carshow.service.CarShowService;

import java.util.List;

//@RestController
public class CarShowController {
    private final CarShowService carShowService;

    @Autowired
    public CarShowController(CarShowService carShowService) {
        this.carShowService = carShowService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return carShowService.getCustomers();
    }

    @GetMapping("/customer/{customerId}")
    public Customer getCustomers(@PathVariable long customerId) {
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
