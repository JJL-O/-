/*
 * Created by JFormDesigner on Fri Oct 15 21:49:37 CST 2021
 */

package form;

import net.miginfocom.swing.MigLayout;
import Util.FileIOUtil;
import Util.GenerateUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Form extends JFrame {
    public Form() {
        initComponents();
    }

    private void CreatActionPerformed(ActionEvent e) {
        // TODO add your code here

        if (Num.getText() == null) {
            JOptionPane.showMessageDialog(null, "请输入生成题目个数");
        } else if (R.getText() == null) {
            JOptionPane.showMessageDialog(null, "请输入参数r以控制题目数值");
        } else {
            new ExpressionCreatThread().start();
            JOptionPane.showMessageDialog(null, "生成完毕");
        }

    }


    private void CheakActionPerformed(ActionEvent e) {
        // TODO add your code here
        Check check = new Check();
        check.setVisible(true);
        check.setMinimumSize(new Dimension(300, 150));
        check.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        NeedNum = new JLabel();
        Num = new JTextField();
        NeedR = new JLabel();
        R = new JTextField();
        Creat = new JButton();
        Cheak = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
                "fill,hidemode 3",
                // columns
                "[fill]" +
                        "[fill]",
                // rows
                "[]" +
                        "[]" +
                        "[]"));

        //---- NeedNum ----
        NeedNum.setText("\u8bf7\u8f93\u5165\u751f\u6210\u9898\u76ee\u7684\u4e2a\u6570");
        NeedNum.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        NeedNum.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(NeedNum, "cell 0 0,grow");
        contentPane.add(Num, "cell 1 0,grow");

        //---- NeedR ----
        NeedR.setText("\u8bf7\u8f93\u5165r \u53c2\u6570\u63a7\u5236\u9898\u76ee\u4e2d\u6570\u503c");
        NeedR.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        contentPane.add(NeedR, "cell 0 1,grow");
        contentPane.add(R, "cell 1 1,grow");

        //---- Creat ----
        Creat.setText("\u751f\u6210");
        Creat.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        Creat.addActionListener(e -> CreatActionPerformed(e));
        contentPane.add(Creat, "cell 0 2,grow");

        //---- Cheak ----
        Cheak.setText("\u68c0\u67e5\u7b54\u6848");
        Cheak.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        Cheak.addActionListener(e -> CheakActionPerformed(e));
        contentPane.add(Cheak, "cell 1 2,grow");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel NeedNum;
    private JTextField Num;
    private JLabel NeedR;
    private JTextField R;
    private JButton Creat;
    private JButton Cheak;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    class ExpressionCreatThread extends Thread {
        @Override
        public void run() {
            String[] expression = GenerateUtil.createExpression(Integer.parseInt(R.getText()), Integer.parseInt(Num.getText()));
            FileIOUtil.expressionOutput(expression);

            String[] answer = new String[0];
            answer = GenerateUtil.toAnswer(expression);
            FileIOUtil.expressionOutput(answer);
        }
    }
}
