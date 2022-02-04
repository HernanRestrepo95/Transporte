/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
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
public class RepresentanteLegal implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String ciudad;
    private String departamento;
    private String direccion;
    private String nombre;
    private BigInteger numeroDocumento;
    private String pais;
    private String telefono;
    private TipoIdentificacion tipoIdentificacion;
    private Collection<Empresa> empresaCollection;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RepresentanteLegal)) {
            return false;
        }
        RepresentanteLegal other = (RepresentanteLegal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
