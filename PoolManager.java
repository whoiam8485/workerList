package com.concurrent.list;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class PoolManager<T> {
	

	private ExecutorService threadPool;

	/**
	 * ����һ���̳߳�
	 */
	public void initThreadPool() {
		int num = Runtime.getRuntime().availableProcessors();
		threadPool = Executors.newFixedThreadPool(num * 3);
	}

	/**
	 * �ر��̳߳�
	 */
	public void closeThreadPool() {
		threadPool.shutdown();
	}

	/**
	 * ���̳߳��м�����
	 * 
	 * @param task
	 * @return
	 */
	public Future<List<T>> addTask(final Callable<List<T>> task) {
		final Future<List<T>> future = threadPool.submit(task);
		return future;
	}

}
