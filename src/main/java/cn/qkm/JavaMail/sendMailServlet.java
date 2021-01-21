package cn.qkm.JavaMail;

import cn.qkm.upload.UploadServlet;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

@WebServlet(name = "sendMailServlet")
public class sendMailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

                    //set Date：设置时间
                    message.setSentDate(new Date());

                    // 设置内容（内容为纯文本文件）
                    message.setText("This is actual message");

                    //当设置内容为多种时，1 假设包含html则可以先创建一个关于html的对象MimeBodyPart如下:
                    //然后设置内容类型，最后生成一个具有多种文件类型内容的对象MimeMultipart，将该类型增加进去
                    MimeBodyPart httpBodyPart = new MimeBodyPart();
                    httpBodyPart.setContent("内容","text/html;charset=UTF-8");
                    Multipart mimeMultipart = new MimeMultipart();
                    mimeMultipart.addBodyPart(httpBodyPart);

                    // 2 当内容类型为文件时
                    Part file = request.getPart("file");
                    String filename = getFileName(file);
                    MimeBodyPart fileBodyPart = new MimeBodyPart();
                    fileBodyPart.setFileName(MimeUtility.encodeText(filename,"UTF-8","B"));
                    fileBodyPart.setContent(getBytes(file),file.getContentType());
                    mimeMultipart.addBodyPart(fileBodyPart);

                    //将含有多种内容类型的对象放进message中去
                    message.setContent(mimeMultipart);

                    // 发送消息
                    Transport.send(message);

                } catch (MessagingException mex) {
                    mex.printStackTrace();
                }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public  String getFileName(Part part){
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        return header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
    }
    public byte[] getBytes(Part part) throws IOException {
        InputStream inputStream = part.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int length = -1;
        while((length = inputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes,0,length);
        }
        inputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
