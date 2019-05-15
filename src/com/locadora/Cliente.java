package com.locadora;

public class Cliente {

    private String nome;
    private String endereco;
    private String telefone;
    private int idade;
    private String rg;
    private String cpf;
    private Carro carroAlugado;
    private String dataAluguel;
    private String dataDevolucao;

    public Cliente(){}

    public Cliente(String nome, String endereco, String telefone, int idade, String rg, String cpf, Carro carroAlugado, String dataAluguel, String dataDevolucao) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idade = idade;
        this.rg = rg;
        this.cpf = cpf;
        this.carroAlugado = carroAlugado;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }
    public void ExibirInformacoes() {
        ExibirInformacoes("Dados do Cliente");
    }

    public void ExibirInformacoes(String cabecalho) {
        System.out.println("--------------------------------------------------");
        System.out.println(cabecalho);
        System.out.println("--------------------------------------------------");
        System.out.println("Nome: " + this.get_nome());
        System.out.println("Endereco: " + this.get_endereco());
        System.out.println("Telefone: " + this.get_telefone());
        System.out.println("Idade: " + String.valueOf(this.get_idade()));
        System.out.println("RG: " + this.get_rg());
        System.out.println("CPF: " + this.get_cpf());

        if(this.get_carroAlugado() != null){
            this.get_carroAlugado().ExibirInformacoes();
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Dados do Contrato");
        System.out.println("--------------------------------------------------");
        System.out.println("Data Aluguel: " + this.get_dataAluguel());
        System.out.println("Data Devolução: " + this.get_dataDevolucao());
    }

    public String get_nome() {
        return nome;
    }
    public void set_nome(String nome) {
        this.nome = nome;
    }

    public String get_endereco() {
        return endereco;
    }
    public void set_endereco(String endereco) {
        this.endereco = endereco;
    }

    public String get_telefone() {
        return telefone;
    }
    public void set_telefone(String telefone) {
        this.telefone = telefone;
    }

    public int get_idade() {
        return idade;
    }
    public void set_idade(int idade) {
        this.idade = idade;
    }

    public String get_rg() {
        return rg;
    }
    public void set_rg(String rg) {
        this.rg = rg;
    }

    public String get_cpf() {
        return cpf;
    }
    public void set_cpf(String cpf) {
        this.cpf = cpf;
    }

    public Carro get_carroAlugado() {
        return carroAlugado;
    }
    public void set_carroAlugado(Carro carroAlugado) {
        this.carroAlugado = carroAlugado;
    }

    public String get_dataAluguel () {
        return dataAluguel;
    }
    public void set_dataAluguel (String dataAluguel) {
        this.dataAluguel  = dataAluguel;
    }

    public String get_dataDevolucao () {
        return dataDevolucao;
    }
    public void set_dataDevolucao (String dataDevolucao) {
        this.dataDevolucao  = dataDevolucao;
    }
}
