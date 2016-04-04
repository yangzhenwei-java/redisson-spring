package com.github.redisson.config;

import java.lang.reflect.Field;

import org.redisson.ClusterServersConfig;
import org.redisson.Config;
import org.redisson.ElasticacheServersConfig;
import org.redisson.MasterSlaveServersConfig;
import org.redisson.SentinelServersConfig;
import org.redisson.SingleServerConfig;
import org.redisson.client.codec.Codec;
import org.springframework.beans.factory.InitializingBean;



public class RedissonPoolConfig implements InitializingBean {

	
	private ClusterServersConfig clusterConfig;
	
	private ElasticacheServersConfig elasticacheConfig;
	
	private MasterSlaveServersConfig masterSlaveConfig;
	
	private SentinelServersConfig sentinelConfig;
	
	private SingleServerConfig singleConfig;
	
	private Config config;

    private int threads = 0; 

    private Codec codec;

    private boolean useLinuxNativeEpoll;
	
    private int pingTimeout = 1000;

    private int timeout = 60000;

    private int retryAttempts = 20;

    private int retryInterval = 1000;

    private int closeConnectionAfterFailAttempts = -1;

    private int database = 0;

    private String password;

    private int subscriptionsPerConnection = 5;

    private String clientName;

	@Override
	public void afterPropertiesSet() throws Exception {
		
			config = new Config();
			if(singleConfig!=null){
				initSingleConfig(singleConfig);
				return;
			}else if(clusterConfig!=null){
				initClusterConfig(clusterConfig);
				return;
			}else if(elasticacheConfig!=null){
				initElasticacheConfig(elasticacheConfig);
				return;
			}else if(masterSlaveConfig!=null){
				initMasterSlaveConfig(masterSlaveConfig);
				return ;
			}else if(sentinelConfig!=null){
				initSentinelConfig(sentinelConfig);
				return ;
			}else{
				throw new Exception("cluster servers config、sentinel servers config、master/slave servers、single server config、elasticache replication group servers config etc. must be configured with a");
			}
		

		
		
	}



	private void initSentinelConfig(SentinelServersConfig sentinelServersConfig) throws Exception {
        checkClusterServersConfig();
        checkMasterSlaveServersConfig();
        checkElasticacheServersConfig();
        checkSingleServerConfig();
        sentinelServersConfig.setPingTimeout(pingTimeout);
        sentinelServersConfig.setTimeout(timeout);
        sentinelServersConfig.setRetryAttempts(retryAttempts);
        sentinelServersConfig.setRetryInterval(retryInterval) ;
        sentinelServersConfig.setRefreshConnectionAfterFails(closeConnectionAfterFailAttempts);
        sentinelServersConfig.setDatabase(database);
        sentinelServersConfig.setPassword(password);
        sentinelServersConfig.setSubscriptionsPerConnection(subscriptionsPerConnection);
        sentinelServersConfig.setClientName(clientName);
        if(config==null){
        	config = new Config();
        }
		Class<Config> clazz = Config.class;
		Field sentinelServers = clazz.getDeclaredField("sentinelServersConfig");
		sentinelServers.setAccessible(true);
		sentinelServers.set(config, sentinelServersConfig);
		config.setCodec(codec);
		config.setThreads(threads);
		config.setUseLinuxNativeEpoll(useLinuxNativeEpoll);
	}



	private void initMasterSlaveConfig(MasterSlaveServersConfig masterSlaveServersConfig) throws Exception {
        checkClusterServersConfig();
        checkSentinelServersConfig();
        checkElasticacheServersConfig();
        checkSingleServerConfig();
        masterSlaveServersConfig.setPingTimeout(pingTimeout);
        masterSlaveServersConfig.setTimeout(timeout);
        masterSlaveServersConfig.setRetryAttempts(retryAttempts);
        masterSlaveServersConfig.setRetryInterval(retryInterval) ;
        masterSlaveServersConfig.setRefreshConnectionAfterFails(closeConnectionAfterFailAttempts);
        masterSlaveServersConfig.setDatabase(database);
        masterSlaveServersConfig.setPassword(password);
        masterSlaveServersConfig.setSubscriptionsPerConnection(subscriptionsPerConnection);
        masterSlaveServersConfig.setClientName(clientName);
        if(config==null){
        	config = new Config();
        }
		Class<Config> clazz = Config.class;
		Field masterSlaveConfig = clazz.getDeclaredField("masterSlaveServersConfig");
		masterSlaveConfig.setAccessible(true);
		masterSlaveConfig.set(config, masterSlaveServersConfig);
		config.setCodec(codec);
		config.setThreads(threads);
		config.setUseLinuxNativeEpoll(useLinuxNativeEpoll);
		
	}



	private void initElasticacheConfig(ElasticacheServersConfig elasticacheServersConfig) throws Exception {
        checkClusterServersConfig();
        checkMasterSlaveServersConfig();
        checkSentinelServersConfig();
        checkSingleServerConfig();
        elasticacheServersConfig.setPingTimeout(pingTimeout);
        elasticacheServersConfig.setTimeout(timeout);
        elasticacheServersConfig.setRetryAttempts(retryAttempts);
        elasticacheServersConfig.setRetryInterval(retryInterval) ;
        elasticacheServersConfig.setRefreshConnectionAfterFails(closeConnectionAfterFailAttempts);
        elasticacheServersConfig.setDatabase(database);
        elasticacheServersConfig.setPassword(password);
        elasticacheServersConfig.setSubscriptionsPerConnection(subscriptionsPerConnection);
        elasticacheServersConfig.setClientName(clientName);
        if(config==null){
        	config = new Config();
        }
		Class<Config> clazz = Config.class;
		Field elasticacheConfig = clazz.getDeclaredField("elasticacheServersConfig");
		elasticacheConfig.setAccessible(true);
		elasticacheConfig.set(config, elasticacheServersConfig);
		config.setCodec(codec);
		config.setThreads(threads);
		config.setUseLinuxNativeEpoll(useLinuxNativeEpoll);
		
	}



	private void initClusterConfig(ClusterServersConfig clusterServersConfig) throws Exception {
        checkMasterSlaveServersConfig();
        checkSentinelServersConfig();
        checkElasticacheServersConfig();
        checkSingleServerConfig();
        clusterServersConfig.setPingTimeout(pingTimeout);
        clusterServersConfig.setTimeout(timeout);
        clusterServersConfig.setRetryAttempts(retryAttempts);
        clusterServersConfig.setRetryInterval(retryInterval) ;
        clusterServersConfig.setRefreshConnectionAfterFails(closeConnectionAfterFailAttempts);
        clusterServersConfig.setDatabase(database);
        clusterServersConfig.setPassword(password);
        clusterServersConfig.setSubscriptionsPerConnection(subscriptionsPerConnection);
        clusterServersConfig.setClientName(clientName);
        if(config==null){
        	config = new Config();
        }
		Class<Config> clazz = Config.class;
		Field clusterConfig = clazz.getDeclaredField("clusterServersConfig");
		clusterConfig.setAccessible(true);
		clusterConfig.set(config, clusterServersConfig);
		config.setCodec(codec);
		config.setThreads(threads);
		config.setUseLinuxNativeEpoll(useLinuxNativeEpoll);
		
	}



	private void initSingleConfig(SingleServerConfig singleServerConfig) throws Exception {
        checkClusterServersConfig();
        checkMasterSlaveServersConfig();
        checkSentinelServersConfig();
        checkElasticacheServersConfig();
        singleServerConfig.setPingTimeout(pingTimeout);
        singleServerConfig.setTimeout(timeout);
        singleServerConfig.setRetryAttempts(retryAttempts);
        singleServerConfig.setRetryInterval(retryInterval) ;
        singleServerConfig.setRefreshConnectionAfterFails(closeConnectionAfterFailAttempts);
        singleServerConfig.setDatabase(database);
        singleServerConfig.setPassword(password);
        singleServerConfig.setSubscriptionsPerConnection(subscriptionsPerConnection);
        singleServerConfig.setClientName(clientName);
        if(config==null){
        	config = new Config();
        }
		Class<Config> clazz = Config.class;
		Field singleConfig = clazz.getDeclaredField("singleServerConfig");
		singleConfig.setAccessible(true);
		singleConfig.set(config, singleServerConfig);
		config.setCodec(codec);
		config.setThreads(threads);
		config.setUseLinuxNativeEpoll(useLinuxNativeEpoll);
	}



