package utils.marshalling;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Person {

    @XmlAttribute(name = "id")
    Integer id;

    @XmlElement(name = "name")
    public String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }
}
