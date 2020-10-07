package StudentManagement;

import java.util.Comparator;

public class SortByGPA implements Comparator <Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getGpa() > o2.getGpa()) return 1;
        return -1;
    }
}
