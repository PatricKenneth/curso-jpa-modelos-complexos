package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "valor_total")
  private BigDecimal valorTotal = BigDecimal.ZERO;
  private LocalDate data = LocalDate.now();

  @ManyToOne(fetch = FetchType.LAZY)
  private Cliente cliente;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<ItemPedido> itens = new ArrayList<>();

  public Pedido() {
  }

  public Pedido(Cliente cliente) {
    this.cliente = cliente;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<ItemPedido> getItens() {
    return itens;
  }

  public void setItens(List<ItemPedido> itens) {
    this.itens = itens;
  }

  public void adicionarItem(ItemPedido item) {
    item.setPedido(this);
    this.itens.add(item);
    this.valorTotal = this.valorTotal.add(item.getValor());
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((valorTotal == null) ? 0 : valorTotal.hashCode());
    result = prime * result + ((data == null) ? 0 : data.hashCode());
    result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
    result = prime * result + ((itens == null) ? 0 : itens.hashCode());
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
    Pedido other = (Pedido) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (valorTotal == null) {
      if (other.valorTotal != null)
        return false;
    } else if (!valorTotal.equals(other.valorTotal))
      return false;
    if (data == null) {
      if (other.data != null)
        return false;
    } else if (!data.equals(other.data))
      return false;
    if (cliente == null) {
      if (other.cliente != null)
        return false;
    } else if (!cliente.equals(other.cliente))
      return false;
    if (itens == null) {
      if (other.itens != null)
        return false;
    } else if (!itens.equals(other.itens))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Pedido [id=" + id + ", valorTotal=" + valorTotal + ", data=" + data + ", cliente=" + cliente + ", itens="
        + itens + "]";
  }

}
