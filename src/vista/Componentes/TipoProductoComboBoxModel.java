/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Componentes;

import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import modelo.TIpo_Producto;

/**
 *
 * @author netom
 */
public class TipoProductoComboBoxModel extends AbstractListModel<TIpo_Producto> implements ComboBoxModel<TIpo_Producto> {
    private List<TIpo_Producto> tipos;
    private TIpo_Producto seleccionado;

    /**
     *
     * @param tipos
     */
    public TipoProductoComboBoxModel(List<TIpo_Producto> tipos) {
        this.tipos = tipos;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return tipos.size();
    }

    /**
     *
     * @param index
     * @return
     */
    public TIpo_Producto getElementAt(int index) {
        return tipos.get(index);
    }

    /**
     *
     * @param item
     */
    public void setSelectedItem(Object item) {
        seleccionado = (TIpo_Producto) item;
    }

    /**
     *
     * @return
     */
    public TIpo_Producto getSelectedItem() {
        return seleccionado;
    }

    /**
     *
     * @param anObject
     * @return
     */
    public int getIndexOf(Object anObject) {
        return tipos.indexOf(anObject);
    }
}
