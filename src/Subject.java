public class Subject {
    private int subjectId;
    private String subjectName;

    public Subject(int subjectId, String subjectName){
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "   - " + subjectName;
    }
}
