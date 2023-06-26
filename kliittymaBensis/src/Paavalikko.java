import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Paavalikko extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Mihin haluat siirtyä");
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton Nappi3_paavalikko;
	
	private Kirjautuminen kirjautuminen = new Kirjautuminen();
	private Maksuautomaatti maksu = new Maksuautomaatti();
	private KirjautuminenHinnat kirjautuminenHinnat = new KirjautuminenHinnat();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paavalikko frame = new Paavalikko();
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
	public Paavalikko() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Paavalikko.class.getResource("/icon/gasoline.png")));
		setTitle("Bensa-asema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(62, 32, 310, 31);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Maksuautomaatti ja bensamittari");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maksu.dispose();
				maksu = new Maksuautomaatti();
				maksu.setVisible(true);
				Paavalikko.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(75, 85, 284, 31);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Hintojen ylläpito ja mainostaulu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kirjautuminenHinnat.dispose();
				kirjautuminenHinnat = new KirjautuminenHinnat();
				kirjautuminenHinnat.setVisible(true);
				Paavalikko.this.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(75, 127, 284, 31);
		contentPane.add(btnNewButton_1);
		
		Nappi3_paavalikko = new JButton("Tankkien tarkkailu ja tilausten hallinta");
		Nappi3_paavalikko.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kirjautuminen.dispose();
				kirjautuminen = new Kirjautuminen();
				kirjautuminen.setVisible(true);
				Paavalikko.this.setVisible(false);
			}
		});
		Nappi3_paavalikko.setBounds(75, 170, 284, 31);
		contentPane.add(Nappi3_paavalikko);
	}

}
