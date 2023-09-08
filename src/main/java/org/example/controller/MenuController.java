package org.example.controller;

import org.example.dao.UsuarioDao;
import org.example.entity.Usuario;
import org.example.views.Menu;

import java.util.Scanner;

public class MenuController {

    Usuario usuario;
    UsuarioController usuarioController;


    public MenuController(Usuario usuario) {
        this.usuario = usuario;
        this.usuarioController=new UsuarioController();

    }

    public void menuController() {
        Scanner sc = new Scanner(System.in);
        int seleccion;
        boolean sesionAbierta = true;
        while (sesionAbierta) {
            Menu.menuPrincipal(usuario.getNombre());
            if (sc.hasNextInt()) {
                seleccion = sc.nextInt();
                if (seleccion < 6 && seleccion >= 0) {
                    opcionMenu(seleccion);
                    if (seleccion == 0) {
                        System.out.println("Saliendo...");
                        sesionAbierta = false;
                    }
                } else {
                    System.out.println("Introduce un número entre 0 y 4");

                }

            } else {
                System.out.println("introduce un digito entre 0 y 4");
                sc.nextLine();
            }


        }


    }

    private void buscartodosUsuarios() {
        usuarioController.todosUsuarios();
    }

    private void buscarUsuario() {
        usuarioController.buscarUSuario();
    }

    private void borrarUsuario() {

    }

    private void registrarUsuario() {
        usuarioController.registrarUsuario();
    }

    private void opcionMenu(int seleccion) {

        switch (seleccion) {

            case 1:
                registrarUsuario();
                break;
            case 2:
                buscartodosUsuarios();
                break;
            case 3:
                buscarUsuario();
                break;
            case 4:
                borrarUsuario();
                break;


            case 0:
                break;
        }
    }
}
