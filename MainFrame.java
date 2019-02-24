package com.sanuthiracommodities;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainFrame extends javax.swing.JFrame {

    private WebDriver driver;
    public static final Color COLOR = new Color(32, 89, 89);
    public static final String DRIVER_PATH = "H:\\springboot-web-app-static-master\\sanuthiracommodities\\src\\main\\resources\\static\\chromedriver.exe";
    public static final String IMAGE_1 = "D:\\icon\\Logo.GIF";
    public static final String IMAGE_2 = "D:\\icon\\www.GIF";
    public static final String IMAGE_3 = "D:\\icon\\image3.GIF";
    public static final String IMAGE_4 = "D:\\icon\\P3.gif";
    private int with;
    private int height;

    public MainFrame() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        setTitle("");
        setIconImage(new ImageIcon(IMAGE_1).getImage());
        setResizable(false);
        setUndecorated(true);
        initComponents();
        title.setIcon(new ImageIcon(IMAGE_2));
        pack();
        setLocationRelativeTo(null);
        with = getWidth();
        height = getHeight();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        urlLabel = new javax.swing.JLabel();
        url = new javax.swing.JTextField();
        goButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AutoSpy");
        setAlwaysOnTop(true);

        body.setBackground(new java.awt.Color(32, 89, 89));
        body.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Auto Heal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        urlLabel.setBackground(new java.awt.Color(204, 204, 255));
        urlLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        urlLabel.setForeground(new java.awt.Color(255, 255, 255));
        urlLabel.setText("Enter URL");
        urlLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout bodyLayout = new org.jdesktop.layout.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, bodyLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .add(bodyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(bodyLayout.createSequentialGroup()
                        .add(urlLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(url, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 276, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(2, 2, 2)
                        .add(goButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cancelButton)))
                .add(75, 75, 75))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bodyLayout.createSequentialGroup()
                .add(50, 50, 50)
                .add(title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 157, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(bodyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(urlLabel)
                    .add(url, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(goButton)
                    .add(cancelButton))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, body, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(body, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        MainFrame spyGUI = this;
        if (url.getText().length() != 0) {
            setPanel(new ImagePanel(new ImageIcon(IMAGE_3)));
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        driver = new ChromeDriver();
                        OpenBrowser.main(driver, url.getText());
                        setPanel((new XpathFrame(spyGUI, driver).getXpathPanel()));
                    } catch (Exception e) {
                        JPanel panel = new JPanel();
                        panel.add(new JLabel("Invalid URL"));
                        setPanel(panel);
                    }
                }
            });
            t.start();
        }
    }//GEN-LAST:event_goButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame spyGUI = new MainFrame();
                spyGUI.setVisible(true);
            }
        });
    }

    @Override
    public void dispose() {
        super.dispose();
        System.exit(0);
    }

    public void setPanel(JPanel panel) {
        panel.setSize(with, height);
        panel.setBackground(COLOR);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        body.removeAll();
        body.setBackground(COLOR);
        body.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Auto Heal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), COLOR));
        body.setLayout(new BorderLayout());
        body.add(panel, BorderLayout.CENTER);
        body.revalidate();
        body.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel title;
    private javax.swing.JTextField url;
    private javax.swing.JLabel urlLabel;
    // End of variables declaration//GEN-END:variables

}
