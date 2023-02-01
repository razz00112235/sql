import java.sql.*;

public class UpdateData{

    public static void main(String[] args) {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", 
            "root", "12345");
           
            String qry="UPDATE persons SET City = 'AJmer' WHERE PersonID = 2";
            Statement st=con.createStatement();
            st.executeUpdate(qry);
           

        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
}