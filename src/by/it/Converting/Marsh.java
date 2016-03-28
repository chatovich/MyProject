package by.it.Converting;

import by.it.generate.Building;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Маршализация
 */
public class Marsh {
    public static void doMarsh(Building st) {
        try {
            JAXBContext context = JAXBContext.newInstance(Building.class);
            Marshaller m = context.createMarshaller();

            m.marshal(st, new FileOutputStream("src/by/it/ProgramCreate/xmlBuilding.xml"));
            System.out.println("XML-файл создан");
           // m.marshal(st, System.out); // копия на консоль
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}

