package com.tracker.covid19.covidtracker.Repository;

import com.tracker.covid19.covidtracker.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface IPatientRepository extends CrudRepository<Patient,Integer> {

    public Patient findByPatientId(int id);

    public void deleteByPatientId(int id);
}
