package com.tsystems.railway.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "time_template")
public class TimeTemplate {

    @Column(name = "template_id")
    @GeneratedValue
    @Id
    private int id;

    @Column(name = "template_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @OneToMany(mappedBy = "template",cascade = CascadeType.ALL)
    private Set<TemplateStation> templateStationSet;

    public TimeTemplate() {
    }

    public TimeTemplate(int id,String name, Route route, Set<TemplateStation> templateStationSet) {
        this.id = id;
        this.name = name;
        this.route = route;
        this.templateStationSet = templateStationSet;
    }

    public TimeTemplate(String name, Route route, Set<TemplateStation> templateStationSet) {
        this.name = name;
        this.route = route;
        this.templateStationSet = templateStationSet;
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

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Set<TemplateStation> getTemplateStationSet() {
        return templateStationSet;
    }

    public void setTemplateStationSet(Set<TemplateStation> templateStationSet) {
        this.templateStationSet = templateStationSet;
    }

    @Override
    public String toString() {
        return "";
    }
}
