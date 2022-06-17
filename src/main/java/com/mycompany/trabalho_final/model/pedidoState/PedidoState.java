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
public abstract class PedidoState {
    
    protected PedidoModel pedido;

    public PedidoState(PedidoModel pedido) {
        this.pedido = pedido;
    }
    
    public abstract void cancelaPedido();
    
    public abstract void atualizaPedido();
    
    public abstract void avancaEtapa();
}
