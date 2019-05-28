package gui;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import codigo.Cliente;
import dao.ClienteDAO;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtfNome;
	private JTextField jtfRg;
	private JTextField jtfEndereco;
	private JTextField jtfContato;
	private JLabel lblCadastro;
	private JPasswordField passwordSenha;
	private JTextField txtEmail;
	private JTextField txtUsuario;
	private ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("Fernanda Modas ");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 622);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("");
		label.setBounds(41, 516, 0, 0);

		final JRadioButton rdbtnMasculino = new JRadioButton("M");
		rdbtnMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMasculino.setActionCommand("M");
			}
		});
		buttonGroup.add(rdbtnMasculino);
		
		final JRadioButton rdbtnFeminino = new JRadioButton("F");
		rdbtnFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFeminino.setActionCommand("F");	
			}
		});
		buttonGroup.add(rdbtnFeminino);
		
		

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSair.setBounds(449, 527, 112, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(148, 24, 601, 492);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), Color.DARK_GRAY, null, null));
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblRg = new JLabel("RG:");
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		
		JLabel lblContato = new JLabel("Contato:");
		
		
		jtfNome = new JTextField();
		jtfNome.setColumns(10);
		
		jtfRg = new JTextField();
		jtfRg.setColumns(10);
		
		jtfEndereco = new JTextField();
		jtfEndereco.setColumns(10);
		
		jtfContato = new JTextField();
		jtfContato.setColumns(10);
		
		lblCadastro = new JLabel("CADASTRO");
		lblCadastro.setFont(new Font("Verdana", Font.BOLD, 23));
		
		JLabel lblSenha = new JLabel("Senha:");
		
		passwordSenha = new JPasswordField();
		
		JLabel lblIdade = new JLabel("Idade:");
		
		JLabel lblEmail = new JLabel("Email:");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblInformeSeuUsuario = new JLabel("Informe seu usuario e senha para login:");
		lblInformeSeuUsuario.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblUtilizeSomenteLetras = new JLabel("Utilize somente letras minisculas (letras e n\u00FAmeros).");
		
		JLabel lblTodosOsCampos = new JLabel("Todos os campos s\u00E3o obrigatorios.");
		lblTodosOsCampos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {" -", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome)
								.addComponent(lblRg)
								.addComponent(lblIdade)
								.addComponent(lblContato)
								.addComponent(lblEndereo)
								.addComponent(lblEmail))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jtfNome, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
								.addComponent(jtfRg, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
									.addGap(64)
									.addComponent(rdbtnMasculino)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnFeminino))
								.addComponent(jtfContato, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
								.addComponent(jtfEndereco, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
								.addComponent(txtEmail))
							.addContainerGap(70, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblSenha)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblUsuario)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblUtilizeSomenteLetras)))
							.addGap(354))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblInformeSeuUsuario)
							.addContainerGap(369, Short.MAX_VALUE))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(229)
					.addComponent(lblCadastro)
					.addContainerGap(428, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(208)
					.addComponent(lblTodosOsCampos)
					.addContainerGap(404, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblCadastro)
					.addGap(18)
					.addComponent(lblTodosOsCampos)
					.addGap(21)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(jtfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(jtfRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnMasculino)
								.addComponent(rdbtnFeminino)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblRg)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblIdade)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContato)
						.addComponent(jtfContato, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(jtfEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(lblInformeSeuUsuario)
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUtilizeSomenteLetras))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(78))
		);
		gl_panel.linkSize(SwingConstants.VERTICAL, new Component[] {lblNome, lblRg, lblEndereo, lblContato, jtfNome, jtfRg, jtfEndereco, jtfContato, lblSenha});
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {jtfNome, jtfEndereco});
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {lblNome, lblRg, lblContato, lblSenha, lblIdade, lblUsuario});
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {passwordSenha, txtUsuario});
		

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCadastrar.setBounds(207, 527, 112, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente c = new Cliente();
				
				c.setNome(jtfNome.getText());
				c.setRg(jtfRg.getText());
				String opcao = buttonGroup.getSelection().getActionCommand();
				
				if("M".equals(opcao)){
					c.setSexo("M");
				} else if ("F".equals(opcao)){
					c.setSexo("F");
				} else {
					JOptionPane.showMessageDialog(null, "Tipo de Sexo não selecionado!");
				};
	
				c.setIdade(Integer.parseInt(comboBox.getSelectedItem().toString()));
				c.setContato(jtfContato.getText());
				c.setEndereco(jtfEndereco.getText());
				c.setEmail(txtEmail.getText());
				c.setUsuario(txtUsuario.getText());
				c.setSenha(passwordSenha.getText());
				
				
				ClienteDAO cliente = new ClienteDAO();
			
				cliente.adiciona(c);
				
				
				jtfNome.setText("");
				jtfRg.setText("");
				comboBox.setSelectedIndex(0);
				buttonGroup.clearSelection();
				jtfEndereco.setText("");
				jtfContato.setText("");
				txtEmail.setText("");
				txtUsuario.setText("");
				passwordSenha.setText("");
				
				
				
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnLimpar.setBounds(329, 527, 112, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				jtfNome.setText("");
				comboBox.setSelectedIndex(0);
				jtfRg.setText("");
				buttonGroup.clearSelection();
				jtfEndereco.setText("");
				jtfContato.setText("");
				txtEmail.setText("");
				txtUsuario.setText("");
				passwordSenha.setText("");	
			}
		});
		
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(panel);
		contentPane.add(btnCadastrar);
		contentPane.add(btnLimpar);
		contentPane.add(btnSair);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameLogin login = new FrameLogin();
				login.setVisible(true);
				
				Cadastro.this.dispose();
				
			}
		});
		
		btnVoltar.setBounds(575, 527, 112, 23);
		contentPane.add(btnVoltar);
		
		JLabel labelTelaDeFundo = new JLabel("");
		labelTelaDeFundo.setIcon(new ImageIcon(Cadastro.class.getResource("/img/Imagem de fundo para login.jpg")));
		labelTelaDeFundo.setBounds(0, 0, 897, 584);
		contentPane.add(labelTelaDeFundo);
	}
}
