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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void nullID_getCountryById_TEST() {
        /*when(countryRepository.findByCountryId(110)).
                thenReturn(new Country(110, "INDIA", null));
        when(mapperService.mapCountryEntityToResponse(new Country(110, "INDIA", null), true))
                .thenReturn(new CountryDTO(110, "INDIA", null));*/
        assertThrows(Exception.class,()->cd.getCountryById(0));
    }

    @Test
    public void getAllCountries() {
    }

    @Test
    public void addCountry() {
    }

    @Test
    public void removeCountryById() {
    }

    @Test
    public void updateCountryDetailsById() {
    }
}
