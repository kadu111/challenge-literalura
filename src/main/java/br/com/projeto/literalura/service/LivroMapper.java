package br.com.projeto.literalura.service;

import br.com.projeto.literalura.model.DadosAutor;
import br.com.projeto.literalura.model.DadosLivro;
import br.com.projeto.literalura.model.Autor;
import br.com.projeto.literalura.model.Livro;

public class LivroMapper {

    public static Livro fromDados(DadosLivro dados) {
        // Trata autor nulo ou lista vazia
        DadosAutor primeiroAutor = (dados.authors() != null && !dados.authors().isEmpty())
                ? dados.authors().get(0)
                : new DadosAutor("Autor Desconhecido", null, null);

        Autor autor = new Autor(
                primeiroAutor.name() != null ? primeiroAutor.name() : "Autor Desconhecido",
                primeiroAutor.birthYear(),
                primeiroAutor.deathYear()
        );

        // Trata idioma nulo ou lista vazia
        String idioma = (dados.languages() != null && !dados.languages().isEmpty())
                ? dados.languages().get(0)
                : "idioma_desconhecido";

        return new Livro(
                dados.title() != null ? dados.title() : "Título Desconhecido",
                autor,
                idioma,
                dados.downloadCount()
        );
    }
}
