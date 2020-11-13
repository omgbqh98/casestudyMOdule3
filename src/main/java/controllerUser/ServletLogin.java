package controllerUser;

import model.User;
import model.Video;
import serviceuser.UserService;
import servicevideo.VideoService;
import servicevideo.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet-login",urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    VideoServiceImpl videoService = new VideoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    UserService userService = new UserService();
    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("Username");
        String pass = request.getParameter("Password");

        User user = new UserService().getInformationUser(username);
        System.out.println(user);
        if (new UserService().checkLogin(username, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            System.out.println("dang nhap thanh cong");
            List<Video> videos= videoService.findAll();
            request.setAttribute("video",videos);

            User user1 = (User)request.getSession().getAttribute("user");
//           int id= userService.getIdUser(username, pass);

            request.setAttribute("idUser", user1.getId());

            try {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request,response);

//                response.sendRedirect("video/personalPage.jsp");
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("message","\n" +
                    "The account password is incorrect!" );
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("user/dangnhap.jsp");
                dispatcher.forward(request, response);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
            System.out.println("loi dang nhap");
        }
    }
}
