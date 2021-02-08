package Presentacion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import Interface.Fabrica;
import Interface.IAlta;
import Interface.IConsulta;
import Interface.IModificacion;
import Persistencia.Conexion;
import Publicaciones.ControladorAltaPublish;
import Publicaciones.ControladorConstPublish;
import Publicaciones.ControladorModiPublish;


public class Principal {
	private JFrame frmEdext;
	private JInstitutoAlta jInstitutoAlta;
	private JAgregarCursoAPrograma jAgregarCursoAPrograma;
	private JCursoAlta jCursoAlta;
	private JCursoConsulta jCursoConsulta;
	private JEdicionAlta jEdicionAlta;
	private JEdicionConsulta jEdicionConsulta;
	private JInscripcionEdicion jInscripcionEdicion;
	private JProgramaAlta jProgramaAlta;
	private JProgramaConsulta jProgramaConsulta;
	private JUsuarioAlta jUsuarioAlta;
	private JUsuarioConsulta jUsuarioConsulta;
	private JUsuarioModificar jUsuarioModificar;
	private JCategoriaAlta jCategoriaAlta;
	private BackGround jPrincipal;
	
	private CardLayout cardPanel;
	private JPanel panel;
	private JMenuItem mniProgramaConsulta;
	private JMenuItem mniUsuarioAlta;
	private JMenuItem mniUsuarioModificar;
	private JMenuItem mniUsuarioConsultar;
	private JMenu mniEdicion;
	private JMenuItem mniEdicionAlta;
	private JMenuItem mniEdicionConsulta;
	private JMenuItem mniAgregarCursoAPrograma;
	private JMenu mniCurso;
	private JMenuItem minCursoAlta;
	private JMenuItem mniCursoConsultar;
	private JMenuItem mniInscripcionEdicion;
	private JMenu mnCategoria;
	private JMenuItem mntmCrear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            Properties props = new Properties();
		            props.put("logoString", "");
		            HiFiLookAndFeel.setCurrentTheme(props);
		            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		            
		            break;
		        }
		    }
		} catch (Exception e) {
		    
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmEdext.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Principal() {
		ControladorAltaPublish cap = new ControladorAltaPublish();
		ControladorConstPublish ccp = new ControladorConstPublish();
		ControladorModiPublish cmp = new ControladorModiPublish();
		
		cap.publicar();
		ccp.publicar();
		cmp.publicar();

		@SuppressWarnings("unused")

		Fabrica fabrica = Fabrica.getInstancia();
		
        IAlta iAlta = fabrica.getIAlta();

        IConsulta iConsulta = fabrica.getIConsulta();
        
        IModificacion iModificar = fabrica.getIModificacion();
        
        jAgregarCursoAPrograma = new JAgregarCursoAPrograma(iAlta, iConsulta,this );
    	jAgregarCursoAPrograma = new JAgregarCursoAPrograma(iAlta, iConsulta, this);
    	jCursoAlta = new JCursoAlta(iConsulta,iAlta, this);
    	jCursoConsulta = new JCursoConsulta(iConsulta, this);
    	jEdicionAlta = new JEdicionAlta(iAlta,iConsulta, this);
    	jEdicionConsulta = new JEdicionConsulta(iAlta,iConsulta, this);
    	jInscripcionEdicion = new JInscripcionEdicion( iAlta, iConsulta, this);
        jInstitutoAlta = new JInstitutoAlta(iAlta, this);
        jCategoriaAlta = new JCategoriaAlta(iAlta,this);
        jInstitutoAlta.setBackground(new Color(0, 153, 204));
        jPrincipal = new BackGround();
	
    	jProgramaAlta = new JProgramaAlta(iAlta,this);
    	jProgramaConsulta = new JProgramaConsulta(iConsulta, this);
    	jUsuarioAlta = new JUsuarioAlta(iAlta,iConsulta, this);
    	jUsuarioConsulta = new JUsuarioConsulta(iConsulta,this);
    	jUsuarioModificar = new JUsuarioModificar(iModificar, this);
    	
        frmEdext = new JFrame();
        frmEdext.setTitle("EdExt");
        
        Dimension desktopSize = frmEdext.getSize();
		Dimension jInternalFrameSize;
		
		jInternalFrameSize = jAgregarCursoAPrograma.getSize();
		jAgregarCursoAPrograma.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jPrincipal.getSize();
		jPrincipal.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		
		
		jInternalFrameSize = jCursoAlta.getSize();
		jCursoAlta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jCategoriaAlta.getSize();
		jCategoriaAlta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		
		jInternalFrameSize = jCursoConsulta.getSize();
		jCursoConsulta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jEdicionAlta.getSize();
		jEdicionAlta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jEdicionConsulta.getSize();
		jEdicionConsulta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jInscripcionEdicion.getSize();
		jInscripcionEdicion.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jProgramaAlta.getSize();
		jProgramaAlta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jProgramaConsulta.getSize();
		jProgramaConsulta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jUsuarioAlta.getSize();
		jUsuarioAlta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jUsuarioConsulta.getSize();
		jUsuarioConsulta.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		jInternalFrameSize = jUsuarioModificar.getSize();
		jUsuarioModificar.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 153, 153));
		frmEdext.setJMenuBar(menuBar);
		
		JMenu mniUsuario = new JMenu("Usuario");
		mniUsuario.setBackground(new Color(153, 204, 204));
		menuBar.add(mniUsuario);
		
		mniUsuarioAlta = new JMenuItem("Crear");
		mniUsuarioAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("UsuarioAlta");
			}
		});
		mniUsuario.add(mniUsuarioAlta);
		
		mniUsuarioModificar = new JMenuItem("Modificar");
		mniUsuarioModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("UsuarioModificar");
			}
		});
		mniUsuario.add(mniUsuarioModificar);
		
		mniInscripcionEdicion = new JMenuItem("Inscribir a Edici\u00F3n");
		mniInscripcionEdicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("InscripcionEdicion");
			}
		});
		mniUsuario.add(mniInscripcionEdicion);
		
		mniUsuarioConsultar = new JMenuItem("Consultar");
		mniUsuarioConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("UsuarioConsultar");
			}
		});
		mniUsuario.add(mniUsuarioConsultar);
		
		mniCurso = new JMenu("Curso");
		mniCurso.setBackground(new Color(153, 204, 204));
		menuBar.add(mniCurso);
		
		minCursoAlta = new JMenuItem("Crear");
		minCursoAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("CursoAlta");
			}
		});
		mniCurso.add(minCursoAlta);
		
		mniCursoConsultar = new JMenuItem("Consultar");
		mniCursoConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("CursoConsultar");
			}
		});
		mniCurso.add(mniCursoConsultar);
		
		mniEdicion = new JMenu("Edicion");
		mniEdicion.setBackground(new Color(153, 204, 204));
		menuBar.add(mniEdicion);
		
		mniEdicionAlta = new JMenuItem("Crear");
		mniEdicionAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("EdicionAlta");

			}
		});
		mniEdicion.add(mniEdicionAlta);
		
		mniEdicionConsulta = new JMenuItem("Consultar");
		mniEdicionConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("EdicionConsulta");
			}
		});
		mniEdicion.add(mniEdicionConsulta);
		
		JMenu mniPrograma = new JMenu("Programa");
		mniPrograma.setBackground(new Color(153, 204, 204));
		menuBar.add(mniPrograma);
		
		JMenuItem mniProgramaAlta = new JMenuItem("Crear");
		mniProgramaAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("ProgramaAlta");
			}
		});
		mniPrograma.add(mniProgramaAlta);
		
		mniProgramaConsulta = new JMenuItem("Consultar");
		mniProgramaConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("ProgramaConsulta");
			}
		});
		
		mniAgregarCursoAPrograma = new JMenuItem("Agregar Curso");
		mniAgregarCursoAPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("AgregarCursoAPrograma");
			}
		});
		mniPrograma.add(mniAgregarCursoAPrograma);
		mniPrograma.add(mniProgramaConsulta);
		
		JMenu mniInstituto = new JMenu("Instituto");
		mniInstituto.setBackground(new Color(153, 204, 204));
		menuBar.add(mniInstituto);
		
		JMenuItem mniInstitutoAlta = new JMenuItem("Crear");
		mniInstitutoAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel("InstitutoAlta");
			}
		});
		mniInstituto.add(mniInstitutoAlta);
		
		mnCategoria = new JMenu("Categoria");
		menuBar.add(mnCategoria);
		
		mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel("CategoriaAlta");
			}
		});
		mnCategoria.add(mntmCrear);
		
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmEdext.setBounds(100, 100, 727, 381);
		frmEdext.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEdext.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		frmEdext.getContentPane().add(panel);
		cardPanel = new CardLayout(0, 0);
		panel.setLayout(cardPanel);
		panel.add(jInstitutoAlta, "InstitutoAlta");
		panel.add(jAgregarCursoAPrograma, "AgregarCursoAPrograma");
		panel.add(jCursoAlta, "CursoAlta");
		panel.add(jCursoConsulta, "CursoConsultar");
		panel.add(jEdicionAlta, "EdicionAlta");
		panel.add(jEdicionConsulta, "EdicionConsulta");
		panel.add(jCategoriaAlta, "CategoriaAlta");
		panel.add(jInscripcionEdicion, "InscripcionEdicion");
		panel.add(jProgramaAlta, "ProgramaAlta");
		panel.add(jProgramaConsulta, "ProgramaConsulta");
		panel.add(jUsuarioAlta, "UsuarioAlta");
		panel.add(jUsuarioConsulta, "UsuarioConsultar");
		panel.add(jUsuarioModificar, "UsuarioModificar");
		panel.add(jPrincipal, "Principal");
		cardPanel.show(panel, "Principal");

	}
	
	public void switchPanel(String panelName) {
        cardPanel.show(panel, panelName);
    }
}
