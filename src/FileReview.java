import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FileReview {
    private String filePath;

    public FileReview(String filePath) {
        this.filePath = filePath;
    }

    public Queue loadReview() {
        Queue reviews = new Queue();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line, "|");
                if (token.countTokens() == 5) {
                    String name = token.nextToken();
                    String title = token.nextToken();
                    String type = token.nextToken();
                    String description = token.nextToken();
                    int rating = Integer.parseInt(token.nextToken());

                    Review review = new Review(name, title, type, description, rating);
                    reviews.enqueue(review);
                }
            }
            return reviews;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public void updateReview(Queue reviews) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            Queue tempQueue = new Queue();
    
            while (!reviews.isEmpty()) {
                Review review = (Review) reviews.dequeue();
                String entry = review.toString(); // Convert Review object to string
                writer.println(entry);
                tempQueue.enqueue(review); // Enqueue the Review object, not the string
            }
    
            while (!tempQueue.isEmpty()) {
                reviews.enqueue(tempQueue.dequeue());
            }
    
        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
    }
    

}
