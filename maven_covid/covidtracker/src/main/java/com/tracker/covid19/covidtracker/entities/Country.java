
package com.tracker.covid19.covidtracker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","patientSet"})
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "country_id", unique=true, nullable = false)
    private int countryId;
    private String countyName;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<Patient> patientSet = new HashSet<Patient>();

    public Country() {
    }

    public Country(int countryId, String countyName, Set<Patient> patientSet) {
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

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return getCountryId() == country.getCountryId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountryId());
    }
}
