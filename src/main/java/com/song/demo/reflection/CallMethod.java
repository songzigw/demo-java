/*
 * Copyright (c) 2016, zhangsong<songm.cn>.
 *
 */

package com.song.demo.reflection;

/**
 * 动态调用类的静态方法和实例方法
 * <p>
 * 
 * 1.调用类的Class对象的newInstance方法能够创建一个类的对象，
 * 该方法实质上调用了类的无参构造器<br/>
 * 2.java.lang.reflect.Method类的invoke方法实现方法调用，它
 * 有两个参数；第一个参数是Object类型，指定调用哪个对象的方
 * 法，如果该方法是静态的，则传入null；第二个产生是Object数
 * 组，指定调用的方法需要的参数，如果方法不需要参数，则传入null<br/>
 * 3.通过Class获得私有方法的Method对象，但是不能使用Method对象调
 * 用私有方法<br/>
 * 
 * @author  zhangsong
 * @since   1.0
 * @version 1.0
 *
 */
public class CallMethod {

}
