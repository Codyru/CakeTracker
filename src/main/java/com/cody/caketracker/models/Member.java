package com.cody.caketracker.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "members", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name", "last_name", "country", "city"})
})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Past
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotNull
    private String country;

    @NotNull
    private String city;

    public Member() {
    }

    public Member(String firstName, String lastName, LocalDate birthDate, String country, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Transient
    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
