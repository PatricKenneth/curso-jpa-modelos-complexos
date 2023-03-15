package br.com.alura.loja.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.Produto;

public class Helpers {

  public static void popularBancoDeDados() {
    Categoria celulares = new Categoria("CELULARES");
    Categoria videogames = new Categoria("VIDEOGAMES");
    Categoria informatica = new Categoria("INFORMATICA");

    Produto celular = new Produto("Xiaomi Redmi", "Muito legal", BigDecimal.valueOf(800), celulares);
    Produto videogame = new Produto("PS5", "Playstation 5", BigDecimal.valueOf(4999), videogames);
    Produto macbook = new Produto("Macbook", "Macbook PRO", BigDecimal.valueOf(7999), informatica);

    Cliente cliente = new Cliente("Patric Kenneth", "12345678901");

    EntityManager em = JPAUtil.getEntityManager();
    ClienteDao clienteDao = new ClienteDao(em);
    ProdutoDao produtoDao = new ProdutoDao(em);
    CategoriaDao categoriaDao = new CategoriaDao(em);

    em.getTransaction().begin();

    clienteDao.cadastrar(cliente);
    categoriaDao.cadastrar(celulares);
    categoriaDao.cadastrar(videogames);
    categoriaDao.cadastrar(informatica);
    produtoDao.cadastrar(celular);
    produtoDao.cadastrar(videogame);
    produtoDao.cadastrar(macbook);

    em.getTransaction().commit();
    em.close();
  }

}
