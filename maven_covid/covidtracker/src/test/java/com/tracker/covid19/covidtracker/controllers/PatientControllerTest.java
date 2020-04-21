package com.tracker.covid19.covidtracker.controllers;

import com.tracker.covid19.covidtracker.DTO.PatientDTO;
import com.tracker.covid19.covidtracker.entities.Patient;
import com.tracker.covid19.covidtracker.services.MapperService;
import com.tracker.covid19.covidtracker.services.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PatientControllerTest {

    @BeforeEach
    void setUp() {

       MapperService mockedMapperservice = mock(MapperService.class);
       when(mockedMapperservice.mapPatientRequestToEntity(new PatientDTO())).thenReturn(new Patient());
        PatientService mockedPatientService = mock(PatientService.class);
    }

    @Test
    void getPatientsById() {
    }

    @Test
    void getAllPatients() {
    }

    @Test
    void addPatient() {
    }

    @Test
    void removePatientsById() {
    }

    @Test
    void updatePatientDetails() {
    }
}
