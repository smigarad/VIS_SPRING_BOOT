package java1_2023_smi0132.Services;

import java1_2023_smi0132.Models.Product;
import java1_2023_smi0132.Models.Review;
import java1_2023_smi0132.Models.User;
import java1_2023_smi0132.Resources.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void addReview(User user, Product product, String description, int rating){
        Review review = new Review(description, rating, new Date(),user, product);
        reviewRepository.save(review);
    }

    public void deleteReview(int id){
        reviewRepository.deleteById(id);
    }

    public List<Review> getReviewsByProduct(Product product){
        return reviewRepository.findAllByProduct(product);
    }
    public Review getReviewById(int id){
        return reviewRepository.findById(id).orElse(null);
    }
}
