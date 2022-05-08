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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Busqueda extends JFrame {

	public JPanel contentPane;
	private JTextField textField;
	Producto productoFinal = null;
	public static Busqueda panelGuardado = new Busqueda();
	
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
		
		 ImageIcon imagen = new ImageIcon("IMG/LOGO.png");
	        this.setIconImage(imagen.getImage());
	        
	        setTitle("Kapritxitos");
		setResizable(false);
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
		list_1.setBounds(10, 298, 604, 82);
		contentPane.add(list_1);
		
		//Boton continuar
		JButton btnNewButton_1 = new JButton("Localizar");
	
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(20, 391, 495, 14);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(productoFinal == null)
				{
				lblNewLabel_1.setText("Por favor seleccione un producto");
				
				}
				else
				{
				DetallesJFrame.main(null, productoFinal);
				dispose();
				}
			}
		});
		btnNewButton_1.setBounds(525, 387, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setVisible(false);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 124, 505, 14);
		contentPane.add(lblNewLabel_2);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
				{
					lblNewLabel_2.setText("Introduzca termino de busqueda");
				}
				else
				{
					DefaultListModel<String> modelo = new DefaultListModel();
					
					ArrayList<Producto> lista = gestorProducto.getGestorProducto().getLista(textField.getText());
					
					for(Producto prod: lista)
					{
					modelo.addElement(prod.getNombre());
					}
			
					list.setModel(modelo); //Parte de gestion, aqui debera ir la lista de objetos relacionados con la busqueda.
					
					
				
				}
				}
				
		});
		
		btnNewButton.setBounds(525, 120, 89, 23);
		contentPane.add(btnNewButton);

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

		         System.out.println(e);
		           DefaultListModel<String> model2 = new DefaultListModel();
		           
		           String nombreItem = (String) ((JList) e.getSource()).getSelectedValue();
		           
		           Producto prod = gestorProducto.getGestorProducto().getProducto(nombreItem);
		           
		           String descripcion = prod.getTipo();
		           float precio = prod.getPrecio();
		           
		         
		           model2.addElement("Producto: " + nombreItem);
		           model2.addElement("Precio: " + Float.toString(precio) + " €");
		           model2.addElement("Tipo: " + descripcion);
		           list_1.setModel(model2);
		           
		           productoFinal = prod;
		       	btnNewButton_1.setVisible(true);
		         }
		    }
		};
		
		
		

		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		scrollPane.setBounds(10, 149, 604, 138);
		contentPane.add(scrollPane);
	
		list.addMouseListener(mouseListener);
	

		
		
	
	
	}
}
