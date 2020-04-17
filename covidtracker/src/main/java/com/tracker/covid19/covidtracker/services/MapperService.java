package com.tracker.covid19.covidtracker.services;

import com.tracker.covid19.covidtracker.DTO.CountryDTO;
import com.tracker.covid19.covidtracker.DTO.PatientDTO;
import com.tracker.covid19.covidtracker.entities.Country;
import com.tracker.covid19.covidtracker.entities.Patient;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MapperService {


    public PatientDTO mapEntityToPatientResponse(Patient patientEntity) {
        PatientDTO patientResponse = new PatientDTO();
        if (patientEntity != null) {
            patientResponse.setCountry(mapCountryEntityToResponse(patientEntity.getCountry(), false));
            patientResponse.setInfectedTimeStamp(patientEntity.getInfectedTimeStamp());
            patientResponse.setName(patientEntity.getName());
            patientResponse.setPatientId(patientEntity.getPatientId());
            patientResponse.setId(patientEntity.getId());
            return patientResponse;
        }
        return patientResponse;
    }

    public CountryDTO mapCountryEntityToResponse(Country country, boolean mapPatientDetails) {

        CountryDTO countryResponse = new CountryDTO();
        countryResponse.setCountryId(country.getCountryId());
        countryResponse.setCountyName(country.getCountyName());
        if (mapPatientDetails) {
            countryResponse.setPatientSet(mapPatientEntityToResponse(country.getPatientSet()));
        }
        return countryResponse;
    }

    private Set<PatientDTO> mapPatientEntityToResponse(Set<Patient> patientSet) {

        return patientSet.stream().map(patient -> {
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setPatientId(patient.getPatientId());
            patientDTO.setName(patient.getName());
            patientDTO.setInfectedTimeStamp(patient.getInfectedTimeStamp());
            return patientDTO;
        }).collect(Collectors.toSet());

    }

    public Patient mapPatientRequestToEntity(PatientDTO patient) {

        Patient patientEntity = new Patient();
        patientEntity.setPatientId(patient.getPatientId());
        patientEntity.setName(patient.getName());
        patientEntity.setInfectedTimeStamp(LocalDateTime.now());
        patientEntity.setCountry(mapCountyRequestToEntity(patient.getCountry()));
        return patientEntity;
    }

    public Country mapCountyRequestToEntity(CountryDTO country) {

        Country countryEntity = new Country();
        countryEntity.setCountyName(country.getCountyName());
        countryEntity.setCountryId(country.getCountryId());
       // countryEntity.setPatientSet(mapPatientDTOToEntity(country.getPatientSet()));
        mapPatientDTOToEntity(country,countryEntity);
        return countryEntity;
    }

    private void mapPatientDTOToEntity(CountryDTO country, Country countryEntity) {

        country.getPatientSet().stream().map(patientDTO -> {
            Patient patient = new Patient();
            patient.setPatientId(patientDTO.getPatientId());
            patient.setName(patientDTO.getName());
            patient.setInfectedTimeStamp(LocalDateTime.now());
            patient.getCountry().setCountryId(country.getCountryId());
            patient.getCountry().setCountyName(country.getCountyName());
            patient.getCountry().setPatientSet(new HashSet<>());
            return patient;
        }).forEach(countryEntity.getPatientSet():: add);
    }

    /*private Set<Patient> mapPatientDTOToEntity(Set<PatientDTO> patientSet) {
        return patientSet.stream().map(patientDTO -> {
            Patient patient = new Patient();
            patient.setPatientId(patientDTO.getPatientId());
            patient.setName(patientDTO.getName());
            patient.setInfectedTimeStamp(LocalDateTime.now());
            return patient;
        }).collect(Collectors.toSet());


    }*/

}
