package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.components.JSpinField;

import DataType.DtEdicion;
import Interface.IAlta;
import Interface.IConsulta;
import Logica.Edicion;
import Logica.Manejador;
import Tools.Herramienta;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.Color;

public class JEdicionConsulta extends BackGround {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbxInstituto;
	private JComboBox<String> cbxCurso;
	private JComboBox<String> cbxEdicion;
	private JEdicionDatos edicionDatos;
	
	private Manejador manejador = Manejador.getInstancia();
	private JPanel panel;
	private JLabel lblNewLabel;
	/**
	 * Create the panel.
	 */
	public JEdicionConsulta(IAlta iAlta,IConsulta iConsulta,Principal principal) {
		
		setLayout(new MigLayout("", "[grow][::400px,grow,left][grow,right]", "[grow][grow][grow]"));
		
		lblNewLabel = new JLabel("Consulta de Edicion");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel, "cell 1 0,alignx center,aligny bottom");
		
		panel = new JPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[][grow]", "[14px][][][grow]"));
		
				
				
				JLabel lblInstituto = new JLabel("Instituto");
				panel.add(lblInstituto, "cell 0 0,growx,aligny top");
				lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
				
				cbxInstituto = new JComboBox<String>();
				panel.add(cbxInstituto, "cell 1 0,growx");
				
				JLabel lblCurso = new JLabel("Cursos");
				panel.add(lblCurso, "cell 0 1");
				lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
				
				
				
				cbxCurso = new JComboBox<String>();
				panel.add(cbxCurso, "cell 1 1,growx");
				
				JLabel lblEdiciones = new JLabel("Ediciones");
				panel.add(lblEdiciones, "cell 0 2");
				
				cbxEdicion = new JComboBox<String>();
				panel.add(cbxEdicion, "cell 1 2,growx");
				edicionDatos = new JEdicionDatos();
				panel.add(edicionDatos, "cell 0 3 2 1,grow");
				cbxEdicion.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(Herramienta.CMBIsEmpty(cbxEdicion) == false) {
							DtEdicion dtEdicion = manejador.buscarEdicion(cbxEdicion.getSelectedItem().toString()).getDtEdicion();
							edicionDatos.llenarDatos(dtEdicion);
						}
					}
				});
				cbxCurso.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(Herramienta.CMBIsEmpty(cbxCurso) == false) {
							cbxEdicion.removeAllItems();
							Herramienta.llenarCombobox(cbxEdicion,iConsulta.seleccionarCurso(cbxCurso.getSelectedItem().toString()).getEdiciones());
							if(Herramienta.CMBIsEmpty(cbxEdicion) == false)
								Herramienta.unblockAll(cbxEdicion);
						}		
					}
				});
				cbxInstituto.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						
						
						edicionDatos.borrarTodo();
						borrarTodo();
						Herramienta.llenarCombobox(cbxCurso,iConsulta.seleccionarInstituto(cbxInstituto.getSelectedItem().toString()));
						if(Herramienta.CMBIsEmpty(cbxCurso)== false)
							Herramienta.unblockAll(cbxCurso);
					}
				});

		
		
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				//Herramienta.blockAll(cbxCurso,cbxEdicion,dchInicio,dchFin,sfiCupos,txtNombre);
				Herramienta.llenarCombobox(cbxInstituto,iConsulta.listarInstituto());
				if(Herramienta.CMBIsEmpty(cbxInstituto) == false) {
					Herramienta.llenarCombobox(cbxCurso,iConsulta.seleccionarInstituto(cbxInstituto.getSelectedItem().toString()));
					Herramienta.unblockAll(cbxInstituto);
				}	
				if(Herramienta.CMBIsEmpty(cbxCurso) == false) {
					Herramienta.llenarCombobox(cbxEdicion,iConsulta.seleccionarCurso(cbxCurso.getSelectedItem().toString()).getEdiciones());
					if(Herramienta.CMBIsEmpty(cbxEdicion) == false)
						Herramienta.unblockAll(cbxEdicion);
				}	
				if(Herramienta.CMBIsEmpty(cbxEdicion) == false) {
					DtEdicion dtEdicion = manejador.buscarEdicion(cbxEdicion.getSelectedItem().toString()).getDtEdicion();
					edicionDatos.llenarDatos(dtEdicion);
				}
			}
			@Override
			public void componentHidden(ComponentEvent e) {
				if(Herramienta.CMBIsEmpty(cbxInstituto)&&Herramienta.CMBIsEmpty(cbxCurso)&&Herramienta.CMBIsEmpty(cbxEdicion))
					edicionDatos.blockAll();
				else if(Herramienta.CMBIsEmpty(cbxCurso)&&Herramienta.CMBIsEmpty(cbxEdicion)) {
					Herramienta.unblockAll(cbxInstituto);
					edicionDatos.blockAll();
				}
				else if(Herramienta.CMBIsEmpty(cbxEdicion)) {
					Herramienta.unblockAll(cbxCurso);
					edicionDatos.blockAll();
				}
				else
					edicionDatos.unblockAll();
			}
		});
	}
	
	
	public void borrarTodo() {
		cbxCurso.removeAllItems();
		cbxEdicion.removeAllItems();
	}
}
