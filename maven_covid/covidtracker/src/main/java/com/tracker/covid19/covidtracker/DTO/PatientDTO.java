package com.tracker.covid19.covidtracker.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PatientDTO {
    private int Id;
    @Range(min=1, message = "The patient ID should not be null or less than 1")
    private int patientId;
    @Valid
    private CountryDTO country;
    @NotNull(message = "The patientName should not be Null")
    @Size(max = 20, message = "The patientName size should not be greater than 20")
    private String name;
    private LocalDateTime infectedTimeStamp;

    public PatientDTO() {
    }

    public PatientDTO(int id, int patientId, CountryDTO country, String name, LocalDateTime infectedTimeStamp) {
        this.Id = id;
        this.patientId = patientId;
        this.country = country;
        this.name = name;
        this.infectedTimeStamp = infectedTimeStamp;
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
