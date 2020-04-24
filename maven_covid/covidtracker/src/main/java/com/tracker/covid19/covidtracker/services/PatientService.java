package com.tracker.covid19.covidtracker.services;

import com.tracker.covid19.covidtracker.Repository.ICountryRepository;
import com.tracker.covid19.covidtracker.Repository.IPatientRepository;
import com.tracker.covid19.covidtracker.DTO.PatientDTO;
import com.tracker.covid19.covidtracker.entities.Country;
import com.tracker.covid19.covidtracker.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    ICountryRepository countryRepository
            ;

    @Autowired
    IPatientRepository patientRepository;

    @Autowired
    MapperService mapperService;


    public PatientDTO getPatientById(int patientId) {

        Patient patientResponse = patientRepository.findByPatientId(patientId);
        return mapperService.mapEntityToPatientResponse(patientResponse);
    }

    public List<PatientDTO> getAllPatients() {

        List<PatientDTO> patientList = new ArrayList<>();
        patientRepository.findAll().forEach(patient -> {
            PatientDTO patientResponse = mapperService.mapEntityToPatientResponse(patient);
            patientList.add(patientResponse);
        });
        return patientList;
    }

    public void addPatient(Patient patient) {
        Country countryEntity = getCountryEntityUsingId(patient.getCountry().getCountryId());
        if(countryEntity!=null) {
            patient.setCountry(countryEntity);
        }
        patientRepository.save(patient);
    }

    private Country getCountryEntityUsingId(int countryId) {
        return countryRepository.findByCountryId(countryId);
    }


    public void removePatientById(int patientId) {
        Patient patient = patientRepository.findByPatientId(patientId);
        patientRepository.delete(patient);
    }

    public void updatePatientDetailsById(int patientId, Patient patient) {

        Patient patientEntity = patientRepository.findByPatientId(patientId);
        patientEntity.setName(patient.getName());
        patientEntity.setPatientId(patient.getPatientId());
        patientEntity.setInfectedTimeStamp(LocalDateTime.now());
        patientEntity.setCountry(getCountryEntityUsingId(patient.getCountry().getCountryId()));
        patientRepository.save(patientEntity);

    }
}
