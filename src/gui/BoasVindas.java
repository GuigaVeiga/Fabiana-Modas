package gui;

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
import javax.swing.border.EmptyBorder;

public class BoasVindas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoasVindas frame = new BoasVindas();
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
	public BoasVindas() {
		setTitle("Fernanda Modas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameLogin login = new FrameLogin();
				login.setVisible(true);
				
				BoasVindas.this.dispose();
			}
		});
		btnCliente.setBounds(161, 100, 112, 23);
		contentPane.add(btnCliente);
		
		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameLoginFuncionario fun = new FrameLoginFuncionario();
				fun.setVisible(true);
				
				BoasVindas.this.dispose();
			}
		});
		btnFuncionario.setBounds(161, 142, 112, 23);
		contentPane.add(btnFuncionario);
		
		JLabel lblSejaBemVindo = new JLabel("SEJA BEM VINDO!");
		lblSejaBemVindo.setForeground(Color.RED);
		lblSejaBemVindo.setFont(new Font("Vijaya", lblSejaBemVindo.getFont().getStyle() | Font.BOLD, lblSejaBemVindo.getFont().getSize() + 18));
		lblSejaBemVindo.setBounds(110, 55, 214, 23);
		contentPane.add(lblSejaBemVindo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BoasVindas.class.getResource("/img/Imagem de fundo para login.jpg")));
		label.setBounds(0, 0, 434, 262);
		contentPane.add(label);
	}

}
