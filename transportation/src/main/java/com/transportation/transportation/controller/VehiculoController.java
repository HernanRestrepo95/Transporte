package com.transportation.transportation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportation.transportation.service.VehiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.transportation.transportation.entity.Vehiculo;

@RestController
@RequestMapping(value = "/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping
    public ResponseEntity<List<Vehiculo>> listAllVehiculos() {
        List<Vehiculo> lstVehiculos = new ArrayList<>();

        lstVehiculos = vehiculoService.listAllVehiculos();
        if (lstVehiculos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lstVehiculos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehiculo> getVehiculo(@PathVariable("id") Long id) {
        Vehiculo vehiculo = vehiculoService.getVehiculo(id);
        if (null == vehiculo) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehiculo);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> createVehiculo(@Valid @RequestBody Vehiculo vehiculo, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Vehiculo vehiculoCreate = vehiculoService.createVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@Valid @PathVariable("id") Long id, @RequestBody Vehiculo vehiculo, BindingResult result) {

        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        vehiculo.setId(id);
        Vehiculo vehiculoDB = vehiculoService.updateVehiculo(vehiculo);
        if (vehiculoDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehiculoDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteVehiculo(@PathVariable("id") Long id) {
        boolean vehiculoDelete = vehiculoService.deleteVehiculo(id);
        if (!vehiculoDelete) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    private String formatMessage(BindingResult result) {
        List<Map<String, String>> errors = result.getFieldErrors().stream().map(err -> {
            Map<String, String> error = new HashMap<>();
            error.put(err.getField(), err.getDefaultMessage());
            return error;

        }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder().code("01").messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
