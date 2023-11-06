import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.species.*;
import com.codegym.model.person.employee.Accountant;
import com.codegym.model.person.employee.Employee;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.service.AnimalService;
import com.codegym.service.EmployeeService;

import java.util.Scanner;

public class Main {

    AnimalService animalService = new AnimalService();

    EmployeeService employeeService = new EmployeeService();
    public static void main(String[] args) {

        Main main = new Main();
        main.menuMain();
    }

    public void menuMain(){
        while (true){
            System.out.println("=== MENU CHÍNH ===");
            System.out.println("1. Quản lý Owner.");
            System.out.println("2. Chăm sóc chuồng thú.");
            System.out.println("3. Khách tham quan.");
            System.out.println("0. Thoát");
            Scanner scanner = new Scanner(System.in);
            int inputDataMainSelected = scanner.nextInt();
            switch (inputDataMainSelected){
                case 1:
                    menuManagerOwner();
                    break;
                case 2:
                    menuManagerStaff();
                    break;
                case 3:
                   menuManagerCustomer();
                    break;
                case 0:
                    return;
            }
        }
    }
    public void menuManagerOwner(){
            System.out.println("=== MENU QUẢN LÝ OWNER ===");
            System.out.println("1. Quản lý khách tham quan");
            System.out.println("2. Quản lý Nhân viên");
            System.out.println("3. Quản lý Thú");
            System.out.println("4.Thoát về Menu chính");
            Scanner scanner = new Scanner(System.in);
            int inputManagerOwnerSelected = scanner.nextInt();
            switch (inputManagerOwnerSelected){
                case 1:
                    System.out.println("1. Quản lý khách tham quan");
                    break;
                case 2:
                    System.out.println("2. Quản lý Nhân viên");
                    break;
                case 3:
                    menuManagerAnimal();
                    break;
                case 4:
                    return;
        }
    }

    public void menuManagerStaff(){
        System.out.println("=== CHĂM SÓC CHUỒNG THÚ ===");
        System.out.println("1. Danh sách chuồng thú");
        System.out.println("2. Cho thú ăn");
        System.out.println("3. Chăm sóc chuồng");
        System.out.println("4. Xem thông tin Nhân viên của chuồng");
        System.out.println("5. Thoát về Menu chính");
        Scanner scanner = new Scanner(System.in);
        int inputMenuManagerStaffSelected = scanner.nextInt();
        switch (inputMenuManagerStaffSelected){
            case 1:
                System.out.println("1.Danh sách chuồng thú");
                break;
            case 2:
                System.out.println("1. Cho thú ăn");
                break;
            case 3:
                System.out.println("2. Chăm sóc chuồng");
                break;
            case 4:
                System.out.println("3. Xem thông tin Nhân viên");
                break;
            case 5:
                return;
        }
    }

    public void menuManagerCustomer(){
        System.out.println("=== MENU KHÁCH THAM QUAN ===");
        System.out.println("1. Xem danh sách thú");
        System.out.println("2. Đặt vé theo độ tuổi");
        System.out.println("3. Thoát về Menu chính");
        Scanner scanner = new Scanner(System.in);
        int inputMenuManagerCustomerSelected = scanner.nextInt();
        switch (inputMenuManagerCustomerSelected){
            case 1:
                for (Animal animal : animalService.getAnimals()) {
                    System.out.println(animal);
                }
                break;
            case 2:
                System.out.println("2. Đặt vé theo độ tuổi");
                break;
            case 3:
                System.out.println("3. Thoát về Menu chính");
                return;
        }
    }

    public void menuManagerAnimal(){
        System.out.println("=== MENU QUẢN LÝ THÚ ===");
        System.out.println("1.Thêm/Chỉnh sửa thông tin thú");
        System.out.println("2.Quản lý chế độ ăn");
        System.out.println("3.Theo dõi sức khỏe");
        System.out.println("4. Thoát về Menu chính");
        Scanner scanner = new Scanner(System.in);
        int inputMenuManagerAnimalSelected = scanner.nextInt();
        switch (inputMenuManagerAnimalSelected){
            case 1:
                menuAnimal();
                break;
            case 2:
                System.out.println("2.Quản lý chế độ ăn");
                break;
            case 3:
                System.out.println("3.Theo dõi sức khỏe");
                break;
            case 4:
                System.out.println("4. Thoát về Menu chính");
        }
    }

    public void menuManagerEmployee(){

        while (true) {
            System.out.println("=== Quản lý thông tin nhân viên ===");
            System.out.println("1.Danh sách thông tin nhân viên");
            System.out.println("2.Thêm thông tin nhân viên");
            System.out.println("3.Sửa thông tin nhân viên");
            System.out.println("4.Xoá thông tin nhân viên");
            System.out.println("5.Thoát về Menu chính");
            Scanner scanner = new Scanner(System.in);
            int inputMenuAnimalSelected = scanner.nextInt();
            switch (inputMenuAnimalSelected) {
                case 1:
                    for (Employee employee : employeeService.getEmployees()) {
                        System.out.println(employee);
                    }
                    break;
                case 2:
                    employeeService.addEmployee(getNewEmployee());
                    System.out.println("Thêm nhân viên thành công.");
                    break;
                case 3:
                    employeeService.updateEmployee(getNewEmployee());
                    System.out.println("Update nhân viên thành công.");
                    break;
                case 4:
                    System.out.println("Id nhân viên muốn xoá: ");
                    String inputAnimalDeleted = scanner.next();
                    employeeService.removeEmployee(inputAnimalDeleted);
                    System.out.println("Xoá nhân viên thành công.");
                    break;
                case 5:
                    System.out.println("5. Thoát về Menu chính");
                    return;
            }
        }
    }

