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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Interface.IConsulta;
import Logica.Curso;
import Logica.Manejador;
import Logica.Programa;
import Tools.Herramienta;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class JProgramaConsulta extends BackGround {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cbCurso;
	private JComboBox<String> cbPrograma ;
	private Manejador manejador = Manejador.getInstancia();
	private JProgramaDatos programaDatos;
	private JCursoDatos cursoDatos;
	private JPanel panel_1;
	private JLabel lblPrograma;


	/**
	 * Create the panel.
	 */
	public JProgramaConsulta(IConsulta iconsulta,Principal principal) {

		setLayout(new MigLayout("", "[grow][][grow][grow]", "[:20:20,grow][][][grow][::20,grow]"));
		JLabel lblNewLabel = new JLabel("Consultar Programas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		add(lblNewLabel, "cell 1 1 2 1,alignx center");
		 
		JPanel panel = new JPanel();
		add(panel, "cell 1 3 2 1,grow");
		panel.setEnabled(false);

		panel.setLayout(new MigLayout("", "[][grow][grow]", "[][grow][10:n][grow][::10,grow,fill]"));
		
		lblPrograma = new JLabel("Programa");
		panel.add(lblPrograma, "cell 0 0,alignx right");
		
		cbPrograma = new JComboBox<String>();
		panel.add(cbPrograma, "cell 1 0 2 1,growx");
		cbPrograma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Herramienta.llenarCombobox(cbPrograma, iconsulta.listarProgramas());
				llenarPrograma(iconsulta);
			}
		});
		programaDatos = new JProgramaDatos();
		panel.add(programaDatos, "cell 0 1 3 1,grow");
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Cursos del Programa", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(255, 255, 255)));
		panel.add(panel_1, "cell 0 3 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[32px][grow]", "[][grow][14px]"));
		
		cbCurso = new JComboBox<String>();
		panel_1.add(cbCurso, "cell 0 0 2 1,growx");
		cbCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				llenarCurso(iconsulta);
			}
		});
		cursoDatos = new JCursoDatos(iconsulta);
		panel_1.add(cursoDatos, "cell 0 1 2 1,grow");


		programaDatos.blockAll();
		cursoDatos.blockAll();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				Herramienta.llenarCombobox(cbPrograma, iconsulta.listarProgramas());
				
				llenarPrograma(iconsulta);
			}
		});
		
	}
	
	public void llenarPrograma(IConsulta iconsulta) {
		if(Herramienta.CMBIsEmpty(cbPrograma)  == false) {
			Programa programa = manejador.buscarPrograma(cbPrograma.getSelectedItem().toString());
			programaDatos.llenarDatos(programa.getDtPrograma());
			cbCurso.removeAllItems();
			Herramienta.llenarCombobox(cbCurso, programa.getCursosNom());
			llenarCurso(iconsulta);
		}else{
			cursoDatos.borrarTodo();
		}
	}
	
	public void llenarCurso(IConsulta iconsulta) {
		if(Herramienta.CMBIsEmpty(cbCurso) == false) {
			Curso c = manejador.buscarCurso(cbCurso.getSelectedItem().toString());
			cursoDatos.llenarDatos(c.getDtCurso());
		}else {
			cursoDatos.borrarTodo();
		}
	}
	
	
	
	

}
