package servicevideo;

import model.Video;

import java.sql.SQLException;
import java.util.List;

public interface VideoService {
    public void insertVideo(Video video) throws SQLException;

    public boolean deleteVideo_new(int id) throws SQLException;



    public List<Video> findAll();

    public boolean updaterCustomer(Video user) throws SQLException;
}

