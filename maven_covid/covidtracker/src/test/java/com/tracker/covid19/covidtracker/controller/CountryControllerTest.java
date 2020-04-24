package com.tracker.covid19.covidtracker.controller;

import com.tracker.covid19.covidtracker.DTO.CountryDTO;
import com.tracker.covid19.covidtracker.controllers.CountryController;
import com.tracker.covid19.covidtracker.entities.Country;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    public void notFoundResponse_getCountryById_TEST() {
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
        when(countryService.getCountryById(1)).thenReturn(new CountryDTO(111, "INDIA", null));
        ResponseEntity response = (ResponseEntity) countryController.getCountyById(1);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void ok_AllCountries_TEST() {
        List<CountryDTO> countryDTOList = Arrays.asList(new CountryDTO(111, "INDIA", null));
        when(countryService.getAllCountries()).thenReturn(countryDTOList);
        ResponseEntity response = (ResponseEntity) countryController.getAllCountries();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void noRecordInDB_getAllCountries_TEST() {
        when(countryService.getAllCountries()).thenReturn(new ArrayList<CountryDTO>());
        ResponseEntity response = (ResponseEntity) countryController.getAllCountries();
        List<CountryDTO> responseList = (List<CountryDTO>) response.getBody();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assert (responseList.size() == 0);
    }

    @Test
    public void exceptionResponse_getAllCountries_TEST() {
        when(countryService.getAllCountries()).thenThrow(new RuntimeException("Exception occured"));
        ResponseEntity response = (ResponseEntity) countryController.getAllCountries();
        assertTrue(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR, "Expected response code is 500");
    }

    @Test
    public void exception_addCountry_TEST() {
        CountryDTO cdto = new CountryDTO();
        when(mapperService.mapCountyRequestToEntity(cdto)).thenReturn(new Country());
        doThrow(new RuntimeException()).when(countryService).addCountry(new Country());
        ResponseEntity response = (ResponseEntity) countryController.addCountry(cdto);
        assertTrue(response.getStatusCode() == HttpStatus.BAD_REQUEST, "Expected response code is 500");
    }

    @Test
    public void ok_addCountry_TEST() {
        CountryDTO cdto = new CountryDTO();
        when(mapperService.mapCountyRequestToEntity(cdto)).thenReturn(new Country());
        doNothing().when(countryService).addCountry(new Country());
        ResponseEntity response = (ResponseEntity) countryController.addCountry(cdto);
        assertTrue(response.getStatusCode() == HttpStatus.OK, "Expected response code is 200");
    }

    @Test
    public void exception_deleteCountry_TEST() {
        doThrow(new RuntimeException()).when(countryService).removeCountryById(1);
        ResponseEntity response = (ResponseEntity) countryController.removeCountryById(1);
        assertTrue(response.getStatusCode() == HttpStatus.NOT_FOUND, "Expected response code is 500");
    }

    @Test
    public void ok_deleteCountry_TEST() {
        doNothing().when(countryService).removeCountryById(1);
        ResponseEntity response = (ResponseEntity) countryController.removeCountryById(1);
        assertTrue(response.getStatusCode() == HttpStatus.OK, "Expected response code is 200");
    }

    @Test
    public void exception_updateCountry_TEST() {
        CountryDTO cdto = new CountryDTO();
        Country country = new Country();
        when(mapperService.mapCountyRequestToEntity(cdto)).thenReturn(country);
        doThrow(new RuntimeException()).when(countryService).updateCountryDetailsById(1, country);
        ResponseEntity response = (ResponseEntity) countryController.updateCountryDetails(1, cdto);
        assertTrue(response.getStatusCode() == HttpStatus.BAD_REQUEST, "Expected response code is 400");
    }

    @Test
    public void ok_updateCountry_TEST() {
        CountryDTO cdto = new CountryDTO();
        Country country = new Country();
        when(mapperService.mapCountyRequestToEntity(cdto)).thenReturn(country);
        doNothing().when(countryService).updateCountryDetailsById(1, country);
        ResponseEntity response = (ResponseEntity) countryController.updateCountryDetails(1, cdto);
        assertTrue(response.getStatusCode() == HttpStatus.OK, "Expected response code is 200");
    }

}


