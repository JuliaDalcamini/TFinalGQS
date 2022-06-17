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
public class DescontoModel {
    private String tipo;
    private double valorDesconto;
    private double percentual;

    public DescontoModel(String tipo, double percentual) {
        this.tipo = tipo;
        this.percentual = percentual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        if (valorDesconto < 0)
            throw new RuntimeException("O valor do desconto deve ser um número poitivo.");
        this.valorDesconto = valorDesconto;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        if (percentual < 0.01 || percentual > 0.99)
            throw new RuntimeException("O percentual do desconto deve ser maior que 0% e menor que 100%");
        this.percentual = percentual;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        DecimalFormat dp = new DecimalFormat("#%");
        return tipo
                + ", Valor do desconto: " + df.format(valorDesconto)
                + ", Porcentagem do Desconto: " + dp.format(percentual)
                + ".\n";
    }
    
    
}
