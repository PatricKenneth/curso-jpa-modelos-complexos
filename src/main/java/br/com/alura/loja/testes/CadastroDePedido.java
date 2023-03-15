package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.dto.RelatorioDeVendasDto;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.Helpers;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDePedido {

  public static void main(String[] args) {
    Helpers.popularBancoDeDados();

    EntityManager em = JPAUtil.getEntityManager();
    ProdutoDao produtoDao = new ProdutoDao(em);
    ClienteDao clienteDao = new ClienteDao(em);

    Produto produto = produtoDao.buscarPorId(1l);
    Produto produto2 = produtoDao.buscarPorId(2l);
    Produto produto3 = produtoDao.buscarPorId(3l);
    Cliente cliente = clienteDao.buscarPorId(1l);

    em.getTransaction().begin();

    Pedido pedido = new Pedido(cliente);
    pedido.adicionarItem(new ItemPedido(10, pedido, produto));
    pedido.adicionarItem(new ItemPedido(40, pedido, produto2));

    Pedido pedido2 = new Pedido(cliente);
    pedido2.adicionarItem(new ItemPedido(2, pedido, produto3));

    PedidoDao pedidoDao = new PedidoDao(em);
    pedidoDao.cadastrar(pedido);
    pedidoDao.cadastrar(pedido2);

    em.getTransaction().commit();

    BigDecimal valorVendido = pedidoDao.valorTotalVendido();
    System.out.println("VALOR TOTAL VENDIDO " + valorVendido);

    List<RelatorioDeVendasDto> relatorio = pedidoDao.relatorioDeVendas();
    relatorio.forEach(System.out::println);

  }

}
