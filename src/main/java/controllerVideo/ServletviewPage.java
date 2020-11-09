package controllerVideo;

import model.Video;
import servicevideo.VideoService;
import servicevideo.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet-viewPage",urlPatterns = "/viewPage")
public class ServletviewPage extends HttpServlet {
    VideoServiceImpl videoService = new VideoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                viewPage(request, response);
    }
        private void viewPage (HttpServletRequest request, HttpServletResponse response){
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            List<Video> videos = videoService.findPage(idUser);
            request.setAttribute("video", videos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("video/personalPage.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}