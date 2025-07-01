package br.com.projeto.literalura.dto;

import java.util.List;

public record BookDTO(
        String title,
        int id,
        List<String> languages,
        List<AuthorDTO> authors,
        int downloadCount)
{}
