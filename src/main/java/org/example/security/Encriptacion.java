package org.example.security;

import com.password4j.Hash;
import com.password4j.HashChecker;
import com.password4j.Password;

import javax.print.attribute.HashAttributeSet;

public class Encriptacion {
    /**
     * Encripta una contraseña utilizando el algoritmo BCrypt
     * @param password
     * @return
     */
    public static String encriptar(String password){
        Hash hash= Password.hash(password).withBcrypt();
        return hash.getResult();
    }

    /**
     * Contrasta la contraseña plana con la que esta guardada en la bbdd
     * @param passPlana
     * @param passEncriptada
     * @return boolean valido
     */
    public static boolean comprobarPass(String passPlana,String passEncriptada){
        return Password.check(passPlana,passEncriptada).withBcrypt();
    }
}
