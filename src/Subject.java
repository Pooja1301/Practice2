
public class Subject {

    private String name;

    public Subject(String subjectName) {
        name = subjectName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Subject that = (Subject)obj;
        return(that.getName().equals(this.getName()));
    }
}
