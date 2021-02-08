package Presentacion;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import Interface.IConsulta;
import Logica.CConsulta;
import Logica.Docente;
import Logica.Estudiante;
import Logica.Manejador;
import Logica.Usuario;
import Tools.Herramienta;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class JUsuarioConsulta extends BackGround {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Manejador manejador = Manejador.getInstancia();
	private JComboBox<String> cbEdicion;
	private JComboBox<String> cbEdicion2;
	private CardLayout cardPanel;

	private JUsuarioDatos usuarioDatos ;
	private JEdicionDatos edicionDatos ;
	private JEdicionDatos edicionDatos2 ;
	private JProgramaDatos programaDatos ;
	private JComboBox<String> cbUsuario;
	private JComboBox<String> cbPrograma;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	/**
	 * Create the panel.
	 */
	public JUsuarioConsulta(IConsulta cConsulta, Principal principal) {
		
		setLayout(new MigLayout("", "[grow][][grow][][grow]", "[grow,top][][][grow][grow]"));
		
		lblNewLabel = new JLabel("Consultar Informaci\u00F3n de Usuario");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel, "cell 2 2,alignx center");
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel, "cell 1 3 3 1,grow");
		panel.setLayout(new MigLayout("", "[grow][grow][][grow][grow]", "[][][][grow]"));
		

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				usuarioDatos.blockAll();
				edicionDatos.borrarTodo();
				usuarioDatos.borrarTodo();
				edicionDatos.borrarTodo();
				edicionDatos2.borrarTodo();
				programaDatos.borrarTodo();
				llenarUsuarios(cConsulta);
				programaDatos.blockAll();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		panel.add(lblNewLabel_1, "cell 2 0");
		
		cbUsuario = new JComboBox<String>();
		panel.add(cbUsuario, "cell 3 0,growx");
		cbUsuario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarUsuarios(cConsulta);
			}
		});
		usuarioDatos = new JUsuarioDatos();
		panel.add(usuarioDatos, "cell 2 1 2 1,grow");
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		panel.add(panel_1, "cell 2 2 2 2,grow");
		cardPanel = new CardLayout(0, 0);
		panel_1.setLayout(cardPanel);
		
		JPanel panelEstudiante = new JPanel();
		panel_1.add(panelEstudiante, "panelEstudiante");
		panelEstudiante.setLayout(new MigLayout("", "[grow][300px,grow]", "[20px][][grow]"));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ediciones del Estudiante", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(255, 255, 255)));
		panelEstudiante.add(panel_2, "cell 0 0 1 3,grow");
		panel_2.setLayout(new MigLayout("", "[][grow][grow]", "[][grow]"));
		
		JLabel lblNewLabel_7 = new JLabel("Edicion");
		panel_2.add(lblNewLabel_7, "cell 0 0,growx,aligny top");
		
		cbEdicion = new JComboBox<String>();
		panel_2.add(cbEdicion, "cell 1 0 2 1,growx");
		edicionDatos = new JEdicionDatos();
		panel_2.add(edicionDatos, "cell 0 1 3 1,growx");
		cbEdicion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarEdicion();
			}
		});
				
		JPanel panelDocente = new JPanel();
		panel_1.add(panelDocente, "panelDocente");
		panelDocente.setLayout(new MigLayout("", "[252.00px,grow][1142px,grow]", "[20px][154px,grow]"));
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ediciones del Docente", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(255, 255, 255)));
		panelDocente.add(panel_4, "cell 0 0 2 2,grow");
		panel_4.setLayout(new MigLayout("", "[][grow][grow]", "[14px][grow,fill]"));
		
		JLabel lblNewLabel_8 = new JLabel("Edicion");
		panel_4.add(lblNewLabel_8, "cell 0 0,alignx left,aligny top");
		cbEdicion2 = new JComboBox<String>();
		panel_4.add(cbEdicion2, "cell 1 0 2 1,growx");
		cbEdicion2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarEdicion2();
			}
		});
		edicionDatos2 = new JEdicionDatos();
		panel_4.add(edicionDatos2, "cell 0 1 3 1,grow");
		cardPanel.show(panel_1, "panelDocente");
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Programas del Estudiante", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, new Color(255, 255, 255)));
		panelEstudiante.add(panel_3, "cell 1 0 1 3,grow");
		panel_3.setLayout(new MigLayout("", "[46px][grow]", "[14px][grow]"));
		
		JLabel lblNewLabel_9 = new JLabel("Programa");
		panel_3.add(lblNewLabel_9, "cell 0 0,alignx left,aligny top");
		
		cbPrograma = new JComboBox<String>();
		panel_3.add(cbPrograma, "cell 1 0,growx");
		programaDatos = new JProgramaDatos();
		panel_3.add(programaDatos, "cell 0 1 2 1,growx");
		cbPrograma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarPrograma();
			}
		});
	}
	
	public void llenarUsuarios(IConsulta cConsulta) {
		Herramienta.llenarCombobox(cbUsuario, cConsulta.listarUsuarios());
		llenarUsuarios();
	}
	
	public void llenarUsuarios() {
		if(Herramienta.CMBIsEmpty(cbUsuario)  == false) {
			Usuario usr = manejador.buscarUsuario(cbUsuario.getSelectedItem().toString());
			usuarioDatos.setDatos(usr.getDtUsuario());
			if(usr instanceof Estudiante) {
				cardPanel.show(panel_1, "panelEstudiante");
				Estudiante es = (Estudiante) usr;
				Herramienta.llenarCombobox(cbEdicion, es.getNomEd());
				Herramienta.llenarCombobox(cbPrograma, es.getNomPr());
				llenarEdicion();
				llenarPrograma();

			}else {
				cardPanel.show(panel_1, "panelDocente");
				
				llenarEdicion2();
			}
		}
	}
	public void llenarPrograma() {
		Usuario usr = manejador.buscarUsuario(cbUsuario.getSelectedItem().toString());
		Estudiante es = (Estudiante) usr;
		Herramienta.llenarCombobox(cbEdicion, es.getNomEd());
		if(Herramienta.CMBIsEmpty(cbPrograma) == false) {
			programaDatos.llenarDatos(manejador.buscarPrograma(cbPrograma.getSelectedItem().toString()).getDtPrograma());
		}
	}
	public void llenarEdicion() {
		Usuario usr = manejador.buscarUsuario(cbUsuario.getSelectedItem().toString());
		Estudiante es = (Estudiante) usr;
		Herramienta.llenarCombobox(cbEdicion, es.getNomEd());
		if(Herramienta.CMBIsEmpty(cbEdicion) == false) {
			edicionDatos.llenarDatos(manejador.buscarEdicion(cbEdicion.getSelectedItem().toString()).getDtEdicion());
		}
	}
	public void llenarEdicion2() {
		Usuario usr = manejador.buscarUsuario(cbUsuario.getSelectedItem().toString());
		Docente doc = (Docente) usr;
		Herramienta.llenarCombobox(cbEdicion, doc.getNomEd());
		if(Herramienta.CMBIsEmpty(cbEdicion2) == false) {
			edicionDatos.llenarDatos(manejador.buscarEdicion(cbEdicion2.getSelectedItem().toString()).getDtEdicion());
		}
	}
}
