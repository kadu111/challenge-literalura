package br.com.projeto.literalura.model;

public class Livro {
    private String titulo;
    private Autor autor;
    private String idioma;
    private int downloads;

    public Livro() {}

    public Livro(String titulo, Autor autor, String idioma, int downloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.downloads = downloads;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return "\nTítulo: " + titulo +
                "\nAutor: " + autor +
                "\nIdioma: " + idioma +
                "\nDownloads: " + downloads +
                "\n---------------------------";
    }
}
