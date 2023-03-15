package br.com.alura.loja.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "informatica")
public class Informatica extends Produto {

  private String marca;
  private Integer modelo;

  public Informatica() {
  }

  public Informatica(String marca, Integer modelo) {
    this.marca = marca;
    this.modelo = modelo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public Integer getModelo() {
    return modelo;
  }

  public void setModelo(Integer modelo) {
    this.modelo = modelo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((marca == null) ? 0 : marca.hashCode());
    result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
    Informatica other = (Informatica) obj;
    if (marca == null) {
      if (other.marca != null)
        return false;
    } else if (!marca.equals(other.marca))
      return false;
    if (modelo == null) {
      if (other.modelo != null)
        return false;
    } else if (!modelo.equals(other.modelo))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Informatica [marca=" + marca + ", modelo=" + modelo + "]";
  }

}
