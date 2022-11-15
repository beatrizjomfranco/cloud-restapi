package br.bootcamp.cloudrestapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bootcamp.cloudrestapi.model.Parking;

@RestController
@RequestMapping("/parking") // http://localhost:8080/parking

public class ParkingController {
        
        @GetMapping
        public List<Parking> findAll()
        {
                var parking = new Parking(); //importar parking
                parking.setColor("Prata");
                parking.setModel("MiniCooper Contryman");
                parking.setLicense("A1B2C3");//placa do carro
                parking.setState("São Paulo");

                return Arrays.asList(parking);

        }
}
