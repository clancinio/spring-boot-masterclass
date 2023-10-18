package com.example.springbootmasterclass.repository;

import com.example.springbootmasterclass.repository.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {

}
