package de.goll.data.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "application_kunde")
public class Kunde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KundeUUID", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String zip;

    @NotBlank
    private String city;

    @NotBlank
    private String email;

    @NotBlank
    private String tel;

    public Kunde(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
