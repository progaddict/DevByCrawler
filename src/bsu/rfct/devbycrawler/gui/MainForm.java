package bsu.rfct.devbycrawler.gui;

import bsu.rfct.devbycrawler.controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MainForm {

    private Controller aController;

    public MainForm() {
        aController = new Controller();
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dev.By Crawler");
        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel1;
    private JList list1;
    private JComboBox comboBox1;
    private JButton calculateButton;
    private JLabel resultLabel;
}
