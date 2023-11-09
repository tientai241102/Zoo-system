package com.codegym.main;

import java.util.Scanner;

public class MainActivity {

    private static MainActivity mainActivity;

    private MainActivity() {
    }

    public static MainActivity getInstanceMainActivity() {
        if (mainActivity == null) {
            mainActivity = new MainActivity();
        }
        return mainActivity;
    }

    public void showMainActivity() {
        while (true) {
            System.out.println("=== MENU CHÍNH ===");
            System.out.println("1. Đăng nhập Owner.");
            System.out.println("2. Đăng nhập Zookeeper.");
            System.out.println("3. Đăng nhập Thu ngân.");
            System.out.println("4. Khách tham quan.");
            System.out.println("0. Khách tham quan.");
            Scanner scanner = new Scanner(System.in);
            int inputDataMainSelected = scanner.nextInt();
            ScreenActivity screenActivity = null;
            switch (inputDataMainSelected) {
                case 1:
                    screenActivity = new OwnerScreenActivity();
                    break;
                case 2:
                    screenActivity = new ZookeeperScreenActivity();
                    break;
                case 3:
                    screenActivity = new AccountantScreenActivity();
                    break;
                case 4:
                    screenActivity = new VisitorScreenActivity();
                    break;
                case 0:
                    return;

            }
            if (screenActivity != null) {
                screenActivity.renderWindow();
            }
        }
    }
}
