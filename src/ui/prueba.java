package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JLabel;

public class prueba extends JFrame {

	private JPanel contentPane;
	private JTextField txtHelloWorld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
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
	public prueba() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnPulsarBoton = new JButton("Pulsar Boton");
		GridBagConstraints gbc_btnPulsarBoton = new GridBagConstraints();
		gbc_btnPulsarBoton.insets = new Insets(0, 0, 5, 0);
		gbc_btnPulsarBoton.gridx = 0;
		gbc_btnPulsarBoton.gridy = 0;
		contentPane.add(btnPulsarBoton, gbc_btnPulsarBoton);
		
		JLabel lblHelloWorld = new JLabel("Hello world!!");
		GridBagConstraints gbc_lblHelloWorld = new GridBagConstraints();
		gbc_lblHelloWorld.gridx = 0;
		gbc_lblHelloWorld.gridy = 1;
		contentPane.add(lblHelloWorld, gbc_lblHelloWorld);
		
		
		
	}

}
