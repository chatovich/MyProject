//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.07 at 12:58:12 AM MSK 
//


package by.it.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommonParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommonParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="positionOfRoom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nameOfRoom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="square" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="perimeter" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="volume" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="squareOfConstruction" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommonParameters", propOrder = {
    "positionOfRoom",
    "nameOfRoom",
    "square",
    "height",
    "perimeter",
    "volume",
    "squareOfConstruction"
})
public class CommonParameters {

    @XmlElement(required = true)
    protected String positionOfRoom;
    @XmlElement(required = true)
    protected String nameOfRoom;
    protected double square;
    protected double height;
    protected double perimeter;
    protected double volume;
    protected double squareOfConstruction;

    /**
     * Gets the value of the positionOfRoom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPositionOfRoom() {
        return positionOfRoom;
    }

    /**
     * Sets the value of the positionOfRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPositionOfRoom(String value) {
        this.positionOfRoom = value;
    }

    /**
     * Gets the value of the nameOfRoom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOfRoom() {
        return nameOfRoom;
    }

    /**
     * Sets the value of the nameOfRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOfRoom(String value) {
        this.nameOfRoom = value;
    }

    /**
     * Gets the value of the square property.
     * 
     */
    public double getSquare() {
        return square;
    }

    /**
     * Sets the value of the square property.
     * 
     */
    public void setSquare(double value) {
        this.square = value;
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
     * Gets the value of the perimeter property.
     * 
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * Sets the value of the perimeter property.
     * 
     */
    public void setPerimeter(double value) {
        this.perimeter = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     */
    public void setVolume(double value) {
        this.volume = value;
    }

    /**
     * Gets the value of the squareOfConstruction property.
     * 
     */
    public double getSquareOfConstruction() {
        return squareOfConstruction;
    }

    /**
     * Sets the value of the squareOfConstruction property.
     * 
     */
    public void setSquareOfConstruction(double value) {
        this.squareOfConstruction = value;
    }

}
