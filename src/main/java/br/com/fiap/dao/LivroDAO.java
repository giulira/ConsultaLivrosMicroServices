package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.fiap.bean.Livro;

@Component
public class LivroDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Livro> getAllLivros() {
		String hql = "FROM livros as liv ORDER BY liv.titulo";
		return (List<Livro>) entityManager.createQuery(hql).getResultList();
	}

	public Livro getLivroById(int livroId) {
		System.out.println(entityManager.find(Livro.class, livroId));
		return entityManager.find(Livro.class, livroId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> getLivroByAutor(String autor) {
		String hql = "FROM livros as liv where liv.autor ='" + autor +"'";
		return (List<Livro>) entityManager.createQuery(hql).getResultList();
	}	
}
