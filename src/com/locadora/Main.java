package com.locadora;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Carro> totalDeCarros = new ArrayList<>();
    private static ArrayList<Carro> carrosAlugados = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Cliente> clientesAlugando = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        CarregarDadosIniciais();
        String opcao = "";

        do {
            ExibirMenuPrincipal();

            System.out.print("Informe a opção desejada: ");
            opcao = input.nextLine();

            if (opcao.equals("1")) {
                CadastrarCliente();
            } else if (opcao.equals("2")) {
                ExibirDadosClientes();
            } else if (opcao.equals("3")) {
                ExibirInfoCarros();
            }
        } while (!opcao.toUpperCase().equals("S"));
    }

    private static void CarregarDadosIniciais() {
        totalDeCarros.add(new Carro("Fiat", "Pálio 1.0", "Prata", "TotalFlex", 50000, false));
        totalDeCarros.add(new Carro("Fiat", "Pálio 1.0", "Prata", "TotalFlex", 50000, false));
        totalDeCarros.add(new Carro("Fiat", "Pálio 1.0", "Prata", "TotalFlex", 50000, false));
        totalDeCarros.add(new Carro("Hyundai", "HB20 1.6", "Branco", "TotalFlex", 40000, false));
        totalDeCarros.add(new Carro("Hyundai", "HB20 1.6", "Branco", "TotalFlex", 40000, false));
        totalDeCarros.add(new Carro("Volkswagen", "Gol 1.0", "Preto", "Gasolina", 55000, false));
        totalDeCarros.add(new Carro("Volkswagen", "Gol 1.0", "Preto", "Gasolina", 55000, false));
        totalDeCarros.add(new Carro("Volkswagen", "Gol 1.0", "Preto", "Gasolina", 55000, false));
        totalDeCarros.add(new Carro("Volkswagen", "Gol 1.0", "Preto", "Gasolina", 55000, false));
        totalDeCarros.add(new Carro("Volkswagen", "Gol 1.0", "Preto", "Gasolina", 55000, false));
        totalDeCarros.add(new Carro("Chevrolet", "Camaro 3.0", "Amarelo", "TotalFlex", 7000, false));
        totalDeCarros.add(new Carro("Chevrolet", "Camaro 3.0", "Amarelo", "TotalFlex", 7000, false));
        totalDeCarros.add(new Carro("Chevrolet", "Camaro 3.0", "Amarelo", "TotalFlex", 7000, false));
        totalDeCarros.add(new Carro("Ford", "Fusion 2.0", "Preto", "TotalFlex", 15000, false));
        totalDeCarros.add(new Carro("Dodge", "Viper 8.3", "Azul", "Gasolina", 5000, false));
    }

    private static void ExibirMenuPrincipal() {
        System.out.println("--------------------------------------------------");
        System.out.println("Bem-vindo a APS Locadora de Veículos");
        System.out.println("Digite a opção desejada:");
        System.out.println("--------------------------------------------------");
        System.out.println("[1] - Alugar Carro");
        System.out.println("[2] - Exibir Informações dos Clientes");
        System.out.println("[3] - Exibir Informações dos Carros");
        System.out.println("[S] - Sair");
        System.out.println("");
    }

    private static void CadastrarCliente() {
        if (clientes.size() >= 20) {
            System.out.println("Quantidade máxima de clientes excedido!");
            input.nextLine();
            return;
        }

        Cliente novoCliente = new Cliente();

        System.out.println("--------------------------------------------------");
        System.out.println("Cadastro de Cliente");
        System.out.println("--------------------------------------------------");
        System.out.print("Nome: ");
        novoCliente.set_nome(input.nextLine());

        System.out.print("Endereço: ");
        novoCliente.set_endereco(input.nextLine());

        System.out.print("Telefone: ");
        novoCliente.set_telefone(input.nextLine());

        System.out.print("Idade: ");
        novoCliente.set_idade(Integer.parseInt(input.nextLine()));

        System.out.print("RG: ");
        novoCliente.set_rg(input.nextLine());

        System.out.print("CPF: ");
        novoCliente.set_cpf(input.nextLine());

        System.out.print("Data do Aluguel: ");
        novoCliente.set_dataAluguel(input.nextLine());

        System.out.print("Data de Devolução: ");
        novoCliente.set_dataDevolucao(input.nextLine());

        System.out.print("Deseja alugar um carro? (S/N) ");

        if (input.nextLine().toUpperCase().equals("S")) {
            novoCliente.set_carroAlugado(AlugarCarroDisponivel());
            novoCliente.get_carroAlugado().set_alugado(true);
            carrosAlugados.add(novoCliente.get_carroAlugado());
            clientesAlugando.add(novoCliente);
        }

        clientes.add(novoCliente);
    }

    private static Carro AlugarCarroDisponivel() {
        Carro carroSelecionado = null;

        do {
            System.out.println("--------------------------------------------------");
            System.out.println("Carros disponíveis");
            System.out.println("--------------------------------------------------");

            for (int i = 0; i < totalDeCarros.size(); i++) {
                Carro carro = totalDeCarros.get(i);

                if (!carro.get_alugado()) {
                    carro.ExibirInformacoes("Carro [" + String.valueOf(i) + "]");
                }
            }

            System.out.print("\nInforme a opção desejada: ");
            carroSelecionado = totalDeCarros.get(Integer.parseInt(input.nextLine()));

            if (carroSelecionado.get_alugado()) {
                System.out.println("Carro já alugado.");
                System.out.println("Favor selecionar uma outra opção.");
                input.nextLine();
            }
        } while (carroSelecionado.get_alugado() == true);

        return carroSelecionado;
    }


    private static void ExibirDadosClientes() {
        System.out.println("--------------------------------------------------");
        System.out.println("Clientes Alugando");
        System.out.println("--------------------------------------------------");
        for (Cliente cliente : clientesAlugando) {
            if (cliente.get_carroAlugado() != null) {
                cliente.ExibirInformacoes();
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Clientes Não Alugando");
        System.out.println("--------------------------------------------------");
        for (Cliente cliente : clientes) {
            if (cliente.get_carroAlugado() == null) {
                cliente.ExibirInformacoes();
            }
        }

    }

    private static void ExibirInfoCarros() {
        System.out.println("--------------------------------------------------");
        System.out.println("Carros Alugando");
        System.out.println("--------------------------------------------------");
        for (Carro carro : carrosAlugados) {
            if (carro.get_alugado() == true) {
                carro.ExibirInformacoes();
            }
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Carros Disponíveis");
        System.out.println("--------------------------------------------------");
        for (Carro carro : totalDeCarros) {
            if (carro.get_alugado() == false) {
                carro.ExibirInformacoes();
            }
        }
    }
}

