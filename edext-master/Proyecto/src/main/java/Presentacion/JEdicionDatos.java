package Presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JDateChooser;

import DataType.DtEdicion;
import DataType.EnumEstadoInscripcion;
import Interface.IConsulta;
import Tools.Herramienta;
import Tools.ImageLoad;
import antlr.collections.List;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class JEdicionDatos extends JPanel {

	private JTextField txtNombre;
	private JDateChooser dchInicio;
	private JDateChooser dchFin;
	private JSpinner sfiCupos;
	private ImageLoad lErrorNombre;
	private ImageLoad lErrorIni;
	private ImageLoad lErrorFin;
	private ImageLoad lErrorCupo;
	
	private JComboBox<EnumEstadoInscripcion> cbxEstadoInsc=new JComboBox<>();
	private JLabel lblEstadoInsc;
	
	
	public JEdicionDatos() {
		
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		setLayout(new MigLayout("", "[][][grow][][][grow]", "[grow][][][grow][grow][][grow]"));
		JLabel lblNombre = new JLabel("Nombre");
		add(lblNombre, "cell 0 2,alignx left,aligny center");
		lErrorNombre = new ImageLoad("/errorIcon.png");
		add(lErrorNombre,"cell 1 2");
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				lErrorNombre.setVisible(false);
			}
		});
		add(txtNombre, "cell 2 2,growx,aligny top");
		txtNombre.setColumns(10);
		JLabel lblCupos = new JLabel("Cupos");
		add(lblCupos, "flowy,cell 3 2,alignx right,aligny center");
		lErrorCupo = new ImageLoad("/errorIcon.png");
		add(lErrorCupo, "cell 4 2");
		
		sfiCupos = new JSpinner();
		sfiCupos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lErrorCupo.setVisible(false);

			}
		});
		sfiCupos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lErrorCupo.setVisible(false);

			}
		});
		sfiCupos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		add(sfiCupos, "cell 5 2,growx");
		
		lblEstadoInsc = new JLabel("Estado Insc");
		add(lblEstadoInsc, "cell 0 3");
		
		cbxEstadoInsc = new JComboBox();
		cbxEstadoInsc.setModel(new DefaultComboBoxModel<EnumEstadoInscripcion>(EnumEstadoInscripcion.values()));
	
		add(cbxEstadoInsc, "cell 2 3 4 1,growx");
		cbxEstadoInsc.setEnabled(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		add(panel, "cell 0 4 6 1,grow");
		panel.setLayout(new MigLayout("", "[25px][][grow]", "[14px,grow][grow]"));
		
		JLabel lblInicio = new JLabel("Inicio");
		panel.add(lblInicio, "cell 0 0,alignx right,aligny center");
		lErrorIni = new ImageLoad("/errorIcon.png");
		panel.add(lErrorIni, "cell 1 0,alignx center");
		
		dchInicio = new JDateChooser();
		dchInicio.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lErrorIni.setVisible(false);
				
			}
		});
		panel.add(dchInicio, "cell 2 0,growx");
		
		JLabel lblFin = new JLabel("Fin");
		panel.add(lblFin, "cell 0 1");
		lErrorFin = new ImageLoad("/errorIcon.png");
		panel.add(lErrorFin, "cell 1 1,alignx center");
		
		dchFin = new JDateChooser();
		dchFin.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lErrorFin.setVisible(false);
			}
		});
		panel.add(dchFin, "cell 2 1,growx");
		dchFin.setForeground(Color.WHITE);
		blockAll();
		lErrorNombre.setVisible(false);
		lErrorIni.setVisible(false);
		lErrorFin.setVisible(false);
		lErrorCupo.setVisible(false);

	}
	
	public void borrarTodo() {
		txtNombre.setText("");
		dchInicio.setDate(null);
		dchFin.setDate(null);
		
		sfiCupos.setValue(0);
	}
	
	public void setTodo(String nombre,Date ini,Date fin,int cupo) {
		txtNombre.setText(nombre);
		dchInicio.setDate(ini);
		dchFin.setDate(fin);
		sfiCupos.setValue(cupo);
	}
	
	public String getNom() {
		return txtNombre.getText();
	}
	
	public Date getFIni() {
		return dchInicio.getDate();
	}
	
	public Date getFFin() {
		return dchFin.getDate(); 
	}
	
	public int getCupos() {
		return (int) sfiCupos.getValue();
	}

	public void llenarDatos(DtEdicion dtEdicion) {
		// TODO Auto-generated method stub
		txtNombre.setText(dtEdicion.getNombre());
		dchInicio.setDate(dtEdicion.getfInicio());
		dchFin.setDate(dtEdicion.getfInicio());
		sfiCupos.setValue(dtEdicion.getCupo());
	}

	public void blockAll() {
		txtNombre.setEditable(false);
		dchInicio.setEnabled(false);
		dchFin.setEnabled(false);
		dchFin.getCalendarButton().setEnabled(false);
		dchInicio.getCalendarButton().setEnabled(false);
		JFormattedTextField spin=((JSpinner.DefaultEditor)sfiCupos.getEditor()).getTextField();
        spin.setEditable(false);
        sfiCupos.setEnabled(false);
        
	}

	public void unblockAll() {
		txtNombre.setEditable(true);
		dchInicio.setEnabled(true);
		dchFin.setEnabled(true);
		dchFin.getCalendarButton().setEnabled(true);
		dchInicio.getCalendarButton().setEnabled(true);
		JFormattedTextField spin=((JSpinner.DefaultEditor)sfiCupos.getEditor()).getTextField();
        spin.setEditable(true);
        sfiCupos.setEnabled(true);
	}
	
	public DtEdicion getDtEdicion() {
		String foto = " "; //MOMENTANEO
		return  new DtEdicion(txtNombre.getText(),dchInicio.getDate(),dchFin.getDate(),(int) sfiCupos.getValue(),Herramienta.getDateSystem(), foto);
	}
	
	public boolean datosValidos() {
		Boolean returno = true;
		if(txtNombre.getText().toString().equals("") == true) {
			returno = false;
			lErrorNombre.setVisible(true);
			lErrorNombre.setToolTipText("EL nombre est� vac�o");
		}
		if(dchInicio.getDate() == null) {
			returno = false;
			lErrorIni.setVisible(true);
			lErrorIni.setToolTipText("La fecha inicio est� vac�a");
		}
		if(dchFin.getDate() == null) {
			returno = false;
			lErrorFin.setVisible(true);
			lErrorFin.setToolTipText("La fecha fin est� vac�a");
		}
		if((int)sfiCupos.getValue() == 0) {
			returno = false;
			lErrorCupo.setVisible(true);
			lErrorCupo.setToolTipText("Los cupos son 0");
		}
		return returno;
	}

	

}
