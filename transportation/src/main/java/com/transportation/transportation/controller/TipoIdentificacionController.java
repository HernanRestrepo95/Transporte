package com.transportation.transportation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportation.transportation.service.TipoIdentificacionService;

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

import com.transportation.transportation.entity.TipoIdentificacion;

@RestController
@RequestMapping(value = "/tipoidentificacion")
public class TipoIdentificacionController {

    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;

    @GetMapping
    public ResponseEntity<List<TipoIdentificacion>> listAllTipoIdentificacions() {
        List<TipoIdentificacion> lstTipoIdentificacions = new ArrayList<>();

        lstTipoIdentificacions = tipoIdentificacionService.listAllTipoIdentificacions();
        if (lstTipoIdentificacions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(lstTipoIdentificacions);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoIdentificacion> getTipoIdentificacion(@PathVariable("id") Long id) {
        TipoIdentificacion tipoIdentificacion = tipoIdentificacionService.getTipoIdentificacion(id);
        if (null == tipoIdentificacion) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoIdentificacion);
    }

    @PostMapping
    public ResponseEntity<TipoIdentificacion> createTipoIdentificacion(@Valid @RequestBody TipoIdentificacion tipoIdentificacion, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        TipoIdentificacion tipoIdentificacionCreate = tipoIdentificacionService.createTipoIdentificacion(tipoIdentificacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoIdentificacionCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoIdentificacion> updateTipoIdentificacion(@Valid @PathVariable("id") Long id, @RequestBody TipoIdentificacion tipoIdentificacion, BindingResult result) {

        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        tipoIdentificacion.setId(id);
        TipoIdentificacion tipoIdentificacionDB = tipoIdentificacionService.updateTipoIdentificacion(tipoIdentificacion);
        if (tipoIdentificacionDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoIdentificacionDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteTipoIdentificacion(@PathVariable("id") Long id) {
        boolean tipoIdentificacionDelete = tipoIdentificacionService.deleteTipoIdentificacion(id);
        if (!tipoIdentificacionDelete) {
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
