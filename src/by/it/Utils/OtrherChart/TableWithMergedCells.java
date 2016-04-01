package by.it.Utils.OtrherChart;

import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.*;

import java.math.BigInteger;

/**
 * Created by Admin on 01.04.2016.
 */
public class TableWithMergedCells {
    private static WordprocessingMLPackage  wordMLPackage;
    private static ObjectFactory factory;

    /**
     *  We create a table with borders and add four rows with content to it,
     *  and then we add the table to the document and save it.
     */
    public static void main (String[] args) throws Docx4JException {
        wordMLPackage = WordprocessingMLPackage.createPackage();
        factory = Context.getWmlObjectFactory();

        Tbl table = factory.createTbl();
        addBorders(table);

        addTableRowWithMergedCells("Heading 1", "Heading 1.1",
                "Field 1", table);
        addTableRowWithMergedCells(null, "Heading 1.2", "Field 2", table);

        addTableRowWithMergedCells("Heading 2", "Heading 2.1",
                "Field 3", table);
        addTableRowWithMergedCells(null, "Heading 2.2", "Field 4", table);

        wordMLPackage.getMainDocumentPart().addObject(table);
        wordMLPackage.save(new java.io.File(
                "src/by/it/ProgramCreate/HelloWord9.docx") );
    }

    /**
     *  In this method we create a row, add the merged column to it, and then
     *  add two regular cells to it. Then we add the row to the table.
     */
    private static void addTableRowWithMergedCells(String mergedContent,
                                                   String field1Content, String field2Content, Tbl table) {
        Tr tableRow1 = factory.createTr();

        addMergedColumn(tableRow1, mergedContent);

        addTableCell(tableRow1, field1Content);
        addTableCell(tableRow1, field2Content);

        table.getContent().add(tableRow1);
    }

    /**
     *  In this method we add a column cell that is merged with cells in other
     *  rows. If the given content is null, we pass on empty content and a merge
     *  value of null.
     */
    private static void addMergedColumn(Tr row, String content) {
        if (content == null) {
            addMergedCell(row, "", null);
        } else {
            addMergedCell(row, content, "restart");
        }
    }

    /**
     *  We create a table cell and then a table cell properties object.
     *  We also create a vertical merge object. If the merge value is not null,
     *  we set it on the object. Then we add the merge object to the table cell
     *  properties and add the properties to the table cell. Finally we set the
     *  content in the table cell and add the cell to the row.
     *
     *  If the merge value is 'restart', a new row is started. If it is null, we
     *  continue with the previous row, thus merging the cells.
     */
    private static void addMergedCell(Tr row, String content, String vMergeVal) {
        Tc tableCell = factory.createTc();
        TcPr tableCellProperties = new TcPr();

        TcPrInner.VMerge merge = new TcPrInner.VMerge();
        if(vMergeVal != null){
            merge.setVal(vMergeVal);
        }
        tableCellProperties.setVMerge(merge);

        tableCell.setTcPr(tableCellProperties);
        if(content != null) {
            tableCell.getContent().add(
                    wordMLPackage.getMainDocumentPart().
                            createParagraphOfText(content));
        }

        row.getContent().add(tableCell);
    }

    /**
     * In this method we add a table cell to the given row with the given
     *  paragraph as content.
     */
    private static void addTableCell(Tr tr, String content) {
        Tc tc1 = factory.createTc();
        tc1.getContent().add(
                wordMLPackage.getMainDocumentPart().createParagraphOfText(
                        content));
        tr.getContent().add(tc1);
    }

    /**
     *  In this method we'll add the borders to the table.
     */
    private static void addBorders(Tbl table) {
        table.setTblPr(new TblPr());
        CTBorder border = new CTBorder();
        border.setColor("auto");
        border.setSz(new BigInteger("4"));
        border.setSpace(new BigInteger("0"));
        border.setVal(STBorder.SINGLE);

        TblBorders borders = new TblBorders();
        borders.setBottom(border);
        borders.setLeft(border);
        borders.setRight(border);
        borders.setTop(border);
        borders.setInsideH(border);
        borders.setInsideV(border);
        table.getTblPr().setTblBorders(borders);
    }
}