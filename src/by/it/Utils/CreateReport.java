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

    public CreateReport(Building building){
        build=building;
    }
    public void create(String filepath) throws Exception {
        MyChart chart=new MyChart(build);
        chart.outputChart();

        TableWithMergedCells tables=new TableWithMergedCells();
        List<Object> t=tables.createTables(build);
        for (Object temp:t){
            chart.getImageAdd().wordMLPackage.getMainDocumentPart().addObject(temp);
        }


       /* List<Object>ch=chart.imageAdd.getCharts();
        for (Object temp:ch){
            wordMLPackage.getMainDocumentPart().addObject(ch);
        }*/
        chart.getImageAdd().wordMLPackage.save(new java.io.File(System.getProperty("user.dir") + filepath) );
    }
}
