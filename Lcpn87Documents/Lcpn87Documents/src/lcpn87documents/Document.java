/***
 * Document class for Lcpn87Documents project
 ***/
package lcpn87documents;

/**
 *
 * @author Carlie
 */
public class Document {
    //creates four private fields for title,author,body,version
    private String title;
    private String author;
    private String body;
    private int version;
    
    //creates constructor receiving title and author parameters
    public Document(String title, String author) {
        this.title=title;
        this.author=author;
        version = 0;
    }
    //creates constructor receiving title,author,body parameters
    public Document(String title, String author, String body) {
        this.title=title;
        this.author=author;
        this.body=body;
        version = 1;
    }
    //creates methods to receive values
    public void setTitle(String title) {
        this.title=title;
        version++;
    }
    public void setAuthor(String author) {
        this.author=author;        
    }
    public void setBody(String body) {
        this.body=body;
        version++;
    }
    //creates methods to return values
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getBody() {
        return body;
    }
    public int getVersion() {
        return version;
    }
    
}
