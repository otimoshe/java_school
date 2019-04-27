package com.tsystems.railway.DAO;

import com.tsystems.railway.entity.Train;
import java.util.List;

public interface TrainDao {

    public void addTrain(Train train);

    public void updateTtain(Train train);

    public void removeTrain(int id);

    public Train getTrainById(int id);

    public List<Train> listTrains();
}
