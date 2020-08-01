/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.model;

import bl.Author;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author D Abazi
 */
public class AuthorTableModel extends AbstractTableModel{
    
    private final String[] columnNames = {"ID","Emri","Mbiemri","Dt. e lindjes","Qyteti","Shteti"};
    private List<Author> data;
    
    public AuthorTableModel(List<Author>data){
        this.data = data;
    }
    
    public AuthorTableModel() {
    }
    
    public void add(List<Author>data){
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
    
    public Author getAuthor(int index){
        return data.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Author en = (Author)data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return en.getId();
            case 1:
                return en.getFirstName();
            case 2:
                return en.getLastName();
            case 3:
                return en.getDateOfBirth();
            case 4:
                return en.getCity();
            case 5:
                return en.getCountry();
            default:
                return null;
        }
    }
}

