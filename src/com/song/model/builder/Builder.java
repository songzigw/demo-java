package com.song.model.builder;

/**
 * 抽象建造者角色
 * @author songzigw
 *
 */
public abstract class Builder {
	/**
	 * 产品零件建造方法1
	 */
	public abstract void buildPart1();
	/**
	 * 产品零件建造方法2
	 */
	public abstract void buildPart2();
	/**
	 * 产品返回方法
	 */
	public abstract Product retrieveResult();
}
