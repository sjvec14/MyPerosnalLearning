package com.tracker.covid19.covidtracker.controllers;

import com.tracker.covid19.covidtracker.DTO.PatientDTO;
import com.tracker.covid19.covidtracker.entities.Patient;
import com.tracker.covid19.covidtracker.services.MapperService;
import com.tracker.covid19.covidtracker.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    MapperService mapperService;

    @RequestMapping(method = RequestMethod.GET, value = "/patients/{id}")
    public Object getPatientsById(@PathVariable int id) {

        try {
            PatientDTO patientResponse = patientService.getPatientById(id);
            if(patientResponse !=null) {
                return patientResponse;
            } else {
                return new ResponseEntity("No Details found in DB", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Could not Retrieve details from DB", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patients")
    public Object getAllPatients() {
        try {
            return patientService.getAllPatients();
        } catch (Exception e) {
            return new ResponseEntity("Could not Retrieve details from DB", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/patients")
    public ResponseEntity addPatient(@RequestBody PatientDTO patient) {
        try {
            Patient patientEntity = mapperService.mapPatientRequestToEntity(patient);
            patientService.addPatient(patientEntity);
            return new ResponseEntity("Details were successfully added", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Could not add the details to DB", HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/patients/{id}")
    public ResponseEntity removePatientsById(@PathVariable int id) {
        try {
            patientService.removePatientById(id);
            return new ResponseEntity("The details were successfully removed", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Could not remove patient details as the patient was not found", HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/patients/{id}")
    public ResponseEntity updatePatientDetails(@PathVariable int id, @RequestBody PatientDTO patient) {
        try {
            Patient patientEntity = mapperService.mapPatientRequestToEntity(patient);
            patientService.updatePatientDetailsById(id, patientEntity);
            return new ResponseEntity("Details were successfully updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }


    }

}
