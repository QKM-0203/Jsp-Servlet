package cn.qkm.JavaMail;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class sendMail {
    public static void main(String[] args) {
        // 收件人电子邮箱
        String to = "156****22**@qq.com";

        // 发件人电子邮箱
        String from = "192***413@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com"; // QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置收取的邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        //设置收取邮件的邮件服务器的端口号smtp协议好像接受邮件都是这个端口号
        properties.setProperty("mail.smtp.port","465");
        properties.put("mail.smtp.auth", "true");
        //设置SSL加密
        MailSSLSocketFactory sf;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);

        } catch (GeneralSecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("username","password"); // 发件人邮件用户名、密码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象，生成message对象因为Message类是抽象类所以根据MimeMessage来获取
            MimeMessage message = new MimeMessage(session);

            // Set From: 发件人的邮箱
            message.setFrom(new InternetAddress(from));

            // Set To: 收件人的邮箱
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 内容的主题
            message.setSubject("This is the Subject Line!");

            // 设置内容
            message.setText("This is actual message");

            // 发送消息
            Transport.send(message);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
