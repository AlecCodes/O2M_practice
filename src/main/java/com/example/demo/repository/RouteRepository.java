package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
}