**1. git clone "https://github.com/yangzhenwei-java/redisson-spring.git"**

**2. cd redisson-spring && mvn clean install** 
        
**3. 引入项目中,在pom.xml添加**

       <dependency>     
			<groupId>com.github</groupId>     
			<artifactId>redisson-spring</artifactId>      
			<version>0.0.1-SNAPSHOT</version>     
		</dependency> 

**4.单一实例redis配置**

	<bean id="singleConfig" class="org.redisson.SingleServerConfig">
			<!-- 必填! 提供redis服务的网络地址 -->
			<property name="address"  value="192.168.80.133:6379"></property>
			<!-- 非必填! redis发布/订阅模式下连接池的大小,默认最大25个 -->
			<property name="subscriptionConnectionPoolSize"  value="25"></property>
			<!--非必填!	redis 连接词大小,默认最大100个  -->
			<property name="connectionPoolSize"  value="100"></property>
			<!-- 非必填! 默认false -->
			<property name="dnsMonitoring"  value="false"></property>
			<property name="dnsMonitoringInterval"  value="5000"></property>
	</bean>
	<bean id="redissonPoolConfig" class="com.github.redisson.config.RedissonPoolConfig">
		<property name="singleConfig" ref="singleConfig"></property>
		<!-- 非必填! 表示使用的线程最大数。默认0等于当前机器的处理器*2 -->
		<property name="threads"  value="0"></property>
		<!-- 非必填! 编码算法 默认JsonJacksonCodec -->
		<!-- <property name="codec" value=""></property> -->
		<!-- 非必填！epoll是Linux内核为处理大批量文件描述符而作了改进的poll，是Linux下多路复用IO接口select/poll的增强版本 默认false -->
		<property name="useLinuxNativeEpoll" value="false"></property>
		<property name="pingTimeout" value="1000"></property>
		<!-- 非必填  超时时间 默认1分钟 -->
		<property name="timeout" value="60000"></property>
		<!-- 非必填 redis down掉尝试重连的次数  默认20 -->
		<property name="retryAttempts" value="20"></property>
		<!-- 非必填  重连的时间间隔 默认1秒  -->
		<property name="retryInterval" value="1000"></property>
		<!-- 非必填   一定次数重连失败 默认关闭连接 -->
		<property name="closeConnectionAfterFailAttempts" value="10"></property>
		<!-- 非必填  默认选择0号库 -->
		<property name="database" value="0"></property>
		<!-- 非必填 默认null -->
		<!-- <property name="password" value=""></property> -->
		<property name="subscriptionsPerConnection" value="5"></property>	
		<!-- 客户端名称 -->
		<property name="clientName" value="singleServerConfig"></property>	
	</bean>
	
	<bean id="redissonTemplate" class="com.github.redisson.factory.RedissonFactoryBean">
		<property name="config"  ref="redissonPoolConfig"/>
	</bean>


**5.  集群配置（ClusterServersConfig）** 

**6. 主从读写分离配置（MasterSlaveServersConfig）**

**7. 基于哨兵监控配置（SentinelServersConfig）**

**8. ElasticacheServersConfig配置**


**作者邮箱 : sxlc_yzw@163.com**

**作者QQ  :  646473942**

**QQ群	: 459927357**

**欢迎纠正问题。欢迎代码爱好者加入,用业余时间一起完成、优化。为开源贡献自己的力量**
