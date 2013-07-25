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
 * File:                org.anon.smarttest.fw.BaseTest
 * Author:              vjaasti
 * Revision:            1.0
 * Date:                Jul 16, 2013
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * <Purpose>
 *
 * ************************************************************
 * */

package org.anon.smarttest.fw;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.open.loadgen.HTTPRequestor;
import org.open.loadgen.LoadGenerator;
import java.util.logging.Logger;

public class BaseTest
{
    String patternFile;
    protected DataAccessor accessor;
    
    
    @Rule
        public TestWatcher testWatcher = new TestWatcher()
        {
            @Override
            public void starting(Description description)
            {
                testName = description.getMethodName();
                testCase = description.getClassName();
                testCase = testCase.substring(testCase.lastIndexOf('.') + 1);
                System.out.println("Starting JUnit-test: " + testCase + " " + testName);
                logger.info("Starting JUnit-test: " + testCase + " " + testName);
                flowName = testCase;
                tenantName = testCase;
            }
        };

        @Rule
        public TestWatcher watchman = new TestWatcher() {
            @Override
            protected void failed(Throwable e, Description description) {
                logger.severe(e.getLocalizedMessage());
            }

        };
    
    protected String event;
    protected String host;
    
    
    protected String suiteName;
    protected String testCase;
    protected String testName;
    
    protected String flowName;
    protected String testResourceLoc;
    protected String tenantName;
    
    protected Logger logger;
    
    
    public BaseTest(String suiteName)
    {
        host = "localHost:9081";
        testResourceLoc = (System.getProperty("SMARTTESTRESOURCES"));
        if((testResourceLoc == null) || testResourceLoc.length()==0)
        {
            testResourceLoc = System.getenv("SMARTTESTRESOURCES");
            if((testResourceLoc == null) || testResourceLoc.length()==0)
            {
                System.out.println("************ Test resources Location is not set ************");
            }
        }
        System.out.println("TestResources are at:"+testResourceLoc);
            //testJarLoc = "/home/vjaasti/testJars/";
        patternFile = testResourceLoc+suiteName+".txt";
        logger = Logger.getLogger("suiteName");
        accessor = new DataAccessor();
        
    }
    
    public String getTestName() { return testName; }
    public List<String> runTest()
        throws Exception
    {
        LoadGenerator gen = new LoadGenerator(patternFile, testResourceLoc+testName+".txt");
        return gen.runLoad();
    }
    
    public List<String> postTo(String url, String data)
        throws Exception
    {
        HTTPRequestor  request = new HTTPRequestor(new String[]{url+"?"+data}, new CyclicBarrier(1), new CountDownLatch(1));
        List<String> resp = request.runRequests();
        return resp;
    }
    
    public List<String> postTo(String host, String tenant, String flow, String event, String data)
            throws Exception
    {
            String url = "http://"+host+"/"+tenant+"/"+flow+"/"+event;
            return postTo(url, data);
    }
    
    public String getStandardJar()
    {
        String jarName = testResourceLoc+testCase+".jar";
        return jarName;
    }
    
    public List<String> deployStandardJar() 
        throws Exception
    {
       List<String> resp = postTo(host, "SmartOwner", "AdminSmartFlow", "DeployEvent", 
                "{'TenantAdmin':{'___smart_action___':'lookup','___smart_value___':'SmartOwner'}, 'deployJar':'"+getStandardJar()+"','flowsoa':'"+flowName+".soa'}");
       return resp;
    }
    
    public List<String> createTenantForTestCase()
         throws Exception
    {
        List<String> resp = postTo(host, "SmartOwner", "AdminSmartFlow", "NewTenant", 
                "{'TenantAdmin':{'___smart_action___':'lookup','___smart_value___':'SmartOwner'}, 'tenant':'"+testCase+"','enableFlow':'"+flowName+"','enableFeatures':['all']}");
       return resp;
    }
    
    public void assertSuccess(String resp)
    {
        Assert.assertTrue(resp.contains("success")); 
    }
    
    
    public List<String> lookupFor(String group, String key)
        throws Exception
    {
        String url = "http://"+host+"/"+tenantName+"/"+flowName+"/LookupEvent";
        return postTo(url, "{'FlowAdmin':{'___smart_action___':'lookup', '___smart_value___':'"+flowName+"'}, 'group':'"+group+"','key':'"+key+"'}");
    }
    
    public List<String> listObjectsFor(String group, int size)
            throws Exception
    {
            String url = "http://"+host+"/"+tenantName+"/"+flowName+"/ListAllEvent";
            return postTo(url, "{'FlowAdmin':{'___smart_action___':'lookup', '___smart_value___':'"+flowName+"'}, 'group':'"+group+"', 'size':"+size+"}");
    }
    
}
