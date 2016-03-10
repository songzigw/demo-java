package com.song.demo.event;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Java事件处理机制:内部类作为事件监听器
 * 
 * @author Administrator
 *
 */
class InnerClassEvent extends JFrame {

    private static final long serialVersionUID = 8937751354316301432L;
    JButton btn;

    public InnerClassEvent() {
        super("Java事件监听机制");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn = new JButton("点击");
        btn.addActionListener(new InnerClass());
        getContentPane().add(btn);

        setBounds(200, 200, 300, 160);
        setVisible(true);
    }

    /**
     * 内部类
     * 
     * @author Administrator
     *
     */
    class InnerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Container c = getContentPane();
            c.setBackground(Color.red);
        }
    }

    public static void main(String args[]) {
        new InnerClassEvent();
    }
}
