package com.tracker.covid19.covidtracker.controllers;

import com.tracker.covid19.covidtracker.DTO.PatientDTO;
import com.tracker.covid19.covidtracker.entities.Patient;
import com.tracker.covid19.covidtracker.services.MapperService;
import com.tracker.covid19.covidtracker.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @Autowired
    MapperService mapperService;

    @RequestMapping(method = RequestMethod.GET, value = "/covidtracker/patients/{id}")
    public ResponseEntity getPatientsById(@PathVariable int id) {

        try {
            PatientDTO patientResponse = patientService.getPatientById(id);
            if (patientResponse != null) {
                return ResponseEntity.ok(patientResponse);
            } else {
                return new ResponseEntity("No patient details for patient ID" + id + "was not found in DB",
                        HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Could not Retrieve patient details for patient ID" + id + " from DB",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/covidtracker/patients")
    public ResponseEntity getAllPatients() {
        try {
            return ResponseEntity.ok(patientService.getAllPatients());
        } catch (Exception e) {
            return new ResponseEntity("Could not Retrieve patient details from DB", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/covidtracker/patients")
    public ResponseEntity addPatient(@Valid @RequestBody PatientDTO patient) {
        try {
            Patient patientEntity = mapperService.mapPatientRequestToEntity(patient);
            patientService.addPatient(patientEntity);
            return new ResponseEntity("Patient details for the patient ID" + patient.getPatientId() + " were successfully added",
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Could not add the patient details with patient Id" + patient.getPatientId() + " to DB",
                    HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/covidtracker/patients/{id}")
    public ResponseEntity removePatientsById(@PathVariable int id) {
        try {
            patientService.removePatientById(id);
            return new ResponseEntity("Patient Details for patient ID" + id + " were successfully removed", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Could not remove patient details as the patient with ID" + id + " was not found",
                    HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/covidtracker/patients/{id}")
    public ResponseEntity updatePatientDetails(@PathVariable int id, @Valid @RequestBody PatientDTO patient) {
        try {
            Patient patientEntity = mapperService.mapPatientRequestToEntity(patient);
            patientService.updatePatientDetailsById(id, patientEntity);
            return new ResponseEntity("patient details for the patient ID" + id + " successfully updated", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Bad Request", HttpStatus.BAD_REQUEST);
        }


    }

}
