/***
 * Description: Write a Java application in NetBeans that 
 * utilizes a class written for the application called Document.
 * The application creates instances of Document objects and 
 * utilizes its properties and methods.
 ***/
package lcpn87documents;

/**
 *
 * @author Carlie
 */
public class Lcpn87Documents {
    public static void main(String[] args) {
        //creates document instances
        Document document1 = new Document("Another Life","Sally Smith");
        document1.setBody("The grass is always greener on the other side.");
        Document document2 = new Document("Final Word","Karen Jones");
        document2.setBody("We should plan for the worst and hope for the best.");
        document2.setTitle("Final Words");
        
        //prints out document contents
        System.out.printf("document1:\ntitle: %s\nauthor: %s\nbody: %s\nversion: %s\n", document1.getTitle(),document1.getAuthor(),document1.getBody(),document1.getVersion());
        System.out.printf("document2:\ntitle: %s\nauthor: %s\nbody: %s\nversion: %s\n", document2.getTitle(),document2.getAuthor(),document2.getBody(),document2.getVersion());
    }  
}
