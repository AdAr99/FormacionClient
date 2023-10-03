package com.adri.service;

import java.util.List;

import com.adri.model.Formacion;

public interface FormacionService {
    List<Formacion> lista();
    void alta(Formacion formacion, String nombreFormacion);
}
