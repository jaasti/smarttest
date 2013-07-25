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
 * File:                org.anon.smarttest.data.DataCleaner
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

package org.anon.smarttest.data;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class DataCleaner implements DALConstants
{
    
    public static void cleanAllDataFor(String tenant, String zkQuoram, String zkPort, String hmaster)
        throws Exception
    {
        //HBaseCleanup
        Configuration conf = HBaseConfiguration.create();
        conf.set(ZOOKEEPER_QUORUM, zkQuoram);
        conf.set(ZOOKEEPER_CLIENT_PORT, zkPort);
        conf.set(HBASE_MASTER, hmaster);
     
        HBaseAdmin admin = new HBaseAdmin(conf);
        HTableDescriptor[] tables = admin.listTables();
        //deleteTables() can be used..but this was suggested way as no rollback
        for(HTableDescriptor desc : tables)
        {
            String tableName = desc.getNameAsString();
            if(tableName.startsWith(TABLE_PREFIX+tenant))
            {
                System.out.println("Deleting Table: " + tableName);
                admin.disableTable(tableName);
                admin.deleteTable(tableName);
            }
        }
    }
    
    public static void main(String args[])
        throws Exception
    {
        if(args.length < 4 )
        {
            System.out.println("*******************************************************");
            System.out.println("Usage: java DataCleaner <tenant> <zookeeperhost> <zookeerperport> <HBasehost:port>");
            System.out.println("*******************************************************");
        }
        
        else
        {
            cleanAllDataFor(args[0], args[1], args[2], args[3]);
        }
    }
}

