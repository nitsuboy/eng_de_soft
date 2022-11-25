package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Servico implements Serializable{
	
	private int id;
	private String nome;
	private String descricao;
	private float preco;
	private List<Feedback> feedbacks;
	
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
	public List<Feedback> getFeedback() {
		return feedbacks;
	}
	public void addFeedback(String rate,String comentario,String id2) {
		this.feedbacks.add(new Feedback(comentario, rate, id2));
	}
	@Override
	public String toString() {
		return "Servico [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", feedback="
				+ feedbacks + "]";
	}
	public Servico(int id, String nome, String descricao, float preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.feedbacks = new ArrayList<Feedback>();
	}

	

}
