package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;

public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Busqueda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 460);
		getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 82, 604, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Introduzca el producto a buscar: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(10, 38, 395, 33);
		contentPane.add(lblNewLabel);
		JList list = new JList();
		
		JButton btnNewButton_1 = new JButton("Localizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Detalles detalles = new Detalles(/*Aqui habria que pasar el objeto de la lista que queremos trackear*/);
				setContentPane(detalles);
				validate();
				
			}
		});
		btnNewButton_1.setBounds(525, 387, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultListModel modelo = new DefaultListModel();
				//Pruebas
				modelo.addElement("Articulo 1");
				modelo.addElement("Articulo 2");
				modelo.addElement("Articulo 3");
		
				list.setModel(modelo); //Parte de gestion, aqui debera ir la lista de objetos relacionados con la busqueda.
				
				//gestor.buscaLista(textField.getText())
				btnNewButton_1.setVisible(true);
			}
		});
		btnNewButton.setBounds(525, 120, 89, 23);
		contentPane.add(btnNewButton);
		
		
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 141, 604, 235);
		contentPane.add(list);
		
	
	}
}
