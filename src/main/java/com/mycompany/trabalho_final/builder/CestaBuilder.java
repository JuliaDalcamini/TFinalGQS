/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.builder;

import com.mycompany.trabalho_final.model.CestaBasicaModel;
import com.mycompany.trabalho_final.model.ProdutoDAO;
import com.mycompany.trabalho_final.model.ProdutoModel;
import java.util.List;

/**
 *
 * @author julia
 */
public class CestaBuilder implements Builder{
    
    protected TipoCesta tipo;
    protected CestaBasicaModel cesta;
    protected ProdutoDAO dao;
    protected List<ProdutoModel> produtos;
    

    @Override
    public void setTipoCesta(TipoCesta tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setProdutos(List produtos) {
        this.produtos = produtos;
    }
    
    public CestaBasicaModel getCesta() {
        return new CestaBasicaModel(produtos, tipo);
    }
}
