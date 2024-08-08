
package com.unal.gestioncomida.model;

public class Compra {
    private Alimento alimento;
    private Integer cantidad;

    public Compra(Alimento alimento, Integer cantidad) {
        this.alimento = alimento;
        this.cantidad = cantidad;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValorNeto() {
        return alimento.getValor() * cantidad;
    }

    public Compra() {
    }
}
