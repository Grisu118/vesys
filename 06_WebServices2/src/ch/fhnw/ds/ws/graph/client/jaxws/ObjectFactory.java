
package ch.fhnw.ds.ws.graph.client.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ch.fhnw.ds.ws.graph.client.jaxws package. 
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

    private final static QName _IsDAGResponse_QNAME = new QName("http://server.graph.ws.ds.fhnw.ch/", "isDAGResponse");
    private final static QName _IsDAG_QNAME = new QName("http://server.graph.ws.ds.fhnw.ch/", "isDAG");
    private final static QName _IsTreeResponse_QNAME = new QName("http://server.graph.ws.ds.fhnw.ch/", "isTreeResponse");
    private final static QName _IsTree_QNAME = new QName("http://server.graph.ws.ds.fhnw.ch/", "isTree");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ch.fhnw.ds.ws.graph.client.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IsTree }
     * 
     */
    public IsTree createIsTree() {
        return new IsTree();
    }

    /**
     * Create an instance of {@link IsTreeResponse }
     * 
     */
    public IsTreeResponse createIsTreeResponse() {
        return new IsTreeResponse();
    }

    /**
     * Create an instance of {@link IsDAG }
     * 
     */
    public IsDAG createIsDAG() {
        return new IsDAG();
    }

    /**
     * Create an instance of {@link IsDAGResponse }
     * 
     */
    public IsDAGResponse createIsDAGResponse() {
        return new IsDAGResponse();
    }

    /**
     * Create an instance of {@link Node }
     * 
     */
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsDAGResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.graph.ws.ds.fhnw.ch/", name = "isDAGResponse")
    public JAXBElement<IsDAGResponse> createIsDAGResponse(IsDAGResponse value) {
        return new JAXBElement<IsDAGResponse>(_IsDAGResponse_QNAME, IsDAGResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsDAG }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.graph.ws.ds.fhnw.ch/", name = "isDAG")
    public JAXBElement<IsDAG> createIsDAG(IsDAG value) {
        return new JAXBElement<IsDAG>(_IsDAG_QNAME, IsDAG.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsTreeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.graph.ws.ds.fhnw.ch/", name = "isTreeResponse")
    public JAXBElement<IsTreeResponse> createIsTreeResponse(IsTreeResponse value) {
        return new JAXBElement<IsTreeResponse>(_IsTreeResponse_QNAME, IsTreeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsTree }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.graph.ws.ds.fhnw.ch/", name = "isTree")
    public JAXBElement<IsTree> createIsTree(IsTree value) {
        return new JAXBElement<IsTree>(_IsTree_QNAME, IsTree.class, null, value);
    }

}
