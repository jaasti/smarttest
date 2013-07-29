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
 * File:                org.anon.smarttest.fw.DataAccessor
 * Author:              vjaasti
 * Revision:            1.0
 * Date:                Jul 23, 2013
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
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.TabExpander;

import org.anon.smarttest.config.ConfigManager;
import org.anon.smarttest.config.TestConfig;
import org.anon.smarttest.data.DALConstants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;


public class DataAccessor implements DALConstants
{
    public TestConfig config;
    public Configuration conf;
    
    public DataAccessor()
    {
        // TODO Auto-generated constructor stub
    
        try
        {
            config = ConfigManager.loadTestConfig("SmartTestConf");
            conf = HBaseConfiguration.create();
            conf.set(ZOOKEEPER_QUORUM, config.getZkQuoram());
            conf.set(ZOOKEEPER_CLIENT_PORT, config.getZkPort());
            conf.set(HBASE_MASTER, config.gethMaster());
            System.out.println("Hbase is at :"+config.gethMaster()+": Zookeeper at:"+config.getZkQuoram());
        }catch(Exception e)
        {
            System.out.println("Error in creating HBase Config...");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void cleanAllDataFor(String tenantName)
            throws Exception
        {
            HBaseAdmin admin = new HBaseAdmin(conf);
            HTableDescriptor[] tables = admin.listTables();
            //deleteTables() can be used..but this was suggested way as no rollback
            for(HTableDescriptor desc : tables)
            {
                String tableName = desc.getNameAsString();
                if(tableName.startsWith(TABLE_PREFIX+tenantName))
                {
                    System.out.println("Deleting Table: " + tableName);
                    admin.disableTable(tableName);
                    admin.deleteTable(tableName);
                }
            }
        }
    public List<String> getRecord(String group, String key)
        throws Exception
    {
        
        return null;
    }
    
    public Map<String, String> getRecordFor(String tenant, String flow, String group, String key)
            throws Exception
        {
        
            System.out.println(conf.toString());
            String tableName = TABLE_PREFIX+tenant+"-"+flow+TABLE_PREFIX+group;
            System.out.println("Getting record from table:"+tableName + " and key:"+key);
            HTable table = new HTable(conf, tableName);
            Get get = new Get(key.getBytes());
            System.out.println(table.getTableDescriptor().toString());
            
            Result result = table.get(get);
            List<KeyValue>  resultSet = result.list();
            Map<String, String> resultMap = new HashMap<String, String>(); 
            for(KeyValue kv : resultSet)
            {
                resultMap.put(kv.getKeyString(), new String(kv.getValue()));
            }
            return resultMap;
                    
        }
}
