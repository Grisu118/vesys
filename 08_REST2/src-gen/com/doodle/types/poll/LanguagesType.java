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
 * <p>Java-Klasse für LanguagesType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="LanguagesType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="aa"/>
 *     &lt;enumeration value="ab"/>
 *     &lt;enumeration value="ae"/>
 *     &lt;enumeration value="af"/>
 *     &lt;enumeration value="ak"/>
 *     &lt;enumeration value="am"/>
 *     &lt;enumeration value="an"/>
 *     &lt;enumeration value="ar"/>
 *     &lt;enumeration value="as"/>
 *     &lt;enumeration value="av"/>
 *     &lt;enumeration value="ay"/>
 *     &lt;enumeration value="az"/>
 *     &lt;enumeration value="ba"/>
 *     &lt;enumeration value="be"/>
 *     &lt;enumeration value="bg"/>
 *     &lt;enumeration value="bh"/>
 *     &lt;enumeration value="bi"/>
 *     &lt;enumeration value="bm"/>
 *     &lt;enumeration value="bn"/>
 *     &lt;enumeration value="bo"/>
 *     &lt;enumeration value="br"/>
 *     &lt;enumeration value="bs"/>
 *     &lt;enumeration value="ca"/>
 *     &lt;enumeration value="ce"/>
 *     &lt;enumeration value="ch"/>
 *     &lt;enumeration value="co"/>
 *     &lt;enumeration value="cr"/>
 *     &lt;enumeration value="cs"/>
 *     &lt;enumeration value="cu"/>
 *     &lt;enumeration value="cv"/>
 *     &lt;enumeration value="cy"/>
 *     &lt;enumeration value="da"/>
 *     &lt;enumeration value="de"/>
 *     &lt;enumeration value="dv"/>
 *     &lt;enumeration value="dz"/>
 *     &lt;enumeration value="ee"/>
 *     &lt;enumeration value="el"/>
 *     &lt;enumeration value="en"/>
 *     &lt;enumeration value="eo"/>
 *     &lt;enumeration value="es"/>
 *     &lt;enumeration value="et"/>
 *     &lt;enumeration value="eu"/>
 *     &lt;enumeration value="fa"/>
 *     &lt;enumeration value="ff"/>
 *     &lt;enumeration value="fi"/>
 *     &lt;enumeration value="fj"/>
 *     &lt;enumeration value="fo"/>
 *     &lt;enumeration value="fr"/>
 *     &lt;enumeration value="fy"/>
 *     &lt;enumeration value="ga"/>
 *     &lt;enumeration value="gd"/>
 *     &lt;enumeration value="gl"/>
 *     &lt;enumeration value="gn"/>
 *     &lt;enumeration value="gu"/>
 *     &lt;enumeration value="gv"/>
 *     &lt;enumeration value="ha"/>
 *     &lt;enumeration value="he"/>
 *     &lt;enumeration value="hi"/>
 *     &lt;enumeration value="ho"/>
 *     &lt;enumeration value="hr"/>
 *     &lt;enumeration value="ht"/>
 *     &lt;enumeration value="hu"/>
 *     &lt;enumeration value="hy"/>
 *     &lt;enumeration value="hz"/>
 *     &lt;enumeration value="ia"/>
 *     &lt;enumeration value="id"/>
 *     &lt;enumeration value="ie"/>
 *     &lt;enumeration value="ig"/>
 *     &lt;enumeration value="ii"/>
 *     &lt;enumeration value="ik"/>
 *     &lt;enumeration value="in"/>
 *     &lt;enumeration value="io"/>
 *     &lt;enumeration value="is"/>
 *     &lt;enumeration value="it"/>
 *     &lt;enumeration value="iu"/>
 *     &lt;enumeration value="iw"/>
 *     &lt;enumeration value="ja"/>
 *     &lt;enumeration value="ji"/>
 *     &lt;enumeration value="jv"/>
 *     &lt;enumeration value="ka"/>
 *     &lt;enumeration value="kg"/>
 *     &lt;enumeration value="ki"/>
 *     &lt;enumeration value="kj"/>
 *     &lt;enumeration value="kk"/>
 *     &lt;enumeration value="kl"/>
 *     &lt;enumeration value="km"/>
 *     &lt;enumeration value="kn"/>
 *     &lt;enumeration value="ko"/>
 *     &lt;enumeration value="kr"/>
 *     &lt;enumeration value="ks"/>
 *     &lt;enumeration value="ku"/>
 *     &lt;enumeration value="kv"/>
 *     &lt;enumeration value="kw"/>
 *     &lt;enumeration value="ky"/>
 *     &lt;enumeration value="la"/>
 *     &lt;enumeration value="lb"/>
 *     &lt;enumeration value="lg"/>
 *     &lt;enumeration value="li"/>
 *     &lt;enumeration value="ln"/>
 *     &lt;enumeration value="lo"/>
 *     &lt;enumeration value="lt"/>
 *     &lt;enumeration value="lu"/>
 *     &lt;enumeration value="lv"/>
 *     &lt;enumeration value="mg"/>
 *     &lt;enumeration value="mh"/>
 *     &lt;enumeration value="mi"/>
 *     &lt;enumeration value="mk"/>
 *     &lt;enumeration value="ml"/>
 *     &lt;enumeration value="mn"/>
 *     &lt;enumeration value="mo"/>
 *     &lt;enumeration value="mr"/>
 *     &lt;enumeration value="ms"/>
 *     &lt;enumeration value="mt"/>
 *     &lt;enumeration value="my"/>
 *     &lt;enumeration value="na"/>
 *     &lt;enumeration value="nb"/>
 *     &lt;enumeration value="nd"/>
 *     &lt;enumeration value="ne"/>
 *     &lt;enumeration value="ng"/>
 *     &lt;enumeration value="nl"/>
 *     &lt;enumeration value="nn"/>
 *     &lt;enumeration value="no"/>
 *     &lt;enumeration value="nr"/>
 *     &lt;enumeration value="nv"/>
 *     &lt;enumeration value="ny"/>
 *     &lt;enumeration value="oc"/>
 *     &lt;enumeration value="oj"/>
 *     &lt;enumeration value="om"/>
 *     &lt;enumeration value="or"/>
 *     &lt;enumeration value="os"/>
 *     &lt;enumeration value="pa"/>
 *     &lt;enumeration value="pi"/>
 *     &lt;enumeration value="pl"/>
 *     &lt;enumeration value="ps"/>
 *     &lt;enumeration value="pt"/>
 *     &lt;enumeration value="qu"/>
 *     &lt;enumeration value="rm"/>
 *     &lt;enumeration value="rn"/>
 *     &lt;enumeration value="ro"/>
 *     &lt;enumeration value="ru"/>
 *     &lt;enumeration value="rw"/>
 *     &lt;enumeration value="sa"/>
 *     &lt;enumeration value="sc"/>
 *     &lt;enumeration value="sd"/>
 *     &lt;enumeration value="se"/>
 *     &lt;enumeration value="sg"/>
 *     &lt;enumeration value="si"/>
 *     &lt;enumeration value="sk"/>
 *     &lt;enumeration value="sl"/>
 *     &lt;enumeration value="sm"/>
 *     &lt;enumeration value="sn"/>
 *     &lt;enumeration value="so"/>
 *     &lt;enumeration value="sq"/>
 *     &lt;enumeration value="sr"/>
 *     &lt;enumeration value="ss"/>
 *     &lt;enumeration value="st"/>
 *     &lt;enumeration value="su"/>
 *     &lt;enumeration value="sv"/>
 *     &lt;enumeration value="sw"/>
 *     &lt;enumeration value="ta"/>
 *     &lt;enumeration value="te"/>
 *     &lt;enumeration value="tg"/>
 *     &lt;enumeration value="th"/>
 *     &lt;enumeration value="ti"/>
 *     &lt;enumeration value="tk"/>
 *     &lt;enumeration value="tl"/>
 *     &lt;enumeration value="tn"/>
 *     &lt;enumeration value="to"/>
 *     &lt;enumeration value="tr"/>
 *     &lt;enumeration value="ts"/>
 *     &lt;enumeration value="tt"/>
 *     &lt;enumeration value="tw"/>
 *     &lt;enumeration value="ty"/>
 *     &lt;enumeration value="ug"/>
 *     &lt;enumeration value="uk"/>
 *     &lt;enumeration value="ur"/>
 *     &lt;enumeration value="uz"/>
 *     &lt;enumeration value="ve"/>
 *     &lt;enumeration value="vi"/>
 *     &lt;enumeration value="vo"/>
 *     &lt;enumeration value="wa"/>
 *     &lt;enumeration value="wo"/>
 *     &lt;enumeration value="xh"/>
 *     &lt;enumeration value="yi"/>
 *     &lt;enumeration value="yo"/>
 *     &lt;enumeration value="za"/>
 *     &lt;enumeration value="zh"/>
 *     &lt;enumeration value="zu"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "LanguagesType")
