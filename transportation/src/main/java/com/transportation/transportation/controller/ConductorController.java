package com.transportation.transportation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportation.transportation.service.ConductorService;

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

import com.transportation.transportation.entity.Conductor;
import com.transportation.transportation.entity.TipoIdentificacion;

@RestController
@RequestMapping(value = "/conductor")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public ResponseEntity<List<Conductor>> listAllConductors(
            @RequestParam(name = "tipoIdentificacion", required = false) TipoIdentificacion tipoIdentificacion,
            @RequestParam(name = "numeroIdentificacion", required = false) Integer numeroIdentificacion) {
        List<Conductor> lstConductors = new ArrayList<>();

        if (tipoIdentificacion != null && numeroIdentificacion != null) {
            lstConductors = conductorService.findByTipoIdentificacionAndNumeroDocumento(tipoIdentificacion, numeroIdentificacion);
            if (lstConductors.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        } else {
            lstConductors = conductorService.listAllConductors();
            if (lstConductors.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.ok(lstConductors);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Conductor> getConductor(@PathVariable("id") Long id) {
        Conductor conductor = conductorService.getConductor(id);
        if (null == conductor) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conductor);
    }

    @PostMapping
    public ResponseEntity<Conductor> createConductor(@Valid @RequestBody Conductor conductor, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Conductor conductorCreate = conductorService.createConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(conductorCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Conductor> updateConductor(@Valid @PathVariable("id") Long id, @RequestBody Conductor conductor, BindingResult result) {

        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        conductor.setId(id);
        Conductor conductorDB = conductorService.updateConductor(conductor);
        if (conductorDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conductorDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteConductor(@PathVariable("id") Long id) {
        boolean conductorDelete = conductorService.deleteConductor(id);
        if (!conductorDelete) {
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
