package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.UsuarioVip;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;

public class TelaCadastro extends JFrame {
	private JTextField tnome;
	private JTextField tlogin;
	private JPasswordField tsenha;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField tsenhaLogin;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setTitle("Cadastro/ Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome  :");
		lblNome.setBounds(20, 61, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setBounds(20, 86, 36, 24);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setBounds(20, 121, 46, 24);
		contentPane.add(lblSenha);
		
		tnome = new JTextField();
		tnome.setBounds(77, 56, 134, 24);
		contentPane.add(tnome);
		tnome.setColumns(10);
		
		tlogin = new JTextField();
		tlogin.setColumns(10);
		tlogin.setBounds(77, 86, 134, 24);
		contentPane.add(tlogin);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnCadastrar) {
					
					UsuarioVip userVip = new UsuarioVip();
					
					//pegar o texto do cadastro e atribuir a set nome
					userVip.setNome(tnome.getText());
					userVip.setLogin(tlogin.getText());
					userVip.setSenha(tsenha.getText());
					
					JOptionPane.showMessageDialog(null, userVip.salvar());
					
					//para que apos do cadastro ficar limpo
						
						tnome.setText("");
						tlogin.setText("");
						tsenha.setText("");
						
				}
				
				
			}
		});
		btnCadastrar.setBounds(65, 202, 96, 32);
		contentPane.add(btnCadastrar);
		
		tsenha = new JPasswordField();
		tsenha.setEchoChar('*');
		tsenha.setBounds(77, 122, 134, 22);
		contentPane.add(tsenha);
		
		JLabel lblInserirImagen = new JLabel("Inserir Imagen");
		lblInserirImagen.setBounds(20, 177, 96, 14);
		contentPane.add(lblInserirImagen);
		
		JLabel lblCadastrar = new JLabel("CADASTRAR ");
		lblCadastrar.setBounds(84, 11, 77, 26);
		contentPane.add(lblCadastrar);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(275, 14, 86, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblLogin_1 = new JLabel("Login :");
		lblLogin_1.setBounds(229, 61, 46, 14);
		contentPane.add(lblLogin_1);
		
		textField = new JTextField();
		textField.setBounds(285, 52, 126, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha_1 = new JLabel("Senha :");
		lblSenha_1.setBounds(229, 110, 46, 14);
		contentPane.add(lblSenha_1);
		
		tsenhaLogin = new JPasswordField();
		tsenhaLogin.setBounds(285, 107, 126, 24);
		contentPane.add(tsenhaLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(302, 202, 89, 32);
		contentPane.add(btnLogin);
	}
}
