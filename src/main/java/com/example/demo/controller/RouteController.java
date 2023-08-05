package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Route;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RouteController {
    @Autowired
    RouteRepository routeRepository;

    @GetMapping("/routes")
    public List<Route> getRoutes(){
        return routeRepository.findAll();
    }

    @GetMapping("/routes/{id}")
    public Optional<Route> getRouteByID(@PathVariable long id){
        return routeRepository.getRouteById(id);
    }

    @GetMapping("/routes/searchinstant/{search}")
    public List<Route> getSearch(@PathVariable(value = "search") String search){
        return routeRepository.findByNameLike("%"+search+"%");
    }

    @PostMapping("/routes")
    public Optional<Route> postRoute(@RequestBody Route route){
        Route _route = routeRepository.save(new Route(route.getName(), route.getDistance()));
        return Optional.of(_route);
    }

    @PutMapping("/routes/{id}")
    public Optional<Route> putRoute(@PathVariable("id") long id, @RequestBody Route route){
        Route _route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldnt find route w id: " + id));

        _route.setName(route.getName());
        _route.setDistance(route.getDistance());

        return Optional.of(routeRepository.save(_route));
    }

    @DeleteMapping("/routes/{id}")
    public Optional<Route> deleteRoute(@PathVariable("id") long id){
        Route _route = routeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Couldnt find route w id:" + id));
        routeRepository.deleteById(id);
        return Optional.of(_route);
    }

}
