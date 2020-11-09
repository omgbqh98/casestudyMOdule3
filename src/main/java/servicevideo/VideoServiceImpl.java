package servicevideo;

import model.Video;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoServiceImpl implements VideoService {

    MyConnection myConnection = new MyConnection();
    private static final String INSERT_USERS_SQL = "INSERT INTO video" + "  (title, des, image, link, idUser) VALUES " +
            " (?, ?, ?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select id,name,email,address,image from customer where id =?;";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update users set name = ?,email= ?, address =?,image=? where id = ?;";
    private static final String SEARCH_VIDEO_BY_NAME = "{CALL searchVideoByNameSQL(?)}";
    private static final String FIND_PAGE ="{CALL find_page(?)}";


    public List<Video> findPage(int idUser) {
        List<Video> videos = new ArrayList<>();
        try (CallableStatement callableStatement =myConnection.getConnection().prepareCall(FIND_PAGE)){
            callableStatement.setInt(1,idUser);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idVideo");
                String title = rs.getString("title");
                String des = rs.getString("des");
                String image = rs.getString("image");
                String link = rs.getString("link");
                videos.add(new Video(id, title, des, image,link));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }
    public List<Video> searchByName(String searchName) {
        List<Video> videoByName = new ArrayList<>();
        try {
            CallableStatement callableStatement = myConnection.getConnection().prepareCall(SEARCH_VIDEO_BY_NAME);
            callableStatement.setString(1, searchName);
            ResultSet rs = callableStatement.executeQuery();
            System.out.println("Đây là test: " + callableStatement);
            while (rs.next()) {
                int id = rs.getInt("idVideo");
                String title = rs.getString("title");
                String des = rs.getString("des");
                String image = rs.getString("image");
                String link = rs.getString("link");
                int idUser = rs.getInt("idUser");
                videoByName.add(new Video(id, title,des, image, link, idUser));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return videoByName;
    }

    public void insertVideo(Video video) throws SQLException {
//        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = myConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, video.getTitle());
            preparedStatement.setString(2, video.getDes());
            preparedStatement.setString(3, video.getImage());
            preparedStatement.setString(4, video.getLink());
            preparedStatement.setInt(5, video.getIdUser());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public VideoServiceImpl() {
    }


    public Video getVideoById(int id) {
        Video video = null;
        String query = "{CALL get_by_idVideo(?)}";
        try (Connection connection = myConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setInt(1,id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String des = rs.getString("des");
                String image = rs.getString("image");
                String link = rs.getString("link");
                int idUser = rs.getInt("idUser");
                video = new Video(id, title, des, image,link,idUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return video;
    }





    @Override
    public List<Video> findAll() {
        List<Video> videos = new ArrayList<>();
        try (Connection connection = myConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall("{call find_alll}")) {
            System.out.println(callableStatement);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idVideo");
                String title = rs.getString("title");
                String des = rs.getString("des");
                String image = rs.getString("image");
                String link = rs.getString("link");
                int idUser = rs.getInt("idUser");
                videos.add(new Video(id, title, des, image,link,idUser));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return videos;
    }

    public void addVideo(Video video) throws SQLException {
        String query = "{CALL add_video(?,?,?,?,?)}";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = myConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {
            callableStatement.setString(1, video.getTitle());
            callableStatement.setString(2, video.getDes());
            callableStatement.setString(3, video.getImage());
            callableStatement.setString(4, video.getLink());
            callableStatement.setInt(5, video.getIdVideo());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void addCustomer(Video video) throws SQLException {

    }

    @Override
    public boolean deleteVideo_new(int id) throws SQLException {
        return false;
    }

    @Override
    public Video getIDVideo(int id) {
        return null;
    }

    public boolean updaterCustomer(Video user) throws SQLException {
        boolean rowUpdate;
        try(Connection connection=myConnection.getConnection();
            CallableStatement callableStatement = connection.prepareCall("{call update_customer(?,?,?,?,?)}")) {
            callableStatement.setInt(1, user.getIdVideo());
            callableStatement.setString(2, user.getTitle());
            callableStatement.setString(3, user.getDes());
            callableStatement.setString(4, user.getImage());
            callableStatement.setString(5, user.getImage());
            rowUpdate = callableStatement.executeUpdate() > 0;
        }
        return rowUpdate;
    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
