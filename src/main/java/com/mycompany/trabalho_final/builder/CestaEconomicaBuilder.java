/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.builder;

import com.mycompany.trabalho_final.model.CestaBasicaModel;
import com.mycompany.trabalho_final.model.ProdutoDAO;
import com.mycompany.trabalho_final.model.ProdutoModel;
import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class CestaEconomicaBuilder extends CestaBuilder {
    
    @Override
    public void createCesta() {
        cesta = new CestaBasicaModel();
    }

    @Override
    public void addProduto() {
        dao = ProdutoDAO.getInstance();
        produtos = new ArrayList<>();
        produtos.addAll(dao.getProdutosBasicos());
        produtos.addAll(dao.getProdutosIndustrializadosA());
        produtos.addAll(dao.getProdutosProteinas());
        produtos.addAll(dao.getProdutosVegetais());
        for (ProdutoModel produto : produtos) {
            cesta.addProdutoCesta(produto, 1);
        }
    }
    
}
