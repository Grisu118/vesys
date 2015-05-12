//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.04.14 um 10:08:26 AM CEST 
//


package com.doodle.types.poll;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.doodle.types.poll package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Comment_QNAME = new QName("http://doodle.com/xsd1", "comment");
    private final static QName _Poll_QNAME = new QName("http://doodle.com/xsd1", "poll");
    private final static QName _Participant_QNAME = new QName("http://doodle.com/xsd1", "participant");
    private final static QName _Features_QNAME = new QName("http://doodle.com/xsd1", "features");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.doodle.types.poll
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OptionsType }
     * 
     */
    public OptionsType createOptionsType() {
        return new OptionsType();
    }

    /**
     * Create an instance of {@link ParticipantType }
     * 
     */
    public ParticipantType createParticipantType() {
        return new ParticipantType();
    }

    /**
     * Create an instance of {@link FeaturesType }
     * 
     */
    public FeaturesType createFeaturesType() {
        return new FeaturesType();
    }

    /**
     * Create an instance of {@link CommentType }
     * 
     */
    public CommentType createCommentType() {
        return new CommentType();
    }

    /**
     * Create an instance of {@link PollType }
     * 
     */
    public PollType createPollType() {
        return new PollType();
    }

    /**
     * Create an instance of {@link CommentsType }
     * 
     */
    public CommentsType createCommentsType() {
        return new CommentsType();
    }

    /**
     * Create an instance of {@link ExtensionsType }
     * 
     */
    public ExtensionsType createExtensionsType() {
        return new ExtensionsType();
    }

    /**
     * Create an instance of {@link ByInvitationOnlyType }
     * 
     */
    public ByInvitationOnlyType createByInvitationOnlyType() {
        return new ByInvitationOnlyType();
    }

    /**
     * Create an instance of {@link InitiatorType }
     * 
     */
    public InitiatorType createInitiatorType() {
        return new InitiatorType();
    }

    /**
     * Create an instance of {@link ParticipantsType }
     * 
     */
    public ParticipantsType createParticipantsType() {
        return new ParticipantsType();
    }

    /**
     * Create an instance of {@link OptionsType.Option }
     * 
     */
    public OptionsType.Option createOptionsTypeOption() {
        return new OptionsType.Option();
    }

    /**
     * Create an instance of {@link ParticipantType.Preferences }
     * 
     */
    public ParticipantType.Preferences createParticipantTypePreferences() {
        return new ParticipantType.Preferences();
    }

    /**
     * Create an instance of {@link ParticipantType.AvatarSmallUri }
     * 
     */
    public ParticipantType.AvatarSmallUri createParticipantTypeAvatarSmallUri() {
        return new ParticipantType.AvatarSmallUri();
    }

    /**
     * Create an instance of {@link ParticipantType.AvatarLargeUri }
     * 
     */
    public ParticipantType.AvatarLargeUri createParticipantTypeAvatarLargeUri() {
        return new ParticipantType.AvatarLargeUri();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CommentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://doodle.com/xsd1", name = "comment")
    public JAXBElement<CommentType> createComment(CommentType value) {
        return new JAXBElement<CommentType>(_Comment_QNAME, CommentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PollType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://doodle.com/xsd1", name = "poll")
    public JAXBElement<PollType> createPoll(PollType value) {
        return new JAXBElement<PollType>(_Poll_QNAME, PollType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParticipantType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://doodle.com/xsd1", name = "participant")
    public JAXBElement<ParticipantType> createParticipant(ParticipantType value) {
        return new JAXBElement<ParticipantType>(_Participant_QNAME, ParticipantType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturesType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://doodle.com/xsd1", name = "features")
    public JAXBElement<FeaturesType> createFeatures(FeaturesType value) {
        return new JAXBElement<FeaturesType>(_Features_QNAME, FeaturesType.class, null, value);
    }

}