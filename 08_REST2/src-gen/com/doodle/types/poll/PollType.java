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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für PollType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PollType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="latestChange" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="type" type="{http://doodle.com/xsd1}PollTypeType" minOccurs="0"/>
 *         &lt;element name="extensions" type="{http://doodle.com/xsd1}ExtensionsType" minOccurs="0"/>
 *         &lt;element name="hidden" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="writeOnce" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="requireAddress" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="requireEMail" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="requirePhone" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="byInvitationOnly" type="{http://doodle.com/xsd1}ByInvitationOnlyType" minOccurs="0"/>
 *         &lt;element name="levels" type="{http://doodle.com/xsd1}LevelsType" minOccurs="0"/>
 *         &lt;element name="state" type="{http://doodle.com/xsd1}StatesType" minOccurs="0"/>
 *         &lt;element name="language" type="{http://doodle.com/xsd1}LanguagesType" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="initiator" type="{http://doodle.com/xsd1}InitiatorType"/>
 *         &lt;element name="options" type="{http://doodle.com/xsd1}OptionsType"/>
 *         &lt;element name="participants" type="{http://doodle.com/xsd1}ParticipantsType" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://doodle.com/xsd1}CommentsType" minOccurs="0"/>
 *         &lt;element name="mandator" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="features" type="{http://doodle.com/xsd1}FeaturesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PollType", propOrder = {
    "latestChange",
    "type",
    "extensions",
    "hidden",
    "writeOnce",
    "requireAddress",
    "requireEMail",
    "requirePhone",
    "byInvitationOnly",
    "levels",
    "state",
    "language",
    "title",
    "location",
    "description",
    "initiator",
    "options",
    "participants",
    "comments",
    "mandator",
    "features"
})
public class PollType {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar latestChange;
    @XmlSchemaType(name = "string")
    protected PollTypeType type;
    protected ExtensionsType extensions;
    protected Boolean hidden;
    protected Boolean writeOnce;
    protected Boolean requireAddress;
    protected Boolean requireEMail;
    protected Boolean requirePhone;
    protected ByInvitationOnlyType byInvitationOnly;
    @XmlSchemaType(name = "integer")
    protected Integer levels;
    @XmlSchemaType(name = "string")
    protected StatesType state;
    @XmlSchemaType(name = "string")
    protected LanguagesType language;
    @XmlElement(required = true)
    protected String title;
    protected String location;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected InitiatorType initiator;
    @XmlElement(required = true)
    protected OptionsType options;
    protected ParticipantsType participants;
    protected CommentsType comments;
    protected BigInteger mandator;
    protected FeaturesType features;

    /**
     * Ruft den Wert der latestChange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLatestChange() {
        return latestChange;
    }

    /**
     * Legt den Wert der latestChange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLatestChange(XMLGregorianCalendar value) {
        this.latestChange = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PollTypeType }
     *     
     */
    public PollTypeType getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PollTypeType }
     *     
     */
    public void setType(PollTypeType value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der extensions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionsType }
     *     
     */
    public ExtensionsType getExtensions() {
        return extensions;
    }

    /**
     * Legt den Wert der extensions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionsType }
     *     
     */
    public void setExtensions(ExtensionsType value) {
        this.extensions = value;
    }

    /**
     * Ruft den Wert der hidden-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHidden() {
        return hidden;
    }

    /**
     * Legt den Wert der hidden-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHidden(Boolean value) {
        this.hidden = value;
    }

    /**
     * Ruft den Wert der writeOnce-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isWriteOnce() {
        return writeOnce;
    }

    /**
     * Legt den Wert der writeOnce-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWriteOnce(Boolean value) {
        this.writeOnce = value;
    }

    /**
     * Ruft den Wert der requireAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequireAddress() {
        return requireAddress;
    }

    /**
     * Legt den Wert der requireAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequireAddress(Boolean value) {
        this.requireAddress = value;
    }

    /**
     * Ruft den Wert der requireEMail-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequireEMail() {
        return requireEMail;
    }

    /**
     * Legt den Wert der requireEMail-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequireEMail(Boolean value) {
        this.requireEMail = value;
    }

    /**
     * Ruft den Wert der requirePhone-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequirePhone() {
        return requirePhone;
    }

    /**
     * Legt den Wert der requirePhone-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequirePhone(Boolean value) {
        this.requirePhone = value;
    }

    /**
     * Ruft den Wert der byInvitationOnly-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ByInvitationOnlyType }
     *     
     */
    public ByInvitationOnlyType getByInvitationOnly() {
        return byInvitationOnly;
    }

    /**
     * Legt den Wert der byInvitationOnly-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ByInvitationOnlyType }
     *     
     */
    public void setByInvitationOnly(ByInvitationOnlyType value) {
        this.byInvitationOnly = value;
    }

    /**
     * Ruft den Wert der levels-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLevels() {
        return levels;
    }

    /**
     * Legt den Wert der levels-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLevels(Integer value) {
        this.levels = value;
    }

    /**
     * Ruft den Wert der state-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StatesType }
     *     
     */
    public StatesType getState() {
        return state;
    }

    /**
     * Legt den Wert der state-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StatesType }
     *     
     */
    public void setState(StatesType value) {
        this.state = value;
    }

    /**
     * Ruft den Wert der language-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LanguagesType }
     *     
     */
    public LanguagesType getLanguage() {
        return language;
    }

    /**
     * Legt den Wert der language-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LanguagesType }
     *     
     */
    public void setLanguage(LanguagesType value) {
        this.language = value;
    }

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Ruft den Wert der location-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Legt den Wert der location-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Ruft den Wert der initiator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link InitiatorType }
     *     
     */
    public InitiatorType getInitiator() {
        return initiator;
    }

    /**
     * Legt den Wert der initiator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link InitiatorType }
     *     
     */
    public void setInitiator(InitiatorType value) {
        this.initiator = value;
    }

    /**
     * Ruft den Wert der options-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OptionsType }
     *     
     */
    public OptionsType getOptions() {
        return options;
    }

    /**
     * Legt den Wert der options-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OptionsType }
     *     
     */
    public void setOptions(OptionsType value) {
        this.options = value;
    }

    /**
     * Ruft den Wert der participants-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantsType }
     *     
     */
    public ParticipantsType getParticipants() {
        return participants;
    }

    /**
     * Legt den Wert der participants-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantsType }
     *     
     */
    public void setParticipants(ParticipantsType value) {
        this.participants = value;
    }

    /**
     * Ruft den Wert der comments-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CommentsType }
     *     
     */
    public CommentsType getComments() {
        return comments;
    }

    /**
     * Legt den Wert der comments-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CommentsType }
     *     
     */
    public void setComments(CommentsType value) {
        this.comments = value;
    }

    /**
     * Ruft den Wert der mandator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMandator() {
        return mandator;
    }

    /**
     * Legt den Wert der mandator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMandator(BigInteger value) {
        this.mandator = value;
    }

    /**
     * Ruft den Wert der features-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FeaturesType }
     *     
     */
    public FeaturesType getFeatures() {
        return features;
    }

    /**
     * Legt den Wert der features-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FeaturesType }
     *     
     */
    public void setFeatures(FeaturesType value) {
        this.features = value;
    }

}
