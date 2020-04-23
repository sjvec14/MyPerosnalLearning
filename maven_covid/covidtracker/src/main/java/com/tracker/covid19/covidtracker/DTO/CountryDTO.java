package com.tracker.covid19.covidtracker.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tracker.covid19.covidtracker.entities.Patient;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CountryDTO {

    @Range(min=1, message = "The country ID should not be null or less than 1")
    private int countryId;
    @NotNull(message = "The country NAME should not be Null")
    @Size(max = 20, message = "The Country Name size should not be greater than 20")
    private String countyName;

    private Set<PatientDTO> patientSet = new HashSet<PatientDTO>();

    public CountryDTO() {
    }

    public CountryDTO(int countryId, String countyName, Set<PatientDTO> patientSet) {
        this.countryId = countryId;
        this.countyName = countyName;
        this.patientSet = patientSet;
    }

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
    }*/
}
