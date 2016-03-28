package by.it.Converting;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Преобразование XML-файла(+ XSL) в HTML
 */
public class XmlToHtml {
    final static String root="src/by/it/Converting/";
    public static void main(String[ ] args) {
        String fileName=root+"RoomToHtml.xml";
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            // установка используемого XSL-преобразования
            Transformer transformer = tf.newTransformer(new StreamSource(root+"RoomToHtml.xsl"));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(root+"RoomToHtml.xml"),
                    new StreamResult(root+"RoomToHtml.html"));
            System.out.println("Transform " + fileName + " complete");
        } catch(TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
}
