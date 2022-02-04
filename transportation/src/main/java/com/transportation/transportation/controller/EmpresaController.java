package com.transportation.transportation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transportation.transportation.service.EmpresaService;

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

import com.transportation.transportation.entity.Empresa;
import com.transportation.transportation.entity.TipoIdentificacion;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> listAllEmpresas(
            @RequestParam(name = "tipoIdentificacion", required = false) TipoIdentificacion tipoIdentificacion,
            @RequestParam(name = "numeroIdentificacion", required = false) Integer numeroIdentificacion) {
        List<Empresa> lstEmpresas = new ArrayList<>();

        if (tipoIdentificacion != null && numeroIdentificacion != null) {
            lstEmpresas = empresaService.findByTipoIdentificacionAndNumeroDocumento(tipoIdentificacion, numeroIdentificacion);
            if (lstEmpresas.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        } else {
            lstEmpresas = empresaService.listAllEmpresas();
            if (lstEmpresas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.ok(lstEmpresas);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresa> getEmpresa(@PathVariable("id") Long id) {
        Empresa empresa = empresaService.getEmpresa(id);
        if (null == empresa) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresa);
    }

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@Valid @RequestBody Empresa empresa, BindingResult result) {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }
        Empresa empresaCreate = empresaService.createEmpresa(empresa);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Empresa> updateEmpresa(@Valid @PathVariable("id") Long id, @RequestBody Empresa empresa, BindingResult result) {

        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
        }

        empresa.setId(id);
        Empresa empresaDB = empresaService.updateEmpresa(empresa);
        if (empresaDB == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(empresaDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteEmpresa(@PathVariable("id") Long id) {
        boolean empresaDelete = empresaService.deleteEmpresa(id);
        if (!empresaDelete) {
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
