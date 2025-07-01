package br.com.projeto.literalura.model;

public class Autor {
    private String nome;
    private Integer nascimento;
    private Integer falecimento;

    public Autor() {}

    public Autor(String nome, Integer nascimento, Integer falecimento) {
        this.nome = (nome != null && !nome.isBlank()) ? nome : "Autor Desconhecido";
        this.nascimento = nascimento;
        this.falecimento = falecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = (nome != null && !nome.isBlank()) ? nome : "Autor Desconhecido";
    }

    public Integer getNascimento() {
        return nascimento;
    }

    public void setNascimento(Integer nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getFalecimento() {
        return falecimento;
    }

    public void setFalecimento(Integer falecimento) {
        this.falecimento = falecimento;
    }

    @Override
    public String toString() {
        String vida = "";
        if (nascimento != null || falecimento != null) {
            vida = " (" +
                    (nascimento != null ? nascimento : "?") + " - " +
                    (falecimento != null ? falecimento : "?") + ")";
        }

        return nome + vida;
    }
}
