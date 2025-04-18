<img height="48" width="48" src="https://cdn.simpleicons.org/maildotru/white" /> &nbsp;&nbsp;&nbsp; <img height="48" width="48" src="https://cdn.simpleicons.org/apachenetbeanside" /> &nbsp;&nbsp;&nbsp; <img height="48" width="48" src="https://cdn.simpleicons.org/apachemaven" /> 
#
<h3><strong>Envio de NF-e </strong><i>(NF-e Sender)</i></h3>


Application designed for sending emails using my Gmail account. The user can send as many attachments as they want, as long as they're and *.xml* and *.pdf* file. This restriction was made based on the  idea that these are the file extensions that RJ de Oliveira Neto (a company) needs to be sent and delivered to their customers.
<br>
<br>
<h1>Helpful snippets 💡</h1>
<h3>Attaching XML files to a FileChooser 📬</h3>
<details open><summary><i>code</i></summary>
  
```java
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
```
</details>
<h3>Sending mails 📧</h3>
<details open><summary><i>code</i></summary>
  
```java
  private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed

        String userMail = "";
        String passwordMail = "";
        HtmlEmail mail = new HtmlEmail();

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
                    + "<p>Qualquer dúvida, entre em contato com o setor financeiro da RJ de Oliveira Neto EPP.</p><br><br><p><small><strong>Telefone: (24)3322-4727</small></strong></p><html>");
            mail.send();
            JOptionPane.showMessageDialog(null, "E-mail enviado com sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
```
</details>

<h3>Reading files in a secure way 🔒</h3>

<details open><summary><i>code</i></summary>
  
```java
  Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("src/main/java/rjferramentas/envionotafiscal/config.properties")) {
            properties.load(input);
            userMail = properties.getProperty("usermail");
            passwordMail = properties.getProperty("passwordmail");
        } catch (IOException e) {
            e.printStackTrace();
        }

```

> _Do not forget to create a_ ``.gitignore`` _file in your repository and add_ ``*.properties`` _, so then any property file you may have won't be uploaded to_ **GitHub**.

</details>

