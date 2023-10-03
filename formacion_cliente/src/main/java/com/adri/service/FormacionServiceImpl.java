package com.adri.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.adri.model.Curso;
import com.adri.model.Formacion;

/**
 * @see com.adri.service.FormacionService
 * @see com.adri.formacion_cliente.FormacionClienteApplication
 */

@Service
public class FormacionServiceImpl implements FormacionService {

    private String url = "http://localhost:8080/";

    @Autowired
    RestTemplate template;

    /**
     * @param listaCurso Creamos un array con todos los cursos que tenemos
     * @param listaFormacion Con esta lista haremos la conversion de curso a formacion y los iremos añadiendo
     */

    @Override
    public List<Formacion> lista() {

    List<Curso> listaCurso = Arrays.asList(template.getForObject(url+"curso", Curso[].class));
    List<Formacion> listaFormacion = new ArrayList<>();

        for(Curso curso: listaCurso){
            Formacion formacion = new Formacion();
           formacion.setCurso(curso.getCodigo());
           int asignaturas = (curso.getDuracion() > 50)? 10:5;
           formacion.setAsignaturas(asignaturas);
           formacion.setPrecioFormacion(curso.getPrecio());
            listaFormacion.add(formacion);
        }

        return listaFormacion;

    }

    /**
     * @param formacio Es el objeto que construimos en el controlador y se lo pasamos al service
     * @param nombreFormacion Es el nombre que queremos para nuesto curso, como formacion no tiene el atributo de nombre
     *                          se lo pasamos de manera independiente
     * 
     * @param if Hacemos una llamada con el codigo del nuevo curso, si recibe respuesta significa que existe, si recibimos null
     *              creamos con el postForLocation
     */
    @Override
    public void alta(Formacion formacion, String nombreFormacion) {

        Curso curso = new Curso(formacion.getCurso(),nombreFormacion,formacion.getAsignaturas()*10,formacion.getPrecioFormacion());
        if(template.getForObject(url+"curso/"+curso.getCodigo(), Curso.class) == null){
            template.postForLocation(url+"curso", curso);
        }

         
        
       }
    
}
