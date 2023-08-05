package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Run;
import com.example.demo.repository.RunRepository;
import com.example.demo.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RunController {

    @Autowired
    RunRepository runRepository;

    @Autowired
    RouteRepository routeRepository;

    @GetMapping("/runs")
    public List<Run> getRuns() {return runRepository.findAll();}

    @GetMapping("/runs/{id}")
    public Optional<Run> getRunById(@PathVariable(value="id") Long id ){
        Run run = runRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("COULD NOT FIND RUN W ID: " + id));
        return runRepository.findById(id);
    }

    //If we don't handle errors, then map returns an optional inside an optional, which can't be converted to a Run type
    @PostMapping("/routes/{id}/runs")
    public Optional<Run> createRun(@PathVariable(value="id") Long routeId, @RequestBody Run runRequest){
        Run run = routeRepository.findById(routeId).map(r -> {
            runRequest.setRoute(r);
            return runRepository.save(runRequest);
        }).orElseThrow(() -> new RuntimeException("Couldn't find route with id: " + routeId) ) ;
        return Optional.of(run);
    }





}
