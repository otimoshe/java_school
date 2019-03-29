package com.tsystems.railway.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    public SeatStatus() {
    }

    public SeatStatus(Seat seat, Station station, Boolean available) {
        this.seat = seat;
        this.station = station;
        this.available = available;
    }

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

    public  static class SeatStatusKey implements Serializable {

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

        public SeatStatusKey() {

        }

        public SeatStatusKey(Seat seat, Station station) {
            this.seat = seat;
            this.station = station;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SeatStatusKey that = (SeatStatusKey) o;
            return Objects.equals(seat, that.seat) &&
                    Objects.equals(station, that.station);
        }

        @Override
        public int hashCode() {
            return Objects.hash(seat, station);
        }
    }
}
