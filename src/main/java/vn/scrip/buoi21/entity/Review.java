package vn.scrip.buoi21.entity;

import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;  // Đây là thuộc tính username

    private String comment;  // Cập nhật lại tên thuộc tính này là comment, không phải content
    private int rating;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;  // Phương thức getUsername
    }

    public void setUsername(String username) {
        this.username = username;  // Phương thức setUsername
    }

    public String getComment() {
        return comment;  // Phương thức getComment
    }

    public void setComment(String comment) {
        this.comment = comment;  // Phương thức setComment
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
