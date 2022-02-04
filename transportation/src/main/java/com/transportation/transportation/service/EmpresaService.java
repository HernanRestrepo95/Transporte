package com.transportation.transportation.service;

import java.util.List;

import com.transportation.transportation.entity.Empresa;
import com.transportation.transportation.entity.TipoIdentificacion;


public interface EmpresaService {
    public List<Empresa> listAllEmpresas();
    public Empresa getEmpresa(Long id);
    public Empresa createEmpresa(Empresa empresaDTO);
    public Empresa updateEmpresa(Empresa empresaDTO);
    public boolean deleteEmpresa(Long id);
    public List<Empresa> findByTipoIdentificacionAndNumeroDocumento(TipoIdentificacion tipoIdentificacion, int numeroDocumento);
}
