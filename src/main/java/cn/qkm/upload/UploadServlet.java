package cn.qkm.upload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
/*
 一个part对象就是一个区段的信息，一个区段就是from表单里面的一项，part对象里面会有Content-Disposition参数值，所以用它来获取文件名
 在利用part对象的write写进你指定的目录.
 */

/**
 *上传文件，通过选择你想要上传的文件,将文件上传到你指定目录(part对象)
 */
@WebServlet("/UploadServlet")
//上传文件的路径，就是你要把这个文件放在哪里，要使用getPart()方法就得添加
@MultipartConfig(location="/home/qikaimeng")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取part对象最好根据要获取的文件的参数来获取对应的part对象
        Part part = request.getPart("filename");
        //获取文件名
        String filename = getFileName(part);
        //利用part对象的这个方法直接利用该文件名将该文件写入你设置的location
        part.write(filename );
    }

    /**
     * 利用part对象获得content-Disposition 的参数值获取以便获取对应的文件名称
     * @param part
     * @return
     */
    public  String getFileName(Part part){
        String header = part.getHeader("Content-Disposition");
        System.out.println(header);
        String filename = header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
        return filename;
    }
}
