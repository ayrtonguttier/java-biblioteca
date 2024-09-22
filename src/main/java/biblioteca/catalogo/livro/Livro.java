package br.com.ayrtonguttier.biblioteca.catalogo.livro;
import java.io.StringWriter;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Livro{
    private Integer id;
    private String titulo;
    private final String MODELO = "Id: %d Titulo: %s";

    public Livro(Integer id, String titulo){
        this.id = id;
        this.titulo = titulo;
    }

    public Integer getId(){
        return this.id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void write(OutputStream out){
        PrintWriter p = new PrintWriter(out, true);
        p.println(String.format(MODELO, this.getId(), this.getTitulo()));
    }
}
