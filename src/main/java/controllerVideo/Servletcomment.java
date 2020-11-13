package controllerVideo;

import model.Comment;
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
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet-comment" ,urlPatterns = "/comment")
public class Servletcomment extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            addComment(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    UserService userService = new UserService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
    }

    private void listComment(HttpServletRequest request, HttpServletResponse response) {
        List<Comment> comments = userService.finAllComment();
        request.setAttribute("comments", comments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/view,jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    VideoServiceImpl videoService = new VideoServiceImpl();
    private void addComment(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String input = request.getParameter("comment");
        Comment comment = new Comment(input);
        videoService.addComment(comment);
        request.setAttribute("message", "New Video was created");
        RequestDispatcher dispatcher =request.getRequestDispatcher("video/view.jsp");

        List<Comment> comments = userService.finAllComment();
        request.setAttribute("comments", comments);


        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("comment thanh cong");
    }
}
