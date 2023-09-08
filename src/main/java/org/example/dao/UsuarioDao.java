package org.example.dao;

import org.example.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDao {

    private ConexionSql sql=new ConexionSql();
    private Connection conn=sql.conectarMySQL();


    public void insertarUsuario(String nombre,String pass){
        String ssql="INSERT INTO usuarios(nombre,pass)values(?,?)";
        try{
            PreparedStatement pstm=conn.prepareStatement(ssql);
            pstm.setString(1,nombre);
            pstm.setString(2,pass);
            pstm.execute();
            
        }catch (SQLException errorSql){
            System.out.println(errorSql.toString());
        }

    }
    public void buscarUsuario(String nombre){
        Usuario usuario;
        String ssql="SELECT *FROM usuarios WHERE nombre=?;";

        try{
            PreparedStatement pstm=conn.prepareStatement(ssql);
            pstm.setString(1,nombre);
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                usuario=new Usuario(rs.getString(2),rs.getString(3));
                System.out.println(usuario);
            }else {
                System.out.println("no se ha encontrado ningun usuario con ese nombre");
            }

        }catch (SQLException errorSql){
            System.out.println(errorSql.toString());
        }
    }

    public ArrayList<Usuario>todosUsuarios(){
        ArrayList<Usuario> usuarios=new ArrayList<>();
        String ssql="SELECT *FROM usuarios";
        try{
            PreparedStatement pstm=conn.prepareStatement(ssql);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                usuarios.add(new Usuario(rs.getString(2),rs.getString(3)));
            }


        }catch (SQLException errorSql){
            System.out.println(errorSql.toString());
        }
        return usuarios;
    }

    public Usuario loginUsuario (String nombre){
        Usuario usuario = null;
        String ssql="SELECT *FROM usuarios where nombre =?";
        try{
            PreparedStatement pstm=conn.prepareStatement(ssql);
            pstm.setString(1,nombre);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()) {
                usuario = new Usuario(rs.getString(2), rs.getString(3));
            }


        }catch (SQLException errorSql){
            System.out.println(errorSql.toString());
        }
        return usuario;
    }
}
