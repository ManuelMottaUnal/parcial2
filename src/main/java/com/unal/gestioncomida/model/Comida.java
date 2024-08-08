package com.unal.gestioncomida.model;

import java.util.ArrayList;

public class Comida {
    private ArrayList<Alimento> stock;
    private ArrayList<Orden> ordenes;

    public ArrayList<Alimento> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Alimento> stock) {
        this.stock = stock;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public Comida(ArrayList<Alimento> stock, ArrayList<Orden> ordenes) {
        this.stock = stock;
        this.ordenes = ordenes;
    }

    public Comida() {
        stock = new ArrayList<>();
        ordenes = new ArrayList<>();
    }
    
    public void addStock(Alimento alimento) {
        stock.add(alimento);
    }
    public void removeStock(Alimento alimento) {
        stock.remove(alimento);
    }
    public void addOrden(Orden orden) {
        ordenes.add(orden);
    }
    public void removeOrden(Orden orden) {
        ordenes.remove(orden);
    }
    
}
