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
            Connection c = getConnection();
            Statement s = c.createStatement();
            ResultSet result = s.executeQuery(sql);
            ArrayList<Livro> livros = new ArrayList<Livro>();

            while(result.next()){
                Integer id = result.getInt("ID");
                String titulo = result.getString("TITULO");
                Livro item = new Livro(id, titulo);
                livros.add(item);
            }

            return livros;
        }catch(SQLException ex){
            logger.log(Level.SEVERE, "Erro ao consultar livros", ex);
            return new ArrayList<Livro>();
        }
    }

    public void add(Livro l){
        try{
            String sql = "INSERT INTO TB_LIVRO (TITULO) VALUES (?)";
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, l.getTitulo());

            ps.executeUpdate();
        }catch(SQLException ex){
            logger.log(Level.SEVERE, "Erro ao consultar livros", ex);
        }
    }

    public void update(Livro l){
        logger.entering("Repository", "update");
        try{
            Connection c = getConnection();
            String sql = "UPDATE TB_LIVRO SET TITULO = ? WHERE ID = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, l.getTitulo());
            ps.setInt(2, l.getId());
            ps.executeUpdate();
        }catch(SQLException ex){
            logger.log(Level.SEVERE, "Erro ao consultar livros", ex);
        }
    }

    public void deleteByTitulo(String titulo){
        try{
            Connection c = getConnection();
            String sql = "DELETE FROM TB_LIVRO WHERE TITULO = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, titulo);
            ps.executeUpdate();

        }catch(SQLException ex){
            logger.log(Level.SEVERE, "Erro ao consultar livros", ex);
        }
    }


    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url);
    }
}



















