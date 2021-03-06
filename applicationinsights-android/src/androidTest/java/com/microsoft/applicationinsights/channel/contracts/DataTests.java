package com.microsoft.applicationinsights.channel.contracts;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.IOException;
import java.io.StringWriter;
import com.microsoft.applicationinsights.channel.contracts.shared.ITelemetryData;
import com.microsoft.applicationinsights.channel.contracts.Data;

/// <summary>
/// Data contract test class DataTests.
/// </summary>
public class DataTests extends TestCase
{
    public void testBase_dataPropertyWorksAsExpected()
    {
        ITelemetryData expected = new EventData();
        Data item = new Data();
        item.setBaseData(expected);
        ITelemetryData actual = item.getBaseData();
        Assert.assertEquals(expected, actual);
        
        expected = new EventData();
        item.setBaseData(expected);
        actual = item.getBaseData();
        Assert.assertEquals(expected, actual);
    }
    
    public void testSerialize() throws IOException
    {
        Data item = new Data();
        item.setBaseData(new EventData());
        StringWriter writer = new StringWriter();
        item.serialize(writer);
        String expected = "{\"baseData\":{\"ver\":2,\"name\":null}}";
        Assert.assertEquals(expected, writer.toString());
    }

}
