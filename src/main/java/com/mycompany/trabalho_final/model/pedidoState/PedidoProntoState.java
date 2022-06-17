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
public class PedidoProntoState extends PedidoState {

    public PedidoProntoState(PedidoModel pedido) {
        super(pedido);
    }
    
    @Override
    public String toString() {
        return "Pronto";
    }

    @Override
    public void cancelaPedido() {
        PedidoState state = new PedidoCanceladoLojaState(pedido);
        state.cancelaPedido();
    }

    @Override
    public void atualizaPedido() {
        throw new UnsupportedOperationException("Não há atualizações nesta etapa."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void avancaEtapa() {
        if (pedido.isPronto())
            pedido.changeState(new PedidoRotaEntregaState(pedido));
    }
    
}
