/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.model;

import com.mycompany.trabalho_final.builder.TipoCesta;
import java.util.List;

/**
 *
 * @author julia
 */
public class CestaBasicaModel {
    
    private List<ProdutoModel> listaProdutosCesta;
    private TipoCesta tipo;

    public CestaBasicaModel(List<ProdutoModel> listaProdutosCesta, TipoCesta tipo) {
        this.listaProdutosCesta = listaProdutosCesta;
        this.tipo = tipo;
    }

    public List<ProdutoModel> getListaProdutosCesta() {
        return listaProdutosCesta;
    }

    public TipoCesta getTipo() {
        return tipo;
    }
    
    public String print() {
        int i = 1;
        for(ProdutoModel p : listaProdutosCesta) {
            System.out.println(i + ":" + p);
            i++;
        }
        return "oi";
    }
}
