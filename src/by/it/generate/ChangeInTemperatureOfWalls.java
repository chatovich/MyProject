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
 * <p>Java class for ChangeInTemperatureOfWalls complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeInTemperatureOfWalls">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id.changeInTemperatureOfWalls" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="fk.id.room" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="changes" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="121" minOccurs="121"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeInTemperatureOfWalls", propOrder = {
    "idChangeInTemperatureOfWalls",
    "fkIdRoom",
    "changes"
})
public class ChangeInTemperatureOfWalls {

    @XmlElement(name = "id.changeInTemperatureOfWalls")
    protected short idChangeInTemperatureOfWalls;
    @XmlElement(name = "fk.id.room")
    protected short fkIdRoom;
    @XmlElement(type = Double.class)
    protected List<Double> changes;

    /**
     * Gets the value of the idChangeInTemperatureOfWalls property.
     * 
     */
    public short getIdChangeInTemperatureOfWalls() {
        return idChangeInTemperatureOfWalls;
    }

    /**
     * Sets the value of the idChangeInTemperatureOfWalls property.
     * 
     */
    public void setIdChangeInTemperatureOfWalls(short value) {
        this.idChangeInTemperatureOfWalls = value;
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
     * Gets the value of the changes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChanges().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getChanges() {
        if (changes == null) {
            changes = new ArrayList<Double>();
        }
        return this.changes;
    }

}
