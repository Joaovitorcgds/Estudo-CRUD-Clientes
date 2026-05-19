package br.com.crud_clientes.controller;

import br.com.crud_clientes.model.Cliente;
import br.com.crud_clientes.model.Endereco;
import br.com.crud_clientes.repository.ClienteRepository;

import java.util.ArrayList;

public class ClienteController {

    private ArrayList<Cliente> clientes = new ArrayList<>();
    ClienteRepository repository = new ClienteRepository();

    public Cliente cadastrarCliente(String cpf, String nome, int idade, Endereco endereco) throws Exception {
        Cliente novoCliente = new Cliente(cpf, nome, idade, endereco);

        clientes.add(novoCliente);
        repository.addClienteOnRepository(clientes);
        return novoCliente;
    }

    public Cliente buscarCliente(String cpf){
        for (Cliente c : clientes){
            if (c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    public void listarClientes(){
        for (Cliente c : clientes){
            System.out.println("Nome: " + c.getNome());
            System.out.println("CPF: " + c.getCpf());
            System.out.println("Idade: " + c.getIdade());
            System.out.println("-------------------");
        }
    }

    public void atualizarCliente(String novoNome, Cliente cliente) throws Exception{
        cliente.setNome(novoNome);
        repository.addClienteOnRepository(clientes);
    }

    public void removerCliente(Cliente cliente) throws Exception {
        clientes.remove(cliente);
        repository.addClienteOnRepository(clientes);
    }

    public void atualizaRepository () throws Exception {
        repository.addClienteOnRepository(clientes);
    }

    public void atualizaClientesFromRepository () throws Exception {
        ArrayList<Cliente> clientes = repository.readClienteOnRepository();

        if (clientes != null){
            this.clientes = clientes;
        }
    }
}

