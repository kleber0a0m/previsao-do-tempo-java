/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Cidades {
    private List<CidadeBusca> cidade = new ArrayList<CidadeBusca>();

    public List<CidadeBusca> getCidade() {
        return cidade;
    }

    public void setCidade(List<CidadeBusca> cidade) {
        this.cidade = cidade;
    }
    
    
}
