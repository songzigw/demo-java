/*
 * Copyright (c) 2016, zhangsong <songm.cn>.
 *
 */

package com.song.demo.reflection;

/**
 * <p>
 * 根据反射获取类信息的关键技术点：
 * </p>
 * <ul>
 * <li>java.lang.reflect包实现了java的反射机制</li>
 * <li>Class.forName方法能够根据类名加载类，获得类的Class对象</li>
 * <li>Class.getSuperClass获取父类的Class对象</li>
 * <li>Class.getDeclaredFields获取类属性，返回java.lang.reflect.Filed</li>
 * <li>Class.getDeclaredConstructors获取构造器，返回java.lang.reflect.Constructor</li>
 * <li>Class.getMethods获得类的方法，返回java.lang.reflect.Method</li>
 * <li>java.lang.reflect.Field描述类声明的属性，getModifiers获取属性的访问修饰符，
 * getType方法获取属性的类型，getName获取属性的名称（标识符）</li>
 * <li>java.lang.reflect.Constructor描述类的构造器，getModifiers获取访问修饰符，
 * getName获得构造器的名称，getParameterTypes获取方法的参数类型，
 * getExceptionTypes获取构造器声明的异常</li>
 * <li>java.lang.reflect.Method描述类声明的方法；getModifiers获取方法的访问修饰符，
 * getReturnType方法获得方法的返回类型，getName获得方法的名称，getParameterTypes
 * 获得方法的参数类型，getExceptionTypes获得方法声明的异常</li>
 * </ul>
 * 
 * @author  zhangsong
 * @since   1.0
 * @version 1.0
 *
 */
public class ShowClassInfo {

}
