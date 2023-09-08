package org.example.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextoControl {

    public static boolean sizeText(String nombre,String pass){
        boolean valido=false;
        if((nombre.length()<=30)&&(pass.length()<=8)){
            valido=true;
        }
        return valido;
    }

    public static boolean sizeRegistroNombre(String nombre){
        if(!(nombre.length() <=30)){
            System.out.println("El nombre debe contener menos de 30 caracteres");
        }
        return nombre.length() <= 30;
    }

    public static boolean sizeRegistroPass(String passTextoPlano){
        if(!(passTextoPlano.length() <=8)){
            System.out.println("El nombre debe contener menos de 30 caracteres");
        }
        return passTextoPlano.length() <= 8;
    }

    public static boolean patronRegistroPass(String pass){
        boolean valido=false;
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);

        if (matcher.matches()) {
            System.out.println("El String cumple con el patrón.");
            valido=true;
        } else {
            System.out.println("El String no cumple con el patrón,asegurate que tenga al menos un digito, " +
                    "y una mayuscula");
        }
        return valido;
    }
}
