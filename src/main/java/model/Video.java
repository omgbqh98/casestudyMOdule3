package model;

public class Video {
    private int idVideo;
    private String title;
    private String des;
    private String image;
    private String link;
    private int idUser;

    public Video() {
    }

    public Video(int id, String title, String des, String image, String link, String idUser) {
    }

    public Video(int idVideo, String title, String des, String image) {
        this.idVideo = idVideo;
        this.title = title;
        this.des = des;
        this.image = image;
    }

    public Video(int idVideo, String title, String des, String image, String link) {
        this.idVideo = idVideo;
        this.title = title;
        this.des = des;
        this.image = image;
        this.link = link;
    }

    public Video(int idVideo, String title, String des, String image, String link, int idUser) {
        this.idVideo = idVideo;
        this.title = title;
        this.des = des;
        this.image = image;
        this.link = link;
        this.idUser = idUser;
    }

    public Video(String title, String des, String image, String link, int idUser) {
        this.title = title;
        this.des = des;
        this.image = image;
        this.link = link;
        this.idUser = idUser;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
