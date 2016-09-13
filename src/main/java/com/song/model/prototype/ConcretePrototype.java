package com.song.model.prototype;

/**
 * 具体原型角色
 * 
 * @author songzigw
 *
 */
public class ConcretePrototype implements Prototype {
	/**
	 * 克隆方法
	 */
	public synchronized Object clone() {
		Prototype temp = null;
		try {
			temp = (Prototype) super.clone();
		} catch (Exception e) {
			System.out.println("Clone failed.");
		}
		return temp;
	}
}
