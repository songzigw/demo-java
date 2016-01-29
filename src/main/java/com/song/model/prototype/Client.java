package com.song.model.prototype;

/**
 * 客户端角色
 * 
 * @author songzigw
 *
 */
public class Client {

	private PrototypeManager mgr;
	private Prototype prototype;
	private Prototype protClone;

	public void registerPrototype() {
		prototype = new ConcretePrototype();
		protClone = (Prototype) prototype.clone();
		mgr.add(protClone);
	}
}
