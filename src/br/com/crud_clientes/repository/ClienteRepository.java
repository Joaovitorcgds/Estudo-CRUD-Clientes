package br.com.crud_clientes.repository;

import br.com.crud_clientes.model.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class ClienteRepository {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void addClienteOnRepository(ArrayList<Cliente> clientes) throws Exception{

        try (Writer writer = new FileWriter("src/clientes.json")) {
            gson.toJson(clientes, writer);
            writer.close();
            System.out.println("Clientes armazenado com sucesso!");

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cliente> readClienteOnRepository() throws Exception{

        try (Reader reader = new FileReader("src/clientes.json")) {
            ArrayList<Cliente> clientesRepository = gson.fromJson(
                    reader,
                    new TypeToken<ArrayList<Cliente>>() {}.getType());
            reader.close();

            return clientesRepository;

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
