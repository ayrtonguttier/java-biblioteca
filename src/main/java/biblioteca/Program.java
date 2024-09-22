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

            r.deleteByTitulo("Harry Potter");
            r.add(new Livro(0, "Harry Potter"));

            ArrayList<Livro> livros = r.getAll();
            for(Livro l : livros){
                Livro n;
                switch(l.getId()){
                    case 1:
                        n = new Livro(l.getId(), "The lord of the rings: The fellowship of the ring");
                        break;
                    case 2:
                        n = new Livro(l.getId(), "The lord of the rings: The two towers");
                        break;
                    case 3:
                        n = new Livro(l.getId(), "The lord of the rings: The return of the king");
                        break;
                    default:
                        n = l;
                }


                r.update(n);
                n.write(System.out);
            }
        

        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
