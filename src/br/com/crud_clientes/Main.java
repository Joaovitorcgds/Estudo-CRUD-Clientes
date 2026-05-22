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
                String cpfDigitado;
                String nome;
                int idade;
                String rua;
                String cidade;
                String cep;

                System.out.println("*** QUAL É O SEU CPF? ***");
                cpfDigitado = scan.nextLine();

                // Verifica se o CPF já existe antes de cadastrar
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

                    try {
                        controller.cadastrarCliente(cpfDigitado, nome, idade, endereco);
                        System.out.println("Cliente " + nome + " Cadastrado(a).");
                    } catch (Exception e){
                        System.out.println("Error:" + e.getMessage());
                    }
                } else {
                    System.out.println("Cliente cadastrado");
                    System.out.println("-------------------");
                }

            }
            else if (opcao == 2) {
                // LISTA TODOS OS CLIENTES CADASTRADOS.
                controller.listarClientes();
            }
            else if (opcao == 3) {

                System.out.println("-------------------");
                System.out.println("Digite o CPF do cliente.");

                String cpf = scan.nextLine();
                //BUSCA UM CLIENTE A PARTIR DO CPF
                Cliente res = controller.buscarCliente(cpf);

                //EXIBE CLIENTE SE ENCONTRAR
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
                //BUSCA UM CLIENTE A PARTIR DO CPF
                Cliente cliente = controller.buscarCliente(cpfDigitado);

                //EDITA O NOME DO CLIENTE SE ENCONTRAR
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

                //APAGA O CLIENTE SE ENCONTRAR
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
                // ENCERRA O PROGRAMA
                System.out.println("-------------------");
                System.out.println("Sistema encerrado");
                System.out.println("-------------------");

                controller.atualizaRepository();
                break;
            }
            else {
                // INFORMA OPÇÃO INVALIDA
                System.out.println("-------------------");
                System.out.println("Opção digitada invalida.");
                System.out.println("-------------------");
            }
        }
    }
}