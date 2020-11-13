package model;

public class Comment {
    int idComment;
    String comment;
    int idUser;
    int idVideo;

    public Comment() {
    }

    public Comment(int idComment, String comment) {
        this.idComment = idComment;
        this.comment = comment;
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }
}
