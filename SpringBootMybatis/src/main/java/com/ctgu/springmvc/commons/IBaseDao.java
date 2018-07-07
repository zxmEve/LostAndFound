package com.ctgu.springmvc.commons;

import java.util.List;

public interface IBaseDao<K, V> {

	/**
	 * 实现原子性数据插入
	 * @param vo   实体类对象
	 * @return  插入成功返回true，否则返回false
	 * @throws Exception  出现异常抛出
	 */
	public boolean insert(V vo) throws Exception;
	
	/**
	 * 删除指定关键词的数据
	 * @param k 表中特定的关键字
	 * @return 删除成功返回true，否则返回false
	 * @throws Exception 出现异常抛出
	 */
	public boolean delete(K k) throws Exception;
	
	/**
	 * 更新对象信息
	 * @param vo  要更新的数据对象
	 * @return 更新成功返回true，否则返回false
	 * @throws Exception 出现异常抛出
	 */
	public boolean update(V vo) throws Exception;
	
	/**
	 *  查找特定对象
	 * @param k  特定的关键词
	 * @return  查询成功，返回相应对象，否则返回null
	 * @throws Exception 出现异常抛出
	 */
	public V findByKey(K k) throws Exception;
	
	/**
	 * 查询指定表中所有对象的信息
	 * @return 查询成功返回对象List对象，未查询到对象，返回null
	 * @throws Exception 出现异常抛出
	 */
	public List<V> findAll() throws Exception;
	
}
