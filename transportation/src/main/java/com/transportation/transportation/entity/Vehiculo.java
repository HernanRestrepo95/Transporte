/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.transportation.transportation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Hernan_Restrepo
 */
@Entity
@Table(name = "vehiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "placa")
    private String placa;

    @Column(name = "motor")
    private String motor;

    @Column(name = "chasis")
    private String chasis;

    @Column(name = "modelo")
    private Long modelo;

    @Column(name = "fecha_matricula")
    private Date fechaMatricula;

    @Column(name = "pasajeros_sentados")
    private Long pasajerosSentados;

    @Column(name = "pasajeros_pie")
    private Long pasajerosPie;

    @Column(name = "peso_seco")
    private Long pesoSeco;

    @Column(name = "peso_bruto")
    private Long pesoBruto;

    @Column(name = "puertas")
    private Long puertas;

    @Column(name = "marca")
    private String marca;

    @Column(name = "linea")
    private String linea;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = true)
    private Empresa empresa;

    @JsonIgnore
    @ManyToMany(mappedBy = "lstVehiculo")
    private List<Conductor> lstConductor;
}
