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
 * File:                org.anon.smarttest.config.TestConfig
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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestConfig
{
    private String zkQuoram;
    private String hMaster;
    private String zkPort;
    
    /*private boolean createTenant = true;
    private String tenant = "";
    private String smartURL = "http://localhost:9181";
    private String testClass = "";*/
    
    public boolean isCreateTenant()
    {
        //return createTenant;
        return false;
    }
    public void setCreateTenant(boolean createTenant)
    {
        //this.createTenant = createTenant;
    }
    public String getTenant()
    {
        return null;
        //return tenant;
    }
    public void setTenant(String tenant)
    {
        //this.tenant = tenant;
    }
    public String getSmartURL()
    {
        return null;
        //return smartURL;
    }
    public void setSmartURL(String smartURL)
    {
        //this.smartURL = smartURL;
    }
    public String getTestClass()
    {
        return null;
       // return testClass;
    }
    public void setTestClass(String testClass)
    {
        //this.testClass = testClass;
    }
    public String getZkQuoram()
    {
        return zkQuoram;
    }
    public void setZkQuoram(String zkQuoram)
    {
        this.zkQuoram = zkQuoram;
    }
    public String gethMaster()
    {
        return hMaster;
    }
    public void sethMaster(String hMaster)
    {
        this.hMaster = hMaster;
    }
    public String getZkPort()
    {
        return zkPort;
    }
    public void setZkPort(String zkPort)
    {
        this.zkPort = zkPort;
    }
    
    
    
}
