package org.example;

import com.sun.security.jgss.GSSUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.controller.LoginController;
import org.example.controller.MenuController;
import org.example.controller.UsuarioController;
import org.example.dao.ConexionSql;
import org.example.dao.UsuarioDao;
import org.example.entity.Usuario;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {


        /**Estoy con hacer la busqueda de todos los usuarios, para eso necesito manejar arraylist en usuariodao **/
        /**
         * usuario:iago
         * Contraseña:A1234a
         */

//
//        LoginController log = new LoginController();
//        Usuario usuario = null;
//        boolean valido=false;
//        int intentos=3;
//        while (intentos>0) {
//                usuario = log.controlarUsuario();
//                System.out.println(usuario);
//                if (usuario != null) {
//                    MenuController usuarioMenu = new MenuController(usuario);
//                    usuarioMenu.menuController();
//                }else{
//                    intentos-=1;
//                    System.out.println("te quedan "+intentos+" intentos");
//                }
//
//            }


            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../views/log.fmxl"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Ayuda");
            stage.setScene(new Scene(root1));


    }}
