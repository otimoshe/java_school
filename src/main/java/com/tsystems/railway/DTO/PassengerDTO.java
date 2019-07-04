package com.tsystems.railway.DTO;

import com.tsystems.railway.entity.User;

import java.sql.Date;

public class PassengerDTO {

    private int id;
    private String name;
    private String lastName;
    private Date birthday;


    public PassengerDTO(int id, String name, String lastName, Date birthday) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public PassengerDTO() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }




}
