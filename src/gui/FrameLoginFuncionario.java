package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import dao.FuncionarioDAO;

public class FrameLoginFuncionario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField ptxtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLoginFuncionario frame = new FrameLoginFuncionario();
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
public void validarLogin() throws Exception{
	
		FuncionarioDAO c = new FuncionarioDAO();
		
		String sql = "SELECT * from funcionario where usuario = ? and senha = ?";
    	
    			try { PreparedStatement stm = c.getConnection().prepareStatement(sql);
    					stm.setString(1, txtLogin.getText());
    					stm.setString(2, ptxtSenha.getText());
    					
    					ResultSet rs = stm.executeQuery();
    					
    				if(rs.next()){
    					
    					FuncionarioCadastro funcionario = new FuncionarioCadastro();
    					funcionario.setVisible(true);
    					FrameLoginFuncionario.this.dispose();
    					stm.close();
    				  }else{
    					  JOptionPane.showMessageDialog(null, "Acesso Negado");
    				    }
    				
    				}catch (SQLException u) {
    		        	System.out.println(u.getMessage());
    		        	
    		        } 
				} 

	public FrameLoginFuncionario() {
		setTitle("Fernanda Modas ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 622);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(277, 132, 342, 258);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		ptxtSenha = new JPasswordField();
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					validarLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				}
		});
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblRealizeOLogin = new JLabel("Funcion\u00E1rio, realize o login para ter acesso! ");
		lblRealizeOLogin.setForeground(new Color(0, 0, 0));
		lblRealizeOLogin.setFont(lblRealizeOLogin.getFont().deriveFont(lblRealizeOLogin.getFont().getStyle() | Font.BOLD, lblRealizeOLogin.getFont().getSize() + 3f));
		
		JLabel lblFernadaModas = new JLabel("FERNANDA MODAS");
		lblFernadaModas.setBackground(Color.DARK_GRAY);
		lblFernadaModas.setForeground(Color.RED);
		lblFernadaModas.setFont(new Font("Vijaya", Font.BOLD, 40));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblFernadaModas, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
								.addGap(12))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnCancelar)
										.addGap(19))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblSenha)
											.addGap(10)
											.addComponent(ptxtSenha, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))))
								.addGap(62)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblRealizeOLogin)
							.addGap(12))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblFernadaModas, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblRealizeOLogin, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblLogin))
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblSenha))
						.addComponent(ptxtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEntrar)
						.addComponent(btnCancelar))
					.addGap(17))
		);
		panel.setLayout(gl_panel);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.RED);
		label.setFont(label.getFont().deriveFont(label.getFont().getStyle() | Font.BOLD, 31f));
		label.setIcon(new ImageIcon(FrameLoginFuncionario.class.getResource("/img/Imagem de fundo para login.jpg")));
		label.setBounds(0, 0, 960, 606);
		contentPane.add(label);
	}
}
