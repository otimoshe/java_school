package com.tsystems.railway.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "train_models")
public class TrainModel {

    @Id
    @GeneratedValue
    @Column(name = "model_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "trainModel")
    Set<Train> trains;

    public TrainModel(String name) {
        this.name = name;
    }

    public TrainModel() {
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
}
