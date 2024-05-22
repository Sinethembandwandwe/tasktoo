import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import com.google.gson.Gson;

public class XmlReader {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("C:\\Users\\Sinethemba Ndwandwe\\Downloads\\data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the node name to extract: ");
            String nodeName = scanner.nextLine();
            
            if (nodeList.getLength() == 0) {
                System.out.println("No nodes found with the name: " + nodeName);
                return;
            }

            NodeList nodeList = doc.getElementsByTagName(nodeName);

             // Check if the node list is empty (no matching nodes found)
             if (nodeList.getLength() == 0) {
                System.out.println("No nodes found with the name: " + nodeName);
                return;
            }

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    // Create a Java object with the extracted data
                    String data = node.getTextContent();
                    // Convert Java object to JSON
                    Gson gson = new Gson();
                    String jsonOutput = gson.toJson(data);
                    // Print or output the JSON string
                    System.out.println(jsonOutput);
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}