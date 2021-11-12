package utils.marshalling;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@XmlType(name = "people")
@XmlRootElement
public class People {

    UUID uuid = UUID.randomUUID();
    String uuidstr = String.valueOf(uuid);

    @XmlElement(name = "person")
    public List<Person> persons = new ArrayList<>();

    public People(List<Person> persons) {
        this.persons = persons;
    }

    public People() {
    }
}
