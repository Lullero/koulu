import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class Tankit extends JFrame {

	private JPanel contentPane;
	private JLabel lblMaara98noedit;
	private JLabel lblMaara95noedit;
	private JLabel lblMaaraDinoedit;
	public static JLabel lblMaara_95;
	public static JLabel lblMaara_98;
	public static JLabel lblMaara_Di;
	

	public static Paavalikko paavalikko = new Paavalikko();
	
	String ysiviis;
	String ysikasi;
	String diesel;

	String filename = "src/Resources/tankeissa_bensaa.txt";
	String filename2 = "src/Resources/tilaukset.txt";
	
	private JButton btnTilaa;
	private JTextField txtTilaa95;
	private JLabel lbl95;
	private JLabel lbl95_1;
	private JLabel lblDi;
	private JSlider slider_95;
	private JSlider slider_Di;
	private JSlider slider_98;
	private JTextField txtTilaa98;
	private JTextField txtTilaaDi;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	
	
	
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tankit frame = new Tankit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tankit() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tankit.class.getResource("/icon/gasoline.png")));
		setTitle("Tankit");
		
		File f = new File(filename); 	
		if(!f.exists()) { 
		    alustaTiedosto();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 351);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Valikko");
		menuBar.add(mnMenu);
		
		mntmNewMenuItem = new JMenuItem("Päävalikko");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paavalikko.dispose();
				paavalikko = new Paavalikko();
				paavalikko.setVisible(true);
				Tankit.this.setVisible(false);
			}
		});
		mnMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Sulje");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Haluatko varmasti sulkea ohjelman?","Sulje?",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if( result == JOptionPane.OK_OPTION ) {
					System.exit(0);
				}
				if( result == JOptionPane.NO_OPTION ) {
					
				}
			}
		});
		mnMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMaara98noedit = new JLabel("litraa");
		lblMaara98noedit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaara98noedit.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMaara98noedit.setBounds(63, 156, 133, 14);
		contentPane.add(lblMaara98noedit);
		
		lblMaara95noedit = new JLabel("litraa");
		lblMaara95noedit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaara95noedit.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMaara95noedit.setBounds(63, 41, 126, 14);
		contentPane.add(lblMaara95noedit);
		
		lblMaara_98 = new JLabel("New label");
		lblMaara_98.setFont(new Font("Verdana", Font.BOLD, 15));
		lblMaara_98.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaara_98.setBounds(63, 132, 126, 29);
		contentPane.add(lblMaara_98);
		
		lblMaara_95 = new JLabel("New label");
		lblMaara_95.setFont(new Font("Verdana", Font.BOLD, 15));
		lblMaara_95.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaara_95.setBounds(68, 18, 128, 29);
		contentPane.add(lblMaara_95);
		
		lblMaaraDinoedit = new JLabel("litraa");
		lblMaaraDinoedit.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaaraDinoedit.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblMaaraDinoedit.setBounds(92, 251, 61, 14);
		contentPane.add(lblMaaraDinoedit);
		
		lblMaara_Di = new JLabel("");
		lblMaara_Di.setFont(new Font("Verdana", Font.BOLD, 15));
		lblMaara_Di.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaara_Di.setBounds(70, 228, 102, 30);
		contentPane.add(lblMaara_Di);
		
		
		
		btnTilaa = new JButton("tilaa");
		btnTilaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ysiviis = (Integer.parseInt(lblMaara_95.getText())	+ Integer.parseInt(txtTilaa95.getText()));
				int ysikasi = (Integer.parseInt(lblMaara_98.getText())	+ Integer.parseInt(txtTilaa98.getText()));
				int diesel = (Integer.parseInt(lblMaara_Di.getText())	+ Integer.parseInt(txtTilaaDi.getText()));
				String kirjoitettava = "95 = " + ysiviis + "\n98 = " + ysikasi +  "\nDi = " + diesel;
				
				String tmp95_maara;
				tmp95_maara = "" + (Integer.parseInt(lblMaara_95.getText())	+ Integer.parseInt(txtTilaa95.getText()));
				String tmp98_maara;
				tmp98_maara = "" + (Integer.parseInt(lblMaara_98.getText())	+ Integer.parseInt(txtTilaa98.getText()));
				String tmpDi_maara;
				tmpDi_maara = "" + (Integer.parseInt(lblMaara_Di.getText())	+ Integer.parseInt(txtTilaaDi.getText()));
				
				String tilaus95 = (txtTilaa95.getText());
				String tilaus98 = (txtTilaa95.getText());
				String tilausDi = (txtTilaa95.getText());
				String kirjoitettava2 = "95: " + tilaus95 + " litraa, 98: " + tilaus98 + " litraa, Di: " + tilausDi + " litraa."; 
				
				
				int result = JOptionPane.showConfirmDialog(null, "Syötetäänkö tilaus?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if( result == JOptionPane.OK_OPTION ) {
					lblMaara_95.setText(tmp95_maara);
					lblMaara_98.setText(tmp98_maara);
					lblMaara_Di.setText(tmpDi_maara);
					txtTilaa95.setText("");
					txtTilaa98.setText("");
					txtTilaaDi.setText("");
					
					kirjoitaTiedostoon(kirjoitettava,filename);
					kirjoitaTiedostoonTilaus(kirjoitettava2, filename2);
				}
				if( result == JOptionPane.NO_OPTION ) {
					txtTilaa95.setText("");
					txtTilaa98.setText("");
					txtTilaaDi.setText("");
				}
			}
		});
		btnTilaa.setBounds(595, 23, 61, 242);
		contentPane.add(btnTilaa);
		
		txtTilaa95 = new JTextField();
		txtTilaa95.setBounds(496, 20, 86, 44);
		contentPane.add(txtTilaa95);
		txtTilaa95.setColumns(10);
		
		lbl95 = new JLabel("95E");
		lbl95.setHorizontalAlignment(SwingConstants.CENTER);
		lbl95.setFont(new Font("Verdana", Font.BOLD, 30));
		lbl95.setBounds(0, 18, 74, 46);
		contentPane.add(lbl95);
		
		lbl95_1 = new JLabel("98");
		lbl95_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl95_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lbl95_1.setBounds(0, 132, 74, 46);
		contentPane.add(lbl95_1);
		
		lblDi = new JLabel("Di");
		lblDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDi.setFont(new Font("Verdana", Font.BOLD, 30));
		lblDi.setBounds(0, 228, 74, 46);
		contentPane.add(lblDi);
		
		slider_95 = new JSlider(0, 10000);
		
		slider_95.setPaintTrack(true);
		slider_95.setPaintTicks(true);
		slider_95.setPaintLabels(true);
		
		slider_95.setMajorTickSpacing(5000);
		slider_95.setMinorTickSpacing(500);
		
		slider_95.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtTilaa95.setText("" + slider_95.getValue());
				
			}
		});
		slider_95.setBounds(177, 23, 309, 52);
		contentPane.add(slider_95);
		
		slider_Di = new JSlider(0, 10000);
		slider_Di.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtTilaaDi.setText("" + slider_Di.getValue());
			}
		});
		slider_Di.setPaintTrack(true);
		slider_Di.setPaintTicks(true);
		slider_Di.setPaintLabels(true);
		slider_Di.setMinorTickSpacing(500);
		slider_Di.setMajorTickSpacing(5000);
		slider_Di.setBounds(177, 233, 309, 52);
		contentPane.add(slider_Di);
		
		slider_98 = new JSlider(0, 10000);
		slider_98.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtTilaa98.setText("" + slider_98.getValue());
			}
		});
		slider_98.setPaintTrack(true);
		slider_98.setPaintTicks(true);
		slider_98.setPaintLabels(true);
		slider_98.setMinorTickSpacing(500);
		slider_98.setMajorTickSpacing(5000);
		slider_98.setBounds(177, 132, 309, 52);
		contentPane.add(slider_98);
		
		txtTilaa98 = new JTextField();
		txtTilaa98.setColumns(10);
		txtTilaa98.setBounds(496, 126, 86, 44);
		contentPane.add(txtTilaa98);
		
		txtTilaaDi = new JTextField();
		txtTilaaDi.setColumns(10);
		txtTilaaDi.setBounds(496, 223, 86, 44);
		contentPane.add(txtTilaaDi);
		
		lueSaldo(filename);
	
	}

	public void lueSaldo(String filename) {
		
		try {
			FileReader freader = new FileReader(filename);
			BufferedReader br = new BufferedReader(freader);
			String line;
			ysiviis = br.readLine();  
			ysiviis = kasitteleRivi(ysiviis);
			
			ysikasi = kasitteleRivi(br.readLine());
			diesel = kasitteleRivi(br.readLine());
			
			lblMaara_98.setText(ysikasi);
			lblMaara_95.setText(ysiviis);
			lblMaara_Di.setText(diesel);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void kirjoitaTiedostoon(String txt, String filename) {
		try {
			FileWriter fwriter = new FileWriter(filename, false);
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alustaTiedosto() {		
		String kirjoitettava = "95 = 10000\n"
				+ "98 = 10000\n"
				+ "Di = 10000";
	
		kirjoitaTiedostoon(kirjoitettava, filename);
	}
	
	public String kasitteleRivi(String txt) {  
		txt = txt.replace(" ", "");				
		String[] temp = txt.split("=");			
		
		return temp[1];
	}
	
	public void kirjoitaTiedostoonTilaus(String txt, String filename) {
		try {
			java.util.Date date = new java.util.Date();
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString()+"\n");
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void tarkastaTilanne() {
		int minimi = 2000;
		if (minimi > (Integer.parseInt(lblMaara_95.getText()))) {
			JOptionPane.showMessageDialog(null, "95 vähissä, tilaa lisää!");
		}
		if ( minimi > (Integer.parseInt(lblMaara_98.getText()))) {
			JOptionPane.showMessageDialog(null, "98 vähissä, tilaa lisää!");
		}
		if ( minimi > (Integer.parseInt(lblMaara_Di.getText()))) {
			JOptionPane.showMessageDialog(null, "Diesel vähissä, tilaa lisää!");
		}
	}
}
