package com.duarte.api_livros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duarte.api_livros.entities.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
	
	List<Aluguel> findByClienteId(Long clienteId);
}
