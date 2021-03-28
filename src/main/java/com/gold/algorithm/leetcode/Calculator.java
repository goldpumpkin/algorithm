package com.gold.algorithm.leetcode;


import java.util.Stack;

/**
 * @author goldhuang
 * @Description: {计算器}https://leetcode-cn.com/problems/calculator-lcci/
 * 注意点 ：
 * 1. 字符串中的空格
 * 2. 正整数可能不止一位
 * 3. java char 直接 + - 计算都是 ascii 的计算，必须先变成数字。
 *      方法： 1. '3'-'0'
 *            2. Character.getNumericValue('2')
 *            3. Integer.parseInt()
 *
 * 4. 注意清空栈时候的顺序 加减
 * 5. 清空栈需要注意 符号的push
 * @date 2021-03-26
 */
public class Calculator {


    public static void main(String[] args) {
        String s = "1+2+3/2*2";
        System.out.println(calculate(s)); // 5

        String s1 = "2+1*4+5/2*2+7";
        System.out.println(calculate(s1)); // 17

        String s3 = "3/2";
        System.out.println(calculate(s3)); //1

        String s4 = "12/2";
        System.out.println(calculate(s4));


        String s5 = "12/2+1*2-1+2*2/2";
        System.out.println(calculate(s5)); // 9


        String s6 = "6*2/3-1+2-4/2+1*2+2/4";
        System.out.println(calculate(s6)); // 5
    }


    /**
     *
     */
    public static int calculate(String s) {
        if (s == null) {
            return 0;
        }

        Stack<Integer> nums = new Stack<>();
        Stack<Character> calSignal = new Stack<>();

        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }

            boolean digit = Character.isDigit(c);
            if (digit) {
                int value = c - '0';
                stringBuilder.append(value);

                if (i == chars.length - 1 || !Character.isDigit(chars[i + 1])) {
                    Integer currNum = Integer.valueOf(stringBuilder.toString());
                    if (!calSignal.isEmpty()) {
                        Character cal = calSignal.peek();
                        if (cal == '*') {
                            calSignal.pop();
                            Integer preNum = nums.pop();
                            currNum = preNum * currNum;
                        } else if (cal == '/') {
                            calSignal.pop();
                            Integer preNum = nums.pop();
                            currNum = preNum / currNum;
                        }
                    }
                    nums.push(currNum);
                    stringBuilder = new StringBuilder();
                }
            } else {
                calSignal.push(c);
            }
        }

        // 清空运算符号 stack
        int result = 0;
        while (!nums.isEmpty()) {
            if (nums.size() == 1) {
                return nums.pop();
            }


            Character cal = calSignal.pop();
            Integer lastNum = nums.pop();
            int calNum1 = cal == '-' ? -lastNum : lastNum;

            Integer preNum = nums.pop();
            Character preNumCal = '+';
            if (!calSignal.isEmpty()) {
                preNumCal = calSignal.pop();
            }
            int calNum2 = preNumCal == '-' ? -preNum : preNum;

            int pushDigit = calNum1 + calNum2;

            nums.push(pushDigit);
            calSignal.push('+');
        }

        return result;
    }

}
