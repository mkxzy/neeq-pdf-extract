package com.iblotus;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xiezhiyan on 18-1-24.
 */
public class PdfTest {

    private PDDocument document;

    @Before
    public void setup() throws IOException {
        URL url = new URL("http://www.neeq.com.cn/disclosure/2017/2017-04-17/1492425227_813748.pdf");
        document = PDDocument.load(url.openStream());
    }

    @Test
    public void testRead(){
        try {

            // 获取页码
            int pages = document.getNumberOfPages();

            // 读文本内容
            PDFTextStripper stripper = new PDFTextStripper();
            // 设置按顺序输出
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pages);
            String content = stripper.getText(document);
            System.out.println(content);

        } catch (InvalidPasswordException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testForm(){

        try
        {
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition( true );
            Rectangle rect = new Rectangle( 370, 200, 110, 30 );
            stripper.addRegion( "class1", rect );
            PDPageTree pages = document.getDocumentCatalog().getPages();
//            PDPage firstPage = (PDPage)allPages.getItem(0);
            PDPage page = pages.get(8);
            stripper.extractRegions(page);
            System.out.println( "Text in the area:" + rect );
            System.out.println( stripper.getTextForRegion( "class1" ) );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
