package com.song.model.builder;

/**
 * 导演角色
 * @author songzigw
 *
 */
public class Director {

	private Builder builder;
	
	/**
	 * 产品的构造，
	 * 负责调用各个零件的建造
	 */
	public void construct() {
		builder = new ConcreteBuilder();
		builder.buildPart1();
		builder.buildPart2();
		builder.retrieveResult();
	}
}
