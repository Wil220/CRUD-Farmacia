package com.wilker.crud_farmacia.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "O Atributo Nome é Obrigatório!")
	private String nome;
	
	@NotBlank(message = "O atributo descrição é obrigatorio!")
	@Size(min = 50, max = 255, message = "O atraibuto descrição deve conter no minumo 50 e no máximo 255 caracteres")
	private String descricao;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	  public @NotBlank(message = "O atributo nome é Obrigatório!") String getName() {
	        return nome;
	    }
	  
	   public void setName(@NotBlank(message = "O atributo nome é Obrigatório!") String name) {
	        this.nome = name;
	   }
	   
	    public @NotBlank(message = "O atributo descrição é Obrigatório!") String getDescription() {
	        return descricao;
	    }

	    public void setDescription(@NotBlank(message = "O atributo descrição é Obrigatório!") String description, @NotBlank(message = "O atributo descrição é obrigatorio!") @Size(min = 50, max = 255, message = "O atraibuto descrição deve conter no minumo 50 e no máximo 255 caracteres") String descricao) {
	        this.descricao = descricao;
}
	    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "categoria", cascade = CascadeType.REMOVE)
	    @JsonIgnoreProperties("categoria")
	    private List<Produto> produto;

	    public List<Produto> getProduto() {
	        return produto;
	    }

	    public void setProduto(List<Produto> produto) {
	        this.produto = produto;
	    }
	}