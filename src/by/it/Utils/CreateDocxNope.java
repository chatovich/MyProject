package by.it.Utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.samples.AbstractSample;
import org.docx4j.wml.ContentAccessor;
import org.docx4j.wml.Text;

import javax.xml.bind.JAXBElement;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 31.03.2016.
 */
public class CreateDocxNope {

    public static void main(String[] args) throws Exception {

        XWPFDocument document = new XWPFDocument();

        XWPFTable tableOne = document.createTable();
        XWPFTableRow tableOneRowOne = tableOne.getRow(0);
        tableOneRowOne.getCell(0).setText("Hello");
        tableOneRowOne.addNewTableCell().setText("World");
        tableOneRowOne.getCell(0).getTableRow().addNewTableCell();

        XWPFTableRow tableOneRowTwo = tableOne.createRow();
        tableOneRowTwo.getCell(0).setText("This is");
        tableOneRowTwo.getCell(1).setText("a table");
        tableOneRowTwo.setCantSplitRow(false);

     //   tableOneRowTwo.getCell(1).getTableRow().getTable().createRow();
     //   tableOneRowTwo.getCell(1).getTableRow().getTable().createRow();
        tableOneRowTwo.getCell(1).getTableRow().addNewTableCell();
        tableOneRowTwo.getCell(1).getTableRow().addNewTableCell();
        document.createParagraph().createRun().addBreak();

        XWPFTable tableTwo = document.createTable();
        XWPFTableRow tableTwoRowOne = tableTwo.getRow(0);
        tableTwoRowOne.getCell(0).setText("col one, row one");
        tableTwoRowOne.addNewTableCell().setText("col two, row one");
        tableTwoRowOne.addNewTableCell().setText("col three, row one");

        XWPFTableRow tableTwoRowTwo = tableTwo.createRow();
        tableTwoRowTwo.getCell(0).setText("col one, row two");
        tableTwoRowTwo.getCell(1).setText("col two, row two");
        tableTwoRowTwo.getCell(2).setText("col three, row two");

        XWPFTableRow tableTwoRowThree = tableTwo.createRow();
        tableTwoRowThree.getCell(0).setText("col one, row three");
        tableTwoRowThree.getCell(1).setText("col two, row three");
        tableTwoRowThree.getCell(2).setText("col three, row three");

        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream("D:\\sample1.docx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            document.write(outStream);
            outStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}