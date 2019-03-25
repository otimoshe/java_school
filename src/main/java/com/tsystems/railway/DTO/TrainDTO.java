package com.tsystems.railway.DTO;

public class TrainDTO {
    private long id;
    private int numberOfSeats;
    private TrainModelDTO trainModelDTO;



    public TrainDTO(long id, int numberOfSeats, TrainModelDTO trainModelDTO) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.trainModelDTO = trainModelDTO;
    }

    public long getId() {
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
