/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.builder;

import com.mycompany.trabalho_final.model.ProdutoDAO;
import com.mycompany.trabalho_final.model.ProdutoModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class CestaDirector {
    protected ProdutoDAO dao;

    public void constructCestaEconomica(CestaBuilder builder) {
        List<ProdutoModel> produtos = new ArrayList<>();
        produtos.addAll(dao.getProdutosBasicos());
        //produtos.addAll(dao.getProdutosVegetais());
        //produtos.addAll(dao.getProdutosProteinas());
        builder.setTipoCesta(TipoCesta.ECONOMICA);
        builder.setProdutos(produtos);
    }
    
    public void constructCestaPremium(Builder builder) {
        List<ProdutoModel> produtos = new ArrayList<>();
        produtos.addAll(dao.getProdutosBasicos());
        produtos.addAll(dao.getProdutosVegetais());
        produtos.addAll(dao.getProdutosProteinas());
        produtos.addAll(dao.getProdutosIndustrializadosA());
        builder.setTipoCesta(TipoCesta.PREMIUM);
        builder.setProdutos(produtos);
    }
}