package StudentManagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Controller {

    public static Scanner scanner = new Scanner(System.in);
    private ArrayList <Student> studentList;
    private StudentFile studentFile;

    public Controller() {
        studentFile = new StudentFile();
        studentList = studentFile.readFile();
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(){
        int id = (studentList.size() > 0) ? (studentList.size() + 1000) : 1000;
        String name = inputName();
        String add = inputAddress();
        int age = inputAge();
        float gpa = inputGPA();
        Student student = new Student(id, name, add, age, gpa);
        studentList.add(student);
        studentFile.writeFile(studentList);
    }

    public void editStudent(int id){
        boolean exist = false;
        int size = studentList.size();
        for(int i = 0; i<size; i++){
            if(id == studentList.get(i).getId()){
                exist = true;
                studentList.get(i).setName(inputName());
                studentList.get(i).setAddress(inputAddress());
                studentList.get(i).setAge(inputAge());
                studentList.get(i).setGpa(inputGPA());
                break;
            }
        }
        if (exist == true){
            studentFile.writeFile(studentList);
        }
        else{
            System.out.println("ID is not existed !");
        }
    }

    public void show(){
        for(Student student : studentList){
            System.out.println(student);
        }
    }

    public void sortByGPA(){
        Collections.sort(studentList, new SortByGPA());
    }

    public void sortByName(){
        Collections.sort(studentList, new SortByName());
    }

    public void deleteStudent(int id){
        Student student = null;
        for(int i = 0; i<studentList.size(); i++){
            if (id == studentList.get(i).getId()){
                student = studentList.get(i);
                break;
            }
        }
        if(student != null){
            studentList.remove(student);
            studentFile.writeFile(studentList);
        }
        else{
            System.out.println("ID is not existed !");
        }
    }

    public int inputID(){
        System.out.println("Text student's ID: ");
        while (true){
            try{
                int id = Integer.parseInt(scanner.nextLine());
                if(id < 0){
                    throw new NumberFormatException();
                }
            }
            catch (NumberFormatException e){
                System.out.println("Invalid ID! Text again.");
            }
        }
    }

    private String inputAddress(){
        System.out.println("Text student's address: ");
        return scanner.nextLine();
    }

    private String inputName(){
        System.out.println("Text student's name: ");
        return scanner.nextLine();
    }

    private int inputAge(){
        System.out.println("Text student's age: ");
        while(true){
            try{
                int age = Integer.parseInt(scanner.nextLine());
                if(age < 0){
                    throw new NumberFormatException();
                }
                return age;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid age! Text again.");
            }
        }
    }

    private float inputGPA(){
        System.out.println("Text student's GPA: ");
        while (true){
            try {
                float gpa = Float.parseFloat(scanner.nextLine());
                if(gpa < 0.0 || gpa > 4.0){
                    throw new NumberFormatException();
                }
                return gpa;
            }
            catch (NumberFormatException e){
                System.out.println("Invalid GPA! Text again.");
            }
        }
    }
}
