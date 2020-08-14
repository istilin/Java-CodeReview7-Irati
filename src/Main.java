import java.sql.*;
import java.util.*;

public class Main {
    static DataAccess da;

    static public void init(){
        try{
            da = new DataAccess();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static public void stop(){
        try{
            da.closeDB();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        init();
        new Menu(da);
        stop();
    }

}
