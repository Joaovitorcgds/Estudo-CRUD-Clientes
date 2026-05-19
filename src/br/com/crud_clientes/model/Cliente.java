package br.com.crud_clientes.model;

public class Cliente {

    private String nome;
    private String cpf;
    private int idade;
    private Endereco endereco;

    public Cliente( String cpf, String nome, int idade, Endereco endereco){
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
