package org.example.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cofradias")
public class CofradiaWrapper {

    private List<cofradia> cofradias;

    public CofradiaWrapper() {
    }

    public CofradiaWrapper(List<cofradia> cofradias) {
        this.cofradias = cofradias;
    }

    @XmlElement(name = "cofradia")
    public List<cofradia> getCofradias() {
        return cofradias;
    }

    public void setCofradias(List<cofradia> cofradias) {
        this.cofradias = cofradias;
    }
}

