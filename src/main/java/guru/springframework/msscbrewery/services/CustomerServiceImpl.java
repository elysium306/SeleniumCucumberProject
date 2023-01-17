package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by mt on 2022-10-22.
 */
@Service
public class CustomerServiceImpl implements CustomerServiceI {
    @Override
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder().id(UUID.randomUUID())
                .customerName("John Thompson")
                .build();
    }
}
