/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rjferramentas.envionotafiscal;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Taskbar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Will
 */
public class Main extends javax.swing.JFrame {

    java.util.List<File> files = new java.util.ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Main
     */
    public Main() {
        FlatLightLaf.setup();

// create UI here...
        initComponents();
        setCustomIcon();
        model.addColumn("Arquivos");
        model.addColumn("Tipo");
        tblFiles.setModel(model);
    }

    private void setCustomIcon() {
        try {
            // Load icon from resources
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/gmail.png"));

            // For Windows/Linux
            this.setIconImage(icon.getImage());

            // For macOS dock icon (optional)
            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                Taskbar.getTaskbar().setIconImage(icon.getImage());
            }
        } catch (Exception e) {
            System.err.println("Error loading icon: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnFileXML = new javax.swing.JButton();
        txtTo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFiles = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btnFilePDF = new javax.swing.JButton();
        btnBoleto = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Envio de NF-e");
        setResizable(false);

        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/email.png"))); // NOI18N
        btnSend.setText("Enviar");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione os arquivos para anexar");

        btnFileXML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xml.png"))); // NOI18N
        btnFileXML.setText("XML");
        btnFileXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFileXMLActionPerformed(evt);
            }
        });

        jLabel2.setText("Destinatário");

        tblFiles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Arquivos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFiles);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnFilePDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdf.png"))); // NOI18N
        btnFilePDF.setText("PDF");
        btnFilePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilePDFActionPerformed(evt);
            }
        });

        btnBoleto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money.png"))); // NOI18N
        btnBoleto.setText("Boleto");
        btnBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletoActionPerformed(evt);
            }
        });

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/question.png"))); // NOI18N
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHelp)
                        .addGap(18, 18, 18)
                        .addComponent(btnSend))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(194, 194, 194)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTo, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFileXML)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFilePDF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBoleto)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFileXML)
                    .addComponent(btnFilePDF)
                    .addComponent(btnBoleto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSend)
                        .addComponent(jButton3)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFileXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFileXMLActionPerformed
        JFileChooser filexml = new JFileChooser("C:\\");
        filexml.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos XML", "xml");
        filexml.setFileFilter(filter);

        int result = filexml.showOpenDialog(null);

        // Verificar se o usuário selecionou um arquivo
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filexml.getSelectedFile();
            files.add(selectedFile); // Adiciona à lista

            try {
                // Processar XML
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = builder.parse(selectedFile);
                NodeList nodeList = document.getElementsByTagName("email");

                if (nodeList.getLength() > 0) {
                    txtTo.setText(nodeList.item(0).getTextContent());
                }

                // Adicionar à tabela com caminho completo
                model.addRow(new Object[]{selectedFile.getName(), "XML"});

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao processar XML: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnFileXMLActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed

        String userMail = "";
        String passwordMail = "";
        HtmlEmail mail = new HtmlEmail();
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/java/rjferramentas/envionotafiscal/config.properties")) {
            properties.load(input);
            userMail = properties.getProperty("usermail");
            passwordMail = properties.getProperty("passwordmail");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mail.setAuthenticator(new DefaultAuthenticator(userMail, passwordMail));
        mail.setHostName("smtp.gmail.com");
        mail.setSmtpPort(587);

        mail.setSSLOnConnect(true);
        mail.setStartTLSRequired(true);
        mail.setStartTLSEnabled(true);

        for (File file : files) {
            try {
                mail.attach(file);
            } catch (EmailException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            mail.setFrom(userMail);
            mail.setSubject("Envio automático de NF-e  |  RJ de Oliveira Neto EPP.");
            mail.addTo(txtTo.getText());

            mail.setHtmlMsg("<html><h2>Olá, caro cliente.</h2> <p>Abaixo seguem anexos os arquivos <strong>XML</strong> e <strong>PDF</strong> referente a sua NF-e.</p> "
                    + "<p>Qualquer dúvida, entre em contato com o setor financeiro da RJ de Oliveira Neto EPP.</p><br><br><p><small><strong>Telefone: +55(xx)xxxx-xxxx</small></strong></p><html>");
            mail.send();
            JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        files.clear(); // Limpa a lista
        txtTo.setText("");
        model.setRowCount(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnFilePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilePDFActionPerformed
        JFileChooser filePDF = new JFileChooser("C:\\");
        filePDF.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos PDF", "pdf");
        filePDF.setFileFilter(filter);

        int result = filePDF.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = filePDF.getSelectedFile();
            files.add(selectedFile); // Adiciona à lista

            // Adicionar caminho completo à tabela
            model.addRow(new Object[]{selectedFile.getName(), "PDF"});
        }
    }//GEN-LAST:event_btnFilePDFActionPerformed

    private void btnBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletoActionPerformed
      JFileChooser fileBoleto = new JFileChooser("C:\\");
        fileBoleto.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos PDF", "pdf");
        fileBoleto.setFileFilter(filter);

        int result = fileBoleto.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileBoleto.getSelectedFile();
            files.add(selectedFile); // Adiciona à lista

            // Adicionar caminho completo à tabela
            model.addRow(new Object[]{selectedFile.getName(), "Boleto"});
        }
    }//GEN-LAST:event_btnBoletoActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(null, "Este software não foi desenvolvido pelo Willian! \n A werks é horrível!!!");
    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoleto;
    private javax.swing.JButton btnFilePDF;
    private javax.swing.JButton btnFileXML;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFiles;
    private javax.swing.JTextField txtTo;
    // End of variables declaration//GEN-END:variables
}
