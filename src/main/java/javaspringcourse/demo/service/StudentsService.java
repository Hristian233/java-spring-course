package javaspringcourse.demo.service;

import javaspringcourse.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsService {

    private static List<Student> students = new ArrayList<>();
    private static int idCounter = 0;

    static {
        students.add(new Student("Ivan", "Ivanov", idCounter++ ));
        students.add(new Student("Petar", "Petrov", idCounter++ ));
        students.add(new Student("Ivan", "Ivanov", idCounter++));
    }

    public List<Student> findAll() { return students; }

    public Student save(Student student) {
        if (student.getId() == -1 || student.getId() == 0) {
            student.setId(++idCounter);
            students.add(student);
        }

        return student;
    }

    public Student deleteById(int id) {
        Student student = findById(id);

        if (student == null)
            return null;

        if (students.remove(student)) {
            return student;
        }

        return null;
    }

    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
}
