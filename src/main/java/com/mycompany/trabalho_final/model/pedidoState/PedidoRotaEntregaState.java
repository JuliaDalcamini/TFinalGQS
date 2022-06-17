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
public class PedidoRotaEntregaState extends PedidoState {

    public PedidoRotaEntregaState(PedidoModel pedido) {
        super(pedido);
    }
    
    @Override
    public String toString() {
        return "Em rota de entrega";
    }

    @Override
    public void cancelaPedido() {
        throw new UnsupportedOperationException("O pedido não pode ser cancelado nessa etapa"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizaPedido() {
        throw new UnsupportedOperationException("Não há atualizações nesta etapa."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void avancaEtapa() {
        if (pedido.isRotaEntrega())
            pedido.changeState(new PedidoEntregueState(pedido));
    }
    
}
