package controllerVideo;

import model.User;
import model.Video;
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

@WebServlet(name = "Servlet-viewPage",urlPatterns = "/viewPage")
public class ServletviewPage extends HttpServlet {
    VideoServiceImpl videoService = new VideoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    viewPage2(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "viewPage2":
                viewPage2(request,response);
                break;
            case "viewPage3":
                viewPage3(request, response);
                break;
            default:
                viewPage(request, response);
        }


    }

    private void viewPage3(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession(false);
//        session.invalidate();
        int id = Integer.parseInt(request.getParameter("id"));

//        Video video = (Video) request.getSession().getAttribute("video");
        List<Video> videos = videoService.findPage(id);
        request.setAttribute("videos", videos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/viewPage3.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewPage2(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession(false);
//        session.invalidate();
        int id = Integer.parseInt(request.getParameter("id"));

//        Video video = (Video) request.getSession().getAttribute("video");
        List<Video> videos = videoService.findPage(id);
        request.setAttribute("videos", videos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/viewPage2.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


        private void viewPage (HttpServletRequest request, HttpServletResponse response){
//            int idUser = Integer.parseInt(request.getParameter("idUser"));
            User user = (User)request.getSession().getAttribute("user");
            request.setAttribute("user",user.getId());
            List<Video> videos = videoService.findPage(user.getId());

            request.setAttribute("videos", videos);

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