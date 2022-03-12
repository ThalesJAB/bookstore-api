package br.com.bookstore.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.bookstore.domain.Categoria;
import br.com.bookstore.domain.Livro;
import br.com.bookstore.repositories.CategoriaRepository;
import br.com.bookstore.repositories.LivroRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		
		this.categoriaRepository.save(cat1);
		this.livroRepository.save(l1);
		
		
		
	}

}
