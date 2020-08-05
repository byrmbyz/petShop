package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DashboardForm extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel dashPanel;
    private JButton kaydetButton;

    public DashboardForm(){
        add(dashPanel);
        setTitle("Dashboard Form");
        setSize(800,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        kaydetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String adi = textField1.getText();
                String turu = textField2.getText();
                String cinsi = textField3.getText();
                DbConnect dbConnect = new DbConnect();
                Connection con = dbConnect.getDbConnect();

                try {

                    String sql = "insert into hastalar values (?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1,adi);
                    ps.setString(2,turu);
                    ps.setString(3,cinsi);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"kayıt yapıldı.");
                    con.close();
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(null,"kayıt sırasında hata:"+throwables.getMessage());
                }
            }
        });
    }
}
