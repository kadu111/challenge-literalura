package br.com.projeto.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(
        @JsonAlias("title") String title,
        @JsonAlias("id") int id,
        @JsonAlias("authors") List<DadosAutor> authors,
        @JsonAlias("translators") List<DadosAutor> translators,      // caso precise depois
        @JsonAlias("subjects") List<String> subjects,
        @JsonAlias("bookshelves") List<String> bookshelves,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") int downloadCount,
        @JsonAlias("formats") Object formats                            // formatos complexos, pode ser Map<String,String> se quiser detalhar
) {}
