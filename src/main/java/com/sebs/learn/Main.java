package com.sebs.learn;

import com.sebs.learn.util.MenuUtil;

import java.util.Scanner;

import static com.sebs.learn.util.Constants.*;

public class Main {
    private static final MenuUtil menuUtil = new MenuUtil();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor a convertir: ");
        double amount = sc.nextDouble();
        sc.nextLine();
        int option = 0;
        while (option != EXIT_OPTION) {
            System.out.println(MENU);
            option = sc.nextInt();
            sc.nextLine();
            if (option == ANOTHER_OPTION) getAnotherCodes(sc, amount);
            else if (option != EXIT_OPTION) System.out.println(menuUtil.validateUserRequest(option, amount));
        }
    }

    private static void getAnotherCodes(Scanner sc, double amount) {
        System.out.println("Ingresa el primer code:");
        String baseCode = sc.nextLine().toUpperCase();
        System.out.println("Ingresa el segundo code:");
        String compareCode = sc.nextLine().toUpperCase();
        System.out.println(menuUtil.validateWithAnotherCodes(baseCode, compareCode, amount));
    }
}