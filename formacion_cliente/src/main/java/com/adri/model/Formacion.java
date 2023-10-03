package com.adri.model;

public class Formacion {
    private int curso;
    private int asignaturas;
    private int precioFormacion;
  
    public Formacion() {
    }

    public Formacion(int curso, int asignaturas, int precioFormacion) {
        this.curso = curso;
        this.asignaturas = asignaturas;
        this.precioFormacion = precioFormacion;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(int asignaturas) {
        this.asignaturas = asignaturas;
    }

    public int getPrecioFormacion() {
        return precioFormacion;
    }

    public void setPrecioFormacion(int precioFormacion) {
        this.precioFormacion = precioFormacion;
    }

    
}
