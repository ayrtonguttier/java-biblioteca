package br.com.ayrtonguttier.biblioteca;

import org.postgresql.*;
import br.com.ayrtonguttier.biblioteca.catalogo.livro.*;
import java.util.ArrayList;
import java.util.logging.*;

public class Program{
    public static void main(String[] args){
        try{
            Logger logger = Logger.getLogger(Program.class.getName());
            logger.info("Iniciando processamento");

            Repository r = new Repository();
            ArrayList<Livro> livros = r.getAll();
            for(Livro l : livros){
                System.out.println(l.getTitulo());
            }

        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
