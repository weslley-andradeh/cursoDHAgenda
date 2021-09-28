package br.com.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.agenda.model.Contato;
import br.com.agenda.model.dto.ContatoInputDto;
import br.com.agenda.repository.ContatoRepository;

@Service
public class ContatoService {
	
	private final ContatoRepository contatoRepository;

	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}
	
	public Contato salvar(ContatoInputDto contatoDto) {
		Contato contato = contatoDto.converte();
		return contatoRepository.save(contato);
	}
	
	public Optional<Contato> buscar(Integer id) {
		 Optional<Contato> contato = contatoRepository.findById(id);
		 return contato;
	}
	
	public List<Contato> buscarTodos() {
		return contatoRepository.findAll();
	}

}
