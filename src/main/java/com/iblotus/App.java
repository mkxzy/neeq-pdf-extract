package com.iblotus;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        try {
            URL url = new URL("http://www.neeq.com.cn/disclosure/2017/2017-04-17/1492425227_813748.pdf");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
