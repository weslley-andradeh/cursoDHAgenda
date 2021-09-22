package br.com.agenda.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNasc;
	private String apelido;
	private String telefone;
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Email> emails;
	@OneToMany(mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;
	
	public Contato(String nome, String sobrenome, LocalDate dataNasc, String apelido, String telefone,
			List<Email> emails, List<Endereco> enderecos) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNasc = dataNasc;
		this.apelido = apelido;
		this.telefone = telefone;
		this.emails = emails;
		this.enderecos = enderecos;
	}

	public Contato() {
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}
	
	public void addEmail(Email email) {
		this.emails.add(email);
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void addEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}
}
