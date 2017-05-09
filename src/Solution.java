import java.io.BufferedReader;
import java.util.*;

public class Solution {

    static Scanner scanner = new Scanner(System.in);

    static int noOfStudents;
    static int noOfSubjects;

    public static void main(String[] args) {
        noOfStudents = scanner.nextInt();
        noOfSubjects = scanner.nextInt();
        List<Subject> subjects = getSubjects();
        List<Student> students = getStudents(subjects);
        Map<Subject, List<Student>> toppers = new HashMap<>();
        for (Subject subject: subjects) {
            List<Student> topperList = getTopper(students, subject);
            toppers.put(subject, topperList);
        }

        printToppersSubjectWise(toppers);
    }

    private static void printToppersSubjectWise(Map<Subject, List<Student>> toppers) {
        for(Subject subject: toppers.keySet()){
            System.out.println(subject.getName());
            for (Student student: toppers.get(subject)){
                System.out.println(student.getName());
            }
        }

    }

    private static List<Student> getTopper(List<Student> students, final Subject subject) {
        List<Student> sortedStudentsList = new ArrayList<>(students);
        Collections.sort(sortedStudentsList, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                Integer marks1 = student1.getMarksFor(subject);
                Integer marks2 = student2.getMarksFor(subject);

                return marks2.compareTo(marks1);
            }
        });
        return sortedStudentsList;
    }

    private static List<Student> getStudents(List<Subject> subjects) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < noOfStudents; i++) {
            String studentData = scanner.nextLine();
            String[] studentArray = studentData.split(" ");
            List<SubjectMark> subjectMarks = new ArrayList<>();
            for (int j = 0; j < noOfSubjects; j++) {
                SubjectMark subjectMark = new SubjectMark(subjects.get(j), Integer.parseInt(studentArray[j+1]));
                subjectMarks.add(subjectMark);
            }
            students.add(new Student(studentArray[0],subjectMarks));
        }
        return students;
    }

    private static List<Subject> getSubjects() {
        scanner.nextLine();
        String[] subjectArray = scanner.nextLine().split(" ");
        List<Subject> subjects = new ArrayList<>();
        for (String subjectName: subjectArray){
            subjects.add(new Subject(subjectName));
        }
        return subjects;
    }
}

