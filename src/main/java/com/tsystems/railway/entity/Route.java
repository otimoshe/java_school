package com.tsystems.railway.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue
    @Column(name = "route_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "first_station_id")
    private Station firstStation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "routes_paths",
            joinColumns = {@JoinColumn(name = "route_id")},
            inverseJoinColumns = {@JoinColumn(name = "path_id")})
    private Set<Path> paths = new HashSet<>();

    @OneToMany(mappedBy = "route")
    private Set<Trip> trips;

    @OneToMany(mappedBy = "route")
    private Set<TimeTemplate> templates;

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

    public Route(int id, String name, BigDecimal price, Station firstStation, Set<Path> paths) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.firstStation = firstStation;
        this.paths = paths;
    }

    public List<Station> getStationList() {
        Set<Path> paths = new HashSet<>(this.getPaths());
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

    public List<Station> getSubRoute(Station start, Station end) {
        List<Station> stationList = this.getStationList();
        int startIndex = stationList.indexOf(start);
        int endIndec = stationList.indexOf(end);
        List<Station> subRoute = stationList.subList(startIndex, endIndec);
        subRoute.add(end);
        return subRoute;
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

    public Station getLastStation(){
        List<Station>stations = this.getStationList();
        return stations.get(stations.size()-1);
    }

    public void setPaths(Set<Path> paths) {
        this.paths = paths;
    }

    public BigDecimal priceCalculate(Station departStation, Station arriveStation) {
        List<Station> subRoute = getSubRoute(departStation, arriveStation);
        if (subRoute.get(0).equals(this.firstStation) && (subRoute.get(subRoute.size()-1).equals(this.getLastStation()))){
            return this.price;
        }
        double subRouteDistance = 0;
        double routeDistance = 0;
        for (Path path : paths) {
            routeDistance += path.getDistance();
        }
        HashSet<Path> paths = new HashSet<Path>(this.getPaths());
        Station currentStation = subRoute.get(0);
        Station nextStation = subRoute.get(1);
        int i = 1;
        while( i < subRoute.size( ) ) {
            Iterator<Path> iterator = paths.iterator();
            while (iterator.hasNext()) {
                Path path = iterator.next();
                if ((path.getStation().equals(currentStation) && (path.getNextStation().equals(nextStation))) ||
                        (path.getStation().equals(nextStation) && path.getNextStation().equals(currentStation))) {
                    subRouteDistance += path.getDistance();
                    iterator.remove();
                    i++;
                    currentStation = nextStation;
                    if (i != subRoute.size()){
                        nextStation = subRoute.get(i);
                    }else
                        break;

                }
            }
        }

        BigDecimal price =  (this.getPrice().multiply(new BigDecimal(subRouteDistance))).divide(new BigDecimal(routeDistance), RoundingMode.HALF_UP);

        return price;
    }
}
