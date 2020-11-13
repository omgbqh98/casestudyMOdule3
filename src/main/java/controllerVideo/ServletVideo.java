package controllerVideo;

import model.Comment;
import model.User;
import model.Video;
import serviceuser.UserService;
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

@WebServlet(name = "ServletVideo",urlPatterns="/video")
public class ServletVideo extends HttpServlet {

    private VideoServiceImpl videoService = new VideoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    addVideo(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateVideo(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteVideo(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "searchByName":
                try {
                    searchByName(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "deletePage":
                try {
                    deleteVideoPage(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:

                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "deletePage":
                showDeleteFormPage(request, response);
                break;
            case "view":
                viewVideo(request, response);
                break;
            case "searchByName":
                try {
                    searchByName(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                listVideo(request, response);
                break;
        }
    }
    private void updateVideo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String des = request.getParameter("des");
        String image = request.getParameter("image");
//        String link = request.getParameter("link");
//        int idUser = Integer.parseInt(request.getParameter("idUser"));

        Video video = new Video(id, title, des, image);
        videoService.updaterVideo_new(video);
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("idUser", user.getId());

        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoService.getVideoById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/edit.jsp");
        request.setAttribute("video", video);
        dispatcher.forward(request, response);
    }

    private void deleteVideo(HttpServletRequest request, HttpServletResponse response)   throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        videoService.deleteUser(id);
        User user = (User) request.getSession().getAttribute("user");
        List<Video> listVideo = videoService.findPage(user.getId());
        request.setAttribute("videos", listVideo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/personalPage.jsp");
        dispatcher.forward(request, response);
    }

    UserService userService = new UserService();
    private void deleteVideoPage(HttpServletRequest request, HttpServletResponse response)   throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        videoService.deleteUser(id);
        User user = (User) request.getSession().getAttribute("user");
        List<Video> listVideo = videoService.findPage(user.getId());
        List<User> listUser = userService.findAll();
        request.setAttribute("listUser",listUser);
        request.setAttribute("videos", listVideo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUser.jsp");
        dispatcher.forward(request, response);
    }
    private void showDeleteFormPage(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoService.getVideoById(id);
        RequestDispatcher dispatcher;

        request.setAttribute("video", video);
        dispatcher = request.getRequestDispatcher("video/deleteVideoPage.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Video video = videoService.getVideoById(id);
        RequestDispatcher dispatcher;

        request.setAttribute("video", video);
        dispatcher = request.getRequestDispatcher("video/delete.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String searchName = request.getParameter("searchByName");
        System.out.println("ĐÂY LÀ" + searchName);
        RequestDispatcher dispatcher;
//        if (searchName.equals("")) {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
            List<Video> videoByName = videoService.searchByName(searchName);
            request.setAttribute("video", videoByName);
            dispatcher = request.getRequestDispatcher("video/search.jsp");
            dispatcher.forward(request, response);
        }
//    }



    private void addVideo(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        String des = request.getParameter("des");
        String image = request.getParameter("image");
        String link = request.getParameter("link");
        int idUser = Integer.parseInt(request.getParameter("idUser"));
//        User idUser= request.setAttribute("user", user.getId());
        Video newVideo = new Video(title, des, image,link,idUser);
        videoService.insertVideo(newVideo);
        request.setAttribute("message", "New Video was created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/create.jsp");
        dispatcher.forward(request, response);
        System.out.println("add thanh cong");
    }


    private void listVideo(HttpServletRequest request, HttpServletResponse response) {
        List<Video> videos = videoService.findAll();
//        User userName = (User) request.getSession().getAttribute("user");
//        request.setAttribute("user",userName.getName());
        request.setAttribute("video", videos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewVideo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Video videos = videoService.getVideoById(id);
        List<Comment> comments = userService.finAllComment();
        request.setAttribute("comments", comments);
        RequestDispatcher dispatcher;
        request.setAttribute("video", videos);
        dispatcher = request.getRequestDispatcher("video/view.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        User user = (User)request.getSession().getAttribute("user");
        request.setAttribute("idUser",user.getId());
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/create.jsp");


        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
