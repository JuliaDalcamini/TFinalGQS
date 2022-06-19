/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.model;

import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class DescontoDAO {
    
    private ArrayList<DescontoModel> descontos;
    private static DescontoDAO instance;
    
    private DescontoDAO() {
        descontos = new ArrayList<>();
        descontos.add(new DescontoModel("Desconto de Natal", 0.15));
        descontos.add(new DescontoModel("Desconto de Pascoa", 0.1));
        descontos.add(new DescontoModel("Desconto de Domingo", 0.05));
    }
    
    public static DescontoDAO getInstance() {
        if (instance == null) {
            instance = new DescontoDAO();
        }
        return instance;
    }
    
    public DescontoModel getDesconto(int n) {
        DescontoModel desconto = null;
        for(DescontoModel d : descontos) {
            desconto = descontos.get(n);
        }
        return desconto;
    }
}
