package com.tsystems.railway.model;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;


@Entity
//@Proxy(lazy=false)
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue
    @Column(name = "train_id")
    public long id;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private TrainModel trainModel;

    @OneToMany
    private Set<Trip> trips;


    public TrainModel getTrainModel() {
        return trainModel;
    }

    public void setTrainModel(TrainModel trainModel) {
        this.trainModel = trainModel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }






    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
            //    ", stations=" + stations +
           //     ", passengers=" + passengers +
                '}';
    }

}
