package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Route;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByNameLike(String search);
}
