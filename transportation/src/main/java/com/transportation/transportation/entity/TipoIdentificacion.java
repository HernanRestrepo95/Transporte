/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.transportation.transportation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "tipo_identificacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TipoIdentificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<Conductor> lstConductor;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<Empresa> lstEmpresa;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<RepresentanteLegal> lstRepresentanteLegal;
}
