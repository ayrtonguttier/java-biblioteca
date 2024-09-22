package br.com.ayrtonguttier;

import org.postgresql.*;

public class Program{
    public static void main(String[] args){
        Livro l = new Livro("The Lord of the rings: The Fellowship of the ring");
        System.out.println(l.getTitulo());
    }
}
