import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SevenServletContext")
public class SevenServletContext extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //获取ServletContext 对象（和服务器打交道的）
        /*
        request.getServletContext()
        this.getServletContext()
        同时两个方法获取的对象是同一个对象
        该对象的功能
        1 获取MINE类型
        MINE：在互联网通信过程中定义的一种文件数据类型
        格式有很多，在web.html中和可以查看很多文件类型
        那莫servletContext 可以t通过该对象获取到相对应的在互联网中传输的类型，就是设置response.setContentType()可以用到
        2 域对象：共享数据
         this.getServletContext().setAttribute(String s1,String s2);
        这个ServletContext 对象所存的值就会存在在整个服务器运行期间，不用通过转发了来共享数据。
        3 获取资源文件的路径
         servletContext.getRealPath("资源文件的路径就是以你建的项目为根目录卡开始找")找java文件在src的下是放在target里面的class里面的，
         所以要获取src里面的就是/target/class/
        */
        ServletContext servletContext = this.getServletContext();
        //
        String mimeType = servletContext.getMimeType("a.jpg");
        System.out.println(mimeType);//image/jpeg

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
