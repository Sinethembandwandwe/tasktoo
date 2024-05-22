import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class XmlReaderSAX {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("C:\\Users\\Sinethemba Ndwandwe\\Downloads\\data.xml");

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean isNodeName = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("record")) {
                        isNodeName = true;
                    }
                }

                public void characters(char[] ch, int start, int length) throws SAXException {
                    if (isNodeName) {
                        System.out.println("Node Name: " + new String(ch, start, length));
                        isNodeName = false;
                    }
                }
            };

            saxParser.parse(xmlFile, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}