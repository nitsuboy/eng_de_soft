package entity;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private int id;
	private String nome;
	private String senha;
	private String CPF;
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", CPF=" + CPF + ", email=" + email + "]";
	}

	public Usuario(int id, String nome, String senha, String CPF, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.CPF = CPF;
		this.email = email;
	}
	
}
