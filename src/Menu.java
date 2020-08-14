import java.sql.*;
import java.util.*;

public class Menu {
    private static Scanner scan = new Scanner(System.in);
    public Menu(DataAccess da){
        System.out.println("+------------------------------------+");
        System.out.println("|                                    |");
        System.out.println("|     Welcome to the school menu     |");
        System.out.println("|                                    |");
        System.out.println("+------------------------------------+");
        programRoot(da);
    }
    public void programRoot(DataAccess da){
        System.out.println("\nPlease select from the following:\n   1) Display all students\n   2) Display all teachers\n   3) Display all classes\n   4) Display all subjects\n   5) Display all courses from a specific teacher\n   6) Create report with students information\n   0) Exit");
        int command = scan.nextInt();
        switch (command){
            case 1:
                da.displayAllStudents();
                programRoot(da);
                break;

            case 2:
                da.displayAllTeachers();
                programRoot(da);
                break;

            case 3:
                da.displayAllClasses();
                programRoot(da);
                break;

            case 4:
                da.displayAllSubjects();
                programRoot(da);
                break;

            case 5:
                System.out.println("\nPlease select teacher ID (0 to go back):");
                da.displayAllTeachersWithId();
                int teacherId = scan.nextInt();
                if (teacherId == 0){
                    programRoot(da);
                }
                else if(da.getAllTeachers().size() >= teacherId){
                    da.displayClassesOfTeacher(teacherId);
                    programRoot(da);
                }
                else{
                    System.out.println("Wrong teacher ID");
                    programRoot(da);
                }
                break;

            case 6:
                new CreateFile(da);
                programRoot(da);
                break;

            case 0:
                System.out.println("Thank you for using the school menu!!!");
                return;

            default:
                System.out.println("Please try again, invalid option.");
                programRoot(da);
                break;
        }
    }
}
