//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.31 at 01:49:07 PM MSK 
//


package by.it.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Aperture complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Aperture">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="typeOfAperture" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="squareOfAperture" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Aperture", propOrder = {
    "typeOfAperture",
    "width",
    "height",
    "count",
    "squareOfAperture"
})
public class Aperture {

    @XmlElement(required = true)
    protected String typeOfAperture;
    protected double width;
    protected double height;
    protected byte count;
    protected double squareOfAperture;

    /**
     * Gets the value of the typeOfAperture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfAperture() {
        return typeOfAperture;
    }

    /**
     * Sets the value of the typeOfAperture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfAperture(String value) {
        this.typeOfAperture = value;
    }

    /**
     * Gets the value of the width property.
     * 
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     */
    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Gets the value of the count property.
     * 
     */
    public byte getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     */
    public void setCount(byte value) {
        this.count = value;
    }

    /**
     * Gets the value of the squareOfAperture property.
     * 
     */
    public double getSquareOfAperture() {
        return squareOfAperture;
    }

    /**
     * Sets the value of the squareOfAperture property.
     * 
     */
    public void setSquareOfAperture(double value) {
        this.squareOfAperture = value;
    }

}
