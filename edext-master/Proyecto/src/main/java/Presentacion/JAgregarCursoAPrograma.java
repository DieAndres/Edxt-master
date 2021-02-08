package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Interface.IAlta;
import Interface.IConsulta;
import Logica.Manejador;
import Logica.Programa;
import Tools.Herramienta;
import Tools.ImageLoad;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;

public class JAgregarCursoAPrograma extends BackGround {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbxPrograma;
	private JComboBox<String> cbxCurso;
	private Manejador manejador = Manejador.getInstancia();
	private ImageLoad lErrorProg = new ImageLoad("/errorIcon.png");
	private ImageLoad lErrorCur = new ImageLoad("/errorIcon.png");

	/**
	 * Create the panel.
	 */
	public JAgregarCursoAPrograma(IAlta iAlta,IConsulta iConsulta,Principal principal) {
		lErrorCur.setVisible(false);
		lErrorCur.setToolTipText("No existen cursos para seleccionar");
		lErrorProg.setVisible(false);
		lErrorProg.setToolTipText("No existen programas para seleccionar");
		setLayout(new MigLayout("", "[grow,left][::200px,grow,fill][::100px,grow][grow,right]", "[grow][][grow,center][grow]"));
		JLabel lblNewLabel_2 = new JLabel("Agregar un Curso a un Programa");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel_2, "cell 1 1 2 1");
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 2 2 1,grow");
		panel.setLayout(new MigLayout("", "[][][100px:n][grow]", "[grow][grow][][]"));
		
		JLabel lblNewLabel = new JLabel("Programas");
		panel.add(lblNewLabel, "cell 0 0,alignx right");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lErrorProg, "cell 1 0,alignx center,aligny center");
		cbxPrograma = new JComboBox<String>();
		panel.add(cbxPrograma, "cell 2 0 2 1,growx,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Cursos");
		panel.add(lblNewLabel_1, "cell 0 1,alignx right");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		cbxCurso = new JComboBox<String>();
		panel.add(cbxCurso, "cell 2 1 2 1,growx,aligny center");
		
		JLabel lblExito = new JLabel("New label");
		panel.add(lblExito, "cell 0 2 4 1,alignx center");
		lblExito.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 3 4 1,grow");
		panel_1.setLayout(new MigLayout("", "[71px,grow][grow]", "[23px]"));
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar, "cell 0 0,alignx center,aligny top");
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar, "cell 1 0,alignx center");
		btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					principal.switchPanel("Principal");
				}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Herramienta.CMBIsEmpty(cbxPrograma) && !Herramienta.CMBIsEmpty(cbxCurso)) {
					btnAceptar.setVisible(true);
					iAlta.agregarPrograma(cbxPrograma.getSelectedItem().toString(), cbxCurso.getSelectedItem().toString());
					lblExito.setText("Ingreso con éxito");
					lblExito.setVisible(true);
					llenarCursos(iConsulta);
				}
				else {
					if(Herramienta.CMBIsEmpty(cbxPrograma)) {
						lErrorProg.setVisible(true);
					}	
					if(Herramienta.CMBIsEmpty(cbxCurso)) {
						lErrorCur.setVisible(true);
					}		
				}
			}		
		});
		panel.add(lErrorCur, "cell 1 1,alignx center,aligny center");
		lblExito.setVisible(false);
		cbxCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//
			}
		});
		cbxPrograma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarCursos(iConsulta);
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				Herramienta.llenarCombobox(cbxPrograma,iConsulta.listarProgramas());
				lErrorCur.setVisible(false);
				lErrorProg.setVisible(false);
				
				llenarCursos(iConsulta);
				
				//Herramienta.blockAll(cbxCurso,cbxCurso,dchInicio,dchFin,sfiCupos,txtNombre);
			}
		});

	}
	
	
	public void llenarCursos(IConsulta iConsulta) {
		if(Herramienta.CMBIsEmpty(cbxPrograma) == false) {
			cbxCurso.setEnabled(true);
			ArrayList<String> cursos = new ArrayList<String>();
			ArrayList<String> cursosProg = new ArrayList<String>();
			cursos = iConsulta.listarCurso();
			Programa p = manejador.buscarPrograma(cbxPrograma.getSelectedItem().toString());
			cursosProg = p.getCursosNom();
			
			cursos.removeAll(cursosProg);
			
			cbxCurso.removeAllItems();
			Herramienta.llenarCombobox(cbxCurso,cursos);
		}else {
			cbxCurso.setEnabled(false);
		}
	}

}
