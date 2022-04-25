package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capadatos.Producto;
import capadatos.gestorProducto;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
		lblNewLabel.setBounds(10, 38, 604, 33);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		JList list_1 = new JList();
		
		//Boton continuar
		JButton btnNewButton_1 = new JButton("Localizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Detalles detalles = new Detalles();
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
				DefaultListModel<String> modelo = new DefaultListModel();
				
				ArrayList<Producto> lista = gestorProducto.getGestorProducto().getLista(textField.getText());
				
				for(Producto prod: lista)
				{
				modelo.addElement(prod.getNombre());
				}
		
				list.setModel(modelo); //Parte de gestion, aqui debera ir la lista de objetos relacionados con la busqueda.
				
				
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

		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {""};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {

		         
		           DefaultListModel<String> model2 = new DefaultListModel();
		           
		           String nombreItem = (String) ((JList) e.getSource()).getSelectedValue();
		           
		           Producto prod = gestorProducto.getGestorProducto().getProducto(nombreItem);
		           
		           String descripcion = prod.getDesc();
		           float precio = prod.getPrecio();
		           
		         
		           model2.addElement("Producto: " + nombreItem);
		           model2.addElement("Precio: " + Float.toString(precio) + "€");
		           model2.addElement("Descripcion: " + descripcion);
		           list_1.setModel(model2);
		         }
		    }
		};
		list.addMouseListener(mouseListener);
		
		
		list.setBounds(10, 141, 604, 120);
		contentPane.add(list);
		
		
		list_1.setBounds(10, 254, 604, 120);
		contentPane.add(list_1);
		
		
	
	
	}
}
