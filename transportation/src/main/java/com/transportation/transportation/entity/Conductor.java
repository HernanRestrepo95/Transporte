/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.transportation.transportation.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
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
@Table(name = "conductor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Conductor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_identificacion", nullable = false)
    private TipoIdentificacion tipoIdentificacion;

    @Column(name = "numero_documento")
    @NotEmpty(message = "El campo numero documento no debe ser vacío")    
    @NotNull(message = "Debe contener un numero_documento")
    private Long numeroDocumento;

    @Column(name = "nombre")
    @NotEmpty(message = "El campo nombre no debe ser vacío")    
    @NotNull(message = "Debe contener un nombre")
    private String nombre;

    @Column(name = "direccion")
    @NotEmpty(message = "El campo direccion no debe ser vacío")    
    @NotNull(message = "Debe contener un direccion")
    private String direccion;

    @Column(name = "ciudad")
    @NotEmpty(message = "El campo ciudad no debe ser vacío")    
    @NotNull(message = "Debe contener un ciudad")
    private String ciudad;

    @Column(name = "departamento")
    @NotEmpty(message = "El campo departamento no debe ser vacío")    
    @NotNull(message = "Debe contener un departamento")
    private String departamento;

    @Column(name = "pais")
    @NotEmpty(message = "El campo pais no debe ser vacío")    
    @NotNull(message = "Debe contener un pais")
    private String pais;

    @Column(name = "telefono")
    @NotEmpty(message = "El campo telefono no debe ser vacío")    
    @NotNull(message = "Debe contener un telefono")
    private String telefono;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name = "conductor_vehiculo", 
        joinColumns = { @JoinColumn(name = "id_conductor") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_vehiculo") }
    )
    private List<Vehiculo> lstVehiculo;

}
