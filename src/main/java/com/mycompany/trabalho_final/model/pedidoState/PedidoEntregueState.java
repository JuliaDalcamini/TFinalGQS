/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.model.pedidoState;

import com.mycompany.trabalho_final.model.PedidoModel;

/**
 *
 * @author julia
 */
public class PedidoEntregueState extends PedidoState {

    public PedidoEntregueState(PedidoModel pedido) {
        super(pedido);
    }
    
    @Override
    public String toString() {
        return "Pedido Entregue";
    }

    @Override
    public void cancelaPedido() {
        throw new UnsupportedOperationException("O pedido já foi entregue e não pode ser cancelado."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizaPedido() {
        throw new UnsupportedOperationException("Não há atualizações nesta etapa;"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void avancaEtapa() {
        throw new UnsupportedOperationException("Esta já é a ultima etapa."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
