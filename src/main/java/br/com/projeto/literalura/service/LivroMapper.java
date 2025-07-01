package br.com.projeto.literalura.service;

import br.com.projeto.literalura.model.DadosAutor;
import br.com.projeto.literalura.model.DadosLivro;
import br.com.projeto.literalura.model.Autor;
import br.com.projeto.literalura.model.Livro;

public class LivroMapper {
    public static Livro fromDados(DadosLivro dados) {
        DadosAutor primeiroAutor = dados.authors() != null && !dados.authors().isEmpty()
                ? dados.authors().get(0)
                : new DadosAutor("Desconhecido", null, null);

        Autor autor = new Autor(primeiroAutor.name(), primeiroAutor.birthYear(), primeiroAutor.deathYear());
        String idioma = dados.languages() != null && !dados.languages().isEmpty()
                ? dados.languages().get(0)
                : "desconhecido";

        return new Livro(dados.title(), autor, idioma, dados.downloadCount());
    }
}