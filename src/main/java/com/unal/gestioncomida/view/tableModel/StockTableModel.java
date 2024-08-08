
package com.unal.gestioncomida.view.tableModel;

import com.unal.gestioncomida.model.Alimento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class StockTableModel extends AbstractTableModel{

    private final List<Alimento> alimentos;

    public StockTableModel(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
    private final String[] columnNames = {"Producto", "Precio"};
    @Override
    public int getRowCount() {
        return alimentos.size();
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
        Alimento alimento = alimentos.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> alimento.getNombre();
            case 1 -> alimento.getValor();
            default -> null;
        };
    }
    
    public Alimento getObjectAt(int rowIndex) {
        return alimentos.get(rowIndex);
    }
    
}
