package com.song.model.builder;

/**
 * 具体建造者角色
 * @author songzigw
 *
 */
public class ConcreteBuilder extends Builder {

	private Product product = new Product();
	
	@Override
	public void buildPart1() {
		// build the first part of the product
	}

	@Override
	public void buildPart2() {
		// build the second part of the product
	}

	@Override
	public Product retrieveResult() {
		return product;
	}

}
