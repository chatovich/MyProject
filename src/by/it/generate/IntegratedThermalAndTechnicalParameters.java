//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.29 at 10:55:07 PM MSK 
//


package by.it.generate;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntegratedThermalAndTechnicalParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegratedThermalAndTechnicalParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="maximumMeanBulkTemperature" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="durationOfFireSurround" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="timeReachMaximumMeanBulkTemperature" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="changesInMeanBulkTemperature" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="121" minOccurs="121"/>
 *         &lt;element name="maximumAverageTemperatureOfWallSurface" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="timeToReachMaximumTemperatureOfWallSurface" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="changeInAverageTemperatureOfWalls" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="121" minOccurs="121"/>
 *         &lt;element name="averageMaximumTemperatureOfSlab" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="timeToReachMaximumTemperatureOfSlabSurface" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="changeInAverageTemperatureOfSlab" type="{http://www.w3.org/2001/XMLSchema}double" maxOccurs="121" minOccurs="121"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegratedThermalAndTechnicalParameters", propOrder = {
    "maximumMeanBulkTemperature",
    "durationOfFireSurround",
    "timeReachMaximumMeanBulkTemperature",
    "changesInMeanBulkTemperature",
    "maximumAverageTemperatureOfWallSurface",
    "timeToReachMaximumTemperatureOfWallSurface",
    "changeInAverageTemperatureOfWalls",
    "averageMaximumTemperatureOfSlab",
    "timeToReachMaximumTemperatureOfSlabSurface",
    "changeInAverageTemperatureOfSlab"
})
public class IntegratedThermalAndTechnicalParameters {

    protected double maximumMeanBulkTemperature;
    protected double durationOfFireSurround;
    protected double timeReachMaximumMeanBulkTemperature;
    @XmlElement(type = Double.class)
    protected List<Double> changesInMeanBulkTemperature;
    protected double maximumAverageTemperatureOfWallSurface;
    protected double timeToReachMaximumTemperatureOfWallSurface;
    @XmlElement(type = Double.class)
    protected List<Double> changeInAverageTemperatureOfWalls;
    protected double averageMaximumTemperatureOfSlab;
    protected double timeToReachMaximumTemperatureOfSlabSurface;
    @XmlElement(type = Double.class)
    protected List<Double> changeInAverageTemperatureOfSlab;

    /**
     * Gets the value of the maximumMeanBulkTemperature property.
     * 
     */
    public double getMaximumMeanBulkTemperature() {
        return maximumMeanBulkTemperature;
    }

    /**
     * Sets the value of the maximumMeanBulkTemperature property.
     * 
     */
    public void setMaximumMeanBulkTemperature(double value) {
        this.maximumMeanBulkTemperature = value;
    }

    /**
     * Gets the value of the durationOfFireSurround property.
     * 
     */
    public double getDurationOfFireSurround() {
        return durationOfFireSurround;
    }

    /**
     * Sets the value of the durationOfFireSurround property.
     * 
     */
    public void setDurationOfFireSurround(double value) {
        this.durationOfFireSurround = value;
    }

    /**
     * Gets the value of the timeReachMaximumMeanBulkTemperature property.
     * 
     */
    public double getTimeReachMaximumMeanBulkTemperature() {
        return timeReachMaximumMeanBulkTemperature;
    }

    /**
     * Sets the value of the timeReachMaximumMeanBulkTemperature property.
     * 
     */
    public void setTimeReachMaximumMeanBulkTemperature(double value) {
        this.timeReachMaximumMeanBulkTemperature = value;
    }

    /**
     * Gets the value of the changesInMeanBulkTemperature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changesInMeanBulkTemperature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangesInMeanBulkTemperature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getChangesInMeanBulkTemperature() {
        if (changesInMeanBulkTemperature == null) {
            changesInMeanBulkTemperature = new ArrayList<Double>();
        }
        return this.changesInMeanBulkTemperature;
    }

    /**
     * Gets the value of the maximumAverageTemperatureOfWallSurface property.
     * 
     */
    public double getMaximumAverageTemperatureOfWallSurface() {
        return maximumAverageTemperatureOfWallSurface;
    }

    /**
     * Sets the value of the maximumAverageTemperatureOfWallSurface property.
     * 
     */
    public void setMaximumAverageTemperatureOfWallSurface(double value) {
        this.maximumAverageTemperatureOfWallSurface = value;
    }

    /**
     * Gets the value of the timeToReachMaximumTemperatureOfWallSurface property.
     * 
     */
    public double getTimeToReachMaximumTemperatureOfWallSurface() {
        return timeToReachMaximumTemperatureOfWallSurface;
    }

    /**
     * Sets the value of the timeToReachMaximumTemperatureOfWallSurface property.
     * 
     */
    public void setTimeToReachMaximumTemperatureOfWallSurface(double value) {
        this.timeToReachMaximumTemperatureOfWallSurface = value;
    }

    /**
     * Gets the value of the changeInAverageTemperatureOfWalls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeInAverageTemperatureOfWalls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeInAverageTemperatureOfWalls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getChangeInAverageTemperatureOfWalls() {
        if (changeInAverageTemperatureOfWalls == null) {
            changeInAverageTemperatureOfWalls = new ArrayList<Double>();
        }
        return this.changeInAverageTemperatureOfWalls;
    }

    /**
     * Gets the value of the averageMaximumTemperatureOfSlab property.
     * 
     */
    public double getAverageMaximumTemperatureOfSlab() {
        return averageMaximumTemperatureOfSlab;
    }

    /**
     * Sets the value of the averageMaximumTemperatureOfSlab property.
     * 
     */
    public void setAverageMaximumTemperatureOfSlab(double value) {
        this.averageMaximumTemperatureOfSlab = value;
    }

    /**
     * Gets the value of the timeToReachMaximumTemperatureOfSlabSurface property.
     * 
     */
    public double getTimeToReachMaximumTemperatureOfSlabSurface() {
        return timeToReachMaximumTemperatureOfSlabSurface;
    }

    /**
     * Sets the value of the timeToReachMaximumTemperatureOfSlabSurface property.
     * 
     */
    public void setTimeToReachMaximumTemperatureOfSlabSurface(double value) {
        this.timeToReachMaximumTemperatureOfSlabSurface = value;
    }

    /**
     * Gets the value of the changeInAverageTemperatureOfSlab property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changeInAverageTemperatureOfSlab property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChangeInAverageTemperatureOfSlab().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getChangeInAverageTemperatureOfSlab() {
        if (changeInAverageTemperatureOfSlab == null) {
            changeInAverageTemperatureOfSlab = new ArrayList<Double>();
        }
        return this.changeInAverageTemperatureOfSlab;
    }

}