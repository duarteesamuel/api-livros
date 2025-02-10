package com.duarte.api_livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duarte.api_livros.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
