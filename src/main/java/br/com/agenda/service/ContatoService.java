package br.com.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.agenda.model.Contato;
import br.com.agenda.model.Email;
import br.com.agenda.model.Endereco;
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

	public Contato adicionaEmail(Integer id, Email email) {
		Contato contato = contatoRepository.getById(id);
		email.setContato(contato);
		contato.addEmail(email);

		return contatoRepository.save(contato);
	}
	
	public Contato adicionaEndereco(Integer id, Endereco endereco) {
		Contato contato = contatoRepository.getById(id);
		endereco.setContato(contato);
		contato.addEndereco(endereco);

		return contatoRepository.save(contato);
	}

}
