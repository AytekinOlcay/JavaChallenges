package OgrenciIsleri;

import java.util.Iterator;
import java.util.List;

public class Student {

    public String tckn;
    public String fullname;
    public String age;
    public String studentNumber;
    public String classRoom;


    public Student(String tckn, String fullname, String age, String studentNumber, String classRoom) {
        this.tckn = tckn;
        this.fullname = fullname;
        this.age = age;
        this.studentNumber = studentNumber;
        this.classRoom = classRoom;
    }

    public static Student findStudentByTckn(List<Student> students, String tckn) {
        for (Student student : students) {
            if (student.tckn.equals(tckn)) {
                return student;
            }
        }
        return null;
    }

    public static void addNewStudent(List<Student> students, String tckn, String fullname, String age, String studentNumber, String classRoom) {
        students.add(new Student(tckn, fullname, age, studentNumber, classRoom));
    }

    public static void getAllStudents(List<Student> students) {
        for (Student st : students) {
            System.out.printf("T.C. Kimlik No: %s\nADI SOYADI: %s\nYAŞI: %s\nNUMARASI: %s\nSINIFI: %s\n", st.tckn, st.fullname, st.age, st.studentNumber, st.classRoom);
            System.out.println("_______________________");
        }
    }

    public static void deleteStudent(List<Student> ogrenciler, String tckn) {

        Iterator<Student> iterator = ogrenciler.iterator();
        while (iterator.hasNext()) {
            Student ogrenci = iterator.next();
            if (ogrenci.tckn.equals(tckn)) {
                iterator.remove();
            }
        }

    }

    @Override
    public String toString() {
        return "*** GİRİLEN TCKN'ye GÖRE ÖĞRENCİ BİLGİLERİ ***\n" +
                "T.C. Kimlik No: " + tckn + "\n" +
                "ADI SOYADI: " + fullname + "\n" +
                "YAŞI: " + age + "\n" +
                "NUMARASI: " + studentNumber + "\n" +
                "SINIFI: " + classRoom + "\n";
    }
}
