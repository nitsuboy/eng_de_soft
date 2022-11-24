package entity;

import java.io.Serializable;
import java.util.HashMap;

public class Servico implements Serializable{
	
	private int id;
	private String nome;
	private String descricao;
	private float preco;
	private HashMap<Integer,String> feedback;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HashMap<Integer,String> getFeedback() {
		return feedback;
	}
	public void setFeedback(int avaliacao,String comentario) {
		this.feedback.put(null, comentario);
	}
	@Override
	public String toString() {
		return "Servico [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", feedback="
				+ feedback + "]";
	}
	public Servico(int id, String nome, String descricao, float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.feedback = new HashMap<Integer, String>();
	}

	

}
