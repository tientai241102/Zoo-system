package com.codegym.main;

import com.codegym.model.animal.Animal;

import java.util.Scanner;

public class AccountantFunction implements MainFunction{
    @Override
    public void show() {
        System.out.println("===  MENU THU NGÂN ===");
        System.out.println("1. Bán vé");
        System.out.println("2. Quản lý vé đã bán");
        System.out.println("3. Thoát về Menu chính");
        Scanner scanner = new Scanner(System.in);
        int inputMenuManagerCustomerSelected = scanner.nextInt();
        switch (inputMenuManagerCustomerSelected) {
            case 1:
                System.out.println("1. Bán vé");
                break;
            case 2:
                System.out.println("2. Quản lý vé đã bán");
                break;
            case 3:
                System.out.println("3. Thoát về Menu chính");
                return;
        }
    }
}
