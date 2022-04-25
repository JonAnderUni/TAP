package ui;

import javax.swing.JPanel;

import capadatos.Producto;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Detalles extends JPanel {

	/**
	 * Create the panel.
	 */
	public Detalles(Producto producto) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Informacion sobre el producto");
		lblNewLabel.setBounds(10, 11, 430, 43);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Prueba");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(529, 435, 89, 23);
		add(btnNewButton);
		
		
		JLabel lblNewLabel_2 = new JLabel("Producto: ");
		lblNewLabel_2.setBounds(10, 66, 113, 15);
		add(lblNewLabel_2);
		

		JLabel lblNewLabel_1 = new JLabel(producto.getNombre());
		lblNewLabel_1.setBounds(10, 93, 89, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Precio: ");
		lblNewLabel_2_1.setBounds(126, 66, 113, 15);
		add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel(Float.toString(producto.getPrecio()));
		lblNewLabel_3.setBounds(126, 93, 70, 15);
		add(lblNewLabel_3);
		
		JLabel lblTienda = new JLabel("Tienda:");
		lblTienda.setBounds(214, 66, 70, 15);
		add(lblTienda);
		
		JLabel lblA = new JLabel(producto.getNombreTienda());
		lblA.setBounds(208, 93, 143, 15);
		add(lblA);

	}
}
