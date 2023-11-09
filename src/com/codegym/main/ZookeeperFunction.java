package com.codegym.main;

import com.codegym.model.Cage.Cage;
import com.codegym.service.CageService;

import java.util.Scanner;

public class ZookeeperFunction implements MainFunction{

    CageService cageService = new CageService();
    @Override
    public void show() {

            System.out.println("=== CHĂM SÓC CHUỒNG THÚ ===");
            System.out.println("1. Danh sách chuồng thú");
            System.out.println("2. Cho thú ăn");
            System.out.println("3. Chăm sóc chuồng");
            System.out.println("4. Xem thông tin Nhân viên của chuồng");
            System.out.println("5. Quản lý lịch làm việc");
            System.out.println("6. Thoát về Menu chính");
            Scanner scanner = new Scanner(System.in);
            int inputMenuManagerStaffSelected = scanner.nextInt();
            switch (inputMenuManagerStaffSelected){
                case 1:
                    for (Cage cage: cageService.getCages()){
                        System.out.println(cage);
                    }
                    break;
                case 2:
                    System.out.println("2. Cho thú ăn");
                    break;
                case 3:
                    System.out.println("3. Chăm sóc chuồng");
                    break;
                case 4:
                    System.out.println("4. Xem thông tin Nhân viên của chuồng");
                    break;
                case 5:
                    System.out.println("5. Quản lý lịch làm việc");
                    break;
                case 6:
                    return;
            }

    }
}
