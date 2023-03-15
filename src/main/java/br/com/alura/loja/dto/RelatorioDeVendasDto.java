package br.com.alura.loja.dto;

import java.time.LocalDate;

public class RelatorioDeVendasDto {

  private String nomeProduto;
  private Long quantidadeVendida;
  private LocalDate dataUltimaVenda;

  public RelatorioDeVendasDto(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
    this.nomeProduto = nomeProduto;
    this.quantidadeVendida = quantidadeVendida;
    this.dataUltimaVenda = dataUltimaVenda;
  }

  public String getNomeProduto() {
    return nomeProduto;
  }

  public Long getQuantidadeVendida() {
    return quantidadeVendida;
  }

  public LocalDate getDataUltimaVenda() {
    return dataUltimaVenda;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nomeProduto == null) ? 0 : nomeProduto.hashCode());
    result = prime * result + ((quantidadeVendida == null) ? 0 : quantidadeVendida.hashCode());
    result = prime * result + ((dataUltimaVenda == null) ? 0 : dataUltimaVenda.hashCode());
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
    RelatorioDeVendasDto other = (RelatorioDeVendasDto) obj;
    if (nomeProduto == null) {
      if (other.nomeProduto != null)
        return false;
    } else if (!nomeProduto.equals(other.nomeProduto))
      return false;
    if (quantidadeVendida == null) {
      if (other.quantidadeVendida != null)
        return false;
    } else if (!quantidadeVendida.equals(other.quantidadeVendida))
      return false;
    if (dataUltimaVenda == null) {
      if (other.dataUltimaVenda != null)
        return false;
    } else if (!dataUltimaVenda.equals(other.dataUltimaVenda))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
        + ", dataUltimaVenda=" + dataUltimaVenda + "]";
  }

}
