package com.tracker.covid19.covidtracker.entities;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "patient_id",unique = true, nullable = false)
    private int patientId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;
    private String name;
    private LocalDateTime infectedTimeStamp;

    public Patient() {
    }

    public Patient(int patientId, Country country, String name, LocalDateTime infectedTimeStamp) {
        this.patientId = patientId;
        this.country = country;
        this.name = name;
        this.infectedTimeStamp = infectedTimeStamp;
    }

    public int getId() {
        return Id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return getPatientId() == patient.getPatientId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPatientId());
    }



}
