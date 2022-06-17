/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author julia
 */
public class CestaBasicaModel {
    
    private ArrayList<ProdutoCesta> listaProdutosCesta = new ArrayList<>();;
    private ProdutoCesta produtoCesta;

    public CestaBasicaModel() {
    }

    public List<ProdutoCesta> getListaProdutosCesta() {
        return Collections.unmodifiableList(listaProdutosCesta);
    }

    public void addProdutoCesta(ProdutoModel produto, int quantidade) {
        //System.out.println("produto: " + produto.getNome() + " quantidade: "+ quantidade);
        listaProdutosCesta.add(new ProdutoCesta(produto.getNome(), quantidade));
    }
    
    public void addQuantidadeProdutoEspecifico(int idProduto, int quantidade) {
        listaProdutosCesta.get(idProduto).setQuantidadeProduto(quantidade);
    }
    
}
