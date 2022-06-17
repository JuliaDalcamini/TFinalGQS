/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.model;

import java.text.DecimalFormat;

/**
 *
 * @author julia
 */
public class ItemPedidoModel {
    
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    private ProdutoModel produto;

    public ItemPedidoModel(ProdutoModel produto, int quantidade) {
        if (produto.getQuantidadeEmEstoque() < quantidade) {
            throw new RuntimeException("Estoque indisponível para atender a quantidade solicitada (" + quantidade
                    + ") para o produto " + produto.getNome()
                    + ", restam " + produto.getQuantidadeEmEstoque() + " em estoque.");
        }
        setQuantidade(quantidade);
        this.produto = produto;
        this.valorUnitario = produto.getPrecoUnitario();
        setValorTotal();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    public void setValorTotal() {
        this.valorTotal = valorUnitario * quantidade;
    }

    public double getValorTotal() {
        setValorTotal();
        return valorTotal; 
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return produto.getNome()
                + ", Valor Unitário: R$" + valorUnitario
                + ", Quantidade no Pedido: " + quantidade
                + ", Valor Total (Itens): R$" + df.format(valorTotal)
                + "\n";
    }
}
