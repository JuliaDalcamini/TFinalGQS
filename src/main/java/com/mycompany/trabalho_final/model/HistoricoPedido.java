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
public final class HistoricoPedido {
    
    private final ArrayList<PedidoModel> listaPedidos = new ArrayList<>();

    public HistoricoPedido(PedidoModel pedido) {
        this.addListaPedidos(pedido);
    }

    public void addListaPedidos(PedidoModel pedido) {
        listaPedidos.add(pedido);
    }
    
    public ArrayList<PedidoModel> getListaPedidos() {
        return listaPedidos;
    }
}
