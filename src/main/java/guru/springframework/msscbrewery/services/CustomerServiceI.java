package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.model.CustomerDTO;

import java.util.UUID;

public interface CustomerServiceI {
    CustomerDTO getCustomerById(UUID customerId);
}
