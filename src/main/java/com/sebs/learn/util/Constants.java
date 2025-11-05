package com.sebs.learn.util;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final int EXIT_OPTION = 8;
    public static final int ANOTHER_OPTION = 7;
    public static final List<String> SELECTED_CODES = Arrays.asList("COP", "BRL", "ARS", "USD");
    public static final String BASE_URL = "https://v6.exchangerate-api.com/v6/046758f0405c6b64a7d66e4b/";
    public static final String MENU = """
            ****************************************************************
            Sea Bienvenido/a al Conversor de Moneda
            
            1) Dolar =>> Peso argentino
            2) Peso argentino =>> Dolar
            3) Dolar =>> Real brasileño
            4) Real brasileño =>> Dolar
            5) Dolar =>> Peso colombiano
            6) Peso colombiano =>> Dolar
            7) Ingresar Codigos de Moneda Manuales
            8) Salir
            
            Elija una opción válida:
            ****************************************************************
            """;
}
