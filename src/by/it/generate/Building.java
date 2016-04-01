//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.31 at 01:49:07 PM MSK 
//


package by.it.generate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="selectedTemperatureOfRegion" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="coefficientSForBuild" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="4" minOccurs="4"/>
 *         &lt;element name="specifyingCoefficientS5" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="room" type="{http://generate.it.by}Room" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="nameOfBuilding" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "selectedTemperatureOfRegion",
    "coefficientSForBuild",
    "specifyingCoefficientS5",
    "room"
})
@XmlRootElement(name = "building")
public class Building {

    protected double selectedTemperatureOfRegion;
    @XmlElement(type = Double.class)
    protected List<Double> coefficientSForBuild;
    @XmlElement(defaultValue = "1")
    protected double specifyingCoefficientS5;
    @XmlElement(required = true)
    protected List<Room> room;
    @XmlAttribute(name = "nameOfBuilding")
    protected String nameOfBuilding;

    /**
     * Gets the value of the selectedTemperatureOfRegion property.
     * 
     */
    public double getSelectedTemperatureOfRegion() {
        return selectedTemperatureOfRegion;
    }

    /**
     * Sets the value of the selectedTemperatureOfRegion property.
     * 
     */
    public void setSelectedTemperatureOfRegion(double value) {
        this.selectedTemperatureOfRegion = value;
    }

    /**
     * Gets the value of the coefficientSForBuild property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coefficientSForBuild property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoefficientSForBuild().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getCoefficientSForBuild() {
        if (coefficientSForBuild == null) {
            coefficientSForBuild = new ArrayList<Double>();
        }
        return this.coefficientSForBuild;
    }

    /**
     * Gets the value of the specifyingCoefficientS5 property.
     * 
     */
    public double getSpecifyingCoefficientS5() {
        return specifyingCoefficientS5;
    }

    /**
     * Sets the value of the specifyingCoefficientS5 property.
     * 
     */
    public void setSpecifyingCoefficientS5(double value) {
        this.specifyingCoefficientS5 = value;
    }

    /**
     * Gets the value of the room property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the room property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Room }
     * 
     * 
     */
    public List<Room> getRoom() {
        if (room == null) {
            room = new ArrayList<Room>();
        }
        return this.room;
    }

    /**
     * Gets the value of the nameOfBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfBuilding() {
        return nameOfBuilding;
    }

    /**
     * Sets the value of the nameOfBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfBuilding(String value) {
        this.nameOfBuilding = value;
    }

}
