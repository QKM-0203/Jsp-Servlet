package cn.qkm.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
//上传文件，获取文件的信息
/*getPart()来获取part对象设置了文件上传，那莫part对象里面存的的就是一些标头信息
见jsp书64页。
要使用getPart()方法就得添加
 */
@WebServlet("/FiveServlet")
//上传文件的路径，就是你要把这个文件放在哪里
@MultipartConfig(location="/home/qikaimeng")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Part part = request.getPart("filename");
        //获取文件名
        String filename = getFileName(part);
        //利用part对象的这个方法直接利用该文件名将该文件写入你设置的location
        part.write(filename );
    }
    public  String getFileName(Part part){
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String filename = header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
        return filename;
    }
}
