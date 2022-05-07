package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StartGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGUI frame = new StartGUI();
					frame.setLocationRelativeTo(null);
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
	public StartGUI() {
		setTitle("Kapritxitos");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 460);
		getContentPane().setLayout(null);
		
		 ImageIcon imagen = new ImageIcon("IMG/LOGO.png");
	        this.setIconImage(imagen.getImage());
	        
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		ImageIcon logo = new ImageIcon(this.getClass().getResource("/LOGO.png"));
		JLabel lblNewLabel = new JLabel("Bienvenido a Kapritxitos");
		
		setSize(630,470);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(10, 0, 590, 80);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 27));
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Busqueda busqueda = new Busqueda();
				busqueda.main(null);
				dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 30,590, 328);
		lblNewLabel_1.setIcon(logo);
		contentPane.add(lblNewLabel_1);
		
		
		
		btnNewButton.setBounds(12, 382, 592, 28);
		contentPane.add(btnNewButton);
	}

}
