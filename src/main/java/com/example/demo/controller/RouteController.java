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

    @GetMapping("/routes/searchinstant/{search}")
    public List<Route> getSearch(@PathVariable(value = "search") String search){
        return routeRepository.findByNameLike("%"+search+"%");
    }

    @PostMapping("/routes")
    public Optional<Route> postRoute(@RequestBody Route route){
        Route _route = routeRepository.save(new Route(route.getName(), route.getDistance()));
        return Optional.of(_route);
    }

}
