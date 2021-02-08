package Presentacion;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import DataType.DtEdicion;
import DataType.DtEstudiante;
import DataType.EnumEstadoInscripcion;
import Interface.IAlta;
import Interface.IConsulta;
import Logica.Curso;
import Logica.Edicion;
import Logica.Estudiante;
import Logica.Manejador;
import Tools.Herramienta;
import Tools.ImageLoad;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JInscripcionEdicion extends BackGround {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfEdicion;
	private JComboBox<String> cbxInstituto;
	private JComboBox<String> cbxCurso;
	private JComboBox<String> cbxEstudiante;
	
	private ImageLoad IErrorInst;
	private ImageLoad IErrorEst;
	private ImageLoad IErrorCurs;
	private ImageLoad IErrorEdi;
	private ImageLoad IErrorFech;
	
	private JDateChooser dFecha;
	
	private Manejador manejador = Manejador.getInstancia();
	private String estadoInicial = EnumEstadoInscripcion.Inscripto.name();

	/**
	 * Create the panel.
	 */
	public JInscripcionEdicion(IAlta iAlta,IConsulta iConsulta,Principal principal) {
		
		
		
		
		IErrorFech = new ImageLoad("/errorIcon.png");;

		setLayout(new MigLayout("", "[grow,center][grow][grow]", "[grow,center][grow][grow]"));
		
		JLabel lblInscripcinDeEstudiante = new JLabel("Inscripci\u00F3n de Estudiante a Edicion Vigente de un curso");
		lblInscripcinDeEstudiante.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInscripcinDeEstudiante.setForeground(Color.WHITE);
		add(lblInscripcinDeEstudiante, "cell 1 0,alignx center,aligny bottom");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[][9.00][10.00][grow][grow][]", "[grow][14px][grow][][grow][][grow][][grow][][][grow][]"));
		
		JLabel lblInstituto = new JLabel("Institutos");
		panel.add(lblInstituto, "cell 0 1,alignx right,aligny top");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		IErrorInst = new ImageLoad("/errorIcon.png");
		panel.add(IErrorInst, "cell 2 1");
		
		cbxInstituto = new JComboBox();
		panel.add(cbxInstituto, "cell 3 1 3 1,growx");
		
		JLabel lblCurso = new JLabel("Cursos");
		panel.add(lblCurso, "cell 0 3,alignx right");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		IErrorCurs= new ImageLoad("/errorIcon.png");
		panel.add(IErrorCurs, "cell 2 3");
		
		cbxCurso = new JComboBox();
		panel.add(cbxCurso, "cell 3 3 3 1,growx");
		
		JLabel lblEdicionVigente = new JLabel("Edicion");
		panel.add(lblEdicionVigente, "cell 0 5,alignx right");
		IErrorEdi= new ImageLoad("/errorIcon.png");
		panel.add(IErrorEdi, "cell 2 5");
		
		tfEdicion = new JTextField();
		

		
		tfEdicion.setEditable(false);
		panel.add(tfEdicion, "cell 3 5 3 1,growx");
		tfEdicion.setColumns(10);
		
		JLabel lblEstudiante = new JLabel("Estudiante");
		panel.add(lblEstudiante, "cell 0 7,alignx right");
		lblEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		IErrorEst= new ImageLoad("/errorIcon.png");
		panel.add(IErrorEst, "cell 2 7");
		
		cbxEstudiante = new JComboBox();
		panel.add(cbxEstudiante, "cell 3 7 3 1,growx");
		
		JLabel lblFechaInscri = new JLabel("Fecha Inscripcion");
		panel.add(lblFechaInscri, "cell 0 9,alignx right");
		
		IErrorFech = new ImageLoad("/errorIcon.png");
		panel.add(IErrorFech, "cell 2 9");
		
		dFecha = new JDateChooser();
		dFecha.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IErrorFech.setVisible(false);
			}
		});
		panel.add(dFecha, "cell 3 9 3 1,growx");
		
		JLabel lblConfirmoEst = new JLabel("Se inscribio el estudiante");
		panel.add(lblConfirmoEst, "cell 0 11 6 1,alignx center");
		lblConfirmoEst.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		JButton btnAceptar = new JButton("Aceptar");
		panel.add(btnAceptar, "cell 3 12,alignx left");
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validarDatos()) {
					Estudiante estudiante = (Estudiante) manejador.buscarUsuario(cbxEstudiante.getSelectedItem().toString());
					lblConfirmoEst.setVisible(true);
	
					if((Herramienta.CMBIsEmpty(cbxInstituto) == false)&&(Herramienta.CMBIsEmpty(cbxCurso) == false)&&(Herramienta.CMBIsEmpty(cbxEstudiante) == false)) {
						if(estudiante.isInscripto(tfEdicion.getText()) == false){

							System.out.println(cbxEstudiante.getSelectedItem().toString());
							System.out.println("Este es el textField" + tfEdicion.getText());
							System.out.println(dFecha.getDate());
							// paso un estado inical que luego es modificado por el docente 
							iAlta.registrarEstEdicion(cbxEstudiante.getSelectedItem().toString(), tfEdicion.getText(), dFecha.getDate(),estadoInicial);
							//cbxEstado.getSelectedItem().toString()
							

							lblConfirmoEst.setVisible(true);
							lblConfirmoEst.setText("Inscripto con exito");
	
						}
						else {
							iAlta.cancelar();
							lblConfirmoEst.setText("Estudiante ya está inscrito");
						}
						
					}		
				}
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, "cell 4 12,alignx right");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				principal.switchPanel("Principal");
			}
		});
		
		lblConfirmoEst.setVisible(false);
		cbxCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				completarEdicion(iConsulta);
			}
		});
		cbxInstituto.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarCursos(iConsulta);
			}

		});
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				Herramienta.llenarCombobox(cbxInstituto, iConsulta.listarInstituto());
				llenarCursos(iConsulta);
				Herramienta.llenarCombobox(cbxEstudiante, iConsulta.getNomEstudiantes());
				lblConfirmoEst.setVisible(false);
			}
		});
		
		IErrorInst.setVisible(false);
		IErrorEst.setVisible(false);
		IErrorCurs.setVisible(false);
		IErrorEdi.setVisible(false);
		IErrorFech.setVisible(false);
		IErrorInst.setToolTipText("No existen institutos aún ");
		IErrorCurs.setToolTipText("No existen cursos aún ");
		IErrorEst.setToolTipText("No existen estudiantes aún ");
		IErrorEdi.setToolTipText("No existe una ediccion vigente");
		IErrorFech.setToolTipText("No hay fecha seleccionada");
	}
	
	private void llenarCursos(IConsulta iConsulta) {
		if(Herramienta.CMBIsEmpty(cbxInstituto) == false) {
			cbxCurso.setEnabled(true);
			cbxCurso.removeAllItems();
			Herramienta.llenarCombobox(cbxCurso, manejador.buscarInstituto(cbxInstituto.getSelectedItem().toString()).getNomCursos());
			if(Herramienta.CMBIsEmpty(cbxCurso) == false) {
				IErrorCurs.setVisible(false);
			}
			completarEdicion(iConsulta);
			IErrorInst.setVisible(false);
		}
		else {
			cbxCurso.setEnabled(false);
		}	
	}
	
	private void completarEdicion(IConsulta iConsulta) {
		if(Herramienta.CMBIsEmpty(cbxCurso) == false) {
			IErrorCurs.setVisible(false);
			DtEdicion edicion =  manejador.buscarCurso(cbxCurso.getSelectedItem().toString()).getDtEdicionVigente();
			if(edicion != null) {
				tfEdicion.setText(edicion.getNombre());
				IErrorEdi.setVisible(false);
			}else {
				tfEdicion.setText("");
			}
		}
		
	}
	private Boolean validarDatos() {
		Boolean returno = true;
		if(Herramienta.CMBIsEmpty(cbxInstituto)) {
			IErrorInst.setVisible(true);
			returno = false;
			
		}
		if(Herramienta.CMBIsEmpty(cbxCurso)) {
			IErrorCurs.setVisible(true);
			returno = false;		
		}
		if(Herramienta.CMBIsEmpty(cbxEstudiante)) {
			IErrorEst.setVisible(true);
			returno = false;
		}
		if(tfEdicion.getText().equals("") == true) {
			IErrorEdi.setVisible(true);
			returno = false;
		}
		if(dFecha.getDate() == null) {
			IErrorFech.setVisible(true);
			returno = false;
		}
		return returno;
	}
	
	
	
}
