/**
 * SMART - State Machine ARchiTecture
 *
 * Copyright (C) 2012 Individual contributors as indicated by
 * the @authors tag
 *
 * This file is a part of SMART.
 *
 * SMART is a free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SMART is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * */
 
/**
 * ************************************************************
 * HEADERS
 * ************************************************************
 * File:                org.anon.smarttest.config.ConfigManager
 * Author:              vjaasti
 * Revision:            1.0
 * Date:                Jul 14, 2013
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * <Purpose>
 *
 * ************************************************************
 * */

package org.anon.smarttest.config;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class ConfigManager
{
    //String testResourceLoc;
    public static TestConfig loadTestConfig(String testConfigFile)
        throws Exception
    {
        TestConfig conf = new TestConfig();
        
        try
        {
            String testResourceLoc = (System.getProperty("SMARTTESTRESOURCES"));
            if((testResourceLoc == null) || testResourceLoc.length()==0)
            {
                testResourceLoc = System.getenv("SMARTTESTRESOURCES");
                if((testResourceLoc == null) || testResourceLoc.length()==0)
                {
                    System.out.println("************ Test resources Location is not set ************");
                }
            }
            String fileName = testResourceLoc+testConfigFile+".xml";
            System.out.println("Loading test config from:"+fileName);
            InputStream str = new FileInputStream(fileName);
            JAXBContext ctx = JAXBContext.newInstance(TestConfig.class);
            Unmarshaller  unMarshall = ctx.createUnmarshaller();
            conf = (TestConfig)unMarshall.unmarshal(str);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        
        return conf;
        
    }
}
