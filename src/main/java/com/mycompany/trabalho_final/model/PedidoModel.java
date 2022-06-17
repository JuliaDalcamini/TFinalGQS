/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.model;

import com.mycompany.trabalho_final.model.pedidoState.PedidoNovoState;
import com.mycompany.trabalho_final.model.pedidoState.PedidoState;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class PedidoModel {

    private static long ultimoNumero;
    private long numero = 0;
    private LocalDateTime data;
    private double valorTotal;
    private double valorTotalImpostos;
    private double valorFinalAPagar;
    private double valorTotalDescontos;
    protected ClienteModel cliente;
    protected ProdutoModel produto;
    protected ArrayList<ItemPedidoModel> itensPedidos = new ArrayList<>();
    protected ArrayList<DescontoModel> descontos = new ArrayList<>();
    protected ArrayList<ImpostoModel> impostos = new ArrayList<>();
    protected PedidoState estadoPedido;

    public PedidoModel(LocalDateTime data, ClienteModel cliente, ItemPedidoModel itemPedido) {
        ultimoNumero += ultimoNumero + 1;
        this.numero = ultimoNumero;
        this.data = data;
        this.cliente = cliente;
        addListaItens(itemPedido);
        setEstadoPedido(new PedidoNovoState(this));
    }

    public long getNumero() {
        return numero;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String formataData(LocalDateTime data) {
        String dtf = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        return dtf;
    }

    public void changeState(PedidoState estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public PedidoState getState() {
        return estadoPedido;
    }

    public ProdutoModel getItemPedido() {
        return produto;
    }

    public void addListaItens(ItemPedidoModel item) {
        itensPedidos.add(item);
    }

    public void addListaDescontos(DescontoModel desconto) {
        descontos.add(desconto);
    }

    public void addListaImpostos(ImpostoModel imposto) {
        impostos.add(imposto);
    }

    public List<ItemPedidoModel> getListaItens() {
        return itensPedidos;
    }

    public List<DescontoModel> getListaDescontos() {
        return descontos;
    }

    public List<ImpostoModel> getListaImpostos() {
        return impostos;
    }

    public void setEstadoPedido(PedidoState estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public PedidoState getEstadoPedido() {
        return estadoPedido;
    }

    public boolean isNovo() {
        return estadoPedido.toString().toLowerCase().equals("novo");
    }

    public boolean isPronto() {
        return estadoPedido.toString().toLowerCase().equals("pronto");
    }

    public boolean isAguardandoPagamento() {
        return estadoPedido.toString().toLowerCase().equals("aguardando pagamento");
    }

    public boolean isRotaEntrega() {
        return estadoPedido.toString().toLowerCase().equals("em rota de entrega");
    }

    public boolean isConfirmado() {
        return estadoPedido.toString().toLowerCase().equals("confirmado");
    }

    public boolean isEntregue() {
        return estadoPedido.toString().toLowerCase().equals("entregue");
    }

    public void setValorTotalPedido() {
        valorTotal = 0;
        for (ItemPedidoModel item : itensPedidos) {
            valorTotal += item.getValorTotal();
        }
    }

    public void setValorTotalDesconto() {
        for (DescontoModel desconto : descontos) {
            desconto.setValorDesconto(valorTotal * desconto.getPercentual());
            valorTotalDescontos += valorTotal * desconto.getPercentual();
        }
    }

    public void setValorTotalImposto() {
        for (ImpostoModel imposto : impostos) {
            imposto.setValor(valorTotal * imposto.getPercentual());
            valorTotalImpostos += valorTotal * imposto.getPercentual();
        }
    }

    public double calculaValorFinal() {
        valorFinalAPagar = (valorTotal - valorTotalDescontos) + valorTotalImpostos;
        return valorFinalAPagar;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        return "Pedido:" + numero + "\n"
                + "Data: " + formataData(data) + "\n"
                + "Nome do Cliente: " + cliente.getNome() + "\n"
                + "Estado do pedido: " + estadoPedido + "\n"
                + "------------------------------- \n"
                + "Itens Pedidos \n"
                + itensPedidos.toString() + "\n"
                + "Valor Total do Pedido: R$ " + df.format(getValorTotal()) + "\n"
                + "------------------------------- \n"
                + "Descontos \n"
                + descontos.toString()
                + "\n------------------------------- \n"
                + "Impostos \n"
                + impostos.toString()
                + "\n------------------------------- \n"
                + "Valor Total a Pagar: "
                + df.format(calculaValorFinal())
                + '.';
    }
}
