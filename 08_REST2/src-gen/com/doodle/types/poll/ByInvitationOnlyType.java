//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.04.14 um 10:08:26 AM CEST 
//


package com.doodle.types.poll;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java-Klasse f�r ByInvitationOnlyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ByInvitationOnlyType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>boolean">
 *       &lt;attribute name="nrOfInvitees" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ByInvitationOnlyType", propOrder = {
    "value"
})
public class ByInvitationOnlyType {

    @XmlValue
    protected boolean value;
    @XmlAttribute(name = "nrOfInvitees")
    protected BigInteger nrOfInvitees;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     */
    public boolean isValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    /**
     * Ruft den Wert der nrOfInvitees-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNrOfInvitees() {
        return nrOfInvitees;
    }

    /**
     * Legt den Wert der nrOfInvitees-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNrOfInvitees(BigInteger value) {
        this.nrOfInvitees = value;
    }

}
