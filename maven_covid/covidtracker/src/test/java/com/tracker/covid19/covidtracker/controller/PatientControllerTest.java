package com.tracker.covid19.covidtracker.controller;

import com.tracker.covid19.covidtracker.DTO.PatientDTO;
import com.tracker.covid19.covidtracker.controllers.PatientController;
import com.tracker.covid19.covidtracker.entities.Patient;
import com.tracker.covid19.covidtracker.services.MapperService;
import com.tracker.covid19.covidtracker.services.PatientService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PatientControllerTest {

    @Mock
    MapperService mapperService;

    @Mock
    PatientService patientService;

    @InjectMocks
    PatientController patientController;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void notFoundResponse_getPatientsById_TEST() {
        when(patientService.getPatientById(1)).thenReturn(null);
        ResponseEntity response = (ResponseEntity) patientController.getPatientsById(1);
        assertTrue(response.getStatusCode() == HttpStatus.NOT_FOUND, "Expected response code is 400");
    }


    @Test
    public void exceptionResponse_getPatientById_TEST() {
        when(patientService.getPatientById(1)).thenThrow(new RuntimeException("Exception occured"));
        ResponseEntity response = (ResponseEntity) patientController.getPatientsById(1);
        assertTrue(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR, "Expected response code is 500");
    }


    @Test
    public void ok_getPatientById_TEST() {
        when(patientService.getPatientById(1)).thenReturn(new PatientDTO());
        ResponseEntity response = (ResponseEntity) patientController.getPatientsById(1);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void ok_AllPatient_TEST() {
        List<PatientDTO> patientDTOList = Arrays.asList(new PatientDTO(), new PatientDTO());
        when(patientService.getAllPatients()).thenReturn(patientDTOList);
        ResponseEntity response = (ResponseEntity) patientController.getAllPatients();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void noRecordInDB_getAllPatients_TEST() {
        when(patientService.getAllPatients()).thenReturn(new ArrayList<PatientDTO>());
        ResponseEntity response = (ResponseEntity) patientController.getAllPatients();
        List<PatientDTO> responseList = (List<PatientDTO>) response.getBody();
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assert (responseList.size() == 0);
    }


    @Test
    public void exceptionResponse_getAllPatients_TEST() {
        when(patientService.getAllPatients()).thenThrow(new RuntimeException("Exception occured"));
        ResponseEntity response = (ResponseEntity) patientController.getAllPatients();
        assertTrue(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR, "Expected response code is 500");
    }


    @Test
    public void exception_addPatient_TEST() {
        PatientDTO pdto = new PatientDTO();
        when(mapperService.mapPatientRequestToEntity(pdto)).thenReturn(new Patient());
        doThrow(new RuntimeException()).when(patientService).addPatient(new Patient());
        ResponseEntity response = (ResponseEntity) patientController.addPatient(pdto);
        assertTrue(response.getStatusCode() == HttpStatus.BAD_REQUEST, "Expected response code is 500");
    }


    @Test
    public void ok_addPatient_TEST() {
        PatientDTO pdto = new PatientDTO();
        when(mapperService.mapPatientRequestToEntity(pdto)).thenReturn(new Patient());
        doNothing().when(patientService).addPatient(new Patient());
        ResponseEntity response = (ResponseEntity) patientController.addPatient(pdto);
        assertTrue(response.getStatusCode() == HttpStatus.OK, "Expected response code is 200");
    }


    @Test
    public void exception_deletePatient_TEST() {
        doThrow(new RuntimeException()).when(patientService).removePatientById(1);
        ResponseEntity response = (ResponseEntity) patientController.removePatientsById(1);
        assertTrue(response.getStatusCode() == HttpStatus.NOT_FOUND, "Expected response code is 500");
    }


    @Test
    public void ok_deletePatient_TEST() {
        doNothing().when(patientService).removePatientById(1);
        ResponseEntity response = (ResponseEntity) patientController.removePatientsById(1);
        assertTrue(response.getStatusCode() == HttpStatus.OK, "Expected response code is 200");
    }


    @Test
    public void exception_updatePatient_TEST() {
        PatientDTO pdto = new PatientDTO();
        Patient patient = new Patient();
        when(mapperService.mapPatientRequestToEntity(pdto)).thenReturn(patient);
        doThrow(new RuntimeException()).when(patientService).updatePatientDetailsById(1, patient);
        ResponseEntity response = (ResponseEntity) patientController.updatePatientDetails(1, pdto);
        assertTrue(response.getStatusCode() == HttpStatus.BAD_REQUEST, "Expected response code is 400");
    }

    @Test
    public void ok_updatePatient_TEST() {
        PatientDTO pdto = new PatientDTO();
        Patient patient = new Patient();
        when(mapperService.mapPatientRequestToEntity(pdto)).thenReturn(patient);
        doNothing().when(patientService).updatePatientDetailsById(1, patient);
        ResponseEntity response = (ResponseEntity) patientController.updatePatientDetails(1, pdto);
        assertTrue(response.getStatusCode() == HttpStatus.OK, "Expected response code is 200");
    }


}
