package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioVip {

	private String nome;
	private String login;
	private String senha;
//	private int id;
	
	
	/*public UsuarioVip(String nome, String login, String senha) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		//this.id = id;
	}*/


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	/*public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	*/
	//para salvar
		
			
	public String salvar() {
		try {
			//esse true é para que ele nao subscrever o que ja esta no arquivo 
			FileWriter fw = new FileWriter("/C:/Users/adida/eclipse-workspace/MediaPlayer2/src/arquivos/Usuario.txt", true);
			
			//escreve conteudo no arquivo e pula linhas
			PrintWriter pw = new PrintWriter(fw);
			pw.println("Usuario : "+this.nome+" login : "+this.login+"  senha : "+this.senha);
			//pw.println("login : "+this.login);
			//pw.println("senha : "+this.senha);
			//enviar os dados no mesmo momento
			pw.flush();
			pw.close();
			pw.close();
			
		} catch (IOException ex) {
			Logger.getLogger(UsuarioVip.class.getName()).log(Level.SEVERE, null, ex);
			
		
		}
		
		return "Usuario Cadastrado com Sucesso! ";
	}
}
