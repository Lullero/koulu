import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class HintojenYllapito extends JFrame {

	private JPanel contentPane;
	public static JTextField Mainosteksti;
	public static JLabel Nykyinenmainos;
	private JLabel Nimimainos;
	private JLabel lbl95Ehintanoedit;
	private JLabel lbl98hintanoedit;
	private JLabel lblDieselhintanoedit;
	public static JLabel lblnykyinenhinta95;
	public static JLabel lblnykyinenhinta98;
	public static JLabel lblnykyinenhintaDiesel;
	private JButton paivitahinnat;
	private JButton muutamainos;
	public static JTextField textuusihinta95;
	public static JTextField textuusihinta98;
	public static JTextField textuusihintaDiesel;
	
	private Mainostolppa mainostolppa = new Mainostolppa();  
	public static Paavalikko paavalikko = new Paavalikko();
	
	String ysiviis;
	String ysikasi; 
	String diesel;
	
	String filename = "src/Resources/hinnat.txt";
	String filename2 = "src/Resources/mainosteksti.txt";
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblHintaNyt;
	private JLabel lblHintaNyt_1;
	private JLabel lblHintaNyt_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HintojenYllapito frame = new HintojenYllapito();
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
	public HintojenYllapito() {
		setTitle("Hintojen ylläpito");
		
		File f = new File(filename); 	
		if(!f.exists()) { 
		    alustaTiedosto();
		    
		File f2 = new File(filename2);
		if(!f.exists()) {
			alustaTiedosto2();
		}
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 407);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Valikko");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Päävalikko");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paavalikko.dispose();
				paavalikko = new Paavalikko();
				paavalikko.setVisible(true);
				HintojenYllapito.this.setVisible(false);
			}
		});
		mntmNewMenuItem.setHorizontalTextPosition(SwingConstants.LEFT);
		mntmNewMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Poistu ohjelmasta");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Haluatko varmasti lopettaa?","Lopetus?",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if( result == JOptionPane.YES_OPTION ) { 
					System.exit(0);
				}
			}
		});

		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Mainosteksti = new JTextField();
		Mainosteksti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainosteksti.getText(); 
			}
		});
		Mainosteksti.setBounds(42, 257, 392, 20);
		contentPane.add(Mainosteksti);
		Mainosteksti.setColumns(10);
		
		Nimimainos = new JLabel("Mainosteksti");
		Nimimainos.setFont(new Font("Tahoma", Font.BOLD, 12));
		Nimimainos.setBounds(42, 207, 108, 14);
		contentPane.add(Nimimainos);
		
		lbl95Ehintanoedit = new JLabel("95E");
		lbl95Ehintanoedit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl95Ehintanoedit.setBounds(42, 23, 86, 14);
		contentPane.add(lbl95Ehintanoedit);
		
		lbl98hintanoedit = new JLabel("98");
		lbl98hintanoedit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl98hintanoedit.setBounds(196, 23, 86, 14);
		contentPane.add(lbl98hintanoedit);
		
		lblDieselhintanoedit = new JLabel("D");
		lblDieselhintanoedit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDieselhintanoedit.setBounds(348, 23, 86, 14);
		contentPane.add(lblDieselhintanoedit);
		
		paivitahinnat = new JButton("Päivitä hinnat mainostolppaan");
		paivitahinnat.setFont(new Font("Tahoma", Font.BOLD, 11));
		paivitahinnat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainostolppa.setVisible(true); 
				Double hinta95 = Double.parseDouble(textuusihinta95.getText());
				Double hinta98 = Double.parseDouble(textuusihinta98.getText());
				Double Diesel = Double.parseDouble(textuusihintaDiesel.getText());
				String kirjoitettava = "95E = " + hinta95
						+ "\n 98 = " + hinta98
						+ "\n Diesel = " + Diesel;
				
				int result = JOptionPane.showConfirmDialog(null, "Päivitetäänkö hinta?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if( result == JOptionPane.YES_OPTION )
				{
				Mainostolppa.lblnykyinenhinta95.setText(textuusihinta95.getText()); 
				Mainostolppa.lblnykyinenhinta98.setText(textuusihinta98.getText()); 
				Mainostolppa.lblnykyinenhintaDiesel.setText(textuusihintaDiesel.getText()); 
				kirjoitaTiedostoonhinnat(kirjoitettava, filename);	
				}
		}
		});

		paivitahinnat.setBounds(42, 147, 240, 23);
		contentPane.add(paivitahinnat);
		
		muutamainos = new JButton("Päivitä mainosteksti mainosotolppaan");
		muutamainos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainostolppa.setVisible(true); 
				String mainos = Mainosteksti.getText(); 
				
				int result = JOptionPane.showConfirmDialog(null, "Päivitetäänkö mainosteksti?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if( result == JOptionPane.YES_OPTION )
				{
				Mainostolppa.Mainosteksti.setText(Mainosteksti.getText());
				kirjoitaTiedostoonmainosteksti(mainos, filename2); 
				}
			}
		});
		muutamainos.setFont(new Font("Tahoma", Font.BOLD, 11));
		muutamainos.setBounds(42, 298, 249, 23);
		contentPane.add(muutamainos);
		
		lblnykyinenhinta98 = new JLabel("");
		lblnykyinenhinta98.setBounds(196, 66, 46, 14);
		contentPane.add(lblnykyinenhinta98);
		
		lblnykyinenhintaDiesel = new JLabel("");
		lblnykyinenhintaDiesel.setBounds(348, 66, 46, 14);
		contentPane.add(lblnykyinenhintaDiesel);
		
		lblnykyinenhinta95 = new JLabel("");
		lblnykyinenhinta95.setBounds(42, 66, 46, 14);
		contentPane.add(lblnykyinenhinta95);
		
		textuusihinta95 = new JTextField();
		textuusihinta95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double hinta95 = Double.parseDouble(textuusihinta95.getText());
			}
		});
		textuusihinta95.setBounds(42, 116, 86, 20);
		contentPane.add(textuusihinta95);
		textuusihinta95.setColumns(10);
		
		textuusihinta98 = new JTextField();
		textuusihinta98.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double hinta98 = Double.parseDouble(textuusihinta98.getText());
			}
		});
		textuusihinta98.setColumns(10);
		textuusihinta98.setBounds(196, 116, 86, 20);
		contentPane.add(textuusihinta98);
		
		textuusihintaDiesel = new JTextField();
		textuusihintaDiesel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double Diesel = Double.parseDouble(textuusihintaDiesel.getText());
			}
		});
		textuusihintaDiesel.setColumns(10);
		textuusihintaDiesel.setBounds(348, 116, 86, 20);
		contentPane.add(textuusihintaDiesel);
		
		Nykyinenmainos = new JLabel("");
		Nykyinenmainos.setBounds(43, 232, 336, 14);
		contentPane.add(Nykyinenmainos);
		
		lblNewLabel = new JLabel("Syötä uusi hinta");
		lblNewLabel.setBounds(42, 91, 108, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Syötä uusi hinta");
		lblNewLabel_1.setBounds(196, 91, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Syötä uusi hinta");
		lblNewLabel_2.setBounds(348, 91, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		lblHintaNyt = new JLabel("Hinta nyt €");
		lblHintaNyt.setBounds(42, 48, 89, 14);
		contentPane.add(lblHintaNyt);
		
		lblHintaNyt_1 = new JLabel("Hinta nyt €");
		lblHintaNyt_1.setBounds(193, 48, 89, 14);
		contentPane.add(lblHintaNyt_1);
		
		lblHintaNyt_2 = new JLabel("Hinta nyt €");
		lblHintaNyt_2.setBounds(345, 48, 89, 14);
		contentPane.add(lblHintaNyt_2);
		
	    luehinta(filename);
	    luemainos(filename2);
	}
	public void luehinta(String filename) {
		
		try {
			FileReader freader = new FileReader(filename);
			BufferedReader br = new BufferedReader(freader);
			String line;
			ysiviis = br.readLine();  
			ysiviis = kasitteleRivi(ysiviis);
			ysikasi = kasitteleRivi(br.readLine());
			diesel = kasitteleRivi(br.readLine());
			
			lblnykyinenhinta95.setText(ysiviis); 
			lblnykyinenhinta98.setText(ysikasi);
			lblnykyinenhintaDiesel.setText(diesel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void luemainos(String filename2) {
		
		try {
			FileReader freader = new FileReader(filename2);
			BufferedReader br = new BufferedReader(freader);
			String line;
			line = br.readLine(); 
			
			Nykyinenmainos.setText(line); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void kirjoitaTiedostoonhinnat(String txt, String filename) {
		try {
			// Valinta true lopussa aiheuttaa sen, ett� ei ylikirjoiteta vaan jatketaan olemassa olevan per��n
			FileWriter fwriter = new FileWriter(filename, false);
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void kirjoitaTiedostoonmainosteksti(String txt, String filename2) {
		try {
			// Valinta true lopussa aiheuttaa sen, ett� ei ylikirjoiteta vaan jatketaan olemassa olevan per��n
			FileWriter fwriter = new FileWriter(filename2, false);
			fwriter.write(txt);
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alustaTiedosto() {
		String kirjoitettava = "95E = 1.4\n"
				+ "98 = 2.0\n"
				+ "Diesel = 1.8";
	
		kirjoitaTiedostoonhinnat(kirjoitettava, filename);
	}
	
	public void alustaTiedosto2() {
		String mainos = "Kahvi ja pulla 2€";
		
		kirjoitaTiedostoonmainosteksti(mainos, filename2);
	}
	
	public String kasitteleRivi(String txt) {   
		txt = txt.replace(" ", "");				
		String[] temp = txt.split("=");			
		
		return temp[1];
	}
}
