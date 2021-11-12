package utils.marshalling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

/**
 * Converting a java object to XML with use JAXB
 */
public class Marshalling {
    public static void main(String[] args) throws JAXBException, IOException {
        List<Person> persons = Arrays.asList(
                new Person(1, "Ivan"),
                new Person(2, "David"),
                new Person(3, "Michell"),
                new Person(4, "Katya"));
        People peopls = new People(persons);

        Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("report.xml"), "utf-8"));

        JAXBContext context = JAXBContext.newInstance(Person.class, People.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(peopls, writer);
        writer.close();
    }
}
