package cn.qkm.Session;
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
        BufferedImage bufferedImage = new BufferedImage(100,50,BufferedImage.TYPE_INT_RGB);

        //获得画笔对象
        Graphics graphics = bufferedImage.getGraphics();
        //设置背景颜色
        graphics.setColor(Color.orange);
        //填充矩形
        graphics.fillRect(0,0,100,50);
        //换颜色
        graphics.setColor(Color.GREEN);
        //画边框
        graphics.drawRect(0,0,99,49);


        graphics.setColor(Color.RED);
        //写验证码
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int i1 = random.nextInt(s.length());
            char ch = s.charAt(i1);
            graphics.drawString(ch+"",100/5*i,25);
        }
        //划线 ]
         graphics.setColor(Color.BLACK);
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(100);
            int y1 = random.nextInt(100);
            int x2 = random.nextInt(50);
            int y2 = random.nextInt(50);

            graphics.drawLine(x1,y1,x2,y2);

        }


        //将图片输出到网页展示
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
