package Presentacion;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DataType.DtPrograma;
import Tools.Herramienta;
import Tools.ImageLoad;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class JProgramaDatos extends JPanel {
	private JTextField nombre;
	private JTextField descripcion;
	private JDateChooser dateChooser_ini;
	private JDateChooser dateChooser_fin;
	private ImageLoad lErrorFin;
	private ImageLoad lErrorIni;
	private ImageLoad lErrorDesc;
	private ImageLoad lErrorNom;
	/**
	 * Create the panel.
	 */
	public JProgramaDatos() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				cleanErrors();
				borrarTodo();
			}
		});
		

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new MigLayout("", "[right][][grow][grow]", "[grow,fill][][grow,fill][][grow,fill][grow,fill]"));
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNombre, "cell 0 1,alignx right,aligny center");
		
		nombre = new JTextField();
		nombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorNom.isVisible() == true) {
					lErrorNom.setVisible(false);
				}
			}
		});
		lErrorNom = new ImageLoad("/errorIcon.png");
		
		add(lErrorNom, "cell 1 1,alignx center");
		add(nombre, "cell 2 1 2 1,growx,aligny top");
		nombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		add(lblDescripcion, "cell 0 3,alignx right,aligny center");
						
		descripcion = new JTextField();
		descripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorDesc.isVisible() == true) {
					lErrorDesc.setVisible(false);
				}
			}
		});
		lErrorDesc= new ImageLoad("/errorIcon.png");
		add(lErrorDesc, "cell 1 3,alignx center");
		add(descripcion, "cell 2 3 2 1,growx,aligny top");
		descripcion.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Periodo Vigencia", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		add(panel, "cell 0 5 4 1,grow");
		panel.setLayout(new MigLayout("", "[25px][][grow][][][grow]", "[14px,grow]"));
		
		JLabel lblFInicio = new JLabel("Inicio");
		panel.add(lblFInicio, "cell 0 0,alignx right,aligny center");
		lErrorIni= new ImageLoad("/errorIcon.png");
		panel.add(lErrorIni, "cell 1 0,alignx center");
		
		dateChooser_ini = new JDateChooser();
		dateChooser_ini.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lErrorIni.setVisible(false);
			}
		});
		panel.add(dateChooser_ini, "cell 2 0,growx");
		dateChooser_ini.getCalendarButton().setForeground(Color.WHITE);
		dateChooser_ini.setForeground(Color.WHITE);
		dateChooser_ini.setDate(Herramienta.getDateSystem());
		
				
				JLabel lblFFin = new JLabel("Fin");
				panel.add(lblFFin, "cell 3 0");
				lblFFin.setHorizontalAlignment(SwingConstants.CENTER);
		lErrorFin= new ImageLoad("/errorIcon.png");
		panel.add(lErrorFin, "cell 4 0,alignx center");
				
		dateChooser_fin = new JDateChooser();
		dateChooser_fin.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lErrorFin.setVisible(false);
			}
		});
		panel.add(dateChooser_fin, "cell 5 0,growx");
		dateChooser_fin.setForeground(Color.WHITE);
		dateChooser_fin.setDate(Herramienta.getDateSystem());
		cleanErrors();
	}
	
	public DtPrograma getDtPrograma() {
		String foto = " ";
		return  new DtPrograma(nombre.getText(), descripcion.getText(), dateChooser_ini.getDate(), dateChooser_fin.getDate(), foto);
	}
	
	public void cleanErrors() {
		lErrorFin.setVisible(false);
		lErrorIni.setVisible(false);
		lErrorDesc.setVisible(false);
		lErrorNom.setVisible(false);
	}

	public void borrarTodo() {
		nombre.setText("");
		descripcion.setText("");
		dateChooser_ini.setDate(null);
		dateChooser_fin.setDate(null);
		
	}

	public void llenarDatos(DtPrograma dtPrograma) {
		nombre.setText(dtPrograma.getNombre());
		descripcion.setText(dtPrograma.getDescripcion());
		dateChooser_ini.setDate(dtPrograma.getfInicio());
		dateChooser_fin.setDate(dtPrograma.getfFin());
	}
	public void blockAll() {
		nombre.setEditable(false);
		descripcion.setEditable(false);
		JTextFieldDateEditor editor1 = (JTextFieldDateEditor) dateChooser_ini.getDateEditor();
		editor1.setEditable(false);
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dateChooser_fin.getDateEditor();
		editor2.setEditable(false);
		dateChooser_ini.setEnabled(false);
		dateChooser_fin.setEnabled(false);
	}
	
	public boolean datosValidos() {
		Boolean returno = true;
		if(nombre.getText().equals("") == true) {
			returno = false;
			lErrorNom.setVisible(true);
			lErrorNom.setToolTipText("El nombre esta vacio");

		}
		if(descripcion.getText().equals("") == true) {
			returno = false;
			lErrorDesc.setVisible(true);
			lErrorDesc.setToolTipText("La descripcion esta vacia");
		}
		if(dateChooser_ini.getDate() == null) {
			returno = false;
			lErrorIni.setVisible(true);
			lErrorIni.setToolTipText("La fecha de inicio est� vac�a");
		}
		if(dateChooser_fin.getDate() == null) {
			returno = false;
			lErrorFin.setVisible(true);
			lErrorFin.setToolTipText("La fecha de fin est� vac�a");
		}
		
		
		return returno;
	}
	

}

