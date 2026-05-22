package br.com.crud_clientes.controller;

import br.com.crud_clientes.model.Cliente;
import br.com.crud_clientes.model.Endereco;
import br.com.crud_clientes.repository.ClienteRepository;

import java.util.ArrayList;

public class ClienteController {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    ClienteRepository repository = new ClienteRepository();

    /**
     * Cadastra um novo cliente após validar os dados
     * @param cpf CPF do cliente
     * @param nome Nome completo
     * @param idade Idade do cliente
     * @param endereco Endereço do cliente
     * @return Cliente cadastrado
     * @throws Exception se CPF for vazio ou idade inválida
     **/
    public Cliente cadastrarCliente(String cpf, String nome, int idade, Endereco endereco) throws Exception {

        validaCliente(cpf, idade);
        Cliente novoCliente = new Cliente(cpf, nome, idade, endereco);

        clientes.add(novoCliente);
        repository.addClienteOnRepository(clientes);
        return novoCliente;
    }

    private void validaCliente(String cpf, int idade) throws Exception{
        if (cpf == null || cpf.isEmpty()){
            throw new Exception("CPF não pode ser vazio");
        }
        if (idade < 0 || idade > 120) {
            throw new Exception("Idade inválida");
        }
    }

    /**
     * Busca um cliente após validar os dados
     * @param cpf CPF do cliente
     * @return Cliente cadastrado ou null se não tiver cliente cadastrado
     * @throws Exception se CPF for vazio.
     **/
    public Cliente buscarCliente(String cpf) throws Exception {
        if (cpf == null || cpf.isEmpty()){
            throw new Exception("CPF não pode ser vazio");
        }

        for (Cliente c : clientes){
            if (c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    /**
     * Exibe todos os clientes.
     **/
    public void listarClientes(){
        for (Cliente c : clientes){
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Idade: " + c.getIdade());
            System.out.println("-------------------");
        }
    }

    /**
     * Atualiza o nome do cliente e atualiza o repositório GSON
     * @param novoNome Nome do cliente
     * @param cliente cliente cadastrado
     * @throws Exception se falhar em atualizar o repositório
     **/
    public void atualizarCliente(String novoNome, Cliente cliente) throws Exception{
        cliente.setNome(novoNome);
        repository.addClienteOnRepository(clientes);
    }

    /**
     * Remove um cliente e atualiza o repositório GSON
     * @param cliente cliente cadastrado da lista de clientes
     * @throws Exception se falhar em atualizar o repositório
     **/
    public void removerCliente(Cliente cliente) throws Exception {
        clientes.remove(cliente);
        repository.addClienteOnRepository(clientes);
    }

    /**
     * Atualiza o repositório GSON
     * @throws Exception se falhar em atualizar o repositório
     **/
    public void atualizaRepository () throws Exception {
        repository.addClienteOnRepository(clientes);
    }

    /**
     * Atualiza lista de clientes a partir do repositório GSON.
     * @throws Exception se não conseguir ler o repositório.
     **/
    public void atualizaClientesFromRepository () throws Exception {
        ArrayList<Cliente> clientes = repository.readClienteOnRepository();

        if (clientes != null){
            this.clientes = clientes;
        }
    }
}

