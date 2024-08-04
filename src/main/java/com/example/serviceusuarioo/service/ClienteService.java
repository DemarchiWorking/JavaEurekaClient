package com.example.serviceusuarioo.service;

import com.example.serviceusuarioo.model.Cliente;
import com.example.serviceusuarioo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> getClienteById(long id){
        return clienteRepository.findById(id);
    }
    public Cliente saveCliente(Cliente produto){
        return clienteRepository.save(produto);
    }
    public void deleteCliente(long id){
        clienteRepository.deleteById(id);
    }

    public Cliente updateCliente(Long id, Cliente clienteDetalhes) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() ->  new NoSuchElementException("Não foi encontrado um cliente com o id " + id));

        cliente.setNome(clienteDetalhes.getNome());
        cliente.setEmail(clienteDetalhes.getEmail());
        cliente.setSenha(clienteDetalhes.getSenha());
        cliente.setTelefone(clienteDetalhes.getTelefone());

        Cliente updatedCliente = clienteRepository.save(cliente);
        return updatedCliente;
    }
}
