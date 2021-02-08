package Presentacion;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import DataType.DtCurso;
import Interface.IConsulta;
import Logica.Manejador;
import Tools.Herramienta;
import Tools.ImageLoad;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

public class JCursoDatos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JTextField tfURLAsoc;
	private JSpinner spCantHoras;
	private JSpinner spCantCredAsociados;
	private boolean VisPanel =true;
	private JSpinner spDuracion;
	private JDateChooser dtFecha;
	private JTextArea txDesc;
	private ImageLoad lErrorNom;
	private ImageLoad lErrorHor;
	private ImageLoad lErrorDur;
	private ImageLoad lErrorCred ;
	private ImageLoad lErrorDesc;
	private ImageLoad lErrorURL;
	private JLabel lblPrevias;
	private List listPrev;
	private JScrollPane scrollPane;
	private IConsulta iconsulta;
	private JScrollPane scrollPane_1;
	private ImageLoad lErrorInsti;
	private JScrollPane scrollPane_2;
	private List listCat;
	private JLabel lblCategoria;
	/**
	 * Create the panel.
	 */
	public JCursoDatos(IConsulta iconsu) {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		iconsulta = iconsu;
		
		setLayout(new MigLayout("", "[][][100px:n,grow,fill][::200px][][100px:n]", "[][][grow][][][grow][20px][]"));
		
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		add(lblNewLabel_1, "cell 0 0,alignx right,aligny center");
		lErrorNom = new ImageLoad("/errorIcon.png");
		add(lErrorNom,"cell 1 0,alignx center");
		
		tfNombre = new JTextField();
		tfNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorNom.isVisible() == true) {
					
					lErrorNom.setVisible(false);
				}
			}
		});
		add(tfNombre, "cell 2 0 2 1,alignx left,aligny top");
		tfNombre.setColumns(10);
		dtFecha = new JDateChooser();
		
		lblCategoria = new JLabel("Categor\u00EDas");
		add(lblCategoria, "cell 4 0");

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane_1, "cell 2 1 1 5,grow");
		
				
				txDesc = new JTextArea(5, 20);
				txDesc.setLineWrap(true);
				scrollPane_1.setViewportView(txDesc);
				txDesc.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						if(lErrorDesc.isVisible() == true) {
						
							lErrorDesc.setVisible(false);
						}
					}
				});
		
		JPanel panel = new JPanel();
		add(panel, "cell 3 1 1 5,grow");
		panel.setLayout(new MigLayout("", "[][][29.00,grow][37.00px:n,grow]", "[grow][grow][grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("Horas");
		panel.add(lblNewLabel_3, "cell 0 0,alignx right");
		
		lErrorHor = new ImageLoad("/errorIcon.png");
		panel.add(lErrorHor, "cell 1 0,alignx right");
		
		spCantHoras = new JSpinner();
		spCantHoras.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(lErrorHor.isVisible() == true) {
					
					lErrorHor.setVisible(false);
				}
			}
		});
		spCantHoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorHor.isVisible() == true) {
					
					lErrorHor.setVisible(false);
				}
			}
		});
		spCantHoras.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel.add(spCantHoras, "cell 2 0 2 1,growx");
		
		JLabel lblNewLabel_6 = new JLabel("Duraci\u00F3n");
		panel.add(lblNewLabel_6, "cell 0 1,alignx right");
		
		lErrorDur = new ImageLoad("/errorIcon.png");
		panel.add(lErrorDur, "cell 1 1,alignx right");
		
		spDuracion = new JSpinner();
		spDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorDur.isVisible() == true) {
					
					lErrorDur.setVisible(false);
				}
			}
		});
		spDuracion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(lErrorDur.isVisible() == true) {
					
					lErrorDur.setVisible(false);
				}
			}
		});
		spDuracion.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel.add(spDuracion, "cell 2 1 2 1,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Creditos");
		panel.add(lblNewLabel_4, "cell 0 2,alignx right,growy");
		
		lErrorCred = new ImageLoad("/errorIcon.png");
		panel.add(lErrorCred, "cell 1 2,alignx center");
		
		spCantCredAsociados = new JSpinner();
		spCantCredAsociados.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(lErrorCred.isVisible() == true) {
					
					lErrorCred.setVisible(false);
				}
			}
		});
		spCantCredAsociados.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lErrorCred.setVisible(false);
			}
		});
		spCantCredAsociados.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		panel.add(spCantCredAsociados, "cell 2 2 2 1,growx");
		
		lblPrevias = new JLabel("Previas");
		add(lblPrevias, "cell 4 4,alignx leading");
		
		scrollPane = new JScrollPane();
		add(scrollPane, "cell 4 5 2 3,grow");
		
		listPrev = new List();
		listPrev.setMultipleMode(true);
		listPrev.setBackground(Color.darkGray);
		scrollPane.setViewportView(listPrev);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion");
		add(lblNewLabel_2, "cell 0 2 1 4,alignx right,aligny top");
		
		lErrorDesc = new ImageLoad("/errorIcon.png");
		lErrorDesc.setToolTipText("");
		add(lErrorDesc, "cell 1 2 1 4,alignx center");
		
		scrollPane_2 = new JScrollPane();
		add(scrollPane_2, "cell 4 1 2 3,grow");
		
		listCat = new List();
		listCat.setMultipleMode(true);
		listCat.setBackground(Color.DARK_GRAY);
		scrollPane_2.setViewportView(listCat);
		
		JLabel lblNewLabel_5 = new JLabel("URL Asociado");
		add(lblNewLabel_5, "cell 0 6,alignx right,aligny center");
		
		lErrorURL = new ImageLoad("/errorIcon.png");
		add(lErrorURL, "cell 1 6,alignx center");
		
		tfURLAsoc = new JTextField();
		tfURLAsoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(lErrorURL.isVisible() == true) {
					
					lErrorURL.setVisible(false);
				}
			}
		});
		add(tfURLAsoc, "cell 2 6 2 1,alignx left,aligny top");
		tfURLAsoc.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Fecha");
		add(lblNewLabel_7, "cell 0 7,alignx right,aligny top");
		
		dtFecha = new JDateChooser();
		add(dtFecha, "cell 2 7 2 1,grow");
		dtFecha.setDate(Herramienta.getDateSystem());
		dtFecha.setEnabled(false);
		
		lErrorHor.setVisible(false);
		lErrorDur.setVisible(false);
		lErrorCred.setVisible(false);
		lErrorDesc.setVisible(false);
		lErrorURL.setVisible(false);
		lErrorNom.setVisible(false);

		
	}
	
	public void llenarDatos(DtCurso c) {
		tfNombre.setText(c.getNombre());
		spCantHoras.setValue(c.getCantHoras());
		txDesc.setText(c.getDescripcion());
		spDuracion.setValue(c.getDuracion());
		spCantCredAsociados.setValue(c.getCreditos());
		tfURLAsoc.setText(c.getURL());
		dtFecha.setDate(c.getFechaReg());
		Herramienta.llenarLista(listPrev, iconsulta.getNomPrevias(c.getNombre()));
	}
	
	public DtCurso getDtCurso() {
		String foto = " ";
		return new DtCurso(tfNombre.getText(),txDesc.getText(), tfURLAsoc.getText(),(Integer)spDuracion.getValue() ,(Integer)spCantHoras.getValue(), (Integer) spCantCredAsociados.getValue(),
				dtFecha.getDate(), foto);
	}
	
	public void setPrevias() {
		listPrev.removeAll();
		Herramienta.llenarLista(listPrev, iconsulta.listarCurso());
	}

	public void borrarTodo() {
		tfNombre.setText("");
		spCantHoras.setValue(0);
		txDesc.setText("");
		spDuracion.setValue(0);
		spCantCredAsociados.setValue(0);
		tfURLAsoc.setText("");
		dtFecha.setDate(null);
		listPrev.removeAll();
	}
	
	public void blockAll() {
		Herramienta.blockAll(tfNombre,spCantHoras,txDesc,spDuracion,spCantCredAsociados,tfURLAsoc);
	}
	public void unblockAll() {
		Herramienta.unblockAll(tfNombre,spCantHoras,txDesc,spDuracion,spCantCredAsociados,tfURLAsoc);
	}

	public boolean datosValidos() {
		Boolean returno = true;
		if(tfNombre.getText().toString().equals("") == true) {
			returno = false;
			lErrorNom.setVisible(true);
			lErrorNom.setToolTipText("EL nombre est� vac�o");
		}
		if(tfURLAsoc.getText().toString().equals("") == true) {
			returno = false;
			lErrorURL.setVisible(true);
			lErrorURL.setToolTipText("La URL est� vac�a");
		}
		if((int)spCantHoras.getValue() == 0) {
			returno = false;
			lErrorHor.setVisible(true);
			lErrorHor.setToolTipText("La duraci�n es 0");
		}
		if(txDesc.getText().toString().equals("") == true) {
			returno = false;
			lErrorDesc.setVisible(true);
			lErrorDesc.setToolTipText("La Descripci�n est� vac�a");
		}
		if((int)spDuracion.getValue() == 0) {
			returno = false;
			lErrorDur.setVisible(true);
			lErrorDur.setToolTipText("La Duraci�n es 0");
		}
		/*if((int)spCantCredAsociados.getValue() == 0) {
			returno = false;
			lErrorCred.setVisible(true);
			lErrorCred.setToolTipText("Da 0 creditos");
		}*/
		return returno;
	}
	
	public ArrayList<String> getNomPrevias(){
		ArrayList<String> returno = new ArrayList<String>();
		for(String i : listPrev.getSelectedItems()) {
			returno.add(i);
		}
		
		return returno;
	}
	
}
