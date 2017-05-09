import java.util.List;

public class Student {

    private String name;

    public List<SubjectMark> getSubjectMarks() {
        return subjectMarks;
    }

    private List<SubjectMark> subjectMarks;

    public Student(String name, List<SubjectMark> subjectMarks) {
        this.name = name;
        this.subjectMarks = subjectMarks;
    }

    public String getName() {
        return name;
    }

    public Integer getMarksFor(Subject subject){
        Integer marks = 0;
        for (SubjectMark subjectMark: subjectMarks){
            if (subjectMark.getSubject().equals(subject)){
               marks = subjectMark.getMarks();
            }
        }
        return marks;

    }
}
