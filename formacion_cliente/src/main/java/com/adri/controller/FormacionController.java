package com.adri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adri.model.Formacion;
import com.adri.service.FormacionService;

/**
 * @see com.adri.service.FormacionService
 * @author Adrián Armesto
 */

@RestController
public class FormacionController{
    
    @Autowired
    FormacionService service;

    /**
     * @param @GetMapping Indicamos mediante el verbo get que queremos obetener datos
     * @return
     */
    @GetMapping(value="formacion")
    public List<Formacion> lista(){
        return service.lista();
    }

    /**
     * @param @PostMappin Indicamos mediante el verbo post que queremos insertar
     * @param curso El codigo del curso
     * @param nombreFormacion El nombre del curso, este parametro lo pasaremos de maneera independiente ya que formacion no contiene
     *                          este atributo
     * @param asignaturas El nombre de asignaturas
     * @param precio El precio
     * 
     * @param formacion Creamos el objeto formacion con los valores de la url
     */

    @PostMapping(value="formacion/{curso}/{nombreFormacion}/{asignaturas}/{precio}")
    public void alta(@PathVariable int curso,@PathVariable String nombreFormacion ,@PathVariable int asignaturas,@PathVariable int precio){
       Formacion formacion = new Formacion(curso, asignaturas, precio);
        service.alta(formacion, nombreFormacion); 
    }


}
