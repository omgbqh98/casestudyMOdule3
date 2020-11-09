package controllerVideo;

import model.Video;
import servicevideo.MyConnection;
import servicevideo.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
//                try {
//                    updateCustomer(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                break;
            case "delete":
//                try {
//                    deleteUser(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                break;
            default:

                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
//                showEditFormCustomer(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
                break;
            case "view":
                viewVideo(request,response);
                break;
            case "searchByName":
                try {
                    searchByName(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                listCustomers(request, response);
                break;
        }
    }



    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String searchName = request.getParameter("searchByName");
//        System.out.println("ĐÂY LÀ" + searchName);
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
        String title = request.getParameter("title");
        String des = request.getParameter("des");
        String image = request.getParameter("image");
        String link = request.getParameter("link");
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        Video newVideo = new Video(title, des, image,link,idUser);
        videoService.insertVideo(newVideo);
        request.setAttribute("message", "New Video was created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/create.jsp");
        dispatcher.forward(request, response);
        System.out.println("add thanh cong");
    }


    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Video> videos = videoService.findAll();
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

//    private void viewPage(HttpServletRequest request, HttpServletResponse response) {
//        int idUser = Integer.parseInt(request.getParameter("idUser"));
//        List<Video> videos = videoService.findPage(idUser);
//        request.setAttribute("video",videos);
//        RequestDispatcher dispatcher =request.getRequestDispatcher("video/personalPage.jsp");
//        try {
//            dispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
    private void viewVideo(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Video videos = videoService.getVideoById(id);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("video/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Video customer = videoService.getUserById(id);
//        RequestDispatcher dispatcher;
//        request.setAttribute("customer", customer);
//        dispatcher = request.getRequestDispatcher("Customer/delete.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    private void showEditFormCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Video customer = videoService.getUserById(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer/edit.jsp");
//        request.setAttribute("customer", customer);
//        dispatcher.forward(request, response);
//    }

//    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        try {
//            videoService.deleteUser_new(id);
//            List<Video> listCustomer = videoService.findAll();
//            request.setAttribute("customers", listCustomer);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("Customer/list.jsp");
//            dispatcher.forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        String image = request.getParameter("image");
//
//        Video book = new Video(id, name, email, address,image);
//        videoService.updaterCustomer(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("Customer/edit.jsp");
//        dispatcher.forward(request, response);
//    }
}
