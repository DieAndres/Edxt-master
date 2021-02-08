package Presentacion;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import DataType.DtEdicion;
import Interface.IAlta;
import Interface.IConsulta;
import Logica.Manejador;
import Tools.Herramienta;
import Tools.ImageLoad;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class JEdicionAlta extends BackGround {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbxInstituto;
	private JComboBox<String> cbxCurso;
	private JButton btnAceptar;
	private JLabel lblExito;
	private JButton btnCancelar;
	private JEdicionDatos edicionDatos;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	/**
	 * Create the panel.
	 */
	public JEdicionAlta(IAlta iAlta,IConsulta iConsulta,Principal principal) {
		setLayout(new MigLayout("", "[][grow,left][::200px,grow,fill][::200px,grow,fill][grow,right]", "[grow][grow][grow]"));
		lblNewLabel = new JLabel("Creaci\u00F3n de Edicion de Curso");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel, "cell 1 0 4 1,alignx center,aligny bottom");
		
		panel = new JPanel();
		add(panel, "cell 2 1 2 1,grow");
		panel.setLayout(new MigLayout("", "[][grow][grow]", "[][][grow][][]"));
		
		panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 1 3 1,grow");
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(new MigLayout("", "[][grow]", "[16px][]"));
		
		JLabel lblInstituto = new JLabel("Instituto");
		panel_1.add(lblInstituto, "cell 0 0,aligny top");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		
		cbxInstituto = new JComboBox<String>();
		panel_1.add(cbxInstituto, "cell 1 0,growx,aligny center");
		
		JLabel lblCurso = new JLabel("Curso");
		panel_1.add(lblCurso, "cell 0 1");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		
		cbxCurso = new JComboBox<String>();
		panel_1.add(cbxCurso, "cell 1 1,growx,aligny center");
		edicionDatos = new JEdicionDatos();
		edicionDatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(edicionDatos, "cell 0 2 3 1,grow");
		
		lblExito = new JLabel("Ingresado con exito");
		panel.add(lblExito, "cell 0 3 3 1,alignx center");
		
		btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar, "cell 0 4 2 1,alignx center");
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, "cell 2 4,alignx center");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.switchPanel("Principal");
			}
		});
		lblExito.setVisible(false);
		
		
		funciones(iAlta,iConsulta);
		
	}
	
	public void funciones(IAlta iAlta,IConsulta iConsulta) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				Herramienta.llenarCombobox(cbxInstituto,iConsulta.listarInstituto());

				if(Herramienta.CMBIsEmpty(cbxInstituto)== false) {
					 Herramienta.llenarCombobox(cbxCurso,iConsulta.seleccionarInstituto(cbxInstituto.getSelectedItem().toString()));
					 Herramienta.unblockAll(cbxCurso);
				}else if(Herramienta.CMBIsEmpty(cbxCurso)== false) {
					edicionDatos.unblockAll();
				}else {
					edicionDatos.blockAll();
				}
				
			}
		});
		cbxInstituto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				 cbxCurso.removeAllItems();
				 Herramienta.llenarCombobox(cbxCurso,iConsulta.seleccionarInstituto(cbxInstituto.getSelectedItem().toString()));
				 Herramienta.unblockAll(cbxCurso);
			}
		});
		cbxCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(Herramienta.CMBIsEmpty(cbxCurso) == false) {
					edicionDatos.unblockAll();
				}else {
					edicionDatos.unblockAll();
				}
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(edicionDatos.datosValidos() == true) {
					lblExito.setVisible(true);
					DtEdicion edicion = edicionDatos.getDtEdicion(); 
					if(iAlta.seleccionarCurso2(cbxCurso.getSelectedItem().toString(), edicion) ==false) {
						iAlta.confirmarEdicion();
						lblExito.setText("Ingresado con exito");
					}else {
						iAlta.cancelar();
						lblExito.setText("Ya existe");
					}
					
				}
			}
		});
		
	}
	
	
	
	
}
