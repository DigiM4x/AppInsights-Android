package com.microsoft.applicationinsights.channel.contracts;

import com.microsoft.applicationinsights.channel.contracts.shared.IJsonSerializable;
import com.microsoft.applicationinsights.channel.contracts.shared.JsonHelper;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

/**
 * Data contract class Application.
 */
public class Application implements
    IJsonSerializable
{
    /**
     * Backing field for property Ver.
     */
    private String ver;
    
    /**
     * Initializes a new instance of the <see cref="Application"/> class.
     */
    public Application()
    {
        this.InitializeFields();
    }
    
    /**
     * Gets the Ver property.
     */
    public String getVer() {
        return this.ver;
    }
    
    /**
     * Sets the Ver property.
     */
    public void setVer(String value) {
        this.ver = value;
    }
    

    /**
     * Adds all members of this class to a hashmap
     * @param map to which the members of this class will be added.
     */
    public void addToHashMap(LinkedHashMap<String, String> map)
    {
        if (!(this.ver == null)) {
            map.put("ai.application.ver", this.ver);
        }
    }
    

    /**
     * Serializes the beginning of this object to the passed in writer.
     * @param writer The writer to serialize this object to.
     */
    @Override
    public void serialize(Writer writer) throws IOException
    {
        if (writer == null)
        {
            throw new IllegalArgumentException("writer");
        }
        
        writer.write('{');
        this.serializeContent(writer);
        writer.write('}');
    }

    /**
     * Serializes the beginning of this object to the passed in writer.
     * @param writer The writer to serialize this object to.
     */
    protected String serializeContent(Writer writer) throws IOException
    {
        String prefix = "";
        if (!(this.ver == null))
        {
            writer.write(prefix + "\"ai.application.ver\":");
            writer.write(JsonHelper.convert(this.ver));
            prefix = ",";
        }
        
        return prefix;
    }
    
    /**
     * Optionally initializes fields for the current context.
     */
    protected void InitializeFields() {
        
    }
}
