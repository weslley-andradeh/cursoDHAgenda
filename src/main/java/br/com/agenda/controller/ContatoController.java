package br.com.agenda.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agenda.model.Contato;
import br.com.agenda.model.dto.ContatoInputDto;
import br.com.agenda.service.ContatoService;

@RestController
@RequestMapping("contatos/")
public class ContatoController {

	private final ContatoService contatoService;

	public ContatoController(ContatoService contatoService) {
		this.contatoService = contatoService;
	}
	
	@PostMapping
	public ResponseEntity<Contato> criar(@RequestBody ContatoInputDto contatoDto) {
		Contato contato = contatoService.salvar(contatoDto);
		URI uri = UriComponentsBuilder.fromPath("contato/{id}").buildAndExpand(contato.getId()).toUri();
		return ResponseEntity.created(uri).body(contato);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
		Optional<Contato> contato = contatoService.buscar(id);
		
		if (contato.isPresent()){
            return ResponseEntity.ok().body(contato);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado");
	}
	
	@GetMapping
	public List<Contato> buscarTodos(){
		return contatoService.buscarTodos();
	}

}
