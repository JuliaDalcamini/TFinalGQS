package com.mycompany.trabalho_final.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author clayton
 */
public class ProdutoDAO {

    private ArrayList<ProdutoModel> produtos;
    private static ProdutoDAO instance;

    private ProdutoDAO() {
        produtos = new ArrayList<>();
        produtos.add(new ProdutoModel(1, "Achocolatado em Pó", 6, 11.99));
        produtos.add(new ProdutoModel(2, "Açúcar Refinado", 15, 29.9));
        produtos.add(new ProdutoModel(3, "Arroz Agulhinha Tipo 1", 8, 24.10));
        produtos.add(new ProdutoModel(4, "Biscoito Recheado (Sabores)", 5, 3.78));
        produtos.add(new ProdutoModel(5, "Biscoito Cream Cracker", 15, 4.95));
        produtos.add(new ProdutoModel(6, "Café Torrado e Moído", 7, 19.50));
        produtos.add(new ProdutoModel(7, "Creme de Leite", 13, 2.65));
        produtos.add(new ProdutoModel(8, "Ervilha em Conserva", 9, 19.30));
        produtos.add(new ProdutoModel(9, "Farinha de Trigo", 7, 3.55));
        produtos.add(new ProdutoModel(10, "Farinha de Mandioca Temperada", 6, 2.70));
        produtos.add(new ProdutoModel(11, "Feijão Carioca Tipo 1", 6, 6.65));
        produtos.add(new ProdutoModel(12, "Fubá Mimoso", 14, 3.71));
        produtos.add(new ProdutoModel(13, "Leite em Pó Integral", 5, 25.79));
        produtos.add(new ProdutoModel(14, "Macarrão Espaguete", 13, 3.15));
        produtos.add(new ProdutoModel(15, "Macarrão Parafuso", 10, 5.95));
        produtos.add(new ProdutoModel(16, "Mistura para Bolo (Sabores)", 12, 41.10));
        produtos.add(new ProdutoModel(17, "Óleo de Soja", 13, 7.89));
        produtos.add(new ProdutoModel(18, "Pó para Gelatina (Sabores)", 5, 1.45));
        produtos.add(new ProdutoModel(19, "Polpa de Tomate", 5, 33.95));
        produtos.add(new ProdutoModel(20, "Sal Refinado", 7, 1.29));
        produtos.add(new ProdutoModel(21, "Sardinha", 12, 18.80));
        produtos.add(new ProdutoModel(22, "Tempero Completo/ Alho e Sal", 15, 2.57));
        produtos.add(new ProdutoModel(23, "Amaciante Líquido (Fragrâncias)", 5, 10.48));
        produtos.add(new ProdutoModel(24, "Creme Dental", 9, 1.30));
        produtos.add(new ProdutoModel(25, "Desinfetante (Fragrâncias)", 10, 27.99));
        produtos.add(new ProdutoModel(26, "Papel Higiênico", 14, 11.19));
        produtos.add(new ProdutoModel(27, "Sabonete (Fragrâncias)", 11, 1.89));
        produtos.add(new ProdutoModel(28, "1 KG de Carne Bovina", 11, 31.89));
        produtos.add(new ProdutoModel(29, "1 KG de Carne Suína", 11, 21.39));
        produtos.add(new ProdutoModel(30, "1 KG de Carne de Frango", 11, 14.39));
        produtos.add(new ProdutoModel(31, "1 dúzia de ovos", 16, 7.19));
        produtos.add(new ProdutoModel(32, "Leite Integral UHT 1 Litro", 100, 3.69));
        produtos.add(new ProdutoModel(33, "Manteiga com Sal 100G", 32, 4.98));
        produtos.add(new ProdutoModel(34, "1 Kg Pão Francês", 20, 7.00));        
        produtos.add(new ProdutoModel(35, "1 Kg batata", 200, 1.71));        
        produtos.add(new ProdutoModel(36, "1 Kg tomate", 120, 6.00));        
        produtos.add(new ProdutoModel(37, "1 dúzia de banana", 20, 2.50));        
    }

