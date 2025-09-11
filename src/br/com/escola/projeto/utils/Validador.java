package br.com.escola.projeto.utils;

import java.util.regex.Pattern;

public class Validador {

    public static boolean isNullOrEmpty(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    public static boolean isNumeric(String valor) {
        if (isNullOrEmpty(valor)) return false;
        return valor.matches("\\d+");
    }

    public static boolean isEmailValido(String email) {
        if (isNullOrEmpty(email)) return false;
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(regex, email);
    }

    public static boolean isCpfValido(String cpf) {
        if (isNullOrEmpty(cpf)) return false;
        String regex = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        return Pattern.matches(regex, cpf);
    }
}

