//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.07 at 12:58:12 AM MSK 
//


package by.it.generate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CoefficientSForRoom complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoefficientSForRoom">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id.coefficientSForRoom" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="fk.id.room" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="s" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="6" minOccurs="6"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoefficientSForRoom", propOrder = {
    "idCoefficientSForRoom",
    "fkIdRoom",
    "s"
})
public class CoefficientSForRoom {

    @XmlElement(name = "id.coefficientSForRoom")
    protected short idCoefficientSForRoom;
    @XmlElement(name = "fk.id.room")
    protected short fkIdRoom;
    @XmlElement(type = Double.class)
    protected List<Double> s;

    /**
     * Gets the value of the idCoefficientSForRoom property.
     * 
     */
    public short getIdCoefficientSForRoom() {
        return idCoefficientSForRoom;
    }

    /**
     * Sets the value of the idCoefficientSForRoom property.
     * 
     */
    public void setIdCoefficientSForRoom(short value) {
        this.idCoefficientSForRoom = value;
    }

    /**
     * Gets the value of the fkIdRoom property.
     * 
     */
    public short getFkIdRoom() {
        return fkIdRoom;
    }

    /**
     * Sets the value of the fkIdRoom property.
     * 
     */
    public void setFkIdRoom(short value) {
        this.fkIdRoom = value;
    }

    /**
     * Gets the value of the s property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the s property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getS() {
        if (s == null) {
            s = new ArrayList<Double>();
        }
        return this.s;
    }

}
