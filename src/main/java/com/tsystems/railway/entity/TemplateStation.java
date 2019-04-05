package com.tsystems.railway.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "template_station")
@IdClass(TemplateStation.TemplateStationKey.class)
public class TemplateStation {

    @Id
    @ManyToOne
    @JoinColumn(name = "template_id")
    private TimeTemplate template;

    @Id
    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    @Column(name = "arrival_time")
    private Time arrivalTime;

    @Column(name = "departure_time")
    private Time departureTime;

    public TemplateStation() {
    }

    public TemplateStation(TimeTemplate template, Station station, Time arrivalTime, Time departureTime) {
        this.template = template;
        this.station = station;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public TimeTemplate getTemplate() {
        return template;
    }

    public void setTemplate(TimeTemplate template) {
        this.template = template;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public  static class TemplateStationKey implements Serializable {

        static final long serialVersionUID = 1L;

        private TimeTemplate template;
        private Station station;

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public TimeTemplate getTemplate() {
            return template;
        }

        public void setTemplate(TimeTemplate template) {
            this.template = template;
        }

        public Station getStation() {
            return station;
        }

        public void setStation(Station station) {
            this.station = station;
        }

        public TemplateStationKey() {
        }

        public TemplateStationKey(TimeTemplate template, Station station) {
            this.template = template;
            this.station = station;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TemplateStationKey that = (TemplateStationKey) o;
            return template.equals(that.template) &&
                    station.equals(that.station);
        }

        @Override
        public int hashCode() {
            return Objects.hash(template, station);
        }
    }

}
