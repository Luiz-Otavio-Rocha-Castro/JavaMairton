package control;

import java.util.LinkedList;
import model.Produto;
import javax.swing.*;

import javax.swing.JOptionPane;

public class GerenciamentoProduto {
    private LinkedList<Produto> produtos;
    private int tamanho;
    private int id;
    public static int CODIGO = 200;
    private String carrinho;
    private double total;


    public GerenciamentoProduto(int tamanho) {
        this.tamanho = tamanho;
        this.produtos = new Produto[this.tamanho];
        this.id = 0;
        this.carrinho = "";
        this.total = 0;
    }
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }
    /*
    public String listarProdutos() {
        int i;
        String conteudo="";
        for(i = 0; i < this.id; ++i) {
            conteudo = conteudo + this.produtos[i].exibirProduto()+ "\n\n";
        }
        return conteudo;
    }

    public Produto buscarProduto(int codigo) {
        int i;
        for(i=0;i<this.id;i++) {
            if(this.produtos[i].getCodigo() == codigo) {
                return this.produtos[i];
            }
        }
        return null;
    }

        public void excluirProduto(int codigo){
            for(int i = 0; i < this.id; i++){
                if(this.produtos[i].getCodigo() == codigo ){
                    if(i <(this.id - 1)) {
                        for (int j = i; j < (this.id - 1); j++){
                            this.produtos[j] = this.produtos[j + 1];
                        }
                    }
                    this.id--;
                    return;
                }
            }
        }

        public void atualizarProduto(int codigo, String nome, double preco, int quantidade,String vencimento, String categoria, String descricao){
            for(int i = 0; i < this.id; i++){
                if(codigo == this.produtos[i].getCodigo()){
                   this.produtos[i].setNome(nome);
                    this.produtos[i].setPreco(preco);
                    this.produtos[i].setQuantidade(quantidade);
                    this.produtos[i].setNome(nome);
                    this.produtos[i].setVencimento(vencimento);
                    this.produtos[i].setCategoria(categoria);
                    this.produtos[i].setDescricao(descricao);
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
