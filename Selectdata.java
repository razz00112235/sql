import java.sql.*;

class SelectData{
    static void fetch_data()
     {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", 
                "root", "12345");

                String fetch_rec="Select * from persons";
                Statement sm=con.createStatement();
                ResultSet rs=sm.executeQuery(fetch_rec);

                while(rs.next())
                {
                    int id=rs.getInt("PersonID");
                    String city=rs.getString("City");
                    System.out.println(id+" - "+city);
                }
                


            } catch (Exception e) {
             System.out.println(e);
        }
        
    }
    public static void main(String[] args) {
        fetch_data();
    }
}