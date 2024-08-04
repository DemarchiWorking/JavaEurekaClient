package com.example.serviceusuarioo.controller;

import com.example.serviceusuarioo.model.Cliente;
import com.example.serviceusuarioo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarCliente() {
        return clienteService.getAllClientes();

    }
    @GetMapping("/{id}")
    public Optional<Cliente> buscarClientePorId(@PathVariable Long id) {
        return clienteService.getClienteById(id);
    }
    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente produto) {
        return clienteService.saveCliente(produto);
    }
    @DeleteMapping("/{id}")
    public void removerCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
    }
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.updateCliente(id, cliente);
    }
}
