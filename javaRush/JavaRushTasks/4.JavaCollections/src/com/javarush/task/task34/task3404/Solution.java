package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
//      String s = "sin(2*(-5+1.5*4)+28)";
//       System.out.print(s + " expected output 0.5 6 actually ");
//       solution.recursion(s, 0);
//       s = "tan(45)";
//       System.out.print(s + " expected output 1 1 actually ");
//       solution.recursion(s, 0);
//       s = "tan(-45)";
//       System.out.print(s + " expected output -1 2 actually ");
//       solution.recursion(s, 0);
//       s = "0.305";
//       System.out.print(s + " expected output 0.3 0 actually ");
//       solution.recursion(s, 0);
//       s = "0.3051";
//       System.out.print(s + " expected output 0.31 0 actually ");
//       solution.recursion(s, 0);
//       s = "(0.3051)";
//       System.out.print(s + " expected output 0.31 0 actually ");
//       solution.recursion(s, 0);
//       s = "1+(1+(1+1)*(1+1))*(1+1)+1";
//       System.out.print(s + " expected output 12 8 actually ");
//       solution.recursion(s, 0);
//       s = "tan(44+sin(89-cos(180)^2))";
//       System.out.print(s + " expected output 1 6 actually ");
//       solution.recursion(s, 0);
//       s = "-2+(-2+(-2)-2*(2+2))";
//       System.out.print(s + " expected output -14 8 actually ");
//       solution.recursion(s, 0);
//       s = "sin(80+(2+(1+1))*(1+1)+2)";
//       System.out.print(s + " expected output 1 7 actually ");
//       solution.recursion(s, 0);
//       s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
//       System.out.print(s + " expected output 6 11 actually ");
//       solution.recursion(s, 0);
//       s = "10-2^(2-1+1)";
//        System.out.print(s + " expected output 6 4 actually ");
//        solution.recursion(s, 0);
//        s = "2^10+2^(5+5)";
//        System.out.print(s + " expected output 2048 4 actually ");
//        solution.recursion(s, 0);
//        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
//        System.out.print(s + " expected output 72.96 8 actually ");
//        solution.recursion(s, 0);
//        s = "0.000025+0.000012";
//        System.out.print(s + " expected output 0 1 actually ");
//        solution.recursion(s, 0);
//        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
//        System.out.print(s + " expected output -3 16 actually ");
//        solution.recursion(s, 0);
//        s = "cos(3 + 19*3)";
//        System.out.print(s + " expected output 0.5 3 actually ");
//        solution.recursion(s, 0);
//        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
//        System.out.print(s + " expected output 8302231.36 14 actually ");
//        solution.recursion(s, 0);
//        s = "(-1 + (-2))";
//        System.out.print(s + " expected output -3 3 actually ");
//        solution.recursion(s, 0);
//        s = "-sin(2*(-5+1.5*4)+28)";
//        System.out.print(s + " expected output -0.5 7 actually ");
//        solution.recursion(s, 0);
//        s = "sin(100)-sin(100)";
//        System.out.print(s + " expected output 0 3 actually ");
//        solution.recursion(s, 0);
//        s = "-(-22+22*2)";
//        System.out.print(s + " expected output -22 4 actually ");
//        solution.recursion(s, 0);
//        s = "-2^(-2)";
//        System.out.print(s + " expected output -0.25 3 actually ");
//        solution.recursion(s, 0);
//        s = "-(-2^(-2))+2+(-(-2^(-2)))";
//        System.out.print(s + " expected output 2.5 10 actually ");
//        solution.recursion(s, 0);
//        s = "(-2)*(-2)";
//        System.out.print(s + " expected output 4 3 actually ");
//        solution.recursion(s, 0);
//        s = "(-2)/(-2)";
//        System.out.print(s + " expected output 1 3 actually ");
//        solution.recursion(s, 0);
//        s = "sin(-30)";
//        System.out.print(s + " expected output -0.5 2 actually ");
//        solution.recursion(s, 0);
//        s = "cos(-30)";
//        System.out.print(s + " expected output 0.87 2 actually ");
//        solution.recursion(s, 0);
//        s = "tan(-30)";
//        System.out.print(s + " expected output -0.58 2 actually ");
//        solution.recursion(s, 0);
//        s = "2+8*(9/4-1.5)^(1+1)";
//        System.out.print(s + " expected output 6.5 6 actually ");
//        solution.recursion(s, 0);
//        s = "0.005 ";
//        System.out.print(s + " expected output 0.01 0 actually ");
//        solution.recursion(s, 0);
//        s = "0.0049 ";
//        System.out.print(s + " expected output 0 0 actually ");
//        solution.recursion(s, 0);
//        s = "0+0.304";
//        System.out.print(s + " expected output 0.3 1 actually ");
//        solution.recursion(s, 0);
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        //remove spaces
        String s1 = expression.replaceAll("\\s+", "");
        //convert string to lowercase
        s1 = s1.toLowerCase();
        //Format number and print
        if (s1.matches("-?\\d+\\.?\\d*") || s1.matches("-?\\d+\\.?\\d*e-?\\d+")) {
            NumberFormat format = new DecimalFormat("#.##");
            DecimalFormatSymbols dfs = ((DecimalFormat) format).getDecimalFormatSymbols();
            dfs.setDecimalSeparator('.');
            ((DecimalFormat) format).setDecimalFormatSymbols(dfs);
            s1 = format.format(Double.parseDouble(s1));
            //process "-0"
            if (s1.matches("-0")) {
                s1 = s1.substring(1);
                if (countOperation == 0)
                    countOperation++;
            }
            System.out.println(String.format("%s %d", s1, countOperation));
            return;
        }
        //increase countOperation if lead minus is present
        if (countOperation == 0) {
            Pattern pattern = Pattern.compile("(?<=^|[\\(\\+\\-])-(\\d+\\.?\\d*|sin|cos|tan|\\()");
            Matcher matcher = pattern.matcher(s1);
            while (matcher.find())
                countOperation++;
        }
        //process trigonometry functions
        if (s1.matches(".*(sin|cos|tan)\\((-?\\d+\\.?\\d*\\)).*")) {
            String[] func = {"sin", "cos", "tan"};
            String beforeS1 = "";
            String afterS1 = "";
            for (String ss : func) {
                Pattern pattern = Pattern.compile(String.format("%s\\((-?\\d+\\.?\\d*\\))", ss));
                Matcher matcher = pattern.matcher(s1);
                if (matcher.find()) {
                    String sInner = matcher.group(0);
                    beforeS1 = beforeS1 + s1.substring(0, s1.indexOf(sInner));
                    afterS1 = new StringBuilder(afterS1).insert(0, s1.substring(s1.indexOf(sInner) + sInner.length())).toString();
                    double num = Double.parseDouble(sInner.substring(4, sInner.length() - 1));
                    switch (ss) {
                        case "sin":
                            num = Math.sin(Math.toRadians(num));
                            break;
                        case "cos":
                            num = Math.cos(Math.toRadians(num));
                            break;
                        case "tan":
                            num = Math.tan(Math.toRadians(num));
                            break;
                    }
                    recursion(beforeS1 + String.valueOf(num) + afterS1, ++countOperation);
                    break;
                }
            }
        }
        //check if bracers present and calculate deepest expression
        if (!s1.matches(".*(?<!\\w)\\((-?\\d+\\.?\\d*\\)).*")) {
            String beforeS1 = "";
            String afterS1 = "";
            if (s1.matches(".*\\(+.*\\).*")) {
                beforeS1 = s1.substring(0, s1.lastIndexOf("(") + 1);
                s1 = s1.substring(s1.lastIndexOf("(") + 1);
                afterS1 = s1.substring(s1.indexOf(")"));
                s1 = s1.substring(0, s1.indexOf(")"));
            }
            char[] ops = {'^', '/', '*', '-', '+'};
            for (Character ch : ops) {
                Pattern pattern = Pattern.compile(String.format("-?\\d+\\.?\\d*\\%s-?\\d+\\.?\\d*", ch));
                Matcher matcher = pattern.matcher(s1);
                if (matcher.find()) {
                    String sInner = matcher.group();
                    beforeS1 = beforeS1 + s1.substring(0, s1.indexOf(sInner));
                    afterS1 = new StringBuilder(afterS1).insert(0, s1.substring(s1.indexOf(sInner) + sInner.length())).toString();
                   /* System.out.println(beforeS1);
                    System.out.println(sInner);
                    System.out.println(afterS1);*/
                    pattern = Pattern.compile("-?\\d+\\.?\\d*");
                    matcher = pattern.matcher(sInner);
                    List<String> listMaches = new ArrayList<>();
                    while (matcher.find())
                        listMaches.add(matcher.group());
                    double a = Double.parseDouble(listMaches.get(0));
                    if ((a < 0) && (ch == '^' || ch == '/' || ch == '*')) {
                        a = Math.abs(a);
                        beforeS1 = beforeS1 + "-";
                    }
                    double b = Double.parseDouble(listMaches.get(1));
//                    System.out.println(a);
//                    System.out.println(b);
                    double result = 0;
                    switch (ch) {
                        case '^':
                            result = Math.pow(a, b);
                            break;
                        case '/':
                            result = a / b;
                            break;
                        case '*':
                            result = a * b;
                            break;
                        case '-':
                            result = a + b;
                            break;
                        case '+':
                            result = a + b;
                            break;
                    }
//                    System.out.println(beforeS1 + result + afterS1);
                    recursion(beforeS1 + result + afterS1, ++countOperation);
                    break;
                }
            }
        }

        if (s1.matches("^--.*")) {
            s1 = s1.replaceAll("^--", "");
            recursion(s1, countOperation);
        }

        if (s1.matches(".*(?<!\\w)\\((-?\\d+\\.?\\d*\\)).*")) {
            Pattern pattern = Pattern.compile("(?<!\\w)\\((-?\\d+\\.?\\d*\\))");
            Matcher matcher = pattern.matcher(s1);
            if (matcher.find()) {
//                System.out.println(matcher.group());
                String sInner = matcher.group();
                String before = s1.substring(0, s1.indexOf(sInner));
                String after = s1.substring(s1.indexOf(sInner) + sInner.length());
                sInner = sInner.substring(1).substring(0, sInner.length() - 2);
                s1 = before + sInner + after;
                s1 = s1.replaceAll("\\+-", "-");
                s1 = s1.replaceAll("\\(--", "(");
                s1 = s1.replaceAll("^--", "");
                s1 = s1.replaceAll("--", "+");
//                System.out.println(before);
//                System.out.println(sInner);
//                System.out.println(after);
                recursion(s1, countOperation);
            }
        }
//        System.out.println(s1);
    }

    public Solution() {
        //don't delete
    }
}
