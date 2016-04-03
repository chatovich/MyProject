package by.it.Utils.OtrherChart;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.math.BigInteger;

/**
 * Created by Admin on 31.03.2016.
 */
public class Word {
    public static void main(String[] args){
        XWPFDocument document=new XWPFDocument();

        XWPFTable table=document.createTable();


        XWPFParagraph paragraph=document.createParagraph();
        XWPFRun run=paragraph.createRun();

        run.setText("Pancakes");
        run.setText(" and Nutella");
        run.addBreak();
        run.setText("i'm hungry");
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        paragraph.setIndentationHanging(1000);
        paragraph.setBorderBottom(Borders.BASIC_THIN_LINES);
        paragraph.setNumID(BigInteger.ONE);


        XWPFParagraph paragraph2=document.createParagraph();
        paragraph2.setPageBreak(true);
        XWPFRun run2=paragraph2.createRun();
        run2.setText("Ninja style");
        try{
            FileOutputStream output=new FileOutputStream("Awesome.docx");
            document.write(output);
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
