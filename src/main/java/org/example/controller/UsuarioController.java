package org.example.controller;

import org.example.dao.UsuarioDao;
import org.example.entity.Usuario;
import org.example.security.Encriptacion;
import org.example.utilidades.TextoControl;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioController {

    Usuario usuario;

    public UsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioController() {
    }

    public void registrarUsuario() {
        UsuarioDao usuarioNuevo = new UsuarioDao();
        Encriptacion encriptacion = null;
        String nombre;
        String pass = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre de usuario");
        nombre = sc.nextLine();
        System.out.println(nombre.length());
        System.out.println("Introduce pass");
        String textoPlanoPass = sc.nextLine();
        if (TextoControl.sizeRegistroNombre(nombre)
                && TextoControl.sizeRegistroPass(textoPlanoPass)
                && TextoControl.patronRegistroPass(textoPlanoPass)) {
            System.out.println("registrado");
            pass = Encriptacion.encriptar(textoPlanoPass);
            usuarioNuevo.insertarUsuario(nombre, pass);
        }

        sc.close();
    }

    public void todosUsuarios() {
        UsuarioDao usuarioNuevo = new UsuarioDao();
        ArrayList<Usuario> usuarios = usuarioNuevo.todosUsuarios();
        for (Usuario a : usuarios) {
            System.out.println("nombre:" + a.getNombre());
        }
    }

    public void buscarUSuario() {
        UsuarioDao usuarioNuevo = new UsuarioDao();
        String nombre;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce nombre de usuario");
        nombre = sc.nextLine();
        usuarioNuevo.buscarUsuario(nombre);

    }
}
