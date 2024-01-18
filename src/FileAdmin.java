import java.io.*;
import java.util.StringTokenizer;

public class FileAdmin {
    private String filePath;

    public FileAdmin(String filePath) {
        this.filePath = filePath;
    }

    public LinkedList loadAdmin() { //1
        LinkedList admins = new LinkedList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(line, ":");
                if (token.countTokens() == 2) {
                    int id = Integer.parseInt(token.nextToken());
                    String password = token.nextToken();
                    Admin admin = new Admin(id, password);
                    admins.insertAtBack(admin);
                }
            }
            return admins;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }
}
