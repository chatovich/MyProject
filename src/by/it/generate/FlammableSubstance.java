//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.29 at 10:55:07 PM MSK 
//


package by.it.generate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FlammableSubstance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FlammableSubstance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="amountOfCombustionAir" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="combustionHeat" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="averageSpeedBurnout" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlammableSubstance", propOrder = {
    "name",
    "amountOfCombustionAir",
    "combustionHeat",
    "averageSpeedBurnout",
    "weight"
})
public class FlammableSubstance {

    @XmlElement(required = true)
    protected String name;
    protected double amountOfCombustionAir;
    protected double combustionHeat;
    protected double averageSpeedBurnout;
    protected double weight;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the amountOfCombustionAir property.
     * 
     */
    public double getAmountOfCombustionAir() {
        return amountOfCombustionAir;
    }

    /**
     * Sets the value of the amountOfCombustionAir property.
     * 
     */
    public void setAmountOfCombustionAir(double value) {
        this.amountOfCombustionAir = value;
    }

    /**
     * Gets the value of the combustionHeat property.
     * 
     */
    public double getCombustionHeat() {
        return combustionHeat;
    }

    /**
     * Sets the value of the combustionHeat property.
     * 
     */
    public void setCombustionHeat(double value) {
        this.combustionHeat = value;
    }

    /**
     * Gets the value of the averageSpeedBurnout property.
     * 
     */
    public double getAverageSpeedBurnout() {
        return averageSpeedBurnout;
    }

    /**
     * Sets the value of the averageSpeedBurnout property.
     * 
     */
    public void setAverageSpeedBurnout(double value) {
        this.averageSpeedBurnout = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     */
    public void setWeight(double value) {
        this.weight = value;
    }

}