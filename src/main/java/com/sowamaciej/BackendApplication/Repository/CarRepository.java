package com.sowamaciej.BackendApplication.Repository;

import com.sowamaciej.BackendApplication.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
