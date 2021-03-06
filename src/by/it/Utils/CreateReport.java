package by.it.Utils;

import by.it.generate.Building;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Admin on 03.04.2016.
 */
public class CreateReport {
    Building build;
    private WordprocessingMLPackage wordMLPackage;

    public WordprocessingMLPackage getWordMLPackage(){
        return wordMLPackage;
    }
    public CreateReport(Building building){
        build=building;
    }
    public void create(String filepath) throws Exception {
        wordMLPackage= WordprocessingMLPackage.createPackage();

        TableWithMergedCells tables=new TableWithMergedCells();
        List<Object> t=tables.createTables(build);
        for (Object temp:t){
            wordMLPackage.getMainDocumentPart().addObject(temp);
        }
        MyChart chart=new MyChart(build);
        chart.outputChart(wordMLPackage);

       /* List<Object>ch=chart.imageAdd.getCharts();
        for (Object temp:ch){
            wordMLPackage.getMainDocumentPart().addObject(ch);
        }*/
        wordMLPackage.save(new java.io.File(System.getProperty("user.dir") + filepath) );
    }
}
