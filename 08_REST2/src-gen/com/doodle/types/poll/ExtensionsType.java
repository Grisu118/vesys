//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.04.14 um 10:08:26 AM CEST 
//


package com.doodle.types.poll;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ExtensionsType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ExtensionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="timeZone" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="columnConstraint" type="{http://doodle.com/xsd1}ColumnConstraintType" />
 *       &lt;attribute name="rowConstraint" type="{http://doodle.com/xsd1}RowConstraintType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtensionsType")
public class ExtensionsType {

    @XmlAttribute(name = "timeZone")
    protected Boolean timeZone;
    @XmlAttribute(name = "columnConstraint")
    protected BigInteger columnConstraint;
    @XmlAttribute(name = "rowConstraint")
    protected Integer rowConstraint;

    /**
     * Ruft den Wert der timeZone-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTimeZone() {
        return timeZone;
    }

    /**
     * Legt den Wert der timeZone-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTimeZone(Boolean value) {
        this.timeZone = value;
    }

    /**
     * Ruft den Wert der columnConstraint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getColumnConstraint() {
        return columnConstraint;
    }

    /**
     * Legt den Wert der columnConstraint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setColumnConstraint(BigInteger value) {
        this.columnConstraint = value;
    }

    /**
     * Ruft den Wert der rowConstraint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRowConstraint() {
        return rowConstraint;
    }

    /**
     * Legt den Wert der rowConstraint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRowConstraint(Integer value) {
        this.rowConstraint = value;
    }

}
