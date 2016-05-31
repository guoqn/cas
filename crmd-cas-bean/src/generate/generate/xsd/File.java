/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.7</a>, using an XML
 * Schema.
 * $Id$
 */

package generate.xsd;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;

/**
 * Class File.
 * 
 * @version $Revision$ $Date$
 */
public class File implements Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private String _name;

    /**
     * Field _description
     */
    private String _description;

    /**
     * Field _package
     */
    private String _package;

    /**
     * Field _jsFileName
     */
    private String _jsFileName;


      //----------------/
     //- Constructors -/
    //----------------/

    public File() 
     {
        super();
    } //-- com.generate.xsd.File()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'description'.
     * 
     * @return String
     * @return the value of field 'description'.
     */
    public String getDescription()
    {
        return this._description;
    } //-- java.lang.String getDescription() 

    /**
     * Returns the value of field 'jsFileName'.
     * 
     * @return String
     * @return the value of field 'jsFileName'.
     */
    public String getJsFileName()
    {
        return this._jsFileName;
    } //-- java.lang.String getJsFileName() 

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'package'.
     * 
     * @return String
     * @return the value of field 'package'.
     */
    public String getPackage()
    {
        return this._package;
    } //-- java.lang.String getPackage() 

    /**
     * Sets the value of field 'description'.
     * 
     * @param description the value of field 'description'.
     */
    public void setDescription(String description)
    {
        this._description = description;
    } //-- void setDescription(java.lang.String) 

    /**
     * Sets the value of field 'jsFileName'.
     * 
     * @param jsFileName the value of field 'jsFileName'.
     */
    public void setJsFileName(String jsFileName)
    {
        this._jsFileName = jsFileName;
    } //-- void setJsFileName(java.lang.String) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'package'.
     * 
     * @param _package
     * @param package the value of field 'package'.
     */
    public void setPackage(String _package)
    {
        this._package = _package;
    } //-- void setPackage(java.lang.String) 

}
