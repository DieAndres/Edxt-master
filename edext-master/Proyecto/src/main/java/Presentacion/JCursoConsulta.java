package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import DataType.DtCurso;
import DataType.DtInfoCurso;
import Interface.IConsulta;
import Logica.Manejador;
import Tools.Herramienta;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class JCursoConsulta extends BackGround {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JCursoDatos cursoDatos;
	private JProgramaDatos programaDatos;
	private JEdicionDatos edicionDatos;
	private JComboBox<String> cbxInstituto;
	private JComboBox<String> cbxEdicion;
	private JComboBox<String> cbxCursos;
	private JComboBox<String> cbxPrograma;
	private IConsulta iconsulta;
	private Manejador manejador = Manejador.getInstancia();
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JPanel panel_3;
	
	public JCursoConsulta(IConsulta iconsu,Principal principal) {
		iconsulta = iconsu;
		setLayout(new MigLayout("", "[grow][grow][grow]", "[16px,grow][grow][grow]"));
		
		lblNewLabel = new JLabel("Consulta de Curso");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel, "cell 1 0,growx,aligny bottom");
		panel_1 = new JPanel();
		add(panel_1, "cell 1 1,grow");
		
		cbxInstituto = new JComboBox<String>();
		cbxInstituto.addComponentListener(new ComponentAdapter() {	
		});
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[58px][][][grow]"));
		
		
		JPanel panel = new JPanel();
		panel_1.add(panel, "cell 0 0 3 1,grow");
		panel.setLayout(new MigLayout("", "[][][124.00,grow][121.00]", "[][]"));
		
		JLabel lblInstituto = new JLabel("Instituto");
		panel.add(lblInstituto, "cell 0 0");
		lblInstituto.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		panel.add(cbxInstituto, "cell 2 0 2 1,grow");
		
		
		JLabel lblCursos = new JLabel("Cursos");
		panel.add(lblCursos, "cell 0 1");
		lblCursos.setHorizontalAlignment(SwingConstants.CENTER);
		
		cbxCursos = new JComboBox<String>();
		panel.add(cbxCursos, "cell 2 1 2 1,growx");
		cursoDatos = new JCursoDatos(iconsulta);
		cursoDatos.setBorder(new TitledBorder(null, "Datos del Curso", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, Color.WHITE));
		panel_1.add(cursoDatos, "cell 0 1 3 1,growx");
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Programas de Curso", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, Color.WHITE));
		panel_1.add(panel_2, "cell 0 2 1 2,grow");
		panel_2.setLayout(new MigLayout("", "[46px][][grow]", "[14px][grow]"));
		
		JLabel lblNewLabel_9 = new JLabel("Programa");
		panel_2.add(lblNewLabel_9, "cell 0 0,alignx left,aligny top");
		
		cbxPrograma = new JComboBox();
		panel_2.add(cbxPrograma, "cell 1 0 2 1,growx");
		programaDatos = new JProgramaDatos();
		panel_2.add(programaDatos, "cell 0 1 3 1,grow");
		programaDatos.blockAll();
		
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ediciones de Curso", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, Color.WHITE));
		panel_1.add(panel_3, "cell 1 2 2 2,grow");
		panel_3.setLayout(new MigLayout("", "[33px][][grow]", "[14px][grow]"));
		
		
		JLabel lblNewLabel_8 = new JLabel("Edicion");
		panel_3.add(lblNewLabel_8, "cell 0 0,alignx left,aligny top");
		
		cbxEdicion = new JComboBox<String>();
		panel_3.add(cbxEdicion, "cell 1 0 2 1,growx");
		edicionDatos = new JEdicionDatos();
		panel_3.add(edicionDatos, "cell 0 1 3 1,grow");
		edicionDatos.blockAll();
		
		cbxEdicion.addItemListener(new ItemListener() {    /// si cambian las ediciones
		public void itemStateChanged(ItemEvent arg0) {
			
		}
		});	
		
		
		cbxInstituto.addItemListener(new ItemListener() {  /// si cambio el instituto
			public void itemStateChanged(ItemEvent arg0) {
				cbxCursos.removeAllItems();
				programaDatos.borrarTodo();
				edicionDatos.borrarTodo();
				cursoDatos.borrarTodo();
				cbxEdicion.removeAllItems();
				cbxPrograma.removeAllItems();
				Herramienta.llenarCombobox(cbxCursos, iconsulta.seleccionarInstituto(cbxInstituto.getSelectedItem().toString()));
				if (Herramienta.CMBIsEmpty(cbxCursos)==false) {     // desbloqueo si hay cursos
					Herramienta.unblockAll(cbxEdicion,cbxPrograma);	
				}
			}
		});
		
		cbxCursos.addItemListener(new ItemListener() {    /// si cambio el curso
			public void itemStateChanged(ItemEvent arg0) {
				if(Herramienta.CMBIsEmpty(cbxCursos) == false) {
					DtCurso curso = manejador.buscarCurso(cbxCursos.getSelectedItem().toString()).getDtCurso();
					cursoDatos.llenarDatos(curso);
					llenarEdicion();
					llenarPrograma();
				}
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				Herramienta.llenarCombobox(cbxInstituto,iconsulta.listarInstituto() );
				Herramienta.blockAll(cbxCursos,cbxEdicion,cbxPrograma);
				cursoDatos.blockAll();
				if (Herramienta.CMBIsEmpty(cbxInstituto)==false) {    //desbloqueo cursos si hay institutos
					Herramienta.unblockAll(cbxCursos,cbxEdicion,cbxPrograma);
					llenarCurso();
					llenarEdicion();
					llenarPrograma();
				 }
			}
		
		});
			
	}
	
	public void llenarCurso() {
		if (Herramienta.CMBIsEmpty(cbxInstituto)==false) { 
			cbxCursos.removeAllItems();
			Herramienta.llenarCombobox(cbxCursos, iconsulta.seleccionarInstituto(cbxInstituto.getSelectedItem().toString()));
			if (Herramienta.CMBIsEmpty(cbxCursos)==false) {     // desbloqueo si hay cursos
				DtCurso curso = manejador.buscarCurso(cbxCursos.getSelectedItem().toString()).getDtCurso();
				cursoDatos.llenarDatos(curso);
				Herramienta.unblockAll(cbxEdicion,cbxPrograma);	
			}else {
				cursoDatos.borrarTodo();
			}
		}
	}

	public void llenarEdicion() {
		if (Herramienta.CMBIsEmpty(cbxCursos)==false) { 
			cbxEdicion.removeAllItems();
			Herramienta.llenarCombobox(cbxEdicion,iconsulta.seleccionarCurso(cbxCursos.getSelectedItem().toString()).getEdiciones());
			if (Herramienta.CMBIsEmpty(cbxEdicion)==false) { 
				edicionDatos.llenarDatos(manejador.buscarEdicion(cbxEdicion.getSelectedItem().toString()).getDtEdicion());
			}else {
				edicionDatos.borrarTodo();
			}
		}
	}
		
	public void llenarPrograma() {
		if (Herramienta.CMBIsEmpty(cbxCursos)==false) { 
			cbxPrograma.removeAllItems();
			Herramienta.llenarCombobox(cbxPrograma,iconsulta.seleccionarCurso(cbxCursos.getSelectedItem().toString()).getProgramas());
			if (Herramienta.CMBIsEmpty(cbxPrograma)==false) { 
				programaDatos.llenarDatos(manejador.buscarPrograma(cbxPrograma.getSelectedItem().toString()).getDtPrograma());
			}else {
				programaDatos.borrarTodo();
			}
		}
	}
}
		
				

	

	
