package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.model.BeerDTO;

import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
public interface BeerServiceI {
    BeerDTO getBeerById(UUID beerId);
}
