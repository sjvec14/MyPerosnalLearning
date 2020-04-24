package com.tracker.covid19.covidtracker.services;

import com.tracker.covid19.covidtracker.DTO.CountryDTO;
import com.tracker.covid19.covidtracker.DTO.PatientDTO;
import com.tracker.covid19.covidtracker.Repository.ICountryRepository;
import com.tracker.covid19.covidtracker.Repository.IPatientRepository;
import com.tracker.covid19.covidtracker.entities.Country;
import com.tracker.covid19.covidtracker.entities.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class PatientServiceTest {

    @Mock
    ICountryRepository countryRepository;

    @Mock
    IPatientRepository patientRepository;

    @Mock
    MapperService mapperService;

    @InjectMocks
    PatientService patientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void happypath_getPatientById_TEST() {
        when(patientRepository.findByPatientId(1)).
                thenReturn(new Patient(1, new Country(110, "INDIA", null),
                        "RAM", LocalDateTime.now()));
        when(mapperService.mapEntityToPatientResponse(new Patient(1, new Country(110, "INDIA",
                null), "RAM", LocalDateTime.now()))).
                thenReturn(new PatientDTO(1,1,new CountryDTO(110,"INDIA",null),"RAM",LocalDateTime.now()));
        PatientDTO pdto = patientService.getPatientById(1);
        assertTrue(pdto.getCountry().getCountryId() == 110, "The country ID Is Wrong");
        assertTrue(pdto.getName() == "RAM", "The Patient Name is Wrong");


    }

   @Test
    public void noRecordInDb_getPatientById_TEST() {
        when(patientRepository.findByPatientId(1)).
                thenReturn(null);
       when(mapperService.mapEntityToPatientResponse(null)).
               thenReturn(null);
        PatientDTO pdto = patientService.getPatientById(1);
        assertTrue(pdto == null);
    }

    @Test
    public void happyPath_getAllPatients_Test() {
        Patient patient1 = new Patient(1, new Country(110, "INDIA", null),
                "RAM", LocalDateTime.now());
        Patient patient2 = new Patient(2, new Country(111, "FRANCE", null),
                "REMO", LocalDateTime.now());

        List<Patient> patientList = Arrays.asList(patient1, patient2);
        when(patientRepository.findAll()).
                thenReturn(patientList);
        when(mapperService.mapEntityToPatientResponse(patient1))
                .thenReturn(new PatientDTO(1,1,new CountryDTO(110,"INDIA",null),"RAM",LocalDateTime.now()));
        when(mapperService.mapEntityToPatientResponse(patient2))
                .thenReturn(new PatientDTO(1,1,new CountryDTO(111,"FRANCE",null),"REMO",LocalDateTime.now()));
        List<PatientDTO> pdto = patientService.getAllPatients();
        assertTrue(pdto.size() == 2);
    }

    @Test
    public void noDataInDB_getAllPatients_Test() {
        List<Patient> patientList = new ArrayList<>();
        when(patientRepository.findAll()).
                thenReturn(patientList);
        List<PatientDTO> pdto = patientService.getAllPatients();
        assertTrue(pdto.size() == 0);
    }
}
