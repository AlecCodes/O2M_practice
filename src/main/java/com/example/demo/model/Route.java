package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    //Generator must be the same as the name of the sequence generator in order for allocation size to work.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_generator")
    @SequenceGenerator(name = "routes_generator", sequenceName = "routes_seq", allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name="distance")
    private double distance;

    public Route(){}

    public Route(String name, double distance){
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
