package org.example.controller;

import com.mysql.cj.conf.EnumProperty;
import org.example.dao.UsuarioDao;
import org.example.entity.Usuario;
import org.example.security.Encriptacion;

import java.util.Scanner;

public class LoginController {
    /**
     * Control de login
     *
     * @return un usuario si este es valido
     */
    public Usuario controlarUsuario() {
        Usuario usuario = null;
        boolean valido = false;
        String nombre = "";
        String passPlana = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("usuario");
        nombre = sc.nextLine();

        System.out.println("Contraseña");
        passPlana = sc.nextLine();


        UsuarioDao usuarioDao = new UsuarioDao();
        usuario = usuarioDao.loginUsuario(nombre);
        if (usuario != null) {
            String passEncriptada = usuario.getPass();
            valido = Encriptacion.comprobarPass(passPlana, passEncriptada);
            if (valido) {
                System.out.println("usuario valido");
                return usuario;

            }else{
                usuario=null;
            }
            System.out.println("no valido");

        }
        System.out.println("Usuario o contraseña no validos");
        return usuario;
    }
}