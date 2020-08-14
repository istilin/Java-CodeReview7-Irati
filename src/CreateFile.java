import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateFile {
    public CreateFile(DataAccess da) {



        try {
            File file = new File("reports/studentsReport.txt");
            if (file.createNewFile()){
                System.out.println("File created: " + file.getName());
            } else{
                System.out.println("File already exists!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        try{

            ArrayList<Student> studentList = da.getAllStudents();
            FileWriter fileWriter = new FileWriter("reports/studentsReport.txt");
            fileWriter.write("STUDENTS REPORT\n_____________________________________________________________________________________\n\n");
            for (Student student: studentList){
                fileWriter.write("ID:  " + String.format("%1$3s", student.getStudentId()) + "   |   ");
                fileWriter.write("Name:  " + String.format("%1$-20s", student.getStudentSurname() + ", " + student.getStudentName()) + "   |   ");
                fileWriter.write("e-mail:   " + student.getStudentEmail() + "\n");
            }
            fileWriter.close();
            System.out.println("Filled up file");

        } catch (Exception e ){
            e.printStackTrace();
        }
    }
}
