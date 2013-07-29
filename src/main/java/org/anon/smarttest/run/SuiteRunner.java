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
 * File:                org.anon.smarttest.run.SuiteRunner
 * Author:              vjaasti
 * Revision:            1.0
 * Date:                Jul 22, 2013
 *
 * ************************************************************
 * REVISIONS
 * ************************************************************
 * <Purpose>
 *
 * ************************************************************
 * */

package org.anon.smarttest.run;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class SuiteRunner
{
    public void runTestCase(String testSuiteName) 
            throws Exception
        {
            Class testCls = this.getClass().getClassLoader().loadClass(testSuiteName);
            Result result = JUnitCore.runClasses(testCls);
            System.out.println("*******************************************************");
            System.out.println("Completed:"+testSuiteName);
            long time = result.getRunTime();
            int count = result.getRunCount();
            int fCount = result.getFailureCount();
            System.out.println("Time taken:"+time+"ms RunCount:"+count+" Failures:"+fCount);
            List<Failure> failures = result.getFailures();
            
            for(Failure f : failures)
            {
                System.out.println("Failure:"+f.toString());
            }
            System.out.println("*******************************************************");
         }
        public static void main(String args[])
            throws Exception
        {
            if(args.length < 1)
            {
                System.out.println("*******************************************************");
                System.out.println("Usage: java SuiteRunner <testSuite>");
                System.out.println("*******************************************************");
            }
            else
            {
                SuiteRunner runner = new SuiteRunner();
                runner.runTestCase(args[0]);
            }
        }
}
