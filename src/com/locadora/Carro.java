package com.locadora;

public class Carro {

    private String fabricante;
    private String modelo;
    private String cor;
    private String combustivel;
    private int kmRodado;
    private boolean alugado;

    public Carro() {}

    public Carro(String fabricante, String modelo, String cor, String combustivel, int kmRodado, boolean alugado) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cor = cor;
        this.combustivel = combustivel;
        this.kmRodado = kmRodado;
        this.alugado = alugado;
    }

    public void ExibirInformacoes() {
        ExibirInformacoes("Dados do Veículo");
    }

    public void ExibirInformacoes(String cabecalho) {
        System.out.println("--------------------------------------------------");
        System.out.println(cabecalho);
        System.out.println("--------------------------------------------------");
        System.out.println("Fabricante: " + this.get_fabricante());
        System.out.println("Modelo: " + this.get_modelo());
        System.out.println("Cor: " + this.get_cor());
        System.out.println("Combustível: " + this.get_combustivel());
        this.ExibirKmRodados();
    }

    public void ExibirKmRodados() {
        System.out.println("Km rodados: " + String.valueOf(this.get_kmRodado()));
    }

    public String get_fabricante() { return fabricante; }
    public void set_fabricante(String fabricante) { this.fabricante = fabricante; }

    public String get_modelo() { return modelo; }
    public void set_modelo(String modelo) { this.modelo = modelo; }

    public String get_cor() { return cor; }
    public void set_cor(String cor) { this.cor = cor; }

    public String get_combustivel() { return combustivel; }
    public void set_combustivel(String combustivel) { this.combustivel = combustivel; }

    public int get_kmRodado() { return kmRodado; }
    public void set_kmRodado (int kmRodado) { this.kmRodado = kmRodado; }

    public boolean get_alugado() { return alugado; }
    public void set_alugado (boolean alugado) { this.alugado = alugado; }
}

