package com.duarte.api_livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duarte.api_livros.entities.Cliente;
import com.duarte.api_livros.exceptions.ClienteException;
import com.duarte.api_livros.exceptions.LivroException;
import com.duarte.api_livros.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void cadastrarCliente(Cliente cliente) {
		 
		if(clienteRepository.existsByCpf(cliente.getCpf())) {
			throw new ClienteException("CPF já cadastrado.");
		};
		
	
		clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		
		if(clientes.isEmpty()) {
			throw new LivroException("Nenhum cliente encontrado");
		}
		
		return clientes;
	}
	
}
