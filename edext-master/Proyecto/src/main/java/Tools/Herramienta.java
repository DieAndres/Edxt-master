package Tools;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class Herramienta {
	public static void llenarCombobox(JComboBox<String> comboBox, ArrayList<String> arrayList) {
		for(String i : arrayList) {
			if(existeCombobox(comboBox,i) == false) {
				comboBox.addItem(i);
			}
		}
	}

	public static void llenarLista(List list,ArrayList<String> nombres) {
		list.removeAll();
		for(String nom: nombres) {
			list.add(nom);
		}
	}

	public static Boolean existeCombobox(JComboBox<String> jComboBox, String name) {
		ComboBoxModel<String> model = jComboBox.getModel();
        int size = model.getSize();
        
		for(int i=0 ; i < size; i++) {
			Object element = model.getElementAt(i);
			if(element.toString().equals(name) ==true) {
				return true;
			}
		}
		return false;
	}
	
	public static void blockAll(JComponent ...components) {
		for(JComponent c : components) {
			c.setEnabled(false);
		}
	}
	public static void unblockAll(JComponent ...components) {
		for(JComponent c : components) {
			c.setEnabled(true);
		}
	}
	public static void emptyAll(JTextField ...components) {
		for(JTextField c : components) {
			c.setText(null);;
		}
	}
	public static Date getDateSystem() {
		return new Date(System.currentTimeMillis());
	}
	
	public static Boolean CMBIsEmpty(JComboBox<String> cb) { 
	return (cb.getItemCount()==0); 
	}
	
}
