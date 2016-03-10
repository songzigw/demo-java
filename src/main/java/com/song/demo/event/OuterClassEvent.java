package com.song.demo.event;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Java事件处理机制:外部类作为事件监听器
 * 
 * @author Administrator
 *
 */
public class OuterClassEvent extends JFrame {

    private static final long serialVersionUID = -8687361352019332061L;
    JButton btn;

    public OuterClassEvent() {
        super("Java事件监听机制");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn = new JButton("点击");
        btn.addActionListener(new OuterClass(this));
        getContentPane().add(btn);

        setBounds(200, 200, 300, 160);
        setVisible(true);
    }

    public static void main(String args[]) {
        new OuterClassEvent();
    }
}

/**
 * 外部类
 * @author Administrator
 *
 */
class OuterClass implements ActionListener {
    OuterClassEvent oce;

    public OuterClass(OuterClassEvent oce) {
        this.oce = oce;
    }

    public void actionPerformed(ActionEvent e) {
        Container c = oce.getContentPane();
        c.setBackground(Color.red);
    }
}
