package com.tracker.covid19.covidtracker.services;

import com.tracker.covid19.covidtracker.DTO.CountryDTO;
import com.tracker.covid19.covidtracker.Repository.ICountryRepository;
import com.tracker.covid19.covidtracker.entities.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryServiceTest {

    @Mock
    ICountryRepository countryRepository;

    @Mock
    MapperService mapperService;
    @InjectMocks
    CountryService cd;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void happypath_getCountryById_TEST() {
        when(countryRepository.findByCountryId(110)).
                thenReturn(new Country(110, "INDIA", null));
        when(mapperService.mapCountryEntityToResponse(new Country(110, "INDIA", null), true))
                .thenReturn(new CountryDTO(110, "INDIA", null));
        CountryDTO cdto = cd.getCountryById(110);
        assertTrue(cdto.getCountryId() == 110, "The country ID Is Wrong");
        assertTrue(cdto.getCountyName() == "INDIA", "The country Name is Wrong");


    }

    @Test
    public void noRecordInDb_getCountryById_TEST() {
        when(countryRepository.findByCountryId(110)).
                thenReturn(null);
        when(mapperService.mapCountryEntityToResponse(null,true))
                .thenReturn(null);
        CountryDTO cdto = cd.getCountryById(110);
        assertTrue(cdto == null);
    }

    @Test
    public void happyPath_getAllCountries_Test() {
        Country country1 = new Country(110,"INDIA",null);
        Country country2 = new Country(111,"FRANCE",null);
        List<Country> countryList = Arrays.asList(country1,country2);
        when(countryRepository.findAll()).
                thenReturn(countryList);
        when(mapperService.mapCountryEntityToResponse(country1, true))
                .thenReturn(new CountryDTO(110, "INDIA", null));
        when(mapperService.mapCountryEntityToResponse(country1, true))
                .thenReturn(new CountryDTO(111, "FRANCE", null));
        List<CountryDTO> cdto = cd.getAllCountries();
        assertTrue(cdto.size() ==2);
    }

    @Test
    public void noDataInDB_getAllCountries_Test() {
    List<Country> countryList = new ArrayList<>();
        when(countryRepository.findAll()).
                thenReturn(countryList);
        List<CountryDTO> cdto = cd.getAllCountries();
        assertTrue(cdto.size() == 0);
    }
}
