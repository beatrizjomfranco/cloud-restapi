package br.bootcamp.cloudrestapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.bootcamp.cloudrestapi.exception.ParkingNotFoundException;
import br.bootcamp.cloudrestapi.model.Parking;
import br.bootcamp.cloudrestapi.repository.ParkingRepo;

@Service
public class ParkingService 
{

    private final ParkingRepo parkingRepo;

    public ParkingService(ParkingRepo parkingRepo) 
    {
        this.parkingRepo = parkingRepo;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Parking> findAll() 
    {
        return parkingRepo.findAll();
    }

    private static String getUUID() 
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Transactional(readOnly = true)
    public Parking findById(String id) 
    {
        return parkingRepo.findById(id).orElseThrow(() ->
                new ParkingNotFoundException(id));
    }

    @Transactional
    public Parking create(Parking parkingCreate) 
    {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepo.save(parkingCreate);
        return parkingCreate;
    }

    @Transactional
    public void delete(String id) 
    {
        findById(id);
        parkingRepo.deleteById(id);
    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) 
    {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parking.setState(parkingCreate.getState());
        parking.setModel(parkingCreate.getModel());
        parking.setLicense(parkingCreate.getLicense());
        parkingRepo.save(parking);
        return parking;
    }

    @Transactional
    public Parking checkOut(String id) 
    {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckout.getBill(parking));
        parkingRepo.save(parking);
        return parking;
    }

}