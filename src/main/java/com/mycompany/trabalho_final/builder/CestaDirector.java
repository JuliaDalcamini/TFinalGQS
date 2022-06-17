/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.builder;

import com.mycompany.trabalho_final.model.CestaBasicaModel;

/**
 *
 * @author julia
 */
public class CestaDirector {
    
    CestaBuilder builder;

    public CestaDirector(CestaBuilder builder) {
        this.builder = builder;
    }

    public CestaBasicaModel buildCesta() {
        builder.createCesta();
        builder.addProduto();
        return builder.getCesta();
    }
}