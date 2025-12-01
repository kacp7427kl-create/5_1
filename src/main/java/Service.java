import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Service {

    public void addStudent(Student student) throws IOException {
        try (FileWriter f = new FileWriter("db.txt", true);
             BufferedWriter b = new BufferedWriter(f)) {

            b.append(student.ToString());
            b.newLine();

        } catch (IOException e) {
            throw e;
        }
    }

    public Collection<Student> getStudents() throws IOException {
        var ret = new ArrayList<Student>();

        try (FileReader f = new FileReader("db.txt");
             BufferedReader reader = new BufferedReader(f)) {

            String line;
            while ((line = reader.readLine()) != null) {
                ret.add(Student.Parse(line));
            }
        } catch (IOException e) {
            throw e;
        }
        return ret;
    }

    public Student findStudentByName(String name) throws IOException {
        try (FileReader f = new FileReader("db.txt");
             BufferedReader reader = new BufferedReader(f)) {

            String line;

            while ((line = reader.readLine()) != null) {
                Student student = Student.Parse(line);

                if (student.GetName().trim().equalsIgnoreCase(name.trim())) {
                    return student;
                }
            }
        } catch (IOException e) {
            throw e;
        }

        return null;
    }
}