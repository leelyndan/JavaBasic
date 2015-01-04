package com.samsung.tools.string;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils
{
    public static Map<String, String> parseHtmlTag(String tag, String regex)
    {
        Map<String, String> resultMap = new HashMap<String, String>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tag);
        if (matcher.find())
        {
            for (int index = 1; index <= matcher.groupCount(); index++)
            {
                resultMap.put(String.valueOf(index), matcher.group(index));
            }
        }
        return resultMap;
    }
    
    public static void main(String[] args)
    {
        System.out.println(parseHtmlTag("<option value=\"06\">Install(Setting) & Environment Test</option>",
            "<option value=\"(.*)\">(.*)</option>"));
    }
}
