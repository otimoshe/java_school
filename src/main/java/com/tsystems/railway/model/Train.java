package com.tsystems.railway.model;

;

import javax.persistence.*;
import java.util.Set;


@Entity
//@Proxy(lazy=false)
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue
    @Column(name = "train_id")
    private int id;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private TrainModel trainModel;

    @OneToMany(mappedBy = "train")
    private Set<Trip> trips;

    public Train(int numberOfSeats, TrainModel trainModel) {
        this.numberOfSeats = numberOfSeats;
        this.trainModel = trainModel;
    }

    public Train(int id,int numberOfSeats, TrainModel trainModel) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.trainModel = trainModel;
    }

    public Train() {
        trainModel = new TrainModel();
    }

    public TrainModel getTrainModel() {
        return trainModel;
    }

    public void setTrainModel(TrainModel trainModel) {
        this.trainModel = trainModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
