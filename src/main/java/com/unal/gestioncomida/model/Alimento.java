package com.unal.gestioncomida.model;

public class Alimento {
    private String nombre;
    private Integer valor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Alimento(String nombre, Integer valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public Alimento() {
    }
}
