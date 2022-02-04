/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
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
public class Conductor implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String ciudad;
    private String departamento;
    private String direccion;
    private String nombre;
    private BigInteger numeroDocumento;
    private String pais;
    private String telefono;
    private List<Vehiculo> lstVehiculo;
    private TipoIdentificacion tipoIdentificacion;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
