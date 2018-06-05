package com.temperatures.rest.repository;

import org.springframework.stereotype.Repository;
import com.temperatures.rest.model.Temperatures;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface TemperaturesRepository extends JpaRepository<Temperatures, Long> {

}
