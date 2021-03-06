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
 * File:                org.anon.smarttest.run.TestCaseRunner
 * Author:              vjaasti
 * Revision:            1.0
 * Date:                Jul 15, 2013
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * <Purpose>
 *
 * ************************************************************
 * */

package org.anon.smarttest.run;

import org.anon.smarttest.config.ConfigManager;
import org.anon.smarttest.config.TestConfig;
import org.junit.runner.JUnitCore;

public class TestCaseRunner
{

    public void runTestCase(String testName) 
        throws Exception
    {
        TestConfig conf = ConfigManager.loadTestConfig(testName);
        String cls = conf.getTestClass();
        Class testCls = this.getClass().getClassLoader().loadClass(cls);
        JUnitCore.runClasses(testCls);
     }
    public static void main(String args[])
        throws Exception
    {
        if(args.length < 1)
        {
            System.out.println("*******************************************************");
            System.out.println("Usage: java TestCaseRunner <testcase>");
            System.out.println("*******************************************************");
        }
        else
        {
            TestCaseRunner runner = new TestCaseRunner();
            runner.runTestCase(args[0]);
        }
    }
}
