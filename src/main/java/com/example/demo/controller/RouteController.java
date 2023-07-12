package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

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
}
