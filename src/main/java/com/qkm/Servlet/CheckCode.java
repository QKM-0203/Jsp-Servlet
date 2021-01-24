package com.qkm.Servlet;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //生成一张图片
        BufferedImage bufferedImage = new BufferedImage(50,30,BufferedImage.TYPE_INT_RGB);

        //获得画笔对象
        Graphics graphics = bufferedImage.getGraphics();
        //设置背景颜色
        graphics.setColor(Color.orange);
        //填充矩形
        graphics.fillRect(0,0,50,30);
        //换颜色
        graphics.setColor(Color.GREEN);
        //画边框
        graphics.drawRect(0,0,49,29);


        graphics.setColor(Color.RED);
        //写验证码
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int i1 = random.nextInt(s.length());
            char ch = s.charAt(i1);
            stringBuffer.append(ch);
            graphics.drawString(ch+"",50/5*i,15);
        }
        request.getSession().setAttribute("checkBoard",stringBuffer.toString());
        //划线
         graphics.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(50);
            int y1 = random.nextInt(30);
            int x2 = random.nextInt(50);
            int y2 = random.nextInt(30);
            graphics.drawLine(x1,y1,x2,y2);

        }


        //将图片输出到网页展示
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
