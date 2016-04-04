package com.github.redisson_spring_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Before;
import org.junit.Test;
import org.redisson.core.RKeys;
import org.redisson.core.RMap;
import org.redisson.core.RSet;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.redisson.RedissonTemplate;

/**
 * 单机redis服务  测试样例
 * @author yangzhenwei
 *
 */
public class SingleServerDemo {
	
	public static ClassPathXmlApplicationContext context = null;
	public static RedissonTemplate template = null;
	
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext("spring-context-singleServer.xml");
		context.start();
		template = context.getBean(RedissonTemplate.class);
	}
	
	@Test
	public void test1() throws InterruptedException {

		RedissonTemplate template = context.getBean(RedissonTemplate.class);
		
		final RMap<Object, Object> map = template.getMap("yzw");
		final AtomicLong count = new AtomicLong(0);
		new Thread(new Runnable() {
			
			public void run() {
				while(true){
					count.incrementAndGet();
					map.put(count, "a");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("Thread-yzw-1-->"+count);
				}
				
			}
		},"Thread-yzw-1").start();
		new Thread(new Runnable() {
			
			public void run() {
				while(true){
					count.incrementAndGet();
					map.put(count, "b");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.err.println("Thread-yzw-2-->"+count);
				}
				
			}
		},"Thread-yzw-2").start();
		TimeUnit.HOURS.sleep(12);
	}

	
	@Test
	public void test2() throws InterruptedException{
		RKeys keys = template.getKeys();
		long delete = keys.delete("yzw");
		System.out.println(delete);
		RSet<Object> set = template.getSet("testSet");
		set.add("zhangsan");
		set.add("lisi");
		TimeUnit.HOURS.sleep(12);
		
	}
}
