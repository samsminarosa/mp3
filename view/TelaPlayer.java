package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaPlayer extends JFrame {

	private JPanel contentPane;
	
	private JMenuBar menuBar;
	private JMenu mnFile;
	
	private JButton btnAddPlaylist;
	private JButton bPause;
	private JButton bPlay;
	private JButton bAvancar;
	private Player ply;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPlayer frame = new TelaPlayer();
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
	public TelaPlayer() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPlayer.class.getResource("/imagen/imagem1.png")));
		setTitle("Media Player");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 700);
		
		//copiei
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnFile.add(mntmCadastrar);
		
		JMenu mnView = new JMenu("Edit");
		menuBar.add(mnView);
		
		JMenu mnHelp = new JMenu("View");
		menuBar.add(mnHelp);
		
		JMenu mnHelp_1 = new JMenu("Help");
		menuBar.add(mnHelp_1);
		
		JEditorPane editorPane = new JEditorPane();
		menuBar.add(editorPane);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMusica = new JLabel("MUSICA :");
		lblMusica.setBounds(248, 97, 188, 35);
		contentPane.add(lblMusica);
		
		JButton bRecuar = new JButton("<<");
		bRecuar.setBounds(34, 540, 49, 34);
		contentPane.add(bRecuar);
		
		JButton bAvancar = new JButton(">>");
		bAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		bAvancar.setBounds(167, 540, 55, 34);
		contentPane.add(bAvancar);
		
		Musica mp3 = new Musica();
		
		// esse metodo para botao play
		JButton bPlay = new JButton("play");
		bPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mp3.start();
				bPlay.setEnabled(false); // para clicar play 1 vez
				bPause.setEnabled(true); // comecar desabilitado 
				bAvancar.setVisible(true); 
				mp3.resume();
			}
		});
		bPlay.setBounds(93, 517, 64, 37);
		contentPane.add(bPlay);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(255, 540, 430, 14);
		contentPane.add(progressBar);
		
		JButton btnAddFile = new JButton("Add FIle");
		btnAddFile.setBounds(30, 137, 107, 35);
		contentPane.add(btnAddFile);
		
		JButton btnAddDiretory = new JButton("Add Diretory");
		btnAddDiretory.setBounds(30, 194, 107, 35);
		contentPane.add(btnAddDiretory);
		
		JLabel lblfoto = new JLabel("");
		lblfoto.setIcon(new ImageIcon(TelaPlayer.class.getResource("/imagen/imagfoto.png")));
		lblfoto.setBounds(779, 97, 150, 150);
		contentPane.add(lblfoto);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(760, 52, 130, 23);
		contentPane.add(lblUsuario);
		
		JList listmusica = new JList();
		listmusica.setBounds(258, 146, 182, 266);
		contentPane.add(listmusica);
		
		JList listPlayListAtual = new JList();
		listPlayListAtual.setBounds(480, 146, 182, 266);
		contentPane.add(listPlayListAtual);
		
		JLabel lblPlayList = new JLabel("Play List : ");
		lblPlayList.setBounds(483, 107, 179, 14);
		contentPane.add(lblPlayList);
		
		JLabel lblPlayList_1 = new JLabel("Play List:");
		lblPlayList_1.setBounds(760, 322, 46, 14);
		contentPane.add(lblPlayList_1);
		
		JList listPlayList = new JList();
		listPlayList.setBounds(779, 341, 169, 168);
		contentPane.add(listPlayList);
		
		JButton btnAddPlaylist = new JButton("+");
		btnAddPlaylist.setBounds(891, 551, 46, 23);
		contentPane.add(btnAddPlaylist);
		
		JLabel lblAddPlaylist = new JLabel("Add PlayList");
		lblAddPlaylist.setBounds(779, 551, 88, 23);
		contentPane.add(lblAddPlaylist);
		
		// metodo para botao pause esta com funcionalidade de estop
		 bPause = new JButton(" | |");
		 bPause.setEnabled(false);
		bPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mp3.suspend();
				bPlay.setEnabled(true);
				bPause.setEnabled(false);

			}
		});
		bPause.setBounds(93, 565, 64, 35);
		contentPane.add(bPause);
	}
	
	//importar jlayer e reproduzir jlayer
	 class Musica extends Thread{
		 public void run() {
			
			 try {
				 InputStream input = this.getClass().getResourceAsStream("/musicas/Djodje - Txukinha .mp3");
				ply= new Player(input);
				ply.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	 }
}
