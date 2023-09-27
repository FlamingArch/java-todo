import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class Fetch {

  public static void main(String[] args) {

    try {
      URL url = new URI("https://jsonplaceholder.typicode.com/todos/1").toURL();
      URLConnection urlConnection = url.openConnection();
      InputStream rawInputStream = urlConnection.getInputStream();
      InputStream inputStreamBuffer = BufferedInputStream(rawInputStream);
      Reader reader = new InputStreamReader(inputStreamBuffer);

      int line;
      while ((line = reader.read()) != -1) {
        System.out.print((char) line);
      }
    } catch (MalformedURLException e) {
      System.out.println("Malformed URL: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO Error: " + e.getMessage());
    }

    Todo todo = new Todo(1, 1, "delectus aut autem", false);
    System.out.println(todo);
  }
}

class Todo {
  int userId;
  int id;
  String title;
  boolean completed;

  public Todo(int userId, int id, String title, boolean completed) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.completed = completed;
  }

  public String toString() {
    return String.format("userId: %d, id: %d, title: %s, completed: %b", userId, id, title, completed);
  }

  // Getters and setters
  public int getUserId() {
    return userId;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public boolean getCompleted() {
    return completed;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
