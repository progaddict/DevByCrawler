package bsu.rfct.devbycrawler.gui;

import bsu.rfct.devbycrawler.controller.Controller;
import bsu.rfct.devbycrawler.core.HTMLTableInfo;
import bsu.rfct.devbycrawler.core.UserQuery;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;

// TODO AUTHOR popretinskaya_e 07.06.2012 LOW do not forget about JavaDoc for class and public methods at least.
public class MainForm {

    public MainForm() {
        aController = new Controller();
        comboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "http://dev.by/salaries/" })); // TODO AUTHOR popretinskaya_e 07.06.2012 LOW it's better to give meaningful names to UI elements as well. comboBox1 is not good name. Same goes for the rest of UI components without meaningful names
        list1.setListData( aController.getPlatforms().toArray() );
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String site = (String) comboBox1.getSelectedItem();
                List<String> selectedPositions = list1.getSelectedValuesList();
                UserQuery userQuery = new UserQuery(site, HTMLTableInfo.PLATFORMS_TABLE, new HashSet<String>(selectedPositions));
                double average = aController.getAverage(userQuery);
                if( average > 0 ) {
                    resultLabel.setText( "Average salary is " + average );
                } else {
                    logger.error("wrong average value: " + average);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Dev.By Crawler");
        frame.setContentPane(new MainForm().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        logger.info("the application has been started.");
    }



    private static Log logger = LogFactory.getLog(MainForm.class);

    private Controller aController;

    private JPanel panel1;
    private JList list1;
    private JComboBox comboBox1;
    private JButton calculateButton;
    private JLabel resultLabel;
}
