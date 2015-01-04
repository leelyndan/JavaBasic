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
        // ��ȡ matcher ����
        Matcher m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        while (m.find())
        {
            m.appendReplacement(sb, replacement);
        }
        // ����foo����appendTail���ϵ�
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
