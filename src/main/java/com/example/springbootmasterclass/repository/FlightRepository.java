package com.example.springbootmasterclass.repository;

import com.example.springbootmasterclass.repository.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, Long> {

}
