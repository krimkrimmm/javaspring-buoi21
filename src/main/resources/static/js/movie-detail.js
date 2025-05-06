<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Chi tiết phim</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <!-- Thông tin phim -->
    <div class="card mb-4">
        <div class="card-body">
            <h3 th:text="${movie.title}">Tiêu đề phim</h3>
            <p th:text="${movie.description}">Mô tả phim</p>
            <p><strong>Thể loại:</strong> <span th:text="${movie.genre}">Action</span></p>
            <p><strong>Năm:</strong> <span th:text="${movie.year}">2024</span></p>
        </div>
    </div>

    <!-- Review -->
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h4>Đánh giá</h4>
        <button class="btn btn-primary" onclick="openCreateReviewModal()">Thêm review</button>
    </div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Nội dung</th>
            <th>Rating</th>
            <th>Hành động</th>
        </tr>
        </thead>
        <tbody>
        <tr th:each="review : ${reviews}">
            <td th:text="${review.content}">Nội dung review</td>
            <td th:text="${review.rating}">5</td>
            <td>
                <button class="btn btn-warning btn-sm"
                        onclick="editReviewModal([[${review.id}]], '[[${review.content}]]', [[${review.rating}]])">Sửa</button>
                <button class="btn btn-danger btn-sm"
                        onclick="deleteReview([[${review.id}]])">Xóa</button>
            </td>
        </tr>
        </tbody>
    </table>
</div>

<!-- Modal thêm/sửa review -->
<div class="modal fade" id="reviewModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <form onsubmit="submitReviewForm(event)">
                <div class="modal-header">
                    <h5 class="modal-title" id="reviewModalTitle">Review</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="reviewId">
                    <input type="hidden" id="movieId" th:value="${movie.id}">
                    <div class="mb-3">
                        <label for="reviewContent" class="form-label">Nội dung</label>
                        <textarea id="reviewContent" class="form-control" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="reviewRating" class="form-label">Đánh giá (1-5)</label>
                        <input type="number" id="reviewRating" class="form-control" min="1" max="5" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Lưu</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function openCreateReviewModal() {
        document.getElementById("reviewId").value = "";
        document.getElementById("reviewContent").value = "";
        document.getElementById("reviewRating").value = 1;
        document.getElementById("reviewModalTitle").innerText = "Thêm review";
        new bootstrap.Modal(document.getElementById("reviewModal")).show();
    }

    function editReviewModal(id, content, rating) {
        document.getElementById("reviewId").value = id;
        document.getElementById("reviewContent").value = content;
        document.getElementById("reviewRating").value = rating;
        document.getElementById("reviewModalTitle").innerText = "Sửa review";
        new bootstrap.Modal(document.getElementById("reviewModal")).show();
    }

    function submitReviewForm(event) {
        event.preventDefault();
        const id = document.getElementById("reviewId").value;
        const content = document.getElementById("reviewContent").value;
        const rating = document.getElementById("reviewRating").value;
        const movieId = document.getElementById("movieId").value;

        const data = { content, rating };
        const url = id ? `/reviews/${id}` : `/api/movies/${movieId}/reviews`;

        fetch(url, {
            method: id ? 'PUT' : 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        }).then(response => {
            if (response.ok) {
                location.reload();
            } else {
                alert("Có lỗi xảy ra!");
            }
        });
    }

    function deleteReview(id) {
        if (confirm("Bạn có chắc chắn muốn xóa review này?")) {
            fetch(`/reviews/${id}`, {
                method: 'DELETE'
            }).then(response => {
                if (response.ok) {
                    location.reload();
                } else {
                    alert("Xóa thất bại!");
                }
            });
        }
    }
</script>
</body>
</html>
