package br.com.projeto.literalura.dto;

import br.com.projeto.literalura.model.DadosLivro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GutendexResponse(
        int count,
        String next,
        String previous,
        @JsonAlias("results") List<DadosLivro> results
) {}
