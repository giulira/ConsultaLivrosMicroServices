package br.com.fiap.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bean.Livro;
import br.com.fiap.dao.LivroDAO;

@RestController
public class LivroController {

	@Autowired
	private LivroDAO livroDAO;
	
	
	@RequestMapping(value = "/livros")
	public ResponseEntity<ArrayList<Livro>> list() {
		return new ResponseEntity<ArrayList<Livro>>((ArrayList<Livro>) livroDAO.getAllLivros(), HttpStatus.OK);	
	}
	
	@GetMapping("/livroById/{id}")
	public ResponseEntity<?> find(@PathVariable("id") int id) {

		Livro livro = livroDAO.getLivroById(id);
		if (livro == null) {
			return new ResponseEntity<>("Livro não existe com id: " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Livro>(livro, HttpStatus.OK);
	}
	
	@GetMapping("/livroByAutor/{autor}")
	public ResponseEntity<?> find(@PathVariable("autor") String autor) {
		return new ResponseEntity<ArrayList<Livro>>((ArrayList<Livro>) livroDAO.getLivroByAutor(autor), HttpStatus.OK);	
	}	
	
}
