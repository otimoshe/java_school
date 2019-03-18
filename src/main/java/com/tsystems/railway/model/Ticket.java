package com.tsystems.railway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "ticket_id")
    private long id;

 //   @Column(name = "passenger_id")
  //  private Passenger passenger;

  //  @Column(name = "train_id")
  //  private Train train;

  //  @Column(name = "departure_station_id")
 //   private Station departureStation;

 //   @Column(name = "arrival_station_id")
 //   private Station arrivalStation;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
           //     ", passenger=" + passenger +
          //      ", train=" + train +
          //      ", departureStation=" + departureStation +
          //      ", arrivalStation=" + arrivalStation +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
