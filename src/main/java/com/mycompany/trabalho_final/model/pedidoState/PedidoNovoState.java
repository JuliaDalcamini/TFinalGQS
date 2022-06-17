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
public class PedidoNovoState extends PedidoState {

    public PedidoNovoState(PedidoModel pedido) {
        super(pedido);
    }
    
    @Override
    public String toString() {
        return "Novo";
    }

    @Override
    public void cancelaPedido() {
        PedidoState state = new PedidoCanceladoClienteState(pedido);
        state.cancelaPedido();
    }

    @Override
    public void atualizaPedido() {
        pedido.setValorTotalPedido();
        pedido.toString();
    }

    @Override
    public void avancaEtapa() {
        if (pedido.isNovo())
            pedido.changeState(new PedidoAguardandoPagamentoState(pedido));
    }
}
