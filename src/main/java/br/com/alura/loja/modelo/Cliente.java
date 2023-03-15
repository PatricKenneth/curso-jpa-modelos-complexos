package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private DadosPessoais dadosPessoais;

  public Cliente() {
  }

  public Cliente(String nome, String cpf) {
    this.dadosPessoais = new DadosPessoais(nome, cpf);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DadosPessoais getDadosPessoais() {
    return dadosPessoais;
  }

  public void setDadosPessoais(DadosPessoais dadosPessoais) {
    this.dadosPessoais = dadosPessoais;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((dadosPessoais == null) ? 0 : dadosPessoais.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Cliente other = (Cliente) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (dadosPessoais == null) {
      if (other.dadosPessoais != null)
        return false;
    } else if (!dadosPessoais.equals(other.dadosPessoais))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Cliente [id=" + id + ", dadosPessoais=" + dadosPessoais + "]";
  }

}
