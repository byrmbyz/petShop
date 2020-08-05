package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton girişButton;
    private JPanel mainPanel;

    public LoginForm(){
        add(mainPanel);
        setTitle("Login Form");
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        girişButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = textField1.getText();
                String pwd = textField2.getText();
                DbConnect dbConnect = new DbConnect();
                Connection con = dbConnect.getDbConnect();

                try {

                    String sql = "select * from kullanicilar where adi = ? and sifre = ?";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,uname);
                    ps.setString(2,pwd);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"Giriş yapıldı.");
                        DashboardForm dashboardForm = new DashboardForm();

                        dashboardForm.setVisible(true);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Hatalı kullanıcı veya şifre.");
                    }
                    con.close();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }
}
