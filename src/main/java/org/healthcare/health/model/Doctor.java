package org.healthcare.health.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table (name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name")
    private String name;

    @Column( name = "surname")
    private String surname;

    @Column( name = "speciality")
    private String speciality;

    @Column( name = "qualifications")
    private List<String> qualifications; 

    @Column( name = "years_of_exp")
    private int yearsOfExp;

    @Column( name = "contact_info")
    private List<String> contactInfo; //email, phone number

    @Column( name = "schedule")
    private LocalDateTime schedule;

    @Column( name = "officeLocation")
    private String location;

    @Column( name = "acceptingNewPatients")
    private boolean acceptingNewPatients;

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }


    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }


    public List<String> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<String> contactInfo) {
        this.contactInfo = contactInfo;
    }


    public LocalDateTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalDateTime schedule) {
        this.schedule = schedule;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
    public boolean isAcceptingNewPatients() {
        return acceptingNewPatients;
    }

    public void setAcceptingNewPatients(boolean acceptingNewPatients) {
        this.acceptingNewPatients = acceptingNewPatients;
    }










    
}
