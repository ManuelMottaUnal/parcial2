package com.unal.gestioncomida.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Orden {
    private ArrayList<Compra> listaCompra;
    private LocalDateTime fechaCompra;
    private Integer totalValue;

    public Orden() {
        listaCompra = new ArrayList<>();
        fechaCompra = LocalDateTime.now();
        totalValue = 0;
    }

    public ArrayList<Compra> getListaCompra() {
        return listaCompra;
    }

    public String getFechaCompra() {
        return fechaCompra.toString();
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getTotalValue() {
        totalValue = 0;
        for (Compra compra : listaCompra) {
            totalValue += compra.getValorNeto();
        }
        return totalValue;
    }
    
    public void addCompra(Compra compra) {
        listaCompra.add(compra);
    }
    
    public void removeCompra(Compra compra) {
        listaCompra.remove(compra);
    }
}
