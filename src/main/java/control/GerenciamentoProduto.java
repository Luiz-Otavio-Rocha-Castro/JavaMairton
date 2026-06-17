package control;

import java.util.LinkedList;
import model.Produto;
import javax.swing.*;

import javax.swing.JOptionPane;

public class GerenciamentoProduto {
    private LinkedList<Produto> produtos;
   
    public static int CODIGO = 200;
    private String carrinho;
    private double total;


    public GerenciamentoProduto() {
        this.produtos = new LinkedList<Produto>();
        this.carrinho = "";
        this.total = 0;
    }
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }
    public String listarProdutos() {
        String conteudo= "";
        for(Produto produto : this.produtos) {
            conteudo = conteudo + produto.exibirProduto()+ "\n\n";
        }
        return conteudo;
    }
    public Produto buscarProduto(int codigo) {
        for(Produto produto : this.produtos) {
            if(produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

        public void excluirProduto(int codigo){
            for(Produto produto: this.produtos){
                if(produto.getCodigo() == codigo ){
                    this.produtos.remove(produto);
                    return;
                }
            }
        }

        public void atualizarProduto(int codigo, String nome, double preco, int quantidade,String vencimento, String categoria, String descricao){
            for(Produto produto : this.produtos){
                if(codigo == produto.getCodigo()){
                    produto.setNome(nome);
                    produto.setPreco(preco);
                    produto.setQuantidade(quantidade);
                    produto.setNome(nome);
                    produto.setVencimento(vencimento);
                    produto.setCategoria(categoria);
                    produto.setDescricao(descricao);
                }
            }
        }

        public void adicionarCarrinho(Produto produto, int quantidade){
            this.carrinho = this.carrinho + "\nCodigo: " + produto.getCodigo() +
                    "\tNome: " + produto.getNome() +
                    "\tQuantidade: " + quantidade +
                    "\tPreco: " + (produto.getPreco() * quantidade) + "\n";
            this.total += (produto.getPreco() * quantidade);
            produto.setQuantidade(produto.getQuantidade()-quantidade);
        }

        public String verCarrinho(){
            return this.carrinho + "\nTotal: " + this.total + "\n";
        }

        public String verificarEstoque(int margem){
            int i;
            String conteudo = "";
            if(this.id == 0){
                return "Nao existe nenhum produto no estoque";
            }
            for(i = 0; i < this.id; i++){
                if(this.produtos[i].getQuantidade() <=margem){
                    conteudo += "Codigo: " + this.produtos[i].getCodigo() +
                            "\nNome " + this.produtos[i].getDescricao() +
                            "\nPreco " + this.produtos[i].getPreco() + "\n\n";

                }
            }
            if(conteudo.equals("")){
                return "Os produtos possuem itens";
            }
            return conteudo;
        }

    public String verificarEstoque(){
        int i;
        String conteudo = "";
        if(this.id == 0){
            return "Nao existe nenhum produto no estoque";
        }
        for(i = 0; i < this.id; i++){
            if(this.produtos[i].getQuantidade() == 0){
                conteudo += "Codigo: " + this.produtos[i].getCodigo() +
                        "\nNome " + this.produtos[i].getDescricao() +
                        "\nPreco " + this.produtos[i].getPreco() + "\n\n";

            }
        }
        if(conteudo.equals("")){
            return "Os produtos possuem itens";
        }
        return conteudo;
    }
    public String finalizarCompra(){
        String conteudo = this.carrinho + "\nTotal: " + this.total + "\n"
                + "Compra concluida com sucesso!\n";
        this.carrinho = "";
        this.total = 0;
        return conteudo;
    }

}
