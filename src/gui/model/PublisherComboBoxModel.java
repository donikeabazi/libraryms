/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.model;

import bl.Publisher;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Gjyli
 */
public class PublisherComboBoxModel extends AbstractListModel<Publisher> implements ComboBoxModel<Publisher> {

    private List<Publisher> data;
    private Publisher selectedItem;

    public PublisherComboBoxModel(List<Publisher> data) {
        this.data = data;
    }

    public PublisherComboBoxModel() {
    }

    public void add(List<Publisher> data) {
        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Publisher getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Publisher)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }


}
