package com.tracker.covid19.covidtracker.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PatientDTO {
    private int Id;
    private int patientId;
    private CountryDTO country;
    private String name;
    private LocalDateTime infectedTimeStamp;

    public PatientDTO() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getInfectedTimeStamp() {
        return infectedTimeStamp;
    }

    public void setInfectedTimeStamp(LocalDateTime infectedTimeStamp) {
        this.infectedTimeStamp = infectedTimeStamp;
    }

    //Sample object
   /* {
  "patientId":1,
  "name": "SAM",
  "country": {
  	"countryId": 111,
  	"countyName": "INDIA"
  	}
}*/
}
