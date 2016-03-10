package com.song.demo.event;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Java事件处理机制:自身类作为事件监听器
 * 
 * @author zhangsong
 *
 */
public class ThisClassEvent extends JFrame implements ActionListener {

    private static final long serialVersionUID = 8294266869955843200L;

    JButton btn;

    public ThisClassEvent() {
        super("Java事件监听机制");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn = new JButton("点击");
        btn.addActionListener(this);
        getContentPane().add(btn);

        setBounds(200, 200, 300, 160);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Container c = getContentPane();
        c.setBackground(Color.red);
    }

    public static void main(String args[]) {
        new ThisClassEvent();
    }
}
