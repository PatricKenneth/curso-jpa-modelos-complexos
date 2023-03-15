package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro extends Produto {

  private String autor;
  private Integer numeroDePaginas;

  public Livro() {
  }

  public Livro(String autor, Integer numeroDePaginas) {
    this.autor = autor;
    this.numeroDePaginas = numeroDePaginas;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public Integer getNumeroDePaginas() {
    return numeroDePaginas;
  }

  public void setNumeroDePaginas(Integer numeroDePaginas) {
    this.numeroDePaginas = numeroDePaginas;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((autor == null) ? 0 : autor.hashCode());
    result = prime * result + ((numeroDePaginas == null) ? 0 : numeroDePaginas.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Livro other = (Livro) obj;
    if (autor == null) {
      if (other.autor != null)
        return false;
    } else if (!autor.equals(other.autor))
      return false;
    if (numeroDePaginas == null) {
      if (other.numeroDePaginas != null)
        return false;
    } else if (!numeroDePaginas.equals(other.numeroDePaginas))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Livro [autor=" + autor + ", numeroDePaginas=" + numeroDePaginas + "]";
  }

}