    public static ProdutoDAO getInstance() {
        if (instance == null) {
            instance = new ProdutoDAO();
        }
        return instance;
    }

    private void verificaQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new RuntimeException("Quantidade deve ser > 0");
        }
    }

    void adicionaEstoque(int codigo, int quantidade) {
        verificaQuantidade(quantidade);
        ProdutoModel produto = buscaProdutoPorCodigo(codigo);
        produto.incrementaEstoque(quantidade);
    }

    private double getQuantidadeEmEstoque(int codigo) {
        return buscaProdutoPorCodigo(codigo).getQuantidadeEmEstoque();
    }

    void baixaEstoque(int codigo, int quantidade) {
        verificaQuantidade(quantidade);
        ProdutoModel produto = buscaProdutoPorCodigo(codigo);
        double quantidadeEmEstoque = getQuantidadeEmEstoque(codigo);
        if (quantidadeEmEstoque >= quantidade) {
            produto.decrementaEstoque(quantidade);
        } else {
            throw new RuntimeException("Quantidade (" + quantidade + ") do produto " + codigo + "insuficiente em estoque (" + quantidadeEmEstoque + ")");
        }

    }

    public ProdutoModel buscaProdutoPorNome(String nome) {
        for (ProdutoModel produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        throw new RuntimeException("Produto " + nome + " não encontrado!");
    }

    public ProdutoModel buscaProdutoPorCodigo(int codigo) {
        for (ProdutoModel produto : produtos) {
            if (produto.getIdProduto() == codigo) {
                return produto;
            }
        }
        throw new RuntimeException("Produto com o código " + codigo + " não encontrado!");
    }
    
    public List<ProdutoModel> getProdutosLimpeza() {
        List<ProdutoModel> produtosLimpeza = new ArrayList<>();
        produtosLimpeza = produtos.subList(22, 26);
        return produtosLimpeza;
    }
    
    public List<ProdutoModel> getProdutosProteinas() {
        List<ProdutoModel> produtosProteina = new ArrayList<>();
        produtosProteina = produtos.subList(27, 31);
        return produtosProteina;
    }
    
    public List<ProdutoModel> getProdutosBasicos() {
        List<ProdutoModel> produtosGrao = new ArrayList<>();
        produtosGrao.add(produtos.get(2));
        produtosGrao.add(produtos.get(8));
        produtosGrao.add(produtos.get(10));
        produtosGrao.add(produtos.get(11));
        produtosGrao.add(produtos.get(13));
        produtosGrao.add(produtos.get(14));
        produtosGrao.add(produtos.get(19));
        return produtosGrao;
    }
    
    public List<ProdutoModel> getProdutosVegetais() {
        List<ProdutoModel> produtosVegetal = new ArrayList<>();
        produtosVegetal = produtos.subList(34, 36);
        return produtosVegetal;
    }
    
    public List<ProdutoModel> getProdutosIndustrializadosA() {
        List<ProdutoModel> produtosIndus = new ArrayList<>();
        produtosIndus.add(produtos.get(1));
        produtosIndus.add(produtos.get(4));
        produtosIndus.add(produtos.get(5));
        produtosIndus.add(produtos.get(9));
        produtosIndus.add(produtos.get(15));
        produtosIndus.add(produtos.get(16));
        produtosIndus.add(produtos.get(21));
        produtosIndus.add(produtos.get(32));
        return produtosIndus;
    }
    
    public List<ProdutoModel> getProdutosIndustrializadosB() {
        List<ProdutoModel> produtosIndus = new ArrayList<>();
        produtosIndus.add(produtos.get(0));
        produtosIndus.add(produtos.get(3));
        produtosIndus.add(produtos.get(6));
        produtosIndus.add(produtos.get(7));
        produtosIndus.add(produtos.get(12));
        produtosIndus.add(produtos.get(17));
        produtosIndus.add(produtos.get(18));
        produtosIndus.add(produtos.get(20));
        return produtosIndus;
    }

    public List<ProdutoModel> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public int getNroProdutos() {
        return produtos.size();
    }

}