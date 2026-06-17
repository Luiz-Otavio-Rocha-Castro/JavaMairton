
package com.mycompany.loja;

import view.Tela;
import control.GerenciamentoProduto;
import model.Produto;
import javax.swing.JOptionPane;

public class Loja {
    public static void main(String[] args) {

        Tela tela = new Tela();
        tela.setVisible(true);

        GerenciamentoProduto genProd = new GerenciamentoProduto(5);
        int codigo,quantidade,busca;
        String nome,descricao,categoria,vencimento;
        double preco;
        boolean controle = true;
        while(controle) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("Sistema de gerenciamento de produtos\n" + "1 - Inserir produto\n" +
                    "2 - listar produtos\n3 - buscar produto\n4 - excluir produto" +
                    "\n5 - editar produto\n6 - adicionar no carrinho\n7 - ver carrinho\n8 - verificar estoque" +
                    "\n9 - finalizar compra\n0 - sair\nSelecione uma opção:"));
            switch(opcao) {
                case 1:
                    //codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
                    nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
                    descricao = JOptionPane.showInputDialog("Digite a descrição do produto: ");
                    preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto: "));
                    vencimento = JOptionPane.showInputDialog("Digite o vencimento do produto: ");
                    quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
                    categoria = JOptionPane.showInputDialog("Digite a categoria do produto: ");
                    Produto produto = new Produto(nome,descricao,preco,vencimento,quantidade,categoria);
                    genProd.adicionarProduto(produto);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,genProd.listarProdutos());
                    break;
                case 3:
                    busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
                    produto=genProd.buscarProduto(busca);
                    if(produto==null) {
                        JOptionPane.showMessageDialog(null,"Produto nao encontrado!");
                    }else {
                        JOptionPane.showMessageDialog(null,produto.exibirProduto()) ;
                    }
                    break;
                case 4:
                    busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
                    genProd.excluirProduto(busca);
                    break;

                case 5:
                    busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
                    produto=genProd.buscarProduto(busca);
                    if(produto == null){
                        JOptionPane.showMessageDialog(null, "Produto não encontrado :(");
                    }
                    else{
                        nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
                        descricao = JOptionPane.showInputDialog("Digite a descrição do produto: ");
                        preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto: "));
                        vencimento = JOptionPane.showInputDialog("Digite o vencimento do produto: ");
                        quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: "));
                        categoria = JOptionPane.showInputDialog("Digite a categoria do produto: ");
                        genProd.atualizarProduto(busca,nome, preco, quantidade, vencimento, categoria, descricao );
                    }
                    break;
                case 6:
                    busca = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto: "));
                    produto=genProd.buscarProduto(busca);
                    if(produto == null){
                        JOptionPane.showMessageDialog(null, "Produto não encontrado :(");
                    }
                    else{
                        quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
                        if (quantidade > produto.getQuantidade()){
                            JOptionPane.showMessageDialog(null, "Quantidade indisponivel :(");
                        }
                        else{ genProd.adicionarCarrinho(produto, quantidade);
                        }
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null,genProd.verCarrinho());
                    break;
                case 8:
                    int margem = Integer.parseInt(JOptionPane.showInputDialog("Digite a margem desejada: "));
                    if(margem == 0){
                        JOptionPane.showInputDialog(null,genProd.verificarEstoque());
                        break;
                    }
                    else{
                        JOptionPane.showInputDialog(null,genProd.verificarEstoque(margem));
                    }
                case 9:
                    JOptionPane.showMessageDialog(null,genProd.finalizarCompra());
                    break;
                case 0:
                    controle = false;
                    JOptionPane.showMessageDialog(null, "Saindo do sistema");

            }
        }



    }
}

