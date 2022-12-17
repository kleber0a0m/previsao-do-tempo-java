/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author User
 */
@XStreamAlias("cidade")
public class CidadeBusca {
  private String nome;
  private String uf;
  private int id;
  // Getters e setters aqui

    public CidadeBusca(String nome, String uf, int id) {
        this.nome = nome;
        this.uf = uf;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
}
