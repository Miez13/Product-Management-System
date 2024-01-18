public class Review {
    private String productName;
    private String reviewTitle;
    private String reviewType;
    private String reviewDescription;
    private int rating;

    public Review(String productName, String title, String type, String description, int rate) {
        this.productName = productName;
        this.reviewTitle = title;
        this.reviewType = type;
        this.reviewDescription = description;
        this.rating = rate;
    }

    public void setProduct(String productName) {
        this.productName = productName;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public void setReviewType(String reviewType) {
        this.reviewType = reviewType;
    }
    
    public void setReviewDescription(String reviewDescription) {
        this.reviewDescription = reviewDescription;
    }
    
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public String getProductName() {
        return productName;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public String getReviewType() {
        return reviewType;
    }

    public String getReviewDescription() {
        return reviewDescription;
    }

    public int getRating() {
        return rating;
    }

    public String toString() { //1
        return (this.productName + "|" + this.reviewTitle + "|" + this.reviewType + "|" + this.reviewDescription + "|" + this.rating);
    }
    
}
