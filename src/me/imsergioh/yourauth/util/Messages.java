package me.imsergioh.yourauth.util;

import me.imsergioh.yourauth.YourAuth;

public class Messages {

    public static String noValidSession = chatColor("&cTu sesión no es válida.");
    public static String alreadyRegistered = chatColor("&cTu cuenta ya está registrado."),
            passwordNoMatch = chatColor("&cLa contraseña de confirmación no es igual."),
            noRegistered = chatColor("&cTu cuenta no está registrada."),
            register = chatColor("&cRegistrate con: /register <contraseña>"),
            login = chatColor("&cInicia sesión con: /login <contraseña>"),
            loginUsage = chatColor("&cUso correcto: /login <contraseña>"),
            registerUsage = chatColor("&cUso correcto: /register <contraseña> <confirmación de la misma contraseña>"),
            loginSuccessfully = chatColor("&aHas iniciado sesión!");

    public static String chatColor(String text) {
        return text.replace("&", "§");
    }

}
