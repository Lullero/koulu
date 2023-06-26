import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bensamittari extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lbl95;
	private JLabel lbl98;
	private JLabel lblDi;
	private JLabel lblnykyinenhinta95;
	private JLabel lblnykyinenhinta98;
	private JLabel lblnykyinenhintaDiesel;
	private JLabel lblNewLabel_1;
	private JTextField txtMaara95;
	private JTextField txtMaara98;
	private JTextField txtMaaraDi;
	private JButton nappi_tankkaa;
	private JLabel lblMaara_95;
	private JLabel lblMaara_98;
	private JLabel lblMaara_Di;
	
	String ysiviis;
	String ysikasi; 
	String diesel;
	
	String filename = "src/Resources/hinnat.txt";
	String filename2 = "src/Resources/kuitti.txt";
	String filename3 = "src/Resources/tankeissa_bensaa.txt";
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bensamittari frame = new Bensamittari();
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
	public Bensamittari() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Bensamittari:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(116, 0, 201, 31);
		contentPane.add(lblNewLabel);
		
		lbl95 = new JLabel("95");
		lbl95.setHorizontalAlignment(SwingConstants.CENTER);
		lbl95.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl95.setBounds(41, 42, 46, 14);
		contentPane.add(lbl95);
		
		lbl98 = new JLabel("98");
		lbl98.setHorizontalAlignment(SwingConstants.CENTER);
		lbl98.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl98.setBounds(194, 42, 46, 14);
		contentPane.add(lbl98);
		
		lblDi = new JLabel("Diesel");
		lblDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDi.setBounds(319, 42, 76, 14);
		contentPane.add(lblDi);
		
		lblnykyinenhinta95 = new JLabel("<dynamic>");
		lblnykyinenhinta95.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnykyinenhinta95.setHorizontalAlignment(SwingConstants.CENTER);
		lblnykyinenhinta95.setBounds(20, 65, 89, 28);
		contentPane.add(lblnykyinenhinta95);
		
		lblnykyinenhinta98 = new JLabel("<dynamic>");
		lblnykyinenhinta98.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnykyinenhinta98.setHorizontalAlignment(SwingConstants.CENTER);
		lblnykyinenhinta98.setBounds(172, 65, 89, 28);
		contentPane.add(lblnykyinenhinta98);
		
		lblnykyinenhintaDiesel = new JLabel("<dynamic>");
		lblnykyinenhintaDiesel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblnykyinenhintaDiesel.setHorizontalAlignment(SwingConstants.CENTER);
		lblnykyinenhintaDiesel.setBounds(315, 65, 89, 28);
		contentPane.add(lblnykyinenhintaDiesel);
		
		lblNewLabel_1 = new JLabel("Syötä haluamasi litramäärä:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 104, 307, 26);
		contentPane.add(lblNewLabel_1);
		
		txtMaara95 = new JTextField();
		txtMaara95.setColumns(10);
		txtMaara95.setBounds(20, 141, 86, 20);
		contentPane.add(txtMaara95);
		
		txtMaara98 = new JTextField();
		txtMaara98.setColumns(10);
		txtMaara98.setBounds(174, 141, 86, 20);
		contentPane.add(txtMaara98);
		
		txtMaaraDi = new JTextField();
		txtMaaraDi.setColumns(10);
		txtMaaraDi.setBounds(319, 141, 86, 20);
		contentPane.add(txtMaaraDi);
		
		nappi_tankkaa = new JButton("tankkaa");
		nappi_tankkaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tankkaa95 = (txtMaara95.getText());
				String tankkaa98 = (txtMaara98.getText());
				String tankkaaDi = (txtMaaraDi.getText());
				String kirjoitettava = "95: " + tankkaa95 + "l 98: " + tankkaa98 + "l Di: " + tankkaaDi + "l.";
				
				
				
				String tmp95_maara;
				tmp95_maara = "" + (Integer.parseInt(lblMaara_95.getText())	- Integer.parseInt(txtMaara95.getText()));
				String tmp98_maara;
				tmp98_maara = "" + (Integer.parseInt(lblMaara_98.getText())	- Integer.parseInt(txtMaara98.getText()));
				String tmpDi_maara;
				tmpDi_maara = "" + (Integer.parseInt(lblMaara_Di.getText())	- Integer.parseInt(txtMaaraDi.getText())); 
				String kirjoitettava2 = "95 = " + tmp95_maara + "\n98 = " + tmp98_maara + "\nDi = " + tmpDi_maara;
				
				int result = JOptionPane.showConfirmDialog(null, "Aloitetaan tankkaus, ok?","Varmistus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if( result == JOptionPane.OK_OPTION ) {
					lblMaara_95.setText(tmp95_maara);
					lblMaara_98.setText(tmp98_maara);
					lblMaara_Di.setText(tmpDi_maara);
					txtMaara95.setText("");
					txtMaara98.setText("");
					txtMaaraDi.setText("");
					
					kirjoitaTiedostoon(kirjoitettava,filename2);
					kirjoitaTiedostoonMaara(kirjoitettava2, filename3);
				}
				if( result == JOptionPane.NO_OPTION ) {
					txtMaara95.setText("");
					txtMaara98.setText("");
					txtMaaraDi.setText("");
				}
			}
		});
		nappi_tankkaa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nappi_tankkaa.setBounds(107, 206, 220, 44);
		contentPane.add(nappi_tankkaa);
		
		lblMaara_95 = new JLabel("");
		lblMaara_95.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaara_95.setBounds(20, 164, 67, 14);
		contentPane.add(lblMaara_95);
		
		lblMaara_98 = new JLabel("");
		lblMaara_98.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaara_98.setBounds(174, 164, 66, 14);
		contentPane.add(lblMaara_98);
		
		lblMaara_Di = new JLabel("");
		lblMaara_Di.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaara_Di.setBounds(319, 164, 66, 14);
		contentPane.add(lblMaara_Di);
		
		lblNewLabel_2 = new JLabel("€ / l");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(93, 65, 46, 28);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("€ / l");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(246, 65, 46, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("€ / l");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(387, 65, 46, 28);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("l");
		lblNewLabel_5.setBounds(81, 164, 24, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("l");
		lblNewLabel_6.setBounds(237, 164, 24, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("l");
		lblNewLabel_7.setBounds(380, 164, 24, 14);
		contentPane.add(lblNewLabel_7);
		
		lueHinta(filename);
		lueMaara(filename3);
		
	}
	public void lueHinta(String filename) {
		
		try {
			FileReader freader = new FileReader(filename);
			BufferedReader br = new BufferedReader(freader);
			String line;
			ysiviis = br.readLine();  
			ysiviis = kasitteleRivi(ysiviis);
			
			ysikasi = kasitteleRivi(br.readLine());
			diesel = kasitteleRivi(br.readLine());
			
			lblnykyinenhinta95.setText(ysikasi);
			lblnykyinenhinta98.setText(ysiviis);
			lblnykyinenhintaDiesel.setText(diesel);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void lueMaara(String filename) {
		
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
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void kirjoitaTiedostoonMaara(String txt, String filename) {
		try {
			FileWriter fwriter = new FileWriter(filename, false);
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alustaTiedosto() {		
		String kirjoitettava = "95E = 1.4\n"
				+ "98 = 2.0\n"
				+ "Diesel = 1.8";
	
		kirjoitaTiedostoon(kirjoitettava, filename);
	}
	
	public void alustaTiedosto2() {		
		String maara = "95 = 10000\n"
				+ "98 = 10000\n"
				+ "Di = 10000";
	
		kirjoitaTiedostoonMaara(maara, filename);
	}
	
	public String kasitteleRivi(String txt) {   
		txt = txt.replace(" ", "");				
		String[] temp = txt.split("=");			
		
		return temp[1];
	}
}
