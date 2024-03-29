package com.alevel.project.coffee.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "address", nullable = false)
    @NotBlank(message = "Address cannot be empty")
    private String address;

    // The district of the city or the nearest metro station
    @Column(name = "location")
    private String location;

    @Column(name = "phone")
    private String phone;

    @Column(name = "website")
    private String website;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_place_id", referencedColumnName = "place_id")
    private Place place;

    public Contact() {
    }

    public Contact(String address, String phone, String website) {
        this.address = address;
        this.phone = phone;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        place.setContact(this);
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!id.equals(contact.id)) return false;
        if (!address.equals(contact.address)) return false;
        if (location != null ? !location.equals(contact.location) : contact.location != null) return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (website != null ? !website.equals(contact.website) : contact.website != null) return false;
        return place != null ? place.equals(contact.place) : contact.place == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", place=" + place +
                '}';
    }
}
