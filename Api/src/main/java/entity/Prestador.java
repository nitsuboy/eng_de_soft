package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Prestador implements Serializable{
	
	private int id;
	private String nome;
	private String senha;
	private String CPF;
	private String email;
	private List<String> servicos;
	
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
	
	public List<String> getServicos() {
		return servicos;
	}

	public void addServico(String Servico) {
		this.servicos.add(Servico);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", CPF=" + CPF + ", email=" + email + "]";
	}

	public Prestador(int id, String nome, String senha, String CPF, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.CPF = CPF;
		this.email = email;
		this.servicos = new ArrayList<String>();
	}
	
}