	public Config getConfig() {
		return config;
	}

	public int getPingTimeout() {
		return pingTimeout;
	}

	public void setPingTimeout(int pingTimeout) {
		this.pingTimeout = pingTimeout;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetryAttempts() {
		return retryAttempts;
	}

	public void setRetryAttempts(int retryAttempts) {
		this.retryAttempts = retryAttempts;
	}

	public int getRetryInterval() {
		return retryInterval;
	}

	public void setRetryInterval(int retryInterval) {
		this.retryInterval = retryInterval;
	}

	public int getCloseConnectionAfterFailAttempts() {
		return closeConnectionAfterFailAttempts;
	}

	public void setCloseConnectionAfterFailAttempts(int closeConnectionAfterFailAttempts) {
		this.closeConnectionAfterFailAttempts = closeConnectionAfterFailAttempts;
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSubscriptionsPerConnection() {
		return subscriptionsPerConnection;
	}

	public void setSubscriptionsPerConnection(int subscriptionsPerConnection) {
		this.subscriptionsPerConnection = subscriptionsPerConnection;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


    private void checkClusterServersConfig() {
        if (clusterConfig != null) {
            throw new IllegalStateException("cluster servers config already used!");
        }
    }

    private void checkSentinelServersConfig() {
        if (sentinelConfig != null) {
            throw new IllegalStateException("sentinel servers config already used!");
        }
    }

    private void checkMasterSlaveServersConfig() {
        if (masterSlaveConfig != null) {
            throw new IllegalStateException("master/slave servers already used!");
        }
    }

    private void checkSingleServerConfig() {
        if (singleConfig != null) {
            throw new IllegalStateException("single server config already used!");
        }
    }
    
    private void checkElasticacheServersConfig() {
        if (elasticacheConfig != null) {
            throw new IllegalStateException("elasticache replication group servers config already used!");
        }
    }



	public ClusterServersConfig getClusterConfig() {
		return clusterConfig;
	}



	public void setClusterConfig(ClusterServersConfig clusterConfig) {
		this.clusterConfig = clusterConfig;
	}



	public ElasticacheServersConfig getElasticacheConfig() {
		return elasticacheConfig;
	}



	public void setElasticacheConfig(ElasticacheServersConfig elasticacheConfig) {
		this.elasticacheConfig = elasticacheConfig;
	}



	public MasterSlaveServersConfig getMasterSlaveConfig() {
		return masterSlaveConfig;
	}



	public void setMasterSlaveConfig(MasterSlaveServersConfig masterSlaveConfig) {
		this.masterSlaveConfig = masterSlaveConfig;
	}



	public SentinelServersConfig getSentinelConfig() {
		return sentinelConfig;
	}



	public void setSentinelConfig(SentinelServersConfig sentinelConfig) {
		this.sentinelConfig = sentinelConfig;
	}



	public SingleServerConfig getSingleConfig() {
		return singleConfig;
	}



	public void setSingleConfig(SingleServerConfig singleConfig) {
		this.singleConfig = singleConfig;
	}



	public int getThreads() {
		return threads;
	}



	public void setThreads(int threads) {
		this.threads = threads;
	}



	public Codec getCodec() {
		return codec;
	}



	public void setCodec(Codec codec) {
		this.codec = codec;
	}



	public boolean isUseLinuxNativeEpoll() {
		return useLinuxNativeEpoll;
	}



	public void setUseLinuxNativeEpoll(boolean useLinuxNativeEpoll) {
		this.useLinuxNativeEpoll = useLinuxNativeEpoll;
	}
	
	
	
	
	public static void main(String[] args) {
		boolean[] a = new boolean[10];
		System.out.println(a[0]);
	}
	

 

}
