package br.bootcamp.cloudrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.bootcamp.cloudrestapi.model.Parking;

@Repository // criação de uma interface
public interface ParkingRepo extends JpaRepository<Parking, String> 
{

}
