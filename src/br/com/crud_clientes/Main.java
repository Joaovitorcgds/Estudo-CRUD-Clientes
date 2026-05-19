package br.com.crud_clientes;

import br.com.crud_clientes.controller.ClienteController;
import br.com.crud_clientes.model.Cliente;
import br.com.crud_clientes.model.Endereco;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        ClienteController controller = new ClienteController();
        controller.atualizaClientesFromRepository();

        while (true){
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Editar cliente");
            System.out.println("5 - Remover cliente");
            System.out.println("0 - Sair");

            int opcao =  Integer.parseInt(scan.nextLine());

            if (opcao == 1){

                System.out.println("*** QUAL É O SEU CPF? ***");
                String cpfDigitado = scan.nextLine();
                String nome;
                int idade;
                String rua;
                String cidade;
                String cep;


                if(controller.buscarCliente(cpfDigitado) == null){

                    System.out.println("*** QUAL É O SEU NOME? ***");
                    nome = scan.nextLine();

                    System.out.println("*** QUAL É A SUA IDADE? ***");
                    idade = Integer.parseInt(scan.nextLine());

                    System.out.println("*** QUAL É A SUA RUA? ***");
                    rua = scan.nextLine();

                    System.out.println("*** QUAL É A SUA CIDADE? ***");
                    cidade = scan.nextLine();

                    System.out.println("*** QUAL É O SEU CEP? ***");
                    cep = scan.nextLine();

                    Endereco endereco = new Endereco(rua, cidade, cep);

                    controller.cadastrarCliente(cpfDigitado, nome, idade, endereco);

                    System.out.println("Cliente " + nome + " Cadastrado(a).");
                } else {
                    System.out.println("Cliente cadastrado");
                    System.out.println("-------------------");
                }

            }
            else if (opcao == 2) {
                controller.listarClientes();
            }
            else if (opcao == 3) {

                System.out.println("-------------------");
                System.out.println("Digite o CPF do cliente.");

                String cpf = scan.nextLine();
                Cliente res = controller.buscarCliente(cpf);

                if (res == null){
                    System.out.println("Cliente não encontrado.");
                }else {
                    System.out.println("-------------------");
                    System.out.println("Nome: " + res.getNome());
                    System.out.println("CPF: " + res.getCpf());
                    System.out.println("Idade: " + res.getIdade());
                    System.out.println("-------------------");
                }

            }
            else if (opcao == 4) {

                System.out.println("*** QUAL É O SEU CPF? ***");
                String cpfDigitado = scan.nextLine();
                Cliente cliente = controller.buscarCliente(cpfDigitado);

                if(cliente != null) {
                    System.out.println("*** DIGITE O NOVO NOME? ***");
                    String novoNome = scan.nextLine();
                    controller.atualizarCliente(novoNome, cliente);
                }else {
                    System.out.println("-------------------");
                    System.out.println("Cliente não encontrado.");
                    System.out.println("-------------------");
                }

            }
            else if (opcao == 5) {

                System.out.println("*** QUAL É O SEU CPF? ***");
                String cpfDigitado = scan.nextLine();
                Cliente cliente = controller.buscarCliente(cpfDigitado);

                if(cliente != null) {
                    controller.removerCliente(cliente);
                    System.out.println("Cliente Removido.");
                }else {
                    System.out.println("-------------------");
                    System.out.println("Cliente não encontrado.");
                    System.out.println("-------------------");
                }

            }
            else if (opcao == 0) {
                System.out.println("-------------------");
                System.out.println("Sistema encerrado");
                System.out.println("-------------------");

                controller.atualizaRepository();
                break;
            }
            else {
                System.out.println("-------------------");
                System.out.println("Opção digitada invalida.");
                System.out.println("-------------------");
            }
        }
    }
}