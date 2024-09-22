package br.com.ayrtonguttier.biblioteca.catalogo.livro;

import java.util.ArrayList;
import java.util.logging.*;
import java.sql.*;

public class Repository {
    public final String format = "jdbc:postgresql://%s/%s?user=%s&password=%s&ssl=false";
    public final String host = "localhost";
    public final String database = "biblioteca";

    public final String user = "usuario";
    public final String password = "senha";

    public String url;
    public Logger logger;

    public Repository(){
        this.url = String.format(format, host, database, user, password); 
        this.logger = Logger.getLogger(this.getClass().getName());
    }

    public ArrayList<Livro> getAll(){
        try{
            String sql = "select * from TB_LIVRO";
            Connection c = DriverManager.getConnection(url);
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);
            ArrayList<Livro> livros = new ArrayList<Livro>();

            while(result.next()){
                Integer id = result.getInt("ID");
                String titulo = result.getString("TITULO");
                livros.add(new Livro(id, titulo));
            }

            return livros;
        }catch(SQLException ex){
            logger.log(Level.SEVERE, "Erro ao consultar livros", ex);
            return new ArrayList<Livro>();
        }
    }

}
