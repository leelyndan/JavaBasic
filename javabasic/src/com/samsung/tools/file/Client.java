package com.samsung.tools.file;

import java.util.Map;

import com.samsung.tools.string.StringUtils;

public class Client
{
    public static void main(String[] args)
    {
        // System.out.println(FileUtils.readFile(System.getProperty("user.dir") +
        // "/src/com/samsung/tools/file/tasks.html"));
        
        String readFileByStream = FileUtils.readFileByStream("tasks.html");
        System.out.println(readFileByStream);
        Map<String, String> trMap =
            StringUtils.parseHtmlTag(readFileByStream.replaceAll("\\r\\n\\t", ""),
                "<tableid=\"task_manamgement_table\">(<tr>.+</tr>)</table>");
        
        String trStrings = trMap.get("1");
        Map<String, String> tdMap = StringUtils.parseHtmlTag(trStrings, "(<tr>(.*)</tr>)");
        System.out.println("tdmap == ===" + tdMap);
        Map<String, String> parseHtmlTag = StringUtils.parseHtmlTag(tdMap.get("1"), "(<td>.*</td>)");
    }
}
