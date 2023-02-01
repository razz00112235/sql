import java.sql.*;

class InsertData{

    void insertdata(){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", 
            "root", "12345");

            String insert_data="Insert into persons value(4,'Yadav','Meghraj','Jagatpura','Jaipur')";
            Statement st=con.createStatement();
            st.executeUpdate(insert_data);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        InsertData id=new InsertData();
        id.insertdata();
    }
}