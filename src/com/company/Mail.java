package com.company;

 import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public final class Mail /*extends FileMangerBinary*/ implements Serializable {
   // FileMangerBinary FManger = new FileMangerBinary();
   // private final String FilePath = "Email.bin";
   // private static ArrayList<Mail> E = new ArrayList();
    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;
    private String ToEmail = "";
    private String CcEmail = "";
    private String Subject = "";
    private String Emailbody = "";

    public Mail() {
    }

    public Mail(String To, String Cc, String subject, String body) {
        this.CcEmail = Cc;
        this.Emailbody = body;
        this.Subject = subject;
        this.ToEmail = To;
    }

    public void generateAndSentMessage() throws AddressException, MessagingException {
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        getMailSession = Session.getDefaultInstance(mailServerProperties);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(RecipientType.TO, new InternetAddress(this.ToEmail));
        if (!this.CcEmail.equals("")) {
            generateMailMessage.addRecipient(RecipientType.CC, new InternetAddress(this.CcEmail));
        }

        generateMailMessage.setSubject(this.Subject);
        String emailBody = this.Emailbody + "<br><br>Regards,<br>Manager Youssef Rasahd ..";
        generateMailMessage.setContent(emailBody, "text/html");
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.yahoo.com", "youssefrashad19@yahoo.com", "");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
       // this.loadFromFile();
       // E.add(this);
       // this.commitToFile();
    }

    /*private void loadFromFile() {
        E = (ArrayList)this.FManger.readBinary("Email.bin");
    }*/

    public void setToEmail(String to) {
        this.ToEmail = to;
    }

    public void setCcEmail(String cc) {
        this.CcEmail = cc;
    }

    public void setSubject(String s) {
        this.Subject = s;
    }

    public void setEmailbody(String b) {
        this.Emailbody = b;
    }

    public String getToEmail() {
        return this.ToEmail;
    }

    public String getCcEmail() {
        return this.CcEmail;
    }

    public String getSubject() {
        return this.Subject;
    }

    public String getEmailbody() {
        return this.Emailbody;
    }

   /* public boolean commitToFile() {
        return this.FManger.writeBinary("Email.bin", E);
    }

    public ArrayList<Mail> ListMails() {
        this.loadFromFile();
        return E;
    }*/
}