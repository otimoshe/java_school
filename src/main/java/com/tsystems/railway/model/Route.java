package com.tsystems.railway.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue
    @Column(name = "route_id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn (name = "first_station_id")
    private Station firstStation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "routes_paths",
                joinColumns = {@JoinColumn(name = "route_id")},
                inverseJoinColumns = {@JoinColumn(name = "path_id")})
    private Set<Path> paths = new HashSet<>();

    @OneToMany(mappedBy = "route")
    private Set<Trip> trips ;

    public Route(String name, BigDecimal price, Station firstStation, Set<Path> paths) {
        this.name = name;
        this.price = price;
        this.firstStation = firstStation;
        this.paths = paths;
    }

    public Route(String name, BigDecimal price, Station firstStation, Set<Path> paths, Set<Trip> trips) {
        this.name = name;
        this.price = price;
        this.firstStation = firstStation;
        this.paths = paths;
        this.trips = trips;
    }

    public Route() {
    }

    //  @ElementCollection(targetClass = Station.class)
  //  private List<Station> stations = this.getStationList();



    public List<Station> getStationList(){
        Set<Path> paths = this.getPaths();
        List<Station> stationList = new ArrayList<>();
        Station firstStation = this.getFirstStation();
        stationList.add(firstStation);
        Station currentStation = firstStation;

        while (!paths.isEmpty()) {
            for (Path path : paths) {
                if (path.getStation().equals(currentStation)) {
                    stationList.add(path.getNextStation());
                    currentStation = path.getNextStation();
                    paths.remove(path);
                    break;
                }
                if (path.getNextStation().equals(currentStation)) {
                    stationList.add(path.getStation());
                    currentStation = path.getStation();
                    paths.remove(path);
                    break;
                }
            }
        }
        return stationList;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Station getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(Station firstStation) {
        this.firstStation = firstStation;
    }

    public Set<Path> getPaths() {
        return paths;
    }

    public void setPaths(Set<Path> paths) {
        this.paths = paths;
    }
}
