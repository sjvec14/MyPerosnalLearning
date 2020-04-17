package com.tracker.covid19.covidtracker.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tracker.covid19.covidtracker.entities.Patient;

import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CountryDTO {

    private int countryId;
    private String countyName;
    private Set<PatientDTO> patientSet = new HashSet<PatientDTO>();


    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Set<PatientDTO> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<PatientDTO> patientSet) {
        this.patientSet = patientSet;
    }
//Sample Request
    /*{
        "countryId": 111,
            "countyName": "INDIA",
            "patientSet": [   {
        "patientId": 1,
                "country":       {
            "countryId": 111,
                    "countyName": "INDIA"
        },
        "name": "SAM",
                "infectedTimeStamp": "2020-04-16T13:12:47.239",
                "id": 1
    }]
    }*/
}
