package StudentManagement;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        boolean exit = false;
        Controller controller = new Controller();
        int id;
        showMenu();
        while(true){
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    controller.addStudent();
                    break;
                case 2:
                    System.out.println("Text ID: ");
                    do{
                        id = scanner.nextInt();
                        if(id < 0){
                            System.out.println("Invalid ID! Text again.");
                        }
                    }
                    while (id < 0);
                    controller.editStudent(id);
                    break;
                case 3:
                    System.out.println("Text ID: ");
                    do{
                        id = scanner.nextInt();
                        if(id < 0){
                            System.out.println("Invalid ID! Text again.");
                        }
                    }
                    while (id < 0);
                    controller.deleteStudent(id);
                    break;
                case 4:
                    controller.sortByGPA();
                    break;
                case 5:
                    controller.sortByName();
                    break;
                case 6:
                    controller.show();
                    break;
                case 0:
                    System.out.println("Thank you !");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid number !");
            }
            if(exit == true)
                break;
            showMenu();
        }
    }

    public static void showMenu(){
        System.out.println("================MENU================");
        System.out.println("1. Add student.");
        System.out.println("2. Edit student's information.");
        System.out.println("3. Delete student.");
        System.out.println("4. Sort student by GPA.");
        System.out.println("5. Sort student by name.");
        System.out.println("6. Show students' information.");
        System.out.println("0. Exit.");
        System.out.println("Please choose: ");
    }
}
