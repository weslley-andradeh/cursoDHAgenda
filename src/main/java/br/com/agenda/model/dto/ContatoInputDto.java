package br.com.agenda.model.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.agenda.model.Contato;
import br.com.agenda.model.Email;
import br.com.agenda.model.Endereco;

public class ContatoInputDto {

	private String nome;
	private String sobrenome;
	private LocalDate dataNasc;
	private String apelido;
	private String telefone;
	private List<Email> emails;
	private List<Endereco> enderecos;

	public ContatoInputDto(String nome, String sobrenome, LocalDate dataNasc, String apelido, String telefone,
			List<Email> emails, List<Endereco> enderecos) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNasc = dataNasc;
		this.apelido = apelido;
		this.telefone = telefone;
		this.emails = emails;
		this.enderecos = enderecos;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public String getApelido() {
		return apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public Contato converte() {
		Contato contato = new Contato(nome, sobrenome, dataNasc, apelido, telefone, null, null);
		if (emails != null) {
			emails.forEach(e -> contato.addEmail(e));
		}

		if (enderecos != null) {
			enderecos.forEach(e -> contato.addEndereco(e));
		}

		return contato;
	}

}
