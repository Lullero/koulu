

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Mainostolppa extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	public static JTextField Mainosteksti;	
	public static JLabel lblnykyinenhinta95;
	public static  JLabel lblnykyinenhinta98;
	public static JLabel lblnykyinenhintaDiesel;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;

	/**
	 * Create the dialog.
	 */
	public Mainostolppa() {
		setTitle("MAINOSTOLPPA");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				HintojenYllapito.lblnykyinenhinta95.setText(lblnykyinenhinta95.getText());
				HintojenYllapito.lblnykyinenhinta98.setText(lblnykyinenhinta98.getText());
				HintojenYllapito.lblnykyinenhintaDiesel.setText(lblnykyinenhintaDiesel.getText());
				HintojenYllapito.Nykyinenmainos.setText(Mainosteksti.getText());
			}
		});
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPanel.setBackground(Color.RED);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("95");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(74, 30, 46, 22);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("98");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.YELLOW);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(194, 30, 46, 22);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("D");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBackground(Color.YELLOW);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(314, 30, 46, 22);
		contentPanel.add(lblNewLabel_2);
		
		Mainosteksti = new JTextField();
		Mainosteksti.setHorizontalAlignment(SwingConstants.CENTER);
		Mainosteksti.setBackground(Color.WHITE);
		Mainosteksti.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Mainosteksti.setBounds(43, 135, 354, 97);
		contentPanel.add(Mainosteksti);
		Mainosteksti.setColumns(10);
		
		lblnykyinenhinta95 = new JLabel("");
		lblnykyinenhinta95.setHorizontalAlignment(SwingConstants.CENTER);
		lblnykyinenhinta95.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblnykyinenhinta95.setOpaque(true);
		lblnykyinenhinta95.setBackground(Color.WHITE);
		lblnykyinenhinta95.setBounds(74, 75, 46, 35);
		contentPanel.add(lblnykyinenhinta95);
		
		lblnykyinenhinta98 = new JLabel("");
		lblnykyinenhinta98.setHorizontalAlignment(SwingConstants.CENTER);
		lblnykyinenhinta98.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblnykyinenhinta98.setOpaque(true);
		lblnykyinenhinta98.setBounds(194, 75, 46, 35);
		contentPanel.add(lblnykyinenhinta98);
		
		lblnykyinenhintaDiesel = new JLabel("");
		lblnykyinenhintaDiesel.setHorizontalAlignment(SwingConstants.CENTER);
		lblnykyinenhintaDiesel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblnykyinenhintaDiesel.setOpaque(true);
		lblnykyinenhintaDiesel.setBounds(314, 75, 46, 35);
		contentPanel.add(lblnykyinenhintaDiesel);
		
		lblNewLabel_3 = new JLabel("€");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(130, 75, 30, 35);
		contentPanel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("€");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(250, 75, 30, 35);
		contentPanel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("€");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(367, 75, 30, 35);
		contentPanel.add(lblNewLabel_5);
	}
	public static void main(String[] args) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src/Resources/hinnat.txt"));
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

