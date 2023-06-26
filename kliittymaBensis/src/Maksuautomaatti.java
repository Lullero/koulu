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

public class Maksuautomaatti extends JFrame {

	private JPanel contentPane;
	private JTextField textField_pin;
	private JLabel lblSyota;
	private JLabel lblPin;
	private JButton Nappi_kirjaudu;
	
	private Bensamittari mittari = new Bensamittari();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maksuautomaatti frame = new Maksuautomaatti();
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
	public Maksuautomaatti() {
		setTitle("Kirjaudu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 256);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_pin = new JTextField();
		textField_pin.setHorizontalAlignment(SwingConstants.CENTER);
		textField_pin.setText("");
		textField_pin.setColumns(10);
		textField_pin.setBounds(119, 92, 196, 25);
		contentPane.add(textField_pin);
		
		lblSyota = new JLabel("Syötä PIN-koodi");
		lblSyota.setHorizontalAlignment(SwingConstants.CENTER);
		lblSyota.setBounds(140, 42, 153, 25);
		contentPane.add(lblSyota);
		
		lblPin = new JLabel("PIN");
		lblPin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPin.setBounds(20, 92, 89, 25);
		contentPane.add(lblPin);
		
		Nappi_kirjaudu = new JButton("Kirjaudu");
		Nappi_kirjaudu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oikea_pin = crypt("1010");
				String salasana_crypted="";
				
				try {
					salasana_crypted = crypt(textField_pin.getText());
				} catch (Exception f) {
				}
				
				if (oikea_pin.equals(salasana_crypted)) {
					Maksuautomaatti.this.setVisible(false); 
					mittari.setVisible(true); 
				}
				else {
					JOptionPane.showMessageDialog(null, "PIN-koodi väärin!");
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
