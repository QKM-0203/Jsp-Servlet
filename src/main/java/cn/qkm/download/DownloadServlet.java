package cn.qkm.download;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * 下载文件的servlet，单击图片链接高级的浏览器直接下载，另一些的询问是否下载
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getParameter("filename");

        ServletContext servletContext = this.getServletContext();
        //获取文件在服务器中的真实路径，加载他,好象是直接在target目录里面找的
        String realPath = servletContext.getRealPath(filename);

        FileInputStream fileInputStream = new FileInputStream(realPath);
        int len = 0;
        byte[] bytes = new byte[1024*8];
        //获取文件的mime类型
        String mimeType = servletContext.getMimeType(filename);
        //设置响应头的文件类型
        response.setHeader("content-type",mimeType);
        //设置是否弹出下载框框的响应头，谷歌是不弹出框框直接下载的
        response.setHeader("content-disposition","attachment;filename="+filename);
       //然后在写到客户端就可以
        ServletOutputStream outputStream = response.getOutputStream();
        while((len =  fileInputStream .read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
    }
}
