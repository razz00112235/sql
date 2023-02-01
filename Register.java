import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Register{
static JLabel user_mail,user_name,u_name,u_mail;
static JTextField mail_data,name_data;
static JButton submit,update,delete,next;
//static String[][] data = new String[20][4];

static  int count=1,count_rec=0,loop_rec=0,id=1;
static  JPanel panel2,panel;
static void home()
    {
       try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_data", 
                "root", "12345");

                String fetch_rec2="Select * from register";
                Statement sm2=con.createStatement();
                ResultSet rs2=sm2.executeQuery(fetch_rec2);
                while(rs2.next())
                {
                    count_rec++;
                    id++;
                }
       } catch (Exception e) {
        // TODO: handle exception
       }      
        count_rec=count_rec+1;
        String[][] data = new String[count_rec][4];



        JFrame home=new JFrame("Home Page");
        home.setSize(500, 600);

        user_mail=new JLabel("Email Address:-");
        user_mail.setBounds(20, 20, 100, 30);
        mail_data=new JTextField();
        mail_data.setBounds(120,20,150,30);

        user_name=new JLabel("User Name:-");
        user_name.setBounds(20, 80, 100, 30);
        name_data=new JTextField();
        name_data.setBounds(120,80,150,30);

        submit=new JButton("Submit");
        submit.setBounds(120, 120, 80, 30);
        
        Color c = new Color(37, 150, 190);
        
        submit.setBackground(c);


        next=new JButton(String.valueOf(id));
        next.setBounds(250, 120, 80, 30);
        next.setVisible(false);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_data", 
            "root", "12345");

            String fetch_rec="Select * from register";
            Statement sm=con.createStatement();
            ResultSet rs=sm.executeQuery(fetch_rec);
          
            int i=0,j=0,k=0;
            String name_data_fetch,mail_data_fetch,user_id;
            panel=new JPanel();
            panel.setBounds(30,160,400,300);    
            panel.setBackground(Color.gray);
            String[] columns = new String[] {
                "Id", "Email", "Username", "Action"
            };
           
            while(rs.next())
            {
                 
                name_data_fetch=rs.getString("user_name");
                mail_data_fetch=rs.getString("user_mail");
                user_id=rs.getString("id");
                
                        data[i][j]="               "+String.valueOf(user_id);
                        data[i][j+1]=mail_data_fetch;
                        data[i][j+2]=name_data_fetch;                        
                        data[i][j+3]="action";
                  
                i++;
                count++;
            }
            JTable table = new JTable(data, columns);
           
        //add the table to the frame    
        panel.add(new JScrollPane(table));
        panel.setVisible(true);
        home.add(panel);  
            


        } catch (Exception e) {
         System.out.println(e);
    }
        //create table with data
              
        home.add(user_mail);home.add(mail_data);
        home.add(user_name);home.add(name_data);home.add(submit);home.add(next);
        home.setLayout(null);
        home.setVisible(true);

        ActionListener submit_bt=new ActionListener(){
            public void actionPerformed(ActionEvent e)
            { 
                panel.setVisible(false);              
                String name,mail;
                mail=mail_data.getText();
                name=name_data.getText();
               
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register_data", 
            "root", "12345");

                    String insert_data="Insert into register value('"+name+"','"+mail+"','"+next.getText()+"')";                    
                   
                    Statement st=con.createStatement();
                    st.executeUpdate(insert_data);
                    mail_data.setText("");
                    name_data.setText("");                    
                    String fetch_rec="Select * from register";
                    Statement sm=con.createStatement();
                    ResultSet rs=sm.executeQuery(fetch_rec);
                    panel2=new JPanel();
                    panel2.setBounds(0,160,400,200);    
                    panel2.setBackground(Color.gray);
                    count_rec=count_rec+1;
                  
                    next.setText(String.valueOf(count_rec));
                    String[][] data2 = new String[count_rec][4];
                      String[] columns2 = new String[] {
                         "Id", "Email", "Username", "Action"
                       };
                       String name_data_fetch,mail_data_fetch,user_id;
                       int i=0,j=0,k=0;
                      while(rs.next())
                        {
                            k++;
                            
                            name_data_fetch=rs.getString("user_name");
                            mail_data_fetch=rs.getString("user_mail");
                            user_id=rs.getString("id");
                                    data2[i][j]="               "+String.valueOf(user_id);
                                    data2[i][j+1]=mail_data_fetch;
                                    data2[i][j+2]=name_data_fetch;
                                    data2[i][j+3]="Action";
                            
                            i++;
                            count++;
                        }
                       
                       
            JTable table2 = new JTable(data2, columns2);
              
        //add the table to the frame
        panel2.add(new JScrollPane(table2));
        panel2.setVisible(true);
        home.add(panel2);  
                    
                } catch (Exception ee) {
                    System.out.println(ee);
                }

            }
        };
        submit.addActionListener(submit_bt);
    }
    public static void main(String[] args) {
        home();
    }
}