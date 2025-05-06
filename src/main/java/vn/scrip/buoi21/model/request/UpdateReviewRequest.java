package vn.scrip.buoi21.model.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReviewRequest {
    @NotBlank(message = "Content is required")
    private String content;
    @Min(value = 1)
    @Max(value = 5)
    private int rating;
}


