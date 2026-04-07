package br.com.controller;
import br.com.model.Cliente;
import br.com.controller.ClienteRepository;

import java.util.ArrayList;

public class ClienteController {

    public ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Cliente> updateClientes (ArrayList<Cliente> clientes){
        this.clientes = clientes;
        return clientes;
    }

    public Cliente cadastrarCliente(String cpf, String nome, int idade){
        Cliente novoCliente = new Cliente(cpf, nome, idade);

        clientes.add(novoCliente);
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

    public void removerCliente(Cliente cliente) {clientes.remove(cliente);}
}

