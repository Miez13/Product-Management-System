import java.io.*;
import java.util.StringTokenizer;

public class FileUser {
    private String filePath;

    public FileUser(String filePath) {
        this.filePath = filePath;
    }

    public LinkedList loadUser() { //1
        LinkedList users = new LinkedList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line, ":");
                if (token.countTokens() == 2) {
                    String username = token.nextToken();
                    int id = Integer.parseInt(token.nextToken());
                    User user = new User(username, id);
                    users.insertAtBack(user);
                }
            }
            return users;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void updateUser(LinkedList users) { //2
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            Object data = users.getFirst();
            while (data != null) {
                User user = (User) data;
                String entry = user.getUserName() + ":" + user.getUserID();
                writer.println(entry);
                data = users.getNext();
            }
        } catch (IOException e) {
            System.out.println("Error writing to user file: " + e.getMessage());
        }
    }
}
