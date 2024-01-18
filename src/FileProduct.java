import java.io.*;
import java.util.StringTokenizer;

public class FileProduct {
    private String filePath;

    public FileProduct(String filePath) {
        this.filePath = filePath;
    }

    public LinkedList loadProduct() { //1
        LinkedList products = new LinkedList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line, ",");
                if (token.countTokens() == 5) {
                    String id = token.nextToken();
                    String name = token.nextToken();
                    String brand = token.nextToken();
                    double price = Double.parseDouble(token.nextToken());
                    String available = token.nextToken();
                    Product product = new Product(id, name, brand, price, available);
                    products.insertAtBack(product);
                }
            }
            return products;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public void updateProduct(LinkedList products) { //2
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            Object data = products.getFirst();
            while (data != null) {
                Product product = (Product) data;
                String entry = product.toString();
                writer.println(entry);
                data = products.getNext();
            }
            
        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
    }
}
