package controllerUser;

import model.User;
import model.Video;
import serviceuser.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Servlet-User",urlPatterns = "/users")
public class ServletUser extends HttpServlet {
    UserService userService = new UserService();
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

                break;
            case "edit":

                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    checkLogin(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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

                break;
            case "edit":

                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "searchByName":
                try {
                    searchByName(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    listUser(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String searchName = request.getParameter("searchByName");
//        System.out.println("ĐÂY LÀ" + searchName);
        RequestDispatcher dispatcher;
        if (searchName.equals("")) {
            request.setAttribute("message","rong");
             dispatcher = request.getRequestDispatcher("user/searchUser.jsp");
            dispatcher.forward(request,response);

        } else {
            List<User> userByName = userService.searchByName(searchName);
            request.setAttribute("user", userByName);
            dispatcher = request.getRequestDispatcher("user/searchUser.jsp");
            dispatcher.forward(request, response);
        }
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, SQLException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userService.deleteUser_new(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("message","active account");
        List<User> listUser = userService.findAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUser.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(id);
        RequestDispatcher dispatcher;

        request.setAttribute("user", user);
        dispatcher = request.getRequestDispatcher("user/showDeleteForm.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        String userName = request.getParameter("username");
        String pass = request.getParameter("pass");
        if (userName.equals("admin") && (pass.equals("admin"))) {
            listUser(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
            request.setAttribute("message","wrong account");
        }
    }

    public void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException,IOException,ServletException{

        List<User> listUser = userService.findAll();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/listUser.jsp");
        dispatcher.forward(request, response);
    }

}
