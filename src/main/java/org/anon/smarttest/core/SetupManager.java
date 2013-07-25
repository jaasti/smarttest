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
 * File:                org.anon.smarttest.core.SetupManager
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

package org.anon.smarttest.core;

import static org.anon.smarttest.config.ConfigManager.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.anon.smarttest.config.FlowDescriptor;
import org.anon.smarttest.config.TestConfig;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class SetupManager
{
    public static String SMARTOWNER = "SmartOwner";
    public static String URL_SEP = "/";
    
    public SetupManager()
    {
        
    }
    
    //assuming SMART is running
    public void setupTests(String testCase)
        throws Exception
    {
       /* TestConfig conf = loadTestConfig(testCase);
        
        deployFlows(conf);
        if(conf.isCreateTenant())
            createTenant(conf);*/
        
        
    }

    public void deployFlows(TestConfig conf)
        throws Exception
    {
       /* List<FlowDescriptor> flows = conf.getFlows();
        for(FlowDescriptor desc : flows)
        {
            post(conf.getSmartURL()+URL_SEP+SMARTOWNER+"DeployEvent", "");
        }
        */
    }

    public void createTenant(TestConfig conf)
        throws Exception
    {
        //post(conf.getSmartURL()+URL_SEP+SMARTOWNER+"NewTenant", "");
    }
            
    public static void post(String url, String data)
        throws ClientProtocolException, IOException
    {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("data", data));
        post.setEntity(new UrlEncodedFormEntity(params));
        client.execute(post);
    }
    
    public static void main(String args[])
        throws Exception
    {
        if(args.length < 1)
        {
            System.out.println("*******************************************************");
            System.out.println("Usage: java SetupManager <testcase>");
            System.out.println("*******************************************************");
        }
        else
        {
            SetupManager manager = new SetupManager();
            manager.setupTests(args[0]);
        }
    }
}
