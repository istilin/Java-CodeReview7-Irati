public class Classs {
    private int classId;
    private String className;

    public Classs(int classId, String className){
        this.classId = classId;
        this.className = className;
    }

    @Override
    public String toString() {
        return "   - " + className;
    }
}
