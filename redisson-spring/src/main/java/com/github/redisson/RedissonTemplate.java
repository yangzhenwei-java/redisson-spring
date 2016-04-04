package com.github.redisson;

import java.util.Collection;
import java.util.List;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.core.ClusterNode;
import org.redisson.core.Node;
import org.redisson.core.NodesGroup;
import org.redisson.core.RAtomicLong;
import org.redisson.core.RBatch;
import org.redisson.core.RBlockingQueue;
import org.redisson.core.RBucket;
import org.redisson.core.RCountDownLatch;
import org.redisson.core.RDeque;
import org.redisson.core.RHyperLogLog;
import org.redisson.core.RKeys;
import org.redisson.core.RLexSortedSet;
import org.redisson.core.RList;
import org.redisson.core.RLock;
import org.redisson.core.RMap;
import org.redisson.core.RPatternTopic;
import org.redisson.core.RQueue;
import org.redisson.core.RScoredSortedSet;
import org.redisson.core.RScript;
import org.redisson.core.RSet;
import org.redisson.core.RSortedSet;
import org.redisson.core.RTopic;
import io.netty.util.concurrent.Future;

public class RedissonTemplate implements RedissonClient{

	
	private Redisson redisson;


	@Override
	public <V> RBucket<V> getBucket(String name) {
		return redisson.getBucket(name);
	}

	@Override
	public <V> RBucket<V> getBucket(String name, Codec codec) {
		return redisson.getBucket(name, codec);
	}

	@Override
	public <V> List<RBucket<V>> getBuckets(String pattern) {
		return redisson.getBuckets(pattern);
	}

	@Override
	public <V> RHyperLogLog<V> getHyperLogLog(String name) {
		return redisson.getHyperLogLog(name);
	}

	@Override
	public <V> RHyperLogLog<V> getHyperLogLog(String name, Codec codec) {
		return redisson.getHyperLogLog(name, codec);
	}

	@Override
	public <V> RList<V> getList(String name) {
		return redisson.getList(name);
	}

	@Override
	public <V> RList<V> getList(String name, Codec codec) {
		
		return redisson.getList(name, codec);
	}

	@Override
	public <K, V> RMap<K, V> getMap(String name) {
		return redisson.getMap(name);
	}

	@Override
	public <K, V> RMap<K, V> getMap(String name, Codec codec) {
		return redisson.getMap(name, codec);
	}

	@Override
	public RLock getLock(String name) {
		return redisson.getLock(name);
	}

	@Override
	public <V> RSet<V> getSet(String name) {
		return redisson.getSet(name);
	}

	@Override
	public <V> RSet<V> getSet(String name, Codec codec) {
		return redisson.getSet(name, codec);
	}

	@Override
	public <V> RSortedSet<V> getSortedSet(String name) {
		return redisson.getSortedSet(name);
	}

	@Override
	public <V> RSortedSet<V> getSortedSet(String name, Codec codec) {
		return redisson.getSortedSet(name, codec);
	}

	@Override
	public <V> RScoredSortedSet<V> getScoredSortedSet(String name) {
		return redisson.getScoredSortedSet(name);
	}

	@Override
	public <V> RScoredSortedSet<V> getScoredSortedSet(String name, Codec codec) {
		return redisson.getScoredSortedSet(name, codec);
	}

	@Override
	public RLexSortedSet getLexSortedSet(String name) {
		return redisson.getLexSortedSet(name);
	}

	@Override
	public <M> RTopic<M> getTopic(String name) {
		return redisson.getTopic(name);
	}

	@Override
	public <M> RTopic<M> getTopic(String name, Codec codec) {
		return redisson.getTopic(name);
	}

	@Override
	public <M> RPatternTopic<M> getPatternTopic(String pattern) {
		return redisson.getPatternTopic(pattern);
	}

	@Override
	public <M> RPatternTopic<M> getPatternTopic(String pattern, Codec codec) {
		return redisson.getPatternTopic(pattern, codec);
	}

	@Override
	public <V> RQueue<V> getQueue(String name) {
		return redisson.getQueue(name);
	}

	@Override
	public <V> RQueue<V> getQueue(String name, Codec codec) {
		return redisson.getQueue(name, codec);
	}

	@Override
	public <V> RBlockingQueue<V> getBlockingQueue(String name) {
		return redisson.getBlockingQueue(name);
	}

	@Override
	public <V> RBlockingQueue<V> getBlockingQueue(String name, Codec codec) {
		return redisson.getBlockingQueue(name, codec);
	}

	@Override
	public <V> RDeque<V> getDeque(String name) {
		return redisson.getDeque(name);
	}

	@Override
	public <V> RDeque<V> getDeque(String name, Codec codec) {
		return redisson.getDeque(name, codec);
	}

	@Override
	public RAtomicLong getAtomicLong(String name) {
		return redisson.getAtomicLong(name);
	}

	@Override
	public RCountDownLatch getCountDownLatch(String name) {
		return redisson.getCountDownLatch(name);
	}

	@Override
	public RScript getScript() {
		return redisson.getScript();
	}

	@Override
	public RBatch createBatch() {
		return redisson.createBatch();
	}

	@Override
	public RKeys getKeys() {
		return redisson.getKeys();
	}

	@Override
	public void shutdown() {
		
	}

	@Override
	public Config getConfig() {
		return redisson.getConfig();
	}

	@Override
	public Collection<String> findKeysByPattern(String pattern) {
		return redisson.findKeysByPattern(pattern);
	}

	@Override
	public Future<Collection<String>> findKeysByPatternAsync(String pattern) {
		return redisson.findKeysByPatternAsync(pattern);
	}

	@Override
	public long deleteByPattern(String pattern) {
		return redisson.deleteByPattern(pattern);
	}

	@Override
	public Future<Long> deleteByPatternAsync(String pattern) {
		return redisson.deleteByPatternAsync(pattern);
	}

	@Override
	public long delete(String... keys) {
		return redisson.delete(keys);
	}

	@Override
	public Future<Long> deleteAsync(String... keys) {
		return redisson.deleteAsync(keys);
	}

	@Override
	public NodesGroup<Node> getNodesGroup() {
		return redisson.getNodesGroup();
	}

	@Override
	public NodesGroup<ClusterNode> getClusterNodesGroup() {
		return redisson.getClusterNodesGroup();
	}

	@Override
	public void flushdb() {
		redisson.flushdb();
	}

	@Override
	public void flushall() {
		redisson.flushall();
		
	}

	public  void setRedisson(Redisson redisson) {
		this.redisson = redisson;
	}

	
}