    public void menuAnimal(){

        while (true) {
            System.out.println("=== Thêm/Chỉnh sửa thông tin thú ===");
            System.out.println("1.Danh sách thông tin thú");
            System.out.println("2.Thêm thông tin thú");
            System.out.println("3.Sửa thông tin thú");
            System.out.println("4.Xoá thông tin thú");
            System.out.println("5.Thoát về Menu chính");
            Scanner scanner = new Scanner(System.in);
            int inputMenuAnimalSelected = scanner.nextInt();
            switch (inputMenuAnimalSelected) {
                case 1:
                    for (Animal animal : animalService.getAnimals()) {
                        System.out.println(animal);
                    }
                    break;
                case 2:
                    animalService.addAnimal(getNewAnimal());
                    System.out.println("Thêm thú thành công.");
                    break;
                case 3:
                    animalService.updateAnimal(getNewAnimal());
                    System.out.println("Update thú thành công.");
                    break;
                case 4:
                    System.out.println("Id thú muốn xoá: ");
                    int inputAnimalDeleted = scanner.nextInt();
                    animalService.removeAnimal(inputAnimalDeleted);
                    System.out.println("Xoá thú thành công.");
                    break;
                case 5:
                    System.out.println("5. Thoát về Menu chính");
                    return;
            }
        }
    }

    public Animal getNewAnimal(){
        Animal animal = null;
        System.out.println("=== Chọn loại thú ===");
        System.out.println("1.Dolphin");
        System.out.println("2.Eagle");
        System.out.println("3.Elephant");
        System.out.println("4.Lion");
        System.out.println("5.Panda");
        System.out.println("6.Seal");
        System.out.println("7.Shark");
        System.out.println("8.Zebra");
        Scanner scanner = new Scanner(System.in);
        int inputAnimalSelected = scanner.nextInt();
        System.out.println("Id:");
        int id = scanner.nextInt();
        System.out.println("Name:");
        String name = scanner.next();
        System.out.println("Species:");
        String species = scanner.next();
        System.out.println("Weight:");
        double weight = scanner.nextDouble();
        System.out.println("Size:");
        double size = scanner.nextDouble();;
        System.out.println("Age:");
        int age = scanner.nextInt();
        System.out.println("Heal Animals in GOOD,\n" +
                "    INJURED,\n" +
                "    SICK;:");
        HealAnimals heal = HealAnimals.valueOf(scanner.next());
        System.out.println("Gender Animals in      MALE,\n" +
                "    FEMALE :");
        GenderAnimals gender = GenderAnimals.valueOf(scanner.next());
        switch (inputAnimalSelected){
            case 1:
                animal = new Dolphin(id,name,species,weight,size,age,heal,gender);
                break;
            case 2:
                animal = new Eagle(id,name,species,weight,size,age,heal,gender);
                break;
            case 3:
                animal = new Elephant(id,name,species,weight,size,age,heal,gender);
                break;
            case 4:
                animal = new Lion(id,name,species,weight,size,age,heal,gender);
                break;
            case 5:
                animal = new Panda(id,name,species,weight,size,age,heal,gender);
                break;
            case 6:
                animal = new Seal(id,name,species,weight,size,age,heal,gender);
                break;
            case 7:
                animal = new Shark(id,name,species,weight,size,age,heal,gender);
                break;
            case 8:
                animal = new Zebra(id,name,species,weight,size,age,heal,gender);
                break;
        }
        return animal;
    }


    public Employee getNewEmployee(){
        Employee employee = null;
        System.out.println("=== Chọn nhân viên ===");
        System.out.println("1.Employee");
        System.out.println("2.Accountant");
        Scanner scanner = new Scanner(System.in);
        int inputAnimalSelected = scanner.nextInt();
        System.out.println("Employee Id:");
        String employeeId = scanner.next();
        System.out.println("Job Position:");
        String jobPosition = scanner.next();
        System.out.println("Salary:");
        double salary = scanner.nextDouble();
        System.out.println("Name:");
        String  name = scanner.next();
        System.out.println("Street Address:");
        String streetAddress = scanner.next();
        System.out.println("City:");
        String city = scanner.next();
        System.out.println("Country:");
        String country = scanner.next();
        System.out.println("Age:");
        int age = scanner.nextInt();
        System.out.println("Gender Person MALE,FEMALE,OTHER :");
        GenderPerson gender = GenderPerson.valueOf(scanner.next());
        switch (inputAnimalSelected){
            case 1:
                employee = new Employee(name,streetAddress,city,country,gender,age,employeeId,jobPosition,salary);
                break;
            case 2:
                employee = new Accountant(name,streetAddress,city,country,gender,age,employeeId,jobPosition,salary);
                break;
        }
        return employee;
    }






}