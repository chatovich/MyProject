//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.05 at 10:27:01 PM MSK 
//


package by.it.generate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParametersCalculatedFireLoad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParametersCalculatedFireLoad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="selectedSs" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="6" minOccurs="6"/>
 *         &lt;element name="specificFireLoad" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="specificFireLoadZVEZDOCHKA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="reducedHeightOfApertures" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="generalSquareOfApertures" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ventilationParameter" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="coefficientK" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="coefficientA" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="coefficientB" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="coefficientS" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="estimatedFireLoad" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParametersCalculatedFireLoad", propOrder = {
    "selectedSs",
    "specificFireLoad",
    "specificFireLoadZVEZDOCHKA",
    "reducedHeightOfApertures",
    "generalSquareOfApertures",
    "ventilationParameter",
    "coefficientK",
    "coefficientA",
    "coefficientB",
    "coefficientS",
    "estimatedFireLoad"
})
public class ParametersCalculatedFireLoad {

    @XmlElement(type = Double.class)
    protected List<Double> selectedSs;
    protected double specificFireLoad;
    protected double specificFireLoadZVEZDOCHKA;
    protected double reducedHeightOfApertures;
    protected double generalSquareOfApertures;
    protected double ventilationParameter;
    protected double coefficientK;
    @XmlElement(defaultValue = "1")
    protected double coefficientA;
    protected double coefficientB;
    protected double coefficientS;
    protected double estimatedFireLoad;

    /**
     * Gets the value of the selectedSs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the selectedSs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSelectedSs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getSelectedSs() {
        if (selectedSs == null) {
            selectedSs = new ArrayList<Double>();
        }
        return this.selectedSs;
    }

    /**
     * Gets the value of the specificFireLoad property.
     * 
     */
    public double getSpecificFireLoad() {
        return specificFireLoad;
    }

    /**
     * Sets the value of the specificFireLoad property.
     * 
     */
    public void setSpecificFireLoad(double value) {
        this.specificFireLoad = value;
    }

    /**
     * Gets the value of the specificFireLoadZVEZDOCHKA property.
     * 
     */
    public double getSpecificFireLoadZVEZDOCHKA() {
        return specificFireLoadZVEZDOCHKA;
    }

    /**
     * Sets the value of the specificFireLoadZVEZDOCHKA property.
     * 
     */
    public void setSpecificFireLoadZVEZDOCHKA(double value) {
        this.specificFireLoadZVEZDOCHKA = value;
    }

    /**
     * Gets the value of the reducedHeightOfApertures property.
     * 
     */
    public double getReducedHeightOfApertures() {
        return reducedHeightOfApertures;
    }

    /**
     * Sets the value of the reducedHeightOfApertures property.
     * 
     */
    public void setReducedHeightOfApertures(double value) {
        this.reducedHeightOfApertures = value;
    }

    /**
     * Gets the value of the generalSquareOfApertures property.
     * 
     */
    public double getGeneralSquareOfApertures() {
        return generalSquareOfApertures;
    }

    /**
     * Sets the value of the generalSquareOfApertures property.
     * 
     */
    public void setGeneralSquareOfApertures(double value) {
        this.generalSquareOfApertures = value;
    }

    /**
     * Gets the value of the ventilationParameter property.
     * 
     */
    public double getVentilationParameter() {
        return ventilationParameter;
    }

    /**
     * Sets the value of the ventilationParameter property.
     * 
     */
    public void setVentilationParameter(double value) {
        this.ventilationParameter = value;
    }

    /**
     * Gets the value of the coefficientK property.
     * 
     */
    public double getCoefficientK() {
        return coefficientK;
    }

    /**
     * Sets the value of the coefficientK property.
     * 
     */
    public void setCoefficientK(double value) {
        this.coefficientK = value;
    }

    /**
     * Gets the value of the coefficientA property.
     * 
     */
    public double getCoefficientA() {
        return coefficientA;
    }

    /**
     * Sets the value of the coefficientA property.
     * 
     */
    public void setCoefficientA(double value) {
        this.coefficientA = value;
    }

    /**
     * Gets the value of the coefficientB property.
     * 
     */
    public double getCoefficientB() {
        return coefficientB;
    }

    /**
     * Sets the value of the coefficientB property.
     * 
     */
    public void setCoefficientB(double value) {
        this.coefficientB = value;
    }

    /**
     * Gets the value of the coefficientS property.
     * 
     */
    public double getCoefficientS() {
        return coefficientS;
    }

    /**
     * Sets the value of the coefficientS property.
     * 
     */
    public void setCoefficientS(double value) {
        this.coefficientS = value;
    }

    /**
     * Gets the value of the estimatedFireLoad property.
     * 
     */
    public double getEstimatedFireLoad() {
        return estimatedFireLoad;
    }

    /**
     * Sets the value of the estimatedFireLoad property.
     * 
     */
    public void setEstimatedFireLoad(double value) {
        this.estimatedFireLoad = value;
    }

}
