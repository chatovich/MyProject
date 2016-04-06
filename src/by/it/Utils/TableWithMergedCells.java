package by.it.Utils;

import by.it.generate.Building;
import by.it.generate.Room;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для создания таблиц и записи их в отчёт
 */
public class TableWithMergedCells {
    private WordprocessingMLPackage wordMLPackage;
    private ObjectFactory factory;

    /**
     *  We create a table with borders and add four rows with content to it,
     *  and then we add the table to the document and save it.
     */
    public List<Object> createTables (Building build) throws Docx4JException {
        wordMLPackage = WordprocessingMLPackage.createPackage();
        factory = Context.getWmlObjectFactory();
        Tbl table1=firstTable(build);
        Tbl table2=secondTable(build);
        Tbl table3=thirdTable(build);
        Tbl table4=fourthTable(build);
        Tbl table5=fifthTable(build);
        Tbl table6=sixthTable(build);
        Tbl table7=seventhTable(build);

        wordMLPackage.getMainDocumentPart().addObject(table1);
        wordMLPackage.getMainDocumentPart().addObject(table2);
        wordMLPackage.getMainDocumentPart().addObject(table3);
        wordMLPackage.getMainDocumentPart().addObject(table4);
        wordMLPackage.getMainDocumentPart().addObject(table5);
        wordMLPackage.getMainDocumentPart().addObject(table6);
        wordMLPackage.getMainDocumentPart().addObject(table7);

        //wordMLPackage.save(new java.io.File("src/by/it/ProgramCreate/HelloWord9.docx") );
        return wordMLPackage.getMainDocumentPart().getContent();
    }
    public Tbl firstTable(Building build){
        factory = Context.getWmlObjectFactory();

        Tbl table = factory.createTbl();
        addBorders(table);

        ArrayList<String> temp=new ArrayList<>();
        temp.add("Поз.");temp.add("Наименование помещения");temp.add("Площадь, м2");temp.add("Категория");
        addTableRowWithMergedCells(temp, table);

        temp=new ArrayList<>();
        temp.add("1");temp.add("2");temp.add("3");temp.add("4");
        addTableRowWithMergedCells(temp, table);

        for (Room room : build.getRoom()) {
            temp=new ArrayList<>();
            temp.add(room.getCommonParameters().getPositionOfRoom());
            temp.add(room.getCommonParameters().getNameOfRoom());
            temp.add(String.valueOf(room.getCommonParameters().getSquare()));
            temp.add("-");
            addTableRowWithMergedCells(temp, table);
        }
        return table;
    }
    public Tbl secondTable(Building build) {
        factory = Context.getWmlObjectFactory();

        Tbl table = factory.createTbl();
        addBorders(table);

        ArrayList<String> temp=new ArrayList<>();
        temp.add("Поз.");temp.add("Наименование помещения");temp.add("Площадь, м2");temp.add("Объем, м3");
        temp.add("Вид проема(расположение)");temp.add("Размеры,b×h, м");temp.add("Количество,шт.");
        addTableRowWithMergedCells(temp, table);

        temp=new ArrayList<>();
        for (int i=1;i<8;i++){
            temp.add(String.valueOf(i));
        }
        addTableRowWithMergedCells(temp, table);

        for (Room room : build.getRoom()) {//печатаем первую строку с первым проемом
            temp=new ArrayList<>();
            temp.add(room.getCommonParameters().getPositionOfRoom());
            temp.add(room.getCommonParameters().getNameOfRoom());
            temp.add(String.valueOf(room.getCommonParameters().getSquare()));
            temp.add(String.valueOf(room.getCommonParameters().getVolume()));
            temp.add(room.getAperture().get(0).getTypeOfAperture());
            temp.add(room.getAperture().get(0).getWidth() + "x" + room.getAperture().get(0).getHeight());
            temp.add(String.valueOf(room.getAperture().get(0).getCount()));

            addTableRowWithMergedCells(temp, table);

            if (room.getAperture().size() > 1) {//если есть еще проемы - добавляем их
                for (int i = 1; i < room.getAperture().size(); i++) {
                    temp=new ArrayList<>();
                    temp.add(null);temp.add(null);temp.add(null);temp.add(null);
                    temp.add(room.getAperture().get(i).getTypeOfAperture());
                    temp.add( room.getAperture().get(i).getWidth() + "x" + room.getAperture().get(i).getHeight());
                    temp.add(String.valueOf(room.getAperture().get(0).getCount()));

                    addTableRowWithMergedCells(temp, table);
                }
            }
        }
        return table;
    }
    public Tbl thirdTable(Building build){
        factory = Context.getWmlObjectFactory();

        Tbl table = factory.createTbl();
        addBorders(table);

        ArrayList<String> temp=new ArrayList<>();
        temp.add("Поз.");temp.add("Наименование помещения");temp.add("A");temp.add("h0");
        temp.add("Sk");temp.add("F0");temp.add("k");temp.add("b");
        addTableRowWithMergedCells(temp, table);

        for (Room room : build.getRoom()) {
            temp=new ArrayList<>();
            temp.add(room.getCommonParameters().getPositionOfRoom());
            temp.add(room.getCommonParameters().getNameOfRoom());
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getReducedHeightOfApertures()));
            temp.add(String.valueOf(room.getCommonParameters().getSquareOfConstruction()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getVentilationParameter()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getCoefficientK()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getCoefficientB()));

            addTableRowWithMergedCells(temp,table);
        }
        return table;
    }
    public Tbl fourthTable(Building build){
        factory = Context.getWmlObjectFactory();

        Tbl table = factory.createTbl();
        addBorders(table);

        ArrayList<String> temp=new ArrayList<>();
        temp.add("Поз.");temp.add("Наименование помещения");
        for (int i=1;i<11;i++){
            temp.add("c"+i);
        }
        temp.add("c");
        addTableRowWithMergedCells(temp, table);

        temp=new ArrayList<>();
        for (int i=1;i<14;i++){
            temp.add(String.valueOf(i));
        }
        addTableRowWithMergedCells(temp, table);

        for (Room room : build.getRoom()) {
            temp = new ArrayList<>();
            temp.add(room.getCommonParameters().getPositionOfRoom());
            temp.add(room.getCommonParameters().getNameOfRoom());
            temp.add(String.valueOf(room.getCoefficientSForRoom().getS().get(0)));
            temp.add(String.valueOf(build.getCoefficientSForBuild().getS().get(0)));
            temp.add(String.valueOf(build.getCoefficientSForBuild().getS().get(1)));
            temp.add(String.valueOf(room.getCoefficientSForRoom().getS().get(1)));
            temp.add(String.valueOf(build.getCoefficientSForBuild().getS().get(2)));
            temp.add(String.valueOf(build.getCoefficientSForBuild().getS().get(3)));
            temp.add(String.valueOf(room.getCoefficientSForRoom().getS().get(2)));
            temp.add(String.valueOf(room.getCoefficientSForRoom().getS().get(3)));
            temp.add(String.valueOf(room.getCoefficientSForRoom().getS().get(4)));
            temp.add(String.valueOf(room.getCoefficientSForRoom().getS().get(5)));
        }
        return table;
    }
    public Tbl fifthTable(Building build){
        factory = Context.getWmlObjectFactory();

        Tbl table = factory.createTbl();
        addBorders(table);

        ArrayList<String> temp=new ArrayList<>();
        temp.add("Поз.");temp.add("Наименование помещения");temp.add("Вид пожарной нагрузки");temp.add("Масса пожарной нагрузки m,кг");
        temp.add("Кол-во воздуха, необходимое  для сгорания 1 кг материала i-ой нагрузки, V0i, м3/кг");
        temp.add("Кол-во воздуха, необходимое  для сгорания 1 кг материала нагрузки, V0, м3/кг");
        temp.add("Скорость выгорания материала нагрузки, n , кг/м2·мин");
        addTableRowWithMergedCells(temp, table);

        temp=new ArrayList<>();
        for (int i=1;i<8;i++){
            temp.add(String.valueOf(i));
        }
        addTableRowWithMergedCells(temp, table);

        for (Room room : build.getRoom()) {//печатаем первую строку с первым материалом
            if (room.getSubstancesOfRoom().size()==0)
                continue;
            temp=new ArrayList<>();
            temp.add(room.getCommonParameters().getPositionOfRoom());
            temp.add(room.getCommonParameters().getNameOfRoom());
            temp.add(room.getSubstancesOfRoom().get(0).getFlammableSubstance().getNameOfSubstance());
            temp.add(String.valueOf(room.getSubstancesOfRoom().get(0).getWeight()));
            temp.add(String.valueOf(room.getSubstancesOfRoom().get(0).getFlammableSubstance().getAmountOfCombustionAir()));
            temp.add(String.valueOf(room.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir()));
            temp.add(String.valueOf(room.getSubstancesOfRoom().get(0).getFlammableSubstance().getAverageSpeedBurnout()));

            addTableRowWithMergedCells(temp, table);

            if (room.getSubstancesOfRoom().size() > 1) {//если есть еще проемы - добавляем их
                for (int i = 1; i < room.getSubstancesOfRoom().size(); i++) {
                    temp=new ArrayList<>();
                    temp.add(null);
                    temp.add(null);
                    temp.add(room.getSubstancesOfRoom().get(0).getFlammableSubstance().getNameOfSubstance());
                    temp.add(String.valueOf(room.getSubstancesOfRoom().get(0).getWeight()));
                    temp.add(String.valueOf(room.getSubstancesOfRoom().get(0).getFlammableSubstance().getAmountOfCombustionAir()));
                    temp.add(null);
                    temp.add(String.valueOf(room.getSubstancesOfRoom().get(0).getFlammableSubstance().getAverageSpeedBurnout()));

                    addTableRowWithMergedCells(temp, table);
                }
            }
        }
        return table;
    }
    public Tbl sixthTable(Building build){
        factory = Context.getWmlObjectFactory();

        Tbl table = factory.createTbl();
        addBorders(table);

        ArrayList<String> temp=new ArrayList<>();
        temp.add("Поз.");temp.add("Наименование помещения");
        temp.add("Удельная пожарная нагрузка, МДж∙м-2");
        temp.add("Коэффициент a");
        temp.add("Коэффициенты b");
        temp.add("Коэффициенты c");
        temp.add("Расчетная пожарная нагрузка, МДж∙м-2");
        addTableRowWithMergedCells(temp, table);

        for (Room room : build.getRoom()) {
            temp=new ArrayList<>();
            temp.add(room.getCommonParameters().getPositionOfRoom());
            temp.add(room.getCommonParameters().getNameOfRoom());
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getSpecificFireLoad()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getCoefficientA()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getCoefficientB()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getCoefficientS()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getEstimatedFireLoad()));

            addTableRowWithMergedCells(temp,table);
        }
        return table;
    }
    public Tbl seventhTable(Building build){
        factory = Context.getWmlObjectFactory();

        Tbl table = factory.createTbl();
        addBorders(table);

        ArrayList<String> temp=new ArrayList<>();
        temp.add("Поз.");temp.add("Наименование помещения");
        temp.add("Расчетная пожарная нагрузка, МДж/м2");
        temp.add("Проемность, П, м0,5");
        temp.add("qкр.к,кг/м2");
        temp.add("qк,кг/м2");
        temp.add("Вид пожара");
        temp.add("Макc. среднеобъемная тем-ра, Tmax, С°");
        temp.add("Время достижения макс. средне-объемной тем-ры, tmax, мин");
        temp.add("Макс. тем-ра перекрытия Tп.max,С°");
        temp.add("Время достижения макс. тем-ры перкрытия, tпmax, мин");
        temp.add("Маск. тем-ра стен Tc.max,С°");
        temp.add("Время достиже-ния макс. тем-ры стен, tсmax, мин");
        addTableRowWithMergedCells(temp, table);

        for (Room room : build.getRoom()) {
            temp=new ArrayList<>();
            temp.add(room.getCommonParameters().getPositionOfRoom());
            temp.add(room.getCommonParameters().getNameOfRoom());
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getEstimatedFireLoad()));
            temp.add(String.valueOf(room.getDetermineTheTypeOfFire().getProemnostOfRoom()));
            temp.add(String.valueOf(room.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad()));
            temp.add(String.valueOf(room.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()));
            temp.add(String.valueOf(room.getParametersCalculatedFireLoad().getCoefficientS()));
            if (room.getDetermineTheTypeOfFire().isPRN()){
                temp.add("ПРН");
            }else temp.add("ПРВ");
            temp.add(String.valueOf(room.getIntegratedThermalAndTechnicalParameters().getMaximumMeanBulkTemperature()));
            temp.add(String.valueOf(room.getIntegratedThermalAndTechnicalParameters().getTimeReachMaximumMeanBulkTemperature()));
            temp.add(String.valueOf(room.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab()));
            temp.add(String.valueOf(room.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface()));
            temp.add(String.valueOf(room.getIntegratedThermalAndTechnicalParameters().getMaximumAverageTemperatureOfWallSurface()));
            temp.add(String.valueOf(room.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfWallSurface()));

            addTableRowWithMergedCells(temp,table);
        }
        return table;
    }
    /**
     *  In this method we create a row, add the merged column to it, and then
     *  add two regular cells to it. Then we add the row to the table.
     */
    private void addTableRowWithMergedCells(ArrayList<String> text, Tbl table) {
        Tr tableRow1 = factory.createTr();
        for (String temp:text) {
            addMergedColumn(tableRow1, temp);
        }
        table.getContent().add(tableRow1);
    }
    /**
     *  In this method we add a column cell that is merged with cells in other
     *  rows. If the given content is null, we pass on empty content and a merge
     *  value of null.
     */
    private void addMergedColumn(Tr row, String content) {
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
    private void addMergedCell(Tr row, String content, String vMergeVal) {
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
    private void addTableCell(Tr tr, String content) {
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