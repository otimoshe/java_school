package com.tsystems.railway.DTO;

public class TrainDTO {
    private int id;
    private int numberOfSeats;
    private TrainModelDTO trainModelDTO;

    public TrainDTO(int id, int numberOfSeats, TrainModelDTO trainModelDTO) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.trainModelDTO = trainModelDTO;
    }

    public TrainDTO() {
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

    public TrainModelDTO getTrainModelDTO() {
        return trainModelDTO;
    }

    public void setTrainModelDTO(TrainModelDTO trainModelDTO) {
        this.trainModelDTO = trainModelDTO;
    }
}
