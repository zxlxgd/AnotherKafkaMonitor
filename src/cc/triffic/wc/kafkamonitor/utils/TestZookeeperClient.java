package cc.triffic.wc.kafkamonitor.utils;

import org.I0Itec.zkclient.ZkClient;

import scala.Option;
import scala.Tuple2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class TestZookeeperClient {

	/*
	static{
		System.setProperty("java.security.auth.login.config","C:\\Users\\zjfh-tangwt\\Desktop\\BigData\\zookeeper\\conf\\jaas.conf");
		System.setProperty("java.security.krb5.conf","C:\\Users\\zjfh-tangwt\\Desktop\\BigData\\zookeeper\\conf\\krb5.conf");
		System.setProperty("zookeeper.sasl.client","true");
	}
	*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ZkClient zkClient = new ZkClient("109.6.13.236:24002,109.6.13.235:24002,109.6.13.234:24002");
		//boolean status = zkClient.exists("/kafka/consumers/example-group2/offsets/FTest1/0");
		
		
		/*
		if(status){
			System.out.println("---I am here");
			List<String> childList = zkClient.getChildren("/kafka/consumers/example-group2/offsets/FTest1/0");
			for(String childName : childList){
				System.out.println(childName);
			}
		}else{
			System.out.println("Sorry, you cannot find me.");
		}
		*/
		
		String path = "/kafka/consumers/example-group2/offsets/FTest1";
	    
		//Tuple2<?, ?> tuple = ZkUtils.readDataMaybeNull(zkClient, path);
		
		Tuple2<?, ?> tuple = zkClient.readData(path, true);
		
        JSONObject obj = JSON.parseObject((String)((Option<?>)tuple._1).get());
        
        //JSON.parseObject((String)((Option<?>)tuple._1).get()).getJSONObject("partitions");
        
        String tempData;
		if (CalendarUtils.getZkHour().equals(obj.getString("hour"))){
			tempData = obj.toJSONString();
			System.out.println(tempData);
		}
        	
		/*
		String zkStr = "109.6.13.236:24002,109.6.13.235:24002,109.6.13.234:24002";
		try {
			ZooKeeper zk = new ZooKeeper(zkStr,45000,null);
			
			
			
			System.out.println("id:"+zk.getSessionId());
			System.out.println("zk root dir:" + zk.getChildren("/", null));
			System.out.println(zk.exists("/kafka_eagle/offsets/group2/ke_test1", false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		*/
		
	}

}
