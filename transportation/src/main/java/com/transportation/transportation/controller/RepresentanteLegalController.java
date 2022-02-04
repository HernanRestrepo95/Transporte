package com.transportation.transportation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportation.transportation.service.RepresentanteLegalService;

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

import com.transportation.transportation.entity.RepresentanteLegal;
import com.transportation.transportation.entity.TipoIdentificacion;

@RestController
@RequestMapping(value = "/representantelegal")
public class RepresentanteLegalController {

    @Autowired
    private RepresentanteLegalService representanteLegalService;

    @GetMapping
    public ResponseEntity<List<RepresentanteLegal>> listAllRepresentanteLegals(
            @RequestParam(name = "tipoIdentificacion", required = false) TipoIdentificacion tipoIdentificacion,
            @RequestParam(name = "numeroIdentificacion", required = false) Integer numeroIdentificacion) {
        List<RepresentanteLegal> lstRepresentanteLegals = new ArrayList<>();

        if (tipoIdentificacion != null && numeroIdentificacion != null) {
            lstRepresentanteLegals = representanteLegalService.findByTipoIdentificacionAndNumeroDocumento(tipoIdentificacion, numeroIdentificacion);
            if (lstRepresentanteLegals.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        } else {
            lstRepresentanteLegals = representanteLegalService.listAllRepresentanteLegals();
            if (lstRepresentanteLegals.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.ok(lstRepresentanteLegals);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RepresentanteLegal> getRepresentanteLegal(@PathVariable("id") Long id) {
        RepresentanteLegal representanteLegal = representanteLegalService.getRepresentanteLegal(id);
        if (null == representanteLegal) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(representanteLegal);
    }

    @PostMapping
    public ResponseEntity<RepresentanteLegal> createRepresentanteLegal(@Valid @RequestBody RepresentanteLegal representanteLegal, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        RepresentanteLegal representanteLegalCreate = representanteLegalService.createRepresentanteLegal(representanteLegal);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(representanteLegalCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RepresentanteLegal> updateRepresentanteLegal(@Valid @PathVariable("id") Long id, @RequestBody RepresentanteLegal representanteLegal, BindingResult result) {

        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        representanteLegal.setId(id);
        RepresentanteLegal representanteLegalDB = representanteLegalService.updateRepresentanteLegal(representanteLegal);
        if (representanteLegalDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(representanteLegalDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRepresentanteLegal(@PathVariable("id") Long id) {
        boolean representanteLegalDelete = representanteLegalService.deleteRepresentanteLegal(id);
        if (!representanteLegalDelete) {
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
