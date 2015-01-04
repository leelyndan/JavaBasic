package com.samsung.tools.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils
{
    public static String readFile(String fileName)
    {
        File file = new File(fileName);
        StringBuffer content = new StringBuffer();
        BufferedReader in = null;
        if (!file.exists())
        {
            System.err.println("Can't Find " + fileName);
        }
        
        try
        {
            in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null)
            {
                content.append(str + "\r\n");
            }
            
        }
        catch (IOException e)
        {
            try
            {
                in.close();
            }
            catch (Exception e2)
            {
            }
        }
        return content.toString();
    }
    
    public static void writeFile(String pathname, String content)
    {
        // String relativelyPath = System.getProperty("user.dir");
        File destFile = new File(pathname);
        if (!destFile.exists())
        {
            try
            {
                destFile.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        BufferedWriter output = null;
        try
        {
            output = new BufferedWriter(new FileWriter(destFile, true));
            output.write(content + "\r\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                output.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        
    }
    
    public static String readFileByStream(String fileName)
    {
        
        InputStream is = FileUtils.class.getResourceAsStream(fileName);
        StringBuffer content = new StringBuffer();
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str;
            while ((str = in.readLine()) != null)
            {
                content.append(str + "\r\n");
            }
            
        }
        catch (IOException e)
        {
            try
            {
                in.close();
            }
            catch (Exception e2)
            {
            }
        }
        return content.toString();
    }
    
}
