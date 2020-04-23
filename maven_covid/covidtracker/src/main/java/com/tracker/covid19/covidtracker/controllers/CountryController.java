package com.tracker.covid19.covidtracker.controllers;

import com.tracker.covid19.covidtracker.DTO.CountryDTO;
import com.tracker.covid19.covidtracker.entities.Country;
import com.tracker.covid19.covidtracker.services.CountryService;
import com.tracker.covid19.covidtracker.services.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CountryController {

    @Autowired
    MapperService mapperService;

    @Autowired
    CountryService countryService;

    @RequestMapping(method = RequestMethod.GET, value = "/covidtracker/countries/{id}")
    public ResponseEntity getCountyById(@PathVariable int id) {

        try {
            CountryDTO countryResponse = countryService.getCountryById(id);
            if (countryResponse != null) {
                return ResponseEntity.ok(countryResponse);
            } else {
                return new ResponseEntity("No Details found in DB for country ID" + id,
                        HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity("Could not Retrieve details from DB for country ID" + id,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/covidtracker/countries")
    public ResponseEntity getAllCountries() {
        try {
            return ResponseEntity.ok(countryService.getAllCountries());
        } catch (Exception e) {
            return new ResponseEntity("Could not Retrieve details from DB", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/covidtracker/countries")
    public ResponseEntity addCountry(@RequestBody @Valid CountryDTO country) {
        try {
            Country countryEntity = mapperService.mapCountyRequestToEntity(country);
            countryService.addCountry(countryEntity);
            return ResponseEntity.ok("The country details with country ID" + country.getCountryId() +
                    " were successfully added");
        } catch (Exception e) {
            return new ResponseEntity("Could not add the country with country ID" + country.getCountryId() +
                    " details to DB", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/covidtracker/countries/{id}")
    public ResponseEntity removeCountryById(@PathVariable int id) {
        try {
            countryService.removeCountryById(id);
            return ResponseEntity.ok("The country details with country ID"+ id +" were successfully removed");
        } catch (Exception e) {
            return new ResponseEntity("Could not remove patient details as the patient was not found",
                    HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/covidtracker/countries/{id}")
    public ResponseEntity updateCountryDetails(@PathVariable int id, @RequestBody @Valid CountryDTO country) {
        try {
            Country countryEntity = mapperService.mapCountyRequestToEntity(country);
            countryService.updateCountryDetailsById(id, countryEntity);
            return ResponseEntity.ok("The details were successfully updated for the country ID" + id);
        } catch (Exception e) {
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }


    }

}
