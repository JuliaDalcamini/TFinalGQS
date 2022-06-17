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
public class PedidoConfirmadoState extends PedidoState {

    public PedidoConfirmadoState(PedidoModel pedido) {
        super(pedido);
    }
    
    @Override
    public String toString() {
        return "Confirmado";
    }
    
    @Override
    public void cancelaPedido() {
        PedidoState state = new PedidoCanceladoLojaState(pedido);
        state.cancelaPedido();
    }

    @Override
    public void atualizaPedido() {
        //pedido.getItemPedido().decrementaEstoque(0);
        pedido.calculaValorFinal();
        pedido.toString();
    }

    @Override
    public void avancaEtapa() {
        if (pedido.isConfirmado())
            pedido.changeState(new PedidoProntoState(pedido));
    }
}
