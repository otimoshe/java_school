package com.tsystems.railway.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @Column(name = "passenger_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date birhtDate;

    @ManyToMany(mappedBy = "passengers")
    private Set<User> users;

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastName + '\'' +
                ", birhtDate=" + birhtDate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Date getBirhtDate() {
        return birhtDate;
    }

    public void setBirhtDate(Date birhtDate) {
        this.birhtDate = birhtDate;
    }
}
