package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Detalles extends JPanel {

	/**
	 * Create the panel.
	 */
	public Detalles() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Por aqui el mapa y tal hay que gestionar esto");
		lblNewLabel.setBounds(10, 11, 430, 43);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Prueba");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(212, 175, 89, 23);
		add(btnNewButton);

	}

}
