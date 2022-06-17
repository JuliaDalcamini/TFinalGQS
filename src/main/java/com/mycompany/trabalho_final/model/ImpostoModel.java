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
public class ImpostoModel {
    
    private String nome;
    private double percentual;
    private double valor;

    public ImpostoModel(String nome, double percentual) {
        this.nome = nome;
        this.percentual = percentual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        if (percentual < 0.01 || percentual > 0.99)
            throw new RuntimeException("O percentual do desconto deve ser maior que 0% e menor que 100%");
        this.percentual = percentual;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0)
            throw new RuntimeException("O valor do imposto deve ser um número poitivo.");
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("R$ 0.00");
        DecimalFormat dp = new DecimalFormat("#%");
        return nome
                + ", Valor do imposto: " + df.format(valor)
                + ", Porcentagem do Imposto: " + dp.format(percentual)
                + ".\n";
    }
}
