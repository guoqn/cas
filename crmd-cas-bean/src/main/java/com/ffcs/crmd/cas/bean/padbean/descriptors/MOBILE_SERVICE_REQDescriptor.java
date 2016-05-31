/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.3.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.ffcs.crmd.cas.bean.padbean.descriptors;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import com.ffcs.crmd.cas.bean.padbean.MOBILE_SERVICE_REQ;

/**
 * 
 * 
 * @version $Revision$ $Date$
 */
public class MOBILE_SERVICE_REQDescriptor extends org.exolab.castor.xml.util.XMLClassDescriptorImpl {

    /**
     * Field _elementDefinition.
     */
    private boolean _elementDefinition;

    /**
     * Field _nsPrefix.
     */
    private java.lang.String _nsPrefix;

    /**
     * Field _nsURI.
     */
    private java.lang.String _nsURI;

    /**
     * Field _xmlName.
     */
    private java.lang.String _xmlName;

    /**
     * Field _identity.
     */
    private org.exolab.castor.xml.XMLFieldDescriptor _identity;

    public MOBILE_SERVICE_REQDescriptor() {
        super();
        _nsURI = "http://www.bean.cmp.ffcs.cn/reflashPreOrderStatus/";
        _xmlName = "MOBILE_SERVICE_REQ";
        _elementDefinition = false;
        org.exolab.castor.xml.util.XMLFieldDescriptorImpl  desc           = null;
        org.exolab.castor.mapping.FieldHandler             handler        = null;
        org.exolab.castor.xml.FieldValidator               fieldValidator = null;
        //-- initialize attribute descriptors

        //-- initialize element descriptors

        //-- QRY_TYPE
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.ffcs.crmd.cas.bean.padbean.QRY_TYPE.class, "QRY_TYPE", "QRY_TYPE", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                MOBILE_SERVICE_REQ target = (MOBILE_SERVICE_REQ) object;
                return target.getQRY_TYPE();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    MOBILE_SERVICE_REQ target = (MOBILE_SERVICE_REQ) object;
                    target.setQRY_TYPE( (com.ffcs.crmd.cas.bean.padbean.QRY_TYPE) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new com.ffcs.crmd.cas.bean.padbean.QRY_TYPE();
            }
        };
        desc.setSchemaType("com.ffcs.crmd.cas.bean.padbean.QRY_TYPE");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.bean.cmp.ffcs.cn/reflashPreOrderStatus/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: QRY_TYPE
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
        //-- QRY_BODY
        desc = new org.exolab.castor.xml.util.XMLFieldDescriptorImpl(com.ffcs.crmd.cas.bean.padbean.QRY_BODY.class, "QRY_BODY", "QRY_BODY", org.exolab.castor.xml.NodeType.Element);
        handler = new org.exolab.castor.xml.XMLFieldHandler() {
            @Override
            public java.lang.Object getValue( java.lang.Object object ) 
                throws IllegalStateException
            {
                MOBILE_SERVICE_REQ target = (MOBILE_SERVICE_REQ) object;
                return target.getQRY_BODY();
            }
            @Override
            public void setValue( java.lang.Object object, java.lang.Object value) 
                throws IllegalStateException, IllegalArgumentException
            {
                try {
                    MOBILE_SERVICE_REQ target = (MOBILE_SERVICE_REQ) object;
                    target.setQRY_BODY( (com.ffcs.crmd.cas.bean.padbean.QRY_BODY) value);
                } catch (java.lang.Exception ex) {
                    throw new IllegalStateException(ex.toString());
                }
            }
            @Override
            @SuppressWarnings("unused")
            public java.lang.Object newInstance(java.lang.Object parent) {
                return new com.ffcs.crmd.cas.bean.padbean.QRY_BODY();
            }
        };
        desc.setSchemaType("com.ffcs.crmd.cas.bean.padbean.QRY_BODY");
        desc.setHandler(handler);
        desc.setNameSpaceURI("http://www.bean.cmp.ffcs.cn/reflashPreOrderStatus/");
        desc.setMultivalued(false);
        addFieldDescriptor(desc);
        addSequenceElement(desc);

        //-- validation code for: QRY_BODY
        fieldValidator = new org.exolab.castor.xml.FieldValidator();
        { //-- local scope
        }
        desc.setValidator(fieldValidator);
    }

    /**
     * Method getAccessMode.
     * 
     * @return the access mode specified for this class.
     */
    @Override()
    public org.exolab.castor.mapping.AccessMode getAccessMode() {
        return null;
    }

    /**
     * Method getIdentity.
     * 
     * @return the identity field, null if this class has no
     * identity.
     */
    @Override()
    public org.exolab.castor.mapping.FieldDescriptor getIdentity() {
        return _identity;
    }

    /**
     * Method getJavaClass.
     * 
     * @return the Java class represented by this descriptor.
     */
    @Override()
    public java.lang.Class getJavaClass() {
        return com.ffcs.crmd.cas.bean.padbean.MOBILE_SERVICE_REQ.class;
    }

    /**
     * Method getNameSpacePrefix.
     * 
     * @return the namespace prefix to use when marshaling as XML.
     */
    @Override()
    public java.lang.String getNameSpacePrefix() {
        return _nsPrefix;
    }

    /**
     * Method getNameSpaceURI.
     * 
     * @return the namespace URI used when marshaling and
     * unmarshaling as XML.
     */
    @Override()
    public java.lang.String getNameSpaceURI() {
        return _nsURI;
    }

    /**
     * Method getValidator.
     * 
     * @return a specific validator for the class described by this
     * ClassDescriptor.
     */
    @Override()
    public org.exolab.castor.xml.TypeValidator getValidator() {
        return this;
    }

    /**
     * Method getXMLName.
     * 
     * @return the XML Name for the Class being described.
     */
    @Override()
    public java.lang.String getXMLName() {
        return _xmlName;
    }

    /**
     * Method isElementDefinition.
     * 
     * @return true if XML schema definition of this Class is that
     * of a global
     * element or element with anonymous type definition.
     */
    public boolean isElementDefinition() {
        return _elementDefinition;
    }

}
