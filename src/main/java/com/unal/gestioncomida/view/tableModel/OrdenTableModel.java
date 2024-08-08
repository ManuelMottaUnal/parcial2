
package com.unal.gestioncomida.view.tableModel;

import com.unal.gestioncomida.model.Compra;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class OrdenTableModel extends AbstractTableModel{

    private final List<Compra> compras;

    public OrdenTableModel(List<Compra> compras) {
        this.compras = compras;
    }
    private final String[] columnNames = {"Producto", "Precio"};
    @Override
    public int getRowCount() {
        return compras.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Compra compra = compras.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> compra.getAlimento().getNombre();
            case 1 -> compra.getCantidad();
            default -> null;
        };
    }
    
    public Compra getObjectAt(int rowIndex) {
        return compras.get(rowIndex);
    }
    
}
