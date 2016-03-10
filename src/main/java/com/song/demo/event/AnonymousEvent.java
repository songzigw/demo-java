/*
 * 在Java的swing编程中,Java中的事件机制非常常用
事件监听器的参与者：
1.事件对象： 
一般继承自java.util.EventObject对象,由开发者自行定义.
2.事件源： 
就是触发事件的源头,不同的事件源会触发不同的事件类型.
3.事件监听器： 
事件监听器负责监听事件源发出的事件.一个事件监听器通常实现java.util.EventListener这个标识接口. 

其整个处理过程是这样的,事件源可以注册事件监听器对象,并可以向事件监听器对象发送事件对象.事件发生后,事件源将事件对象发给已经注册的所有事件监听器. 
监听器对象随后会根据事件对象内的相应方法响应这个事件.

--------------------

如果用户用鼠标单击了按钮对象button，则该按钮button就是事件源，而java运行时系统会生成ActionEvent类的对象actionE，该对象中描述了该单击事件发生时的一些信息，然后，事件处理者对象将接收由java运行时系统传递过来的事件对象actionE并进行相应的处理。

　　由于同一个事件源上可能发生多种事件，因此java采取了授权处理机制(Delegation Model)，事件源可以把在其自身所有可能发生的事件分别授权给不同的事件处理者来处理。比如在Canvas对象上既可能发生鼠标事件，也可能发生键盘事件，该Canvas对象就可以授权给事件处理者一来处理鼠标事件，同时授权给事件处理者二来处理键盘事件。有时也将事件处理者称为监听器，主要原因也在于监听器时刻监听着事件源上所有发生的事件类型，一旦该事件类型与自己所负责处理的事件类型一致，就马上进行处理。授权模型把事件的处理委托给外部的处理实体进行处理，实现了将事件源和监听器分开的机制。事件处理者（监听器）通常是一个类，该类如果要能够处理某种类型的事件，就必须实现与该事件类型相对的接口。例如例5.9中类ButtonHandler之所以能够处理ActionEvent事件，原因在于它实现了与ActionEvent事件对应的接口ActionListener。每个事件类都有一个与之相对应的接口。

　　将事件源对象和事件处理器（事件监听器）分开。

 */
package com.song.demo.event;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Java事件处理机制:匿名内部类作为事件监听器
 * 
 * @author Administrator
 *
 */
class AnonymousEvent extends JFrame {
    private static final long serialVersionUID = -1739891937576087533L;
    JButton btn;

    public AnonymousEvent() {
        super("Java事件监听机制");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn = new JButton("点击");
        // 匿名内部类
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container c = getContentPane();
                c.setBackground(Color.red);
            }
        });
        getContentPane().add(btn);

        setBounds(200, 200, 300, 160);
        setVisible(true);
    }

    public static void main(String args[]) {
        new AnonymousEvent();
    }
}
