package br.com.ayrtonguttier.biblioteca.catalogo.livro;

public class Livro{
    private Integer id;
    private String titulo;

    public Livro(Integer id, String titulo){
        this.id = id;
        this.titulo = titulo;
    }

    public Integer getid(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }
}
