/**
 * 
 */
package org.otojunior.springbootwildfly;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author 01456231650
 *
 */
@Entity
public class Entidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private Long versao;
	
	@Column(nullable = false)
	private Long codigo;

	@Column(nullable = false, length = 20)
	private String nome;

	public Entidade() { }
	
	public Entidade(Long codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Entidade("
			+ "id:" + this.id
			+ ",codigo:" + this.codigo
			+ ",nome:" + this.nome
			+ ")";
	}
}
