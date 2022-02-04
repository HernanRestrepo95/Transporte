/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Hernan_Restrepo
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String chasis;      
    private Date fechaMatricula;
    private String linea;
    private String marca;
    private BigInteger modelo;
    private String motor;
    private BigInteger pasajerosPie;
    private BigInteger pasajerosSentados;
    private BigInteger pesoBruto;
    private BigInteger pesoSeco;
    private String placa;
    private BigInteger puertas;
    private Collection<Conductor> conductorCollection;
    private Empresa empresa;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
