package com.zj.algorithm.rpn;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰表达式计算
 */
public class RPN1 {
    public static void main(String[] args) {
        // 逆波兰表达式
        // (30+4)*5-6 => 30 4 + 5 * 6 -
        // 4*5-8+60+8/2   4 5 * - 8 + 60 + 8 2 /
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        // 1.先将 "3 4 + 5 * 6 -" 放大list中
        // 2.将list传给一个方法，遍历list配合栈完成计算
        List<String> rpnList = getStringList(suffixExpression);
        System.out.println(calculate(rpnList));
    }

    // 将一个逆波兰表达式，依次将数据和运算符放到list中

    public static List<String> getStringList(String suffixExpression) {
        return Arrays.asList(suffixExpression.split(" "));
    }

    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> list) {
        // 创建一个栈，一个即可
        Stack<String> stack = new Stack<>();
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if ("+".equals(item)) {
                    result = num1 + num2;
                } else if ("-".equals(item)) {
                    result = num1 - num2;
                } else if ("*".equals(item)) {
                    result = num1 * num2;
                } else if ("/".equals(item)) {
                    result = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
