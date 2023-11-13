package com.codegym.main;

import com.codegym.model.animal.Animal;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.person.visitors.Adult;
import com.codegym.model.person.visitors.Child;
import com.codegym.model.person.visitors.Senior;
import com.codegym.model.person.visitors.Visitor;
import com.codegym.model.ticket.AdultTicket;
import com.codegym.model.ticket.ChildTicket;
import com.codegym.model.ticket.SeniorTicket;
import com.codegym.service.AnimalService;
import com.codegym.service.CageService;
import com.codegym.service.EmployeeService;
import com.codegym.service.VisitorService;

import java.util.Scanner;

public class VisitorFunction implements MainFunction {

    AnimalService animalService = AnimalService.getAnimalService();

    EmployeeService employeeService = EmployeeService.getEmployeeService();

    CageService cageService = CageService.getCageService();

    VisitorService visitorService = VisitorService.getVisitorService();

    @Override
    public void show() {
        System.out.println("=== MENU KHÁCH THAM QUAN ===");
        System.out.println("1. Đặt vé theo độ tuổi");
        System.out.println("2. Đặt tour hướng dẫn");
        System.out.println("3. Thoát về Menu chính");
        Scanner scanner = new Scanner(System.in);
        int inputMenuManagerCustomerSelected = scanner.nextInt();
        switch (inputMenuManagerCustomerSelected) {
            case 1:
                visitorService.addVisitor(getNewVisitor());
                showDetail();
                break;
            case 2:
                System.out.println("2. Đặt tour hướng dẫn");
                break;
            case 3:
                System.out.println("3. Thoát về Menu chính");
                return;
        }

    }



    public void showDetail() {
        while (true) {
            System.out.println("=== MENU KHÁCH THAM QUAN ===");
            System.out.println("1. Xem danh sách thú");
            System.out.println("2. Xem chi tiết thú");
            System.out.println("3. Thăm chuồng thú");
            System.out.println("4. Quay lại menu");
            Scanner scanner = new Scanner(System.in);
            int inputMenuManagerCustomerSelected = scanner.nextInt();
            switch (inputMenuManagerCustomerSelected) {
                case 1:
                    for (Animal animal : animalService.getAnimals()) {
                        System.out.println(animal);
                    }
                    break;
                case 2:
                    System.out.println("AnimalId ID: ");
                    int animalId = scanner.nextInt();
                    Animal animal = animalService.findById(animalId);
                    animal.play();
                    animal.move();
                    animal.makeSound();
                    animal.eat();
                    break;
                case 3:
                    cageService.getCages().stream().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("4. Quay lại menu");
                    return;

            }
        }

    }

    public Visitor getNewVisitor() {
        Visitor visitor = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Thông tin khách thăm quan===");


        int inputVisitorSelected = 1;
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("Street Address: ");
        String streetAddress = scanner.next();
        System.out.println("City: ");
        String city = scanner.next();
        System.out.println("Country: ");
        String country = scanner.next();
        System.out.println("Gender Person in MALE,FEMALE,OTHER: ");
        GenderPerson gender = GenderPerson.valueOf(scanner.next());
        System.out.println("Age: ");
        int age = scanner.nextInt();
        System.out.println("Visitor ID: ");
        String visitorID = scanner.next();
        System.out.println("Age Category in CHILD, ADULT, SENIOR: ");
        AgeCategory ageCategory = AgeCategory.valueOf(scanner.next());
        if (age <= 12) {
            inputVisitorSelected = 1;
        } else if (age <= 64) {
            inputVisitorSelected = 3;
        } else {
            inputVisitorSelected = 2;
        }
        switch (inputVisitorSelected) {
            case 1:
                visitor = new Child(name, streetAddress, city, country, gender, age, visitorID, ageCategory, new ChildTicket());
                break;
            case 2:
                visitor = new Adult(name, streetAddress, city, country, gender, age, visitorID, ageCategory, new AdultTicket());
                break;
            case 3:
                visitor = new Senior(name, streetAddress, city, country, gender, age, visitorID, ageCategory, new SeniorTicket());
                break;
            default:
                break;
        }
        return visitor;
    }


}
