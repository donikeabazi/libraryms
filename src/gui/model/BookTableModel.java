/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.model;

import bl.Book;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gjyli
 */
public class BookTableModel extends AbstractTableModel{
    
    private final String[] columnNames = {"ID","Titulli","Pershkrimi","ISBN","AutoriID","PublikuesiID"};
    private List<Book> data;
    
    public BookTableModel(List<Book>data){
        this.data = data;
    }
    
    public BookTableModel() {
    }
    
    public void add(List<Book>data){
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
    
    public Book getBook(int index){
        return data.get(index);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book en = (Book)data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return en.getId();
            case 1:
                return en.getTitle();
            case 2:
                return en.getDescription();
            case 3:
                return en.getIsbn();
            case 4:
                return en.getAuthorID();
            case 5:
                return en.getPublisherID();
            default:
                return null;
        }
    }

}