@XmlEnum
public enum LanguagesType {

    @XmlEnumValue("aa")
    AA("aa"),
    @XmlEnumValue("ab")
    AB("ab"),
    @XmlEnumValue("ae")
    AE("ae"),
    @XmlEnumValue("af")
    AF("af"),
    @XmlEnumValue("ak")
    AK("ak"),
    @XmlEnumValue("am")
    AM("am"),
    @XmlEnumValue("an")
    AN("an"),
    @XmlEnumValue("ar")
    AR("ar"),
    @XmlEnumValue("as")
    AS("as"),
    @XmlEnumValue("av")
    AV("av"),
    @XmlEnumValue("ay")
    AY("ay"),
    @XmlEnumValue("az")
    AZ("az"),
    @XmlEnumValue("ba")
    BA("ba"),
    @XmlEnumValue("be")
    BE("be"),
    @XmlEnumValue("bg")
    BG("bg"),
    @XmlEnumValue("bh")
    BH("bh"),
    @XmlEnumValue("bi")
    BI("bi"),
    @XmlEnumValue("bm")
    BM("bm"),
    @XmlEnumValue("bn")
    BN("bn"),
    @XmlEnumValue("bo")
    BO("bo"),
    @XmlEnumValue("br")
    BR("br"),
    @XmlEnumValue("bs")
    BS("bs"),
    @XmlEnumValue("ca")
    CA("ca"),
    @XmlEnumValue("ce")
    CE("ce"),
    @XmlEnumValue("ch")
    CH("ch"),
    @XmlEnumValue("co")
    CO("co"),
    @XmlEnumValue("cr")
    CR("cr"),
    @XmlEnumValue("cs")
    CS("cs"),
    @XmlEnumValue("cu")
    CU("cu"),
    @XmlEnumValue("cv")
    CV("cv"),
    @XmlEnumValue("cy")
    CY("cy"),
    @XmlEnumValue("da")
    DA("da"),
    @XmlEnumValue("de")
    DE("de"),
    @XmlEnumValue("dv")
    DV("dv"),
    @XmlEnumValue("dz")
    DZ("dz"),
    @XmlEnumValue("ee")
    EE("ee"),
    @XmlEnumValue("el")
    EL("el"),
    @XmlEnumValue("en")
    EN("en"),
    @XmlEnumValue("eo")
    EO("eo"),
    @XmlEnumValue("es")
    ES("es"),
    @XmlEnumValue("et")
    ET("et"),
    @XmlEnumValue("eu")
    EU("eu"),
    @XmlEnumValue("fa")
    FA("fa"),
    @XmlEnumValue("ff")
    FF("ff"),
    @XmlEnumValue("fi")
    FI("fi"),
    @XmlEnumValue("fj")
    FJ("fj"),
    @XmlEnumValue("fo")
    FO("fo"),
    @XmlEnumValue("fr")
    FR("fr"),
    @XmlEnumValue("fy")
    FY("fy"),
    @XmlEnumValue("ga")
    GA("ga"),
    @XmlEnumValue("gd")
    GD("gd"),
    @XmlEnumValue("gl")
    GL("gl"),
    @XmlEnumValue("gn")
    GN("gn"),
    @XmlEnumValue("gu")
    GU("gu"),
    @XmlEnumValue("gv")
    GV("gv"),
    @XmlEnumValue("ha")
    HA("ha"),
    @XmlEnumValue("he")
    HE("he"),
    @XmlEnumValue("hi")
    HI("hi"),
    @XmlEnumValue("ho")
    HO("ho"),
    @XmlEnumValue("hr")
    HR("hr"),
    @XmlEnumValue("ht")
    HT("ht"),
    @XmlEnumValue("hu")
    HU("hu"),
    @XmlEnumValue("hy")
    HY("hy"),
    @XmlEnumValue("hz")
    HZ("hz"),
    @XmlEnumValue("ia")
    IA("ia"),
    @XmlEnumValue("id")
    ID("id"),
    @XmlEnumValue("ie")
    IE("ie"),
    @XmlEnumValue("ig")
    IG("ig"),
    @XmlEnumValue("ii")
    II("ii"),
    @XmlEnumValue("ik")
    IK("ik"),
    @XmlEnumValue("in")
    IN("in"),
    @XmlEnumValue("io")
    IO("io"),
    @XmlEnumValue("is")
    IS("is"),
    @XmlEnumValue("it")
    IT("it"),
    @XmlEnumValue("iu")
    IU("iu"),
    @XmlEnumValue("iw")
    IW("iw"),
    @XmlEnumValue("ja")
    JA("ja"),
    @XmlEnumValue("ji")
    JI("ji"),
    @XmlEnumValue("jv")
    JV("jv"),
    @XmlEnumValue("ka")
    KA("ka"),
    @XmlEnumValue("kg")
    KG("kg"),
    @XmlEnumValue("ki")
    KI("ki"),
    @XmlEnumValue("kj")
    KJ("kj"),
    @XmlEnumValue("kk")
    KK("kk"),
    @XmlEnumValue("kl")
    KL("kl"),
    @XmlEnumValue("km")
    KM("km"),
    @XmlEnumValue("kn")
    KN("kn"),
    @XmlEnumValue("ko")
    KO("ko"),
    @XmlEnumValue("kr")
    KR("kr"),
    @XmlEnumValue("ks")
    KS("ks"),
    @XmlEnumValue("ku")
    KU("ku"),
    @XmlEnumValue("kv")
    KV("kv"),
    @XmlEnumValue("kw")
    KW("kw"),
    @XmlEnumValue("ky")
    KY("ky"),
    @XmlEnumValue("la")
    LA("la"),
    @XmlEnumValue("lb")
    LB("lb"),
    @XmlEnumValue("lg")
    LG("lg"),
    @XmlEnumValue("li")
    LI("li"),
    @XmlEnumValue("ln")
    LN("ln"),
    @XmlEnumValue("lo")
    LO("lo"),
    @XmlEnumValue("lt")
    LT("lt"),
    @XmlEnumValue("lu")
    LU("lu"),
    @XmlEnumValue("lv")
    LV("lv"),
    @XmlEnumValue("mg")
    MG("mg"),
    @XmlEnumValue("mh")
    MH("mh"),
    @XmlEnumValue("mi")
    MI("mi"),
    @XmlEnumValue("mk")
    MK("mk"),
    @XmlEnumValue("ml")
    ML("ml"),
    @XmlEnumValue("mn")
    MN("mn"),
    @XmlEnumValue("mo")
    MO("mo"),
    @XmlEnumValue("mr")
    MR("mr"),
    @XmlEnumValue("ms")
    MS("ms"),
    @XmlEnumValue("mt")
    MT("mt"),
    @XmlEnumValue("my")
    MY("my"),
    @XmlEnumValue("na")
    NA("na"),
    @XmlEnumValue("nb")
    NB("nb"),
    @XmlEnumValue("nd")
    ND("nd"),
    @XmlEnumValue("ne")
    NE("ne"),
    @XmlEnumValue("ng")
    NG("ng"),
    @XmlEnumValue("nl")
    NL("nl"),
    @XmlEnumValue("nn")
    NN("nn"),
    @XmlEnumValue("no")
    NO("no"),
    @XmlEnumValue("nr")
    NR("nr"),
    @XmlEnumValue("nv")
    NV("nv"),
    @XmlEnumValue("ny")
    NY("ny"),
    @XmlEnumValue("oc")
    OC("oc"),
    @XmlEnumValue("oj")
    OJ("oj"),
    @XmlEnumValue("om")
    OM("om"),
    @XmlEnumValue("or")
    OR("or"),
    @XmlEnumValue("os")
    OS("os"),
    @XmlEnumValue("pa")
    PA("pa"),
    @XmlEnumValue("pi")
    PI("pi"),
    @XmlEnumValue("pl")
    PL("pl"),
    @XmlEnumValue("ps")
    PS("ps"),
    @XmlEnumValue("pt")
    PT("pt"),
    @XmlEnumValue("qu")
    QU("qu"),
    @XmlEnumValue("rm")
    RM("rm"),
    @XmlEnumValue("rn")
    RN("rn"),
    @XmlEnumValue("ro")
    RO("ro"),
    @XmlEnumValue("ru")
    RU("ru"),
    @XmlEnumValue("rw")
    RW("rw"),
    @XmlEnumValue("sa")
    SA("sa"),
    @XmlEnumValue("sc")
    SC("sc"),
    @XmlEnumValue("sd")
    SD("sd"),
    @XmlEnumValue("se")
    SE("se"),
    @XmlEnumValue("sg")
    SG("sg"),
    @XmlEnumValue("si")
    SI("si"),
    @XmlEnumValue("sk")
    SK("sk"),
    @XmlEnumValue("sl")
    SL("sl"),
    @XmlEnumValue("sm")
    SM("sm"),
    @XmlEnumValue("sn")
    SN("sn"),
    @XmlEnumValue("so")
    SO("so"),
    @XmlEnumValue("sq")
    SQ("sq"),
    @XmlEnumValue("sr")
    SR("sr"),
    @XmlEnumValue("ss")
    SS("ss"),
    @XmlEnumValue("st")
    ST("st"),
    @XmlEnumValue("su")
    SU("su"),
    @XmlEnumValue("sv")
    SV("sv"),
    @XmlEnumValue("sw")
    SW("sw"),
    @XmlEnumValue("ta")
    TA("ta"),
    @XmlEnumValue("te")
    TE("te"),
    @XmlEnumValue("tg")
    TG("tg"),
    @XmlEnumValue("th")
    TH("th"),
    @XmlEnumValue("ti")
    TI("ti"),
    @XmlEnumValue("tk")
    TK("tk"),
    @XmlEnumValue("tl")
    TL("tl"),
    @XmlEnumValue("tn")
    TN("tn"),
    @XmlEnumValue("to")
    TO("to"),
    @XmlEnumValue("tr")
    TR("tr"),
    @XmlEnumValue("ts")
    TS("ts"),
    @XmlEnumValue("tt")
    TT("tt"),
    @XmlEnumValue("tw")
    TW("tw"),
    @XmlEnumValue("ty")
    TY("ty"),
    @XmlEnumValue("ug")
    UG("ug"),
    @XmlEnumValue("uk")
    UK("uk"),
    @XmlEnumValue("ur")
    UR("ur"),
    @XmlEnumValue("uz")
    UZ("uz"),
    @XmlEnumValue("ve")
    VE("ve"),
    @XmlEnumValue("vi")
    VI("vi"),
    @XmlEnumValue("vo")
    VO("vo"),
    @XmlEnumValue("wa")
    WA("wa"),
    @XmlEnumValue("wo")
    WO("wo"),
    @XmlEnumValue("xh")
    XH("xh"),
    @XmlEnumValue("yi")
    YI("yi"),
    @XmlEnumValue("yo")
    YO("yo"),
    @XmlEnumValue("za")
    ZA("za"),
    @XmlEnumValue("zh")
    ZH("zh"),
    @XmlEnumValue("zu")
    ZU("zu");
    private final String value;

    LanguagesType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LanguagesType fromValue(String v) {
        for (LanguagesType c: LanguagesType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
