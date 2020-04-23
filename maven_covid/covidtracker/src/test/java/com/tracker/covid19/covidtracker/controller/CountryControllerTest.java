package com.tracker.covid19.covidtracker.controller;


import com.tracker.covid19.covidtracker.DTO.CountryDTO;
import com.tracker.covid19.covidtracker.controllers.CountryController;
import com.tracker.covid19.covidtracker.services.CountryService;
import com.tracker.covid19.covidtracker.services.MapperService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryControllerTest {

    @Mock
    MapperService mapperService;

    @Mock
    CountryService countryService;

    @InjectMocks
    CountryController countryController;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void notFoundRespose_getCountryById_TEST() {
        when(countryService.getCountryById(1)).thenReturn(null);
        ResponseEntity response = (ResponseEntity) countryController.getCountyById(1);
        assertTrue(response.getStatusCode() == HttpStatus.NOT_FOUND, "Expected response code is 400");
    }

    @Test
    public void exceptionResponse_getCountryById_TEST() {
        when(countryService.getCountryById(1)).thenThrow(new RuntimeException("Exception occured"));
        ResponseEntity response = (ResponseEntity) countryController.getCountyById(1);
        assertTrue(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR, "Expected response code is 500");
    }


    @Test
    public void ok_getCountryById_TEST() {
        when(countryService.getCountryById(1)).thenReturn(new CountryDTO(111,"INDIA",null));
        ResponseEntity response = (ResponseEntity) countryController.getCountyById(1);
        assertEquals(response.getStatusCode(),HttpStatus.OK);
    }


}

