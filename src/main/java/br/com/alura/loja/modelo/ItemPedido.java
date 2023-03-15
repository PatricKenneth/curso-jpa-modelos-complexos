package br.com.alura.loja.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "preco_unitario")
  private BigDecimal precoUnitario;
  private Integer quantidade;

  @ManyToOne(fetch = FetchType.LAZY)
  private Pedido pedido;

  @ManyToOne(fetch = FetchType.LAZY)
  private Produto produto;

  public ItemPedido() {
  }

  public ItemPedido(Integer quantidade, Pedido pedido, Produto produto) {
    this.quantidade = quantidade;
    this.pedido = pedido;
    this.precoUnitario = produto.getPreco();
    this.produto = produto;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getPrecoUnitario() {
    return precoUnitario;
  }

  public void setPrecoUnitario(BigDecimal precoUnitario) {
    this.precoUnitario = precoUnitario;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((precoUnitario == null) ? 0 : precoUnitario.hashCode());
    result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
    result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
    result = prime * result + ((produto == null) ? 0 : produto.hashCode());
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
    ItemPedido other = (ItemPedido) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (precoUnitario == null) {
      if (other.precoUnitario != null)
        return false;
    } else if (!precoUnitario.equals(other.precoUnitario))
      return false;
    if (quantidade == null) {
      if (other.quantidade != null)
        return false;
    } else if (!quantidade.equals(other.quantidade))
      return false;
    if (pedido == null) {
      if (other.pedido != null)
        return false;
    } else if (!pedido.equals(other.pedido))
      return false;
    if (produto == null) {
      if (other.produto != null)
        return false;
    } else if (!produto.equals(other.produto))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ItemPedido [id=" + id + ", precoUnitario=" + precoUnitario + ", quantidade=" + quantidade + ", pedido="
        + pedido + ", produto=" + produto + "]";
  }

  public BigDecimal getValor() {
    return this.precoUnitario.multiply(BigDecimal.valueOf(this.quantidade));
  }

}
