/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.model;

import bl.Publisher;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Eliona M
 */
public class PublisherTableModel extends AbstractTableModel{
    
    private final String[] columnNames = {"ID","Emri","Shteti"};
    private List<Publisher> data;
    
    public PublisherTableModel(List<Publisher>data){
        this.data = data;
    }
    
    public PublisherTableModel() {
    }
    
    public void add(List<Publisher>data){
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }
    
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int col){
        return columnNames[col];
    }
    
    public void remove(int row){
        data.remove(row);
    }
    
    public Publisher getPublisher(int index){
        return data.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Publisher en = (Publisher)data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return en.getId();
            case 1:
                return en.getCountry();
            default:
                return null;
        }
    }

}
