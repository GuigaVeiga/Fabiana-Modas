package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

import codigo.PagamentoCliente;
import dao.FuncionarioDAO;

public class ArtigosDaLoja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArtigosDaLoja frame = new ArtigosDaLoja();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public ArtigosDaLoja() throws Exception {
		setTitle("Fernanda Modas ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1265, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		
		final PagamentoCliente p = new PagamentoCliente();
		
		FuncionarioDAO f = new FuncionarioDAO();
		f.consulta();
		
		final JPanel panelDeProdutos = new JPanel();
		panelDeProdutos.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		
		final JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDeProdutos, GroupLayout.PREFERRED_SIZE, 1025, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panelDeProdutos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel_1.setLayout(null);
		
		JLabel lblFuncionario = new JLabel("Funcionario em Atendimento: ");
		lblFuncionario.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblFuncionario.setForeground(Color.BLACK);
		lblFuncionario.setBounds(10, 11, 174, 30);
		panel_1.add(lblFuncionario);
		
		
		JLabel label = new JLabel();
		label.setForeground(Color.BLUE);
		label.setBounds(44, 40, 120, 19);
		panel_1.add(label);
		label.setText(f.getS());
		
		JLabel lblIconefunc = new JLabel("");
		lblIconefunc.setBounds(30, 74, 120, 104);
		panel_1.add(lblIconefunc);
		lblIconefunc.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/guard-icon.png")));
		panel.setLayout(null);
		
		JLabel lblFormasDePagamentos = new JLabel("Formas de Pagamento");
		lblFormasDePagamentos.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblFormasDePagamentos.setBounds(16, 11, 162, 30);
		panel.add(lblFormasDePagamentos);
		
		JRadioButton rdbtnAvista = new JRadioButton("Avista");
		rdbtnAvista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.avista();
			}
		});
		buttonGroup_1.add(rdbtnAvista);
		rdbtnAvista.setForeground(Color.BLUE);
		rdbtnAvista.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnAvista.setBounds(42, 211, 109, 23);
		panel.add(rdbtnAvista);
		
		
		
		
		
		final JButton btnComprarCliente = new JButton("<html><p align=\"center\">Comprar com<br>Cart\u00E3o Fidelidade</p></html>\r\r\n");
		btnComprarCliente.setToolTipText("Somente Pagamento Parcelado para clientes com cart\u00E3o fidelidade ");
		btnComprarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.cartaoFidelidade();
				JOptionPane.showMessageDialog(null, "OBRIGADO!! PAGAMENTO REALIZADO COM SUCESSO! " + " \nTotal: " + p.getTotal()
				+ " \nParcelado em: " + p.getQtdParcelas() + "x" + " \nValor total das Parcelas é de: " + p.getTotalParcela());
				
			}
		});
		btnComprarCliente.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnComprarCliente.setBounds(14, 333, 165, 41);
		panel.add(btnComprarCliente);
		
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setEnabled(false);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.parcelado(Integer.parseInt( comboBox.getSelectedItem().toString()));
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(135, 260, 43, 20);
		
		
		panel.add(comboBox);
		
		final JRadioButton rdbtnParcelado = new JRadioButton("Parcelado");
		rdbtnParcelado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
				comboBox.setSelectedItem("1");
				btnComprarCliente.setEnabled(true);
			}
		});
		buttonGroup_1.add(rdbtnParcelado);
		rdbtnParcelado.setForeground(Color.BLUE);
		rdbtnParcelado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		rdbtnParcelado.setBounds(42, 237, 93, 23);
		panel.add(rdbtnParcelado);
		
		JLabel lblParcelaEm = new JLabel("Parcela em:");
		lblParcelaEm.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblParcelaEm.setBounds(63, 262, 67, 14);
		panel.add(lblParcelaEm);
		
		JLabel lblEscolhaUmaDas = new JLabel("Escolha uma das op\u00E7\u00F5es:");
		lblEscolhaUmaDas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaUmaDas.setBounds(16, 186, 162, 14);
		panel.add(lblEscolhaUmaDas);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(21, 52, 152, 114);
		panel.add(label_1);
		label_1.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/pagamentos.png")));
		
		final JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnParcelado.isSelected()){
					
					JOptionPane.showMessageDialog(null, "OBRIGADO!! PAGAMENTO REALIZADO COM SUCESSO! " + " \nTotal: " + p.getTotal()
					+ " \nParcelado em: " + p.getQtdParcelas() + "x" + " \nValor total das Parcelas é de: " + p.getTotalParcela());
				}else{
				
				try {
				p.setDinheiroAvista(Double.parseDouble(JOptionPane.showInputDialog(null, "Total " + p.getValor() 
				+ "\nPagamento total em dinheiro: ")));
				if (p.getDinheiroAvista() >= p.getValor()){
				JOptionPane.showMessageDialog(null, "OBRIGADO!! PAGAMENTO REALIZADO COM SUCESSO! " + " \nTotal: " + p.getTotal() 
				+ "\nTroco: " + p.troco());
				} else { 
					JOptionPane.showMessageDialog(null, "Insira um valor igual ou maior que o total de " + p.getValor());
				}
			} 
				catch(Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro, formato inserido incorreto"
				+ "\nInsira apenas números!"
				+ "\nEx. 100 ou 100.10");
				}	
			}
			}
		});
		btnComprar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnComprar.setBounds(52, 296, 89, 30);
		panel.add(btnComprar);
		
		JButton btnVoltarAosProdutos = new JButton("Voltar aos produtos");
		btnVoltarAosProdutos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltarAosProdutos.setBounds(23, 385, 147, 30);
		panel.add(btnVoltarAosProdutos);
		
		for (Component cp : panel.getComponents()){
			cp.setEnabled(false);
		}
		
		panelDeProdutos.setLayout(null);
		
		JLabel lblVestidoTubinho = new JLabel("Vestido Tubinho - R$89,99");
		lblVestidoTubinho.setBounds(100, 25, 187, 16);
		panelDeProdutos.add(lblVestidoTubinho);
		lblVestidoTubinho.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblCamisaRegataR = new JLabel("Vestido de malha azul - R$59,90 ");
		lblCamisaRegataR.setBounds(418, 25, 249, 16);
		panelDeProdutos.add(lblCamisaRegataR);
		lblCamisaRegataR.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		final JCheckBox chckbxComprar = new JCheckBox("Comprar");
		chckbxComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(89.99);
			}
		});
		chckbxComprar.setBounds(100, 137, 97, 20);
		panelDeProdutos.add(chckbxComprar);
		
		final JCheckBox chckbxComprar_1 = new JCheckBox("Comprar");
		chckbxComprar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(59.90);
			}
		});
		chckbxComprar_1.setBounds(418, 134, 97, 23);
		panelDeProdutos.add(chckbxComprar_1);
		
		final JCheckBox chckbxComprar_2 = new JCheckBox("Comprar");
		chckbxComprar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(79.90);
			}
		});
		chckbxComprar_2.setBounds(769, 126, 97, 23);
		panelDeProdutos.add(chckbxComprar_2);
		
		final JCheckBox chckbxComprar_3 = new JCheckBox("Comprar");
		chckbxComprar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(69.90);
			}
		});
		chckbxComprar_3.setBounds(418, 335, 97, 16);
		panelDeProdutos.add(chckbxComprar_3);
		
		final JCheckBox chckbxComprar_4 = new JCheckBox("Comprar");
		chckbxComprar_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(99.90);
			}
		});
		chckbxComprar_4.setBounds(418, 559, 97, 23);
		panelDeProdutos.add(chckbxComprar_4);
		
		JLabel lblMacaquinhoDeAlcinhas = new JLabel("Macaquinho de Alcinhas - R$99,90");
		lblMacaquinhoDeAlcinhas.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMacaquinhoDeAlcinhas.setBounds(420, 443, 249, 15);
		panelDeProdutos.add(lblMacaquinhoDeAlcinhas);
		
		final JCheckBox chckbxComprar_5 = new JCheckBox("Comprar");
		chckbxComprar_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(129.00);
			}
		});
		chckbxComprar_5.setBounds(100, 559, 80, 23);
		panelDeProdutos.add(chckbxComprar_5);
		
		JLabel lblBlusaFeminina = new JLabel("Cal\u00E7a Jegging  - R$129,00");
		lblBlusaFeminina.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBlusaFeminina.setBounds(100, 443, 174, 20);
		panelDeProdutos.add(lblBlusaFeminina);
		
		JButton btnAddAoCarrinho = new JButton("Add ao carrinho?");
		btnAddAoCarrinho.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/CarrinhoDeVendas.png")));
		btnAddAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (Component cp : panel.getComponents()){
					cp.setEnabled(true);
					btnComprarCliente.setEnabled(false);
					
				}
				
				for (Component cp : panelDeProdutos.getComponents()){
					cp.setEnabled(false);
				}
						}
		});
		btnAddAoCarrinho.setForeground(new Color(0, 0, 128));
		btnAddAoCarrinho.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnAddAoCarrinho.setBounds(839, 589, 166, 26);
		panelDeProdutos.add(btnAddAoCarrinho);
		
		JLabel lblVestidotubinho = new JLabel("");
		lblVestidotubinho.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), Color.DARK_GRAY, null, null));
		lblVestidotubinho.setBackground(Color.LIGHT_GRAY);
		lblVestidotubinho.setFont(lblVestidotubinho.getFont().deriveFont(lblVestidotubinho.getFont().getStyle() | Font.BOLD));
		lblVestidotubinho.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/Vestido tubinho estampado.jpg")));
		lblVestidotubinho.setBounds(10, 30, 80, 113);
		panelDeProdutos.add(lblVestidotubinho);
		
		JLabel lblVestidotubinho_1 = new JLabel("<html><p align=\"Justify\">Vestido tubinho de viscose sensacional, com decote redondo, mangas 7/8 e estampa corrida supermoderna!</p></html> ");
		lblVestidotubinho_1.setBounds(100, 57, 218, 59);
		panelDeProdutos.add(lblVestidotubinho_1);
		
		JLabel lblVestidodemalhapedrarias = new JLabel("<html><p align=\"Justify\">Moderno vestido de malha em decote V. Na parte frontal, o vestido \u00E9 decorado com aplica\u00E7\u00E3o de pequenas pedrarias no busto, em look envelope.</p></html> ");
		lblVestidodemalhapedrarias.setBounds(418, 57, 249, 59);
		panelDeProdutos.add(lblVestidodemalhapedrarias);
		
		JLabel lblVestidomalhapedrarias = new JLabel("VestidoMalhaPedrarias");
		lblVestidomalhapedrarias.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		lblVestidomalhapedrarias.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/Vestido de malha com pedrarias.jpg")));
		lblVestidomalhapedrarias.setBounds(328, 30, 80, 113);
		panelDeProdutos.add(lblVestidomalhapedrarias);
		
		JLabel lblVestidodeTrico = new JLabel("");
		lblVestidodeTrico.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		lblVestidodeTrico.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/Vestido de trico gola role.jpg")));
		lblVestidodeTrico.setBounds(677, 30, 80, 113);
		panelDeProdutos.add(lblVestidodeTrico);
		
		JLabel lblVestidoDeTric = new JLabel("Vestido de tric\u00F4 gola rol\u00EA - R$79,90");
		lblVestidoDeTric.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblVestidoDeTric.setBounds(769, 25, 238, 26);
		panelDeProdutos.add(lblVestidoDeTric);
		
		JLabel lblVestidotrico = new JLabel("<html><p align=\"Justify\">Vestido b\u00E1sico com gola rol\u00EA canelada, manga longa e punhos canelados. Vestido ideal para combinar com botas e leggings.</p></html>");
		lblVestidotrico.setBounds(769, 57, 216, 62);
		panelDeProdutos.add(lblVestidotrico);
		
		JLabel lblCamisaxadrez = new JLabel("");
		lblCamisaxadrez.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		lblCamisaxadrez.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/Camisa estampa xadrez.jpg")));
		lblCamisaxadrez.setBounds(328, 214, 80, 113);
		panelDeProdutos.add(lblCamisaxadrez);
		
		JLabel lblCamisa = new JLabel("Camisa estampa xadrez - R$69,90");
		lblCamisa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCamisa.setBounds(418, 203, 251, 33);
		panelDeProdutos.add(lblCamisa);
		
		JLabel lblCamisaxadrez_1 = new JLabel("<html><p align=\"Justify\">Camisa xadrez madras, a tend\u00EAncia do momento\r\ne que pode ser combinada com in\u00FAmeras pe\u00E7as e estilos.\r\nCom dois bolsos aplicados no busto, fechamento com bot\u00F5es \r\nde press\u00E3o, punhos regul\u00E1vel por bot\u00F5es de press\u00E3o. </p></html>");
		lblCamisaxadrez_1.setBounds(418, 233, 249, 95);
		panelDeProdutos.add(lblCamisaxadrez_1);
		
		JLabel lblCalajegging = new JLabel("");
		lblCalajegging.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		lblCalajegging.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/cal\u00E7a jegging.jpg")));
		lblCalajegging.setBounds(10, 448, 80, 113);
		panelDeProdutos.add(lblCalajegging);
		
		JLabel lblCalcajegging = new JLabel("<html><p align=\"Justify\">A cal\u00E7a legging em estilo jeans combina com v\u00E1rios estilos e ajudam a compor in\u00FAmeros looks. Com modelagem marcada, este modelo \u00E9 muito confort\u00E1vel.</p></html>");
		lblCalcajegging.setBounds(100, 461, 216, 78);
		panelDeProdutos.add(lblCalcajegging);
		
		JLabel lblMacaquinhoalcinhas = new JLabel("");
		lblMacaquinhoalcinhas.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		lblMacaquinhoalcinhas.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/macaquinho de alcinhas.jpg")));
		lblMacaquinhoalcinhas.setBounds(328, 448, 80, 113);
		panelDeProdutos.add(lblMacaquinhoalcinhas);
		
		JLabel lblMacaquinhodealcinhas = new JLabel("<html><p align=\"Justify\">Esta \u00E9 a roupa perfeita para enfrentar o calor absurdo que o ver\u00E3o traz, por ser confort\u00E1vel, macia e curtinha. Macaquinho listrado curto de alcinhas. Com tiras do mesmo tecido, el\u00E1stico na cintura, para garantir um caimento perfeito.</p></html>");
		lblMacaquinhodealcinhas.setBounds(420, 461, 249, 95);
		panelDeProdutos.add(lblMacaquinhodealcinhas);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(761, 32, 20, -10);
		panelDeProdutos.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		label_3.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/short jeans.jpg")));
		label_3.setBounds(679, 448, 85, 113);
		panelDeProdutos.add(label_3);
		
		JLabel lblShortJens = new JLabel("Short Jeans com stretch - R$49,90");
		lblShortJens.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblShortJens.setBounds(769, 440, 236, 20);
		panelDeProdutos.add(lblShortJens);
		
		JLabel lblShortjeans = new JLabel("<html><p text align=\"Justify\">Short jeans com stretch e look vintage, um pouco desbotado. A bainha dobrada \u00E9 um charme. De modelo justo, em estilo 5 pocket, com z\u00EDper e passadores para cinto.</p></html>");
		lblShortjeans.setBounds(769, 461, 216, 87);
		panelDeProdutos.add(lblShortjeans);
		
		JLabel label_4 = new JLabel("");
		label_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		label_4.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/Camisa estampa floral.jpg")));
		label_4.setBounds(10, 219, 80, 113);
		panelDeProdutos.add(label_4);
		
		JLabel lblCamisaDeEstampa = new JLabel("Camisa estampa floral R$57,90");
		lblCamisaDeEstampa.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCamisaDeEstampa.setBounds(100, 214, 218, 16);
		panelDeProdutos.add(lblCamisaDeEstampa);
		
		JLabel lblBlusaSemMangas = new JLabel("<html><p align=\"Justify\">Blusa sem mangas, com estampa floral de ver\u00E3o. Mais comprida atr\u00E1s, comprimento de aprox. 70cm no tam.</p></html>");
		lblBlusaSemMangas.setBounds(100, 233, 218, 72);
		panelDeProdutos.add(lblBlusaSemMangas);
		
		JLabel label_5 = new JLabel("");
		label_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, null, null));
		label_5.setIcon(new ImageIcon(ArtigosDaLoja.class.getResource("/img/Camisa vermelho rosado.jpg")));
		label_5.setBounds(677, 214, 80, 113);
		panelDeProdutos.add(label_5);
		
		JLabel lblCamisaVermelhoRosado = new JLabel("Camisa Vermelho Rosado - R$78,99");
		lblCamisaVermelhoRosado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCamisaVermelhoRosado.setBounds(769, 214, 246, 16);
		panelDeProdutos.add(lblCamisaVermelhoRosado);
		
		JLabel lblBlusaDeMalha = new JLabel("<html><p align=\"Justify\">Blusa de malha descontra\u00EDda, com gola e barra de bot\u00F5es, frente com bolso aplicado no busto, em tecido stretch macio.</p></html> ");
		lblBlusaDeMalha.setBounds(769, 233, 216, 72);
		panelDeProdutos.add(lblBlusaDeMalha);
		
		final JCheckBox chckbxComprar_6 = new JCheckBox("Comprar");
		chckbxComprar_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(57.90);
			}
		});
		chckbxComprar_6.setBounds(100, 332, 97, 23);
		panelDeProdutos.add(chckbxComprar_6);
		
		final JCheckBox chckbxComprar_7 = new JCheckBox("Comprar");
		chckbxComprar_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(78.99);
			}
		});
		chckbxComprar_7.setBounds(769, 332, 97, 23);
		panelDeProdutos.add(chckbxComprar_7);
		
		final JCheckBox chckbxComprar_8 = new JCheckBox("Comprar");
		chckbxComprar_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.somar(49.90);
			}
		});
		chckbxComprar_8.setBounds(769, 559, 97, 23);
		panelDeProdutos.add(chckbxComprar_8);
		
		btnVoltarAosProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxComprar.setSelected(false);
				chckbxComprar_1.setSelected(false);
				chckbxComprar_2.setSelected(false);
				chckbxComprar_3.setSelected(false);
				chckbxComprar_4.setSelected(false);
				chckbxComprar_5.setSelected(false);
				chckbxComprar_6.setSelected(false);
				chckbxComprar_7.setSelected(false);
				chckbxComprar_8.setSelected(false);
				
				buttonGroup_1.clearSelection();
				comboBox.setSelectedIndex(0);
				p.setValor(0);
				p.setQtdParcelas(0);
				p.setTotalParcela(0);
				p.setTotal(0);
				
				for (Component cp : panelDeProdutos.getComponents()){
					cp.setEnabled(true);
				}
				
				for (Component cp : panel.getComponents()){
					cp.setEnabled(false);
				}
			}
		});
		contentPane.setLayout(gl_contentPane);

	}
}
