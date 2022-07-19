package br.com.bookstore.service;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import br.com.bookstore.domain.Categoria;
import br.com.bookstore.domain.Livro;
import br.com.bookstore.repositories.CategoriaRepository;
import br.com.bookstore.repositories.LivroRepository;


@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBasedeDados() {
		
		Lorem lorem = LoremIpsum.getInstance();
		String loremIpsum = lorem.getParagraphs(25, 25);
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção científica");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");
				
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", loremIpsum, cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", loremIpsum, cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G. Wells", loremIpsum, cat2);
		Livro l4 = new Livro(null, "The War of the Worlds", "H.G. Wells", loremIpsum, cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", loremIpsum, cat2);
				
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));
				
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
