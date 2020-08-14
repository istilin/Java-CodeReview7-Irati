import java.sql.*;
import java.lang.*;
import java.util.*;

public class DataAccess {
    private final Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/CR7_Irati" + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


    public DataAccess() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Connecting to database...");
        SECRET secret = new SECRET();
        connection = DriverManager.getConnection(url, secret.getUser(), secret.getPassword());
        connection.setAutoCommit(true);
        connection.setReadOnly(false);

    }

    public void closeDB() throws SQLException {
        System.out.println("Closing connection...");
        connection.close();
    }

    public ArrayList<Student> getAllStudents() {
        String sql = "SELECT * FROM Students";
        ArrayList <Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int studentId = rs.getInt("studentId");
                String studentName = rs.getString("studentName");
                String studentSurname = rs.getString("studentSurname");
                String studentEmail = rs.getString("studentEmail");
                studentList.add(new Student(studentId, studentName, studentSurname, studentEmail));
            }
            rs.close();
            preparedStatement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return studentList;
    }

    public ArrayList<Teacher> getAllTeachers(){
        String sql = "SELECT * FROM Teachers";
        ArrayList <Teacher> teacherList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int teacherId = rs.getInt("teacherId");
                String teacherName = rs.getString("teacherName");
                String teacherSurname = rs.getString("teacherSurname");
                String teacherEmail = rs.getString("teacherEmail");
                teacherList.add(new Teacher(teacherId, teacherName, teacherSurname, teacherEmail));
            }
            rs.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return teacherList;
    }

    public ArrayList<Classs> getAllClasses(){
        String sql = "SELECT * FROM Classes";
        ArrayList <Classs> classList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int classId = rs.getInt("classId");
                String className = rs.getString("className");
                classList.add(new Classs(classId, className));
            }
            rs.close();
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return classList;
    }

    public ArrayList<Subject> getAllSubjects(){
        String sql = "SELECT * FROM Subjects";
        ArrayList <Subject> subjectList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int subjectId = rs.getInt("subjectId");
                String subjectName = rs.getString("subjectName");
                subjectList.add(new Subject(subjectId, subjectName));
            }
            rs.close();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return subjectList;
    }

    public HashMap<ArrayList<Classs>, Teacher> getClassesOfTeacher(int teacherId){
        String sql1 = "SELECT DISTINCT Classes.* " +
        "From Teachers " +
        "INNER JOIN ConnectTeacherClassSubject ON Teachers.teacherId = ConnectTeacherClassSubject.fk_teacherId " +
        "INNER JOIN Classes ON ConnectTeacherClassSubject.fk_classId = Classes.classId " +
        "WHERE Teachers.teacherId = " + teacherId + ";";
        String sql2 = "SELECT * FROM Teachers WHERE Teachers.teacherId = " + teacherId + ";";
        ArrayList <Classs> classList = new ArrayList<>();
        HashMap <ArrayList<Classs>, Teacher> classTeacher = new HashMap<>();

        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            ResultSet rs1 = preparedStatement1.executeQuery();

            while (rs1.next()) {
                int classId = rs1.getInt("classId");
                String className = rs1.getString("className");
                classList.add(new Classs(classId, className));
            }

            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
            ResultSet rs2 = preparedStatement2.executeQuery();
            rs2.next();
            String teacherName = rs2.getString("teacherName");
            String teacherSurname = rs2.getString("teacherSurname");
            String teacherEmail = rs2.getString("teacherEmail");
            Teacher teacher = new Teacher(teacherId, teacherName, teacherSurname, teacherEmail);
            classTeacher.put(classList, teacher);

            rs1.close();
            rs2.close();

            preparedStatement1.close();
            preparedStatement2.close();
        } catch (Exception e){
            e.printStackTrace();
        }

        return classTeacher;
    }

    public void displayAllStudents(){
        ArrayList <Student> studentList = getAllStudents();
        System.out.println("\n########## All students in school ##########");
        for (Student student: studentList) {
            System.out.println(student);
        }
    }

    public void displayAllTeachers(){

        ArrayList <Teacher> teacherList = getAllTeachers();
        System.out.println("\n########## All teachers in school ##########");
        for (Teacher teacher: teacherList){
            System.out.println(teacher);
        }
    }

    public void displayAllTeachersWithId(){
        ArrayList <Teacher> teacherList= getAllTeachers();
        for (Teacher teacher: teacherList){
            System.out.println("ID " + teacher.getTeacherId() + ": " + teacher);
        }
    }

    public void displayAllClasses(){
        ArrayList <Classs> classList = getAllClasses();
        System.out.println("\n########## All classes in school ##########");
        for (Classs classs: classList){
            System.out.println(classs);
        }
    }

    public void displayAllSubjects(){
        ArrayList <Subject> subjectList = getAllSubjects();
        System.out.println("\n########## All subjects in school ##########");
        for (Subject subject: subjectList) {
            System.out.println(subject);
        }
    }

    public void displayClassesOfTeacher(int teacherId){
        HashMap<ArrayList<Classs>, Teacher> classTeacher = getClassesOfTeacher(teacherId);
        System.out.println("\n########## Information of teacher with ID " + teacherId + " ##########");

        for (Teacher teacher: classTeacher.values()){
            System.out.println(" - Name: " + teacher.getTeacherName() + "\n - Surname: " + teacher.getTeacherSurname() + "\n - e-mail address: " + teacher.getTeacherEmail());
        }

        System.out.println("\n########## All classes of teacher with ID " + teacherId + " ##########");

        for (ArrayList <Classs> classes: classTeacher.keySet()){
            for (Classs classs: classes){
                System.out.println(classs);
            }
        }
    }
}
