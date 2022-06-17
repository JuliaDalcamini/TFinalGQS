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
public class PedidoCanceladoLojaState extends PedidoState {

    public PedidoCanceladoLojaState(PedidoModel pedido) {
        super(pedido);
    }

    @Override
    public String toString() {
        return "Pedido cancelado pela loja";
    }
    
    @Override
    public void cancelaPedido() {
        throw new UnsupportedOperationException("Pedido cancelado."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizaPedido() {
        throw new UnsupportedOperationException("Pedido cancelado."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void avancaEtapa() {
        throw new UnsupportedOperationException("Não há etapas apó o cancelamento do pedido."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
