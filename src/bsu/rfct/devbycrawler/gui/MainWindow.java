package bsu.rfct.devbycrawler.gui;



import javax.swing.*;





/**
 * Main window of the application.
 */
public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Dev.by crawler");
        setSize(300,200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        MainWindow mainWindow = new MainWindow();
                        mainWindow.setVisible(true);
                    }
                }
        );
    }

}
