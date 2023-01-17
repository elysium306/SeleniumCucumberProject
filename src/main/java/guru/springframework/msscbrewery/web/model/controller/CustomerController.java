package guru.springframework.msscbrewery.web.model.controller;

import guru.springframework.msscbrewery.services.CustomerServiceI;
import guru.springframework.msscbrewery.web.model.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerServiceI customerService;

    public CustomerController(CustomerServiceI customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
}
