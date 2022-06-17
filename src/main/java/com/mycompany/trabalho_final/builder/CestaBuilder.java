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
public abstract class CestaBuilder {

    protected CestaBasicaModel cesta;
    protected ProdutoDAO dao;
    protected List<ProdutoModel> produtos;

    public abstract void createCesta();

    public abstract void addProduto();

    public CestaBasicaModel getCesta() {
        return cesta;
    }
}
