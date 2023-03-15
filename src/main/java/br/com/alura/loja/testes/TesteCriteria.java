package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class TesteCriteria {

  public static void main(String[] args) {
    popularBancoDeDados();
    EntityManager em = JPAUtil.getEntityManager();
    ProdutoDao produtoDao = new ProdutoDao(em);
    produtoDao.buscarPorParametrosComCriteria(null, null, LocalDate.now());
  }

  private static void popularBancoDeDados() {
    Categoria celulares = new Categoria("CELULARES");
    Categoria videogames = new Categoria("VIDEOGAMES");
    Categoria informatica = new Categoria("INFORMATICA");

    Produto celular = new Produto("Xiaomi Redmi", "Muito legal", BigDecimal.valueOf(800), celulares);
    Produto videogame = new Produto("PS5", "Playstation 5", BigDecimal.valueOf(4999), videogames);
    Produto macbook = new Produto("Macbook", "Macbook PRO", BigDecimal.valueOf(7999), informatica);

    EntityManager em = JPAUtil.getEntityManager();
    ProdutoDao produtoDao = new ProdutoDao(em);
    CategoriaDao categoriaDao = new CategoriaDao(em);

    em.getTransaction().begin();

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
