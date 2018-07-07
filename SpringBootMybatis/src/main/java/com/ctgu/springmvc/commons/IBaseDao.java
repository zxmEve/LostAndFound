package com.ctgu.springmvc.commons;

import java.util.List;

public interface IBaseDao<K, V> {

	/**
	 * ʵ��ԭ�������ݲ���
	 * @param vo   ʵ�������
	 * @return  ����ɹ�����true�����򷵻�false
	 * @throws Exception  �����쳣�׳�
	 */
	public boolean insert(V vo) throws Exception;
	
	/**
	 * ɾ��ָ���ؼ��ʵ�����
	 * @param k �����ض��Ĺؼ���
	 * @return ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception �����쳣�׳�
	 */
	public boolean delete(K k) throws Exception;
	
	/**
	 * ���¶�����Ϣ
	 * @param vo  Ҫ���µ����ݶ���
	 * @return ���³ɹ�����true�����򷵻�false
	 * @throws Exception �����쳣�׳�
	 */
	public boolean update(V vo) throws Exception;
	
	/**
	 *  �����ض�����
	 * @param k  �ض��Ĺؼ���
	 * @return  ��ѯ�ɹ���������Ӧ���󣬷��򷵻�null
	 * @throws Exception �����쳣�׳�
	 */
	public V findByKey(K k) throws Exception;
	
	/**
	 * ��ѯָ���������ж������Ϣ
	 * @return ��ѯ�ɹ����ض���List����δ��ѯ�����󣬷���null
	 * @throws Exception �����쳣�׳�
	 */
	public List<V> findAll() throws Exception;
	
}
