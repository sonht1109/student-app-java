package StudentManagement;

import java.io.*;
import java.util.ArrayList;

public class StudentFile {
    private static final String fileName = "student.txt";

    public void writeFile(ArrayList <Student> studentList){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(fileName));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
            fos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList <Student> readFile (){
        ArrayList <Student> studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(fileName));
            ois = new ObjectInputStream(fis);
            studentList = (ArrayList<Student>) ois.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
