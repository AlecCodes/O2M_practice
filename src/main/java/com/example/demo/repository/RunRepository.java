package com.example.demo.repository;
import java.util.List;
import com.example.demo.model.Run;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepository extends JpaRepository<Run, Long> {

}
