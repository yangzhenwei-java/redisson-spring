package com.github.redisson.config;

import org.redisson.Config;
import org.redisson.SingleServerConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;



public class RedissonConfig implements InitializingBean {
	
	private Config config;
	
	private String hostName = "localhost";
	private int port = 6379;
	private int timeout = 60000;
	private String password;
	private int database = 0;

	@Override
	public void afterPropertiesSet() throws Exception {
		
		config = new Config();
		SingleServerConfig singleServerConfig = config.useSingleServer();
		singleServerConfig.setAddress(hostName + ":" +port )
		.setDatabase(database)
		.setTimeout(timeout);
		if(!StringUtils.isEmpty(password)){
			singleServerConfig.setPassword(password);
		}
		
		
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}
	
	
	
	

 

}
