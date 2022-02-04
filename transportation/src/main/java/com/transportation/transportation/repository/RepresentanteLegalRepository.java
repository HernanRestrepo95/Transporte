/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.transportation.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transportation.transportation.entity.RepresentanteLegal;
import com.transportation.transportation.entity.TipoIdentificacion;
import java.util.List;
/**
 *
 * @author Hernan_Restrepo
 */
@Repository
public interface RepresentanteLegalRepository extends JpaRepository<RepresentanteLegal, Long> {
    public List<RepresentanteLegal> findByTipoIdentificacionAndNumeroDocumento(TipoIdentificacion tipoIdentificacion, int numeroDocumento);
}
