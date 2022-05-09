package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capadatos.Producto;

public class DetallesJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Producto prod) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					DetallesJFrame frame = new DetallesJFrame(prod);
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
	public DetallesJFrame(Producto producto) {
		setTitle("Kapritxitos");
		 ImageIcon imagen = new ImageIcon("IMG/LOGO.png");
	        this.setIconImage(imagen.getImage());
	        
		
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Informacion sobre el producto");
		lblNewLabel.setBounds(25, 11, 430, 43);
		getContentPane().add(lblNewLabel);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Producto: ");
		lblNewLabel_2.setBounds(25, 65, 103, 15);
		getContentPane().add(lblNewLabel_2);
		

		JLabel lblNewLabel_1 = new JLabel(producto.getNombre());
		lblNewLabel_1.setBounds(25, 93, 474, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Precio: ");
		lblNewLabel_2_1.setBounds(25, 132, 103, 15);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel(Float.toString(producto.getPrecio()));
		lblNewLabel_3.setBounds(25, 159, 70, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblTienda = new JLabel("Tienda:");
		lblTienda.setBounds(25, 201, 119, 15);
		getContentPane().add(lblTienda);
		
		JLabel lblA = new JLabel(producto.getNombreTienda());
		lblA.setBounds(25, 227, 346, 15);
		getContentPane().add(lblA);
		
		
		JButton btnNewButton_1 = new JButton("Nueva Busqueda");
		btnNewButton_1.setBounds(25, 357, 170, 23);
		getContentPane().add(btnNewButton_1);
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Busqueda busqueda = new Busqueda();
				busqueda.main(null);
				dispose();
			
			}
			});
		
		
		JButton btnNewButton_2 = new JButton("Mapa");
		btnNewButton_2.setBounds(502, 357, 89, 23);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				URI theURI = null;
				try {
					
					
					theURI = new URI("https://www.google.com/maps/search/?api=1&query="+producto.getNombreTienda().replaceAll("\\s","+"));
				} catch (URISyntaxException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					java.awt.Desktop.getDesktop().browse(theURI);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	}


