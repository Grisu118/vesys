//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.04.14 um 10:08:26 AM CEST 
//


package com.doodle.types.poll;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für FeatureType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="FeatureType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="useCustomURL"/>
 *     &lt;enumeration value="useCustomLogo"/>
 *     &lt;enumeration value="hideAds"/>
 *     &lt;enumeration value="hideDoodleFor"/>
 *     &lt;enumeration value="useCustomDecoration"/>
 *     &lt;enumeration value="useCustomCSS"/>
 *     &lt;enumeration value="requireAuth"/>
 *     &lt;enumeration value="useSSL"/>
 *     &lt;enumeration value="customTheme"/>
 *     &lt;enumeration value="avatar"/>
 *     &lt;enumeration value="extraInformation"/>
 *     &lt;enumeration value="quickReply"/>
 *     &lt;enumeration value="pickSubCalendar"/>
 *     &lt;enumeration value="smsLink"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FeatureType")
@XmlEnum
public enum FeatureType {

    @XmlEnumValue("useCustomURL")
    USE_CUSTOM_URL("useCustomURL"),
    @XmlEnumValue("useCustomLogo")
    USE_CUSTOM_LOGO("useCustomLogo"),
    @XmlEnumValue("hideAds")
    HIDE_ADS("hideAds"),
    @XmlEnumValue("hideDoodleFor")
    HIDE_DOODLE_FOR("hideDoodleFor"),
    @XmlEnumValue("useCustomDecoration")
    USE_CUSTOM_DECORATION("useCustomDecoration"),
    @XmlEnumValue("useCustomCSS")
    USE_CUSTOM_CSS("useCustomCSS"),
    @XmlEnumValue("requireAuth")
    REQUIRE_AUTH("requireAuth"),
    @XmlEnumValue("useSSL")
    USE_SSL("useSSL"),
    @XmlEnumValue("customTheme")
    CUSTOM_THEME("customTheme"),
    @XmlEnumValue("avatar")
    AVATAR("avatar"),
    @XmlEnumValue("extraInformation")
    EXTRA_INFORMATION("extraInformation"),
    @XmlEnumValue("quickReply")
    QUICK_REPLY("quickReply"),
    @XmlEnumValue("pickSubCalendar")
    PICK_SUB_CALENDAR("pickSubCalendar"),
    @XmlEnumValue("smsLink")
    SMS_LINK("smsLink");
    private final String value;

    FeatureType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FeatureType fromValue(String v) {
        for (FeatureType c: FeatureType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
