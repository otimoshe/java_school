package com.tsystems.railway.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "seat_status")
@IdClass(SeatStatus.SeatStatusKey.class)
public class SeatStatus {

    @Id
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @Id
    @ManyToOne
    @JoinColumn( name = " station_id")
    private Station station;

    @Column(name = "available", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean available;





    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public class SeatStatusKey implements Serializable {

        static final long serialVersionUID = 1L;

        private Seat seat;
        private Station station;

        public Seat getSeat() {
            return seat;
        }

        public void setSeat(Seat seat) {
            this.seat = seat;
        }

        public Station getStation() {
            return station;
        }

        public void setStation(Station station) {
            this.station = station;
        }


    }
}
