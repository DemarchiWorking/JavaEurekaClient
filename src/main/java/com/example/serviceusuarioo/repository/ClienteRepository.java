package com.example.serviceusuarioo.repository;

import com.example.serviceusuarioo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
