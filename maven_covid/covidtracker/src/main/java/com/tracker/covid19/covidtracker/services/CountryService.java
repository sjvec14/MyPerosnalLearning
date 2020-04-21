package com.tracker.covid19.covidtracker.services;

import com.tracker.covid19.covidtracker.DTO.CountryDTO;
import com.tracker.covid19.covidtracker.Repository.ICountryRepository;
import com.tracker.covid19.covidtracker.entities.Country;
import com.tracker.covid19.covidtracker.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    MapperService mapperService;
    @Autowired
    ICountryRepository countryRepository;

    public CountryDTO getCountryById(int countryId) {

        Country countryEntity = countryRepository.findByCountryId(countryId);
        return mapperService.mapCountryEntityToResponse(countryEntity, true);
    }

    public List<CountryDTO> getAllCountries() {
        List<CountryDTO> countryList = new ArrayList<>();
        countryRepository.findAll().forEach(country -> {
            CountryDTO countryResponse = mapperService.mapCountryEntityToResponse(country, false);
            countryList.add(countryResponse);
        });
        return countryList;
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public void removeCountryById(int countryId) {
        Country country = countryRepository.findByCountryId(countryId);
        countryRepository.delete(country);

    }

    public void updateCountryDetailsById(int countryId, Country country) {

        Country countryEntity = countryRepository.findByCountryId(countryId);
        countryEntity.setCountyName(country.getCountyName());
        countryEntity.setCountryId(country.getCountryId());
        countryRepository.save(countryEntity);
    }
}
