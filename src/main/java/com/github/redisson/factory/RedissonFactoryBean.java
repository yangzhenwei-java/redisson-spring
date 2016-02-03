package com.github.redisson.factory;

import org.redisson.Redisson;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

import com.github.redisson.RedissonTemplate;
import com.github.redisson.config.RedissonConfig;


public class RedissonFactoryBean implements DisposableBean, FactoryBean<RedissonTemplate> {
	
	
	RedissonConfig config;
	
	RedissonTemplate template;
	
	@Override
	public RedissonTemplate getObject() throws Exception {
		
		Redisson redisson = Redisson.create(config.getConfig());
		
		RedissonTemplate template = new RedissonTemplate();
		template.setRedisson(redisson);
		this.template = template;
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

	public RedissonConfig getConfig() {
		return config;
	}

	public void setConfig(RedissonConfig config) {
		this.config = config;
	}

	@Override
	public  void destroy() throws Exception {
		synchronized (this) {
			template.shutdown();
		}

	}

	
	
}
