package com.song.model.prototype;

import java.util.Vector;

/**
 * 原型管理器角色
 * 
 * @author songzigw
 *
 */
public class PrototypeManager {

	private Vector<Prototype> objects = new Vector<Prototype>();

	/**
	 * 增加一个新的对象
	 * @param object
	 */
	public void add(Prototype object) {
		objects.add(object);
	}
	
	/**
	 * 取出聚集中的一个对象
	 * @param i
	 * @return
	 */
	public Prototype get(int i) {
		return (Prototype) objects.get(i);
	}
	
	/**
	 * 给出聚集的大小
	 * @return
	 */
	public int getSize() {
		return objects.size();
	}
}
