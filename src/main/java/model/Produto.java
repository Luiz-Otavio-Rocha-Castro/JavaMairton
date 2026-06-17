package model;

import control.GerenciamentoProduto;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private String vencimento;
    private int quantidade;
    private String categoria;
0
    public Produto(String nome, String descricao, double preco, String vencimento, int quantidade, String categoria) {
        this.setCodigo(GerenciamentoProduto.CODIGO);
        this.setNome(nome);
        this.setPreco(preco);
        this.setVencimento(vencimento);
        this.setQuantidade(quantidade);
        this.setCategoria(categoria);
        this.setDescricao(descricao);
        ++GerenciamentoProduto.CODIGO;
    }




    public int getCodigo() {
        return this.codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if(preco >= 0) {
            this.preco = preco;
        }
    }
    public String getVencimento() {
        return vencimento;
    }
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if(quantidade >= 0) {
            this.quantidade = quantidade;
        }
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String exibirProduto() {
        String conteudo = "";
        conteudo = "Codigo: " + this.codigo +
                "\nNome: " + this.nome +
                "\nDescricao: " + this.descricao +
                "\nPreco: " + this.preco +
                "\nVencimento: " + this.vencimento +
                "\nQuantidade: " + this.quantidade +
                "\nCategoria: " + this.categoria;
        return conteudo;
    }

}
