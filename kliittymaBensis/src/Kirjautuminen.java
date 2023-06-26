import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Kirjautuminen extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ktunnus;
	private JTextField textField_ssana;
	private JLabel lbl_ktunnus;
	private JLabel lbl_ssana;
	private JButton Nappi_kirjaudu;
	
	public static Tankit ohjelma = new Tankit();
	
	String filename = "src/Resources/tunnukset.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kirjautuminen frame = new Kirjautuminen();
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
	public Kirjautuminen() {
		setTitle("Kirjaudu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_ktunnus = new JTextField();
		textField_ktunnus.setText("");
		textField_ktunnus.setBounds(119, 49, 196, 25);
		contentPane.add(textField_ktunnus);
		textField_ktunnus.setColumns(10);
		
		textField_ssana = new JTextField();
		textField_ssana.setText("");
		textField_ssana.setColumns(10);
		textField_ssana.setBounds(119, 92, 196, 25);
		contentPane.add(textField_ssana);
		
		lbl_ktunnus = new JLabel("Käyttäjätunnus");
		lbl_ktunnus.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_ktunnus.setBounds(20, 49, 89, 25);
		contentPane.add(lbl_ktunnus);
		
		lbl_ssana = new JLabel("Salasana");
		lbl_ssana.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_ssana.setBounds(20, 92, 89, 25);
		contentPane.add(lbl_ssana);
		
		Nappi_kirjaudu = new JButton("Kirjaudu");
		Nappi_kirjaudu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oikea_tunnus = "ktunnus";
				String oikea_ssana = crypt("salasana");
				String salasana_crypted="";
				
				try {
					salasana_crypted = crypt(textField_ssana.getText());
				} catch (Exception f) {
				}
				
				if (textField_ktunnus.getText().equals(oikea_tunnus) && oikea_ssana.equals(salasana_crypted)) {
					Kirjautuminen.this.setVisible(false); 
					ohjelma.setVisible(true); 
					ohjelma.tarkastaTilanne();
				}
				else {
					JOptionPane.showMessageDialog(null, "Väärä salasana!");
				}
			}
		});
		Nappi_kirjaudu.setBounds(172, 165, 89, 23);
		contentPane.add(Nappi_kirjaudu);
	}
	public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        MessageDigest digester;
        try {
            digester = MessageDigest.getInstance("MD5");

            digester.update(str.getBytes());
            byte[] hash = digester.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
