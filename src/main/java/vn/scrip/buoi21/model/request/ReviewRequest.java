package vn.scrip.buoi21.model.request;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ReviewRequest
{
    private String content;
    private int rating;
}