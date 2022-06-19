/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho_final.Main;

import com.mycompany.trabalho_final.builder.CestaBuilder;
import com.mycompany.trabalho_final.builder.CestaDirector;
import com.mycompany.trabalho_final.model.ClienteModel;
import com.mycompany.trabalho_final.model.DescontoModel;
import com.mycompany.trabalho_final.model.ImpostoModel;
import com.mycompany.trabalho_final.model.ItemPedidoModel;
import com.mycompany.trabalho_final.model.PedidoModel;
import com.mycompany.trabalho_final.model.ProdutoDAO;
import com.mycompany.trabalho_final.model.ProdutoModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class Main {

    public static void main(String[] args) {

        try {

            //PEDIDO 1
            LocalDateTime data = LocalDateTime.now();

            ProdutoDAO dao = ProdutoDAO.getInstance();
            
            /*List<ProdutoModel> lista = new ArrayList<>();
            
            lista.addAll(dao.getProdutosBasicos());
            
            for(ProdutoModel p : lista) {
                System.out.println(p);
            }*/

            //constroi cesta economica
            CestaDirector director = new CestaDirector();
            
            CestaBuilder builder = new CestaBuilder();
            director.constructCestaEconomica(builder);
            
            //CestaBasicaModel cesta = builder.getCesta();
            
            //System.out.println(cesta.getListaProdutosCesta());

            // pega produtos
            ProdutoModel produto = dao.getProdutos().get(0);
            ProdutoModel produto2 = dao.getProdutos().get(1);

            //cria cliente
            ClienteModel cliente1 = new ClienteModel("Fulano");

            // cria item pedido
            ItemPedidoModel itemPedido = new ItemPedidoModel(produto, 2);
            ItemPedidoModel itemPedido2 = new ItemPedidoModel(produto2, 1);

            //cria descontos
            DescontoModel desconto = new DescontoModel("Promo Dia das Maes", 0.30);

            //cria impostos
            ImpostoModel imposto = new ImpostoModel("ICMS", 0.02);

            // cria novo pedido
            PedidoModel pedido1 = new PedidoModel(data, cliente1, itemPedido);
            pedido1.addListaItens(itemPedido2);
            pedido1.getState().atualizaPedido();

            System.out.println(pedido1);

            // adiciona desconto e imposto
            pedido1.addListaDescontos(desconto);
            pedido1.addListaImpostos(imposto);

            //aguardando pagamento
            pedido1.getState().avancaEtapa();
            pedido1.getState().atualizaPedido();

            System.out.println(pedido1);

            //confirma pedido
            pedido1.getState().avancaEtapa();

            System.out.println(pedido1);

            /*cancela pedido
            pedido1.getState().cancelaPedido();
            System.out.println(pedido1);*/
            //pronto
            pedido1.getState().avancaEtapa();
            System.out.println(pedido1);

            //rota
            pedido1.getState().avancaEtapa();
            System.out.println(pedido1);

            //entregue
            pedido1.getState().avancaEtapa();
            System.out.println(pedido1);

        } catch (Exception ex) {
            System.out.println("Falha:\n" + ex.getMessage());
        }
    }
}
