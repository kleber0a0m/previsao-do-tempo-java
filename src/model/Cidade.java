package model;

import java.util.ArrayList;
import java.util.List;

public class Cidade {
	private String nome;
	private String uf;
	private String atualizacao;

    public Cidade(String nome, String uf, String atualizacao) {
        this.nome = nome;
        this.uf = uf;
        this.atualizacao = atualizacao;
    }
	
        
	private List<Previsao> previsoes = new ArrayList<Previsao>();

    public Cidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getAtualizacao() {
		return atualizacao;
	}
	public void setAtualizacao(String atualizacao) {
		this.atualizacao = atualizacao;
	}
	public Previsao getPrevisoes(int i) {
		return previsoes.get(i);
	}
	public void setPrevisoes(List<Previsao> previsoes) {
		this.previsoes = previsoes;
	}
}