package com.samsung.tools.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils
{
    
    public static void main(String[] args)
    {
        String REGEX = "a*b";
        
        String INPUT = "aabfooaabfooabfoobfoo";
        
        String REPLACE = "-";
        regexReplace(INPUT, REGEX, REPLACE);
    }
    
    private static void regexReplace(String input, String regex, String replacement)
    {
        
        Pattern p = Pattern.compile(regex);
        // 获取 matcher 对象
        Matcher m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (m.find())
        {
            m.appendReplacement(sb, replacement);
        }
        // 最后的foo就是appendTail加上的
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
