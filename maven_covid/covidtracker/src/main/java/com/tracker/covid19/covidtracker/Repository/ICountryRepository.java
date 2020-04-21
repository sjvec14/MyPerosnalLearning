package com.tracker.covid19.covidtracker.Repository;

import com.tracker.covid19.covidtracker.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface ICountryRepository extends CrudRepository<Country, Integer> {


    public Country findByCountryId(int countryId);
}
