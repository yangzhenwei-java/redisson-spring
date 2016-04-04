package com.github.redisson.factory;

import org.redisson.Redisson;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

import com.github.redisson.RedissonTemplate;
import com.github.redisson.config.RedissonPoolConfig;

public class RedissonFactoryBean implements DisposableBean, FactoryBean<RedissonTemplate> {

	RedissonPoolConfig config;

	private Redisson redisson;
	


	@Override
	public RedissonTemplate getObject() throws Exception {

		redisson = Redisson.create(config.getConfig());
		RedissonTemplate template = new RedissonTemplate();
		template.setRedisson(redisson);
		return template;
	}

	
	@Override
	public Class<?> getObjectType() {

		return RedissonTemplate.class;
	}

	@Override
	public boolean isSingleton() {

		return true;
	}

	public RedissonPoolConfig getConfig() {
		return config;
	}

	public void setConfig(RedissonPoolConfig config) {
		this.config = config;
	}

	@Override
	public void destroy() throws Exception {

		if (redisson != null) {
			synchronized (this) {
				if (redisson != null) {
					redisson.shutdown();
				}
			}
		}

	}

}
