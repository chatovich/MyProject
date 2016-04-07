package by.it;

import by.it.DAO.BuildingDAO;
import by.it.Utils.CreateReport;
import by.it.Utils.MyChart;
import by.it.generate.*;
import by.it.generate.functional.AllDefinition;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Building b=new Building();
        Room r=new Room();
        b.getRoom().add(r);
        b.setNameOfBuilding("Bikini Bottom");
        b.getCoefficientSForBuild().getS().add(1.0);
        b.getCoefficientSForBuild().getS().add(0.7);
        b.getCoefficientSForBuild().getS().add(0.8);
        b.getCoefficientSForBuild().getS().add(0.73);
        b.setSpecifyingCoefficientS5(1.0);
        b.setSelectedTemperatureOfRegion(35);
        r.setCommonParameters(new CommonParameters());
        r.setParametersCalculatedFireLoad(new ParametersCalculatedFireLoad());
        r.setIntegratedThermalAndTechnicalParameters(new IntegratedThermalAndTechnicalParameters());
        r.setDetermineTheTypeOfFire(new DetermineTheTypeOfFire());

        r.getCommonParameters().setHeight(3);
        r.getCommonParameters().setNameOfRoom("rock");
        r.getCommonParameters().setPerimeter(10.82);
        r.getCommonParameters().setPositionOfRoom("1");
        r.getCommonParameters().setSquare(7.27);
        r.getCommonParameters().setSquareOfConstruction(47);
        r.getCommonParameters().setVolume(21.81);
        r.getCoefficientSForRoom().getS().add(1.0);
        r.getCoefficientSForRoom().getS().add(1.0);
        r.getCoefficientSForRoom().getS().add(1.0);
        r.getCoefficientSForRoom().getS().add(1.0);
        r.getCoefficientSForRoom().getS().add(1.0);
        r.getCoefficientSForRoom().getS().add(1.0);
        r.getParametersCalculatedFireLoad().setSpecificFireLoadZVEZDOCHKA(71.14);
        Aperture a=new Aperture();
        r.getAperture().add(a);
        a.setCount((byte)1);
        r.getParametersCalculatedFireLoad().setCoefficientA(1.0);
        a.setHeight(2.1);a.setWidth(1.0);
        a.setSquareOfAperture(2.1);
        a.setTypeOfAperture("дверь");

   /*     FlammableSubstance f=new FlammableSubstance();
        r.getFlammableSubstance().add(f);
        f.setAmountOfCombustionAir(3);
        f.setAverageSpeedBurnout(2);
        f.setCombustionHeat(2);
        f.setNameOfSubstance("дрэва");
        f.setWeight(32);*/
        AllDefinition all=new AllDefinition();
        all.setALlParemeters(b);
        MyChart m=new MyChart(b);
        m.outputChart();
        CreateReport create=new CreateReport(b);
        create.create("/src/by/it/ProgramCreate/Hey.docx");
        b.setFkIdUser((short) 1);
        b.getRoom().get(0).setFkIdBuilding((short) 1);
        b.getCoefficientSForBuild().setFkIdBuilding((short)1);
        b.getRoom().get(0).getCoefficientSForRoom().setFkIdRoom((short)1);
        b.getRoom().get(0).getChangeInMeanBulkTemperature().setFkIdRoom((short)1);
        b.getRoom().get(0).getChangeInTemperatureOfSlab().setFkIdRoom((short)1);
        b.getRoom().get(0).getChangeInTemperatureOfWalls().setFkIdRoom((short)1);
        b.getRoom().get(0).getAperture().get(0).setFkIdRoom((short)1);
        BuildingDAO dao=new BuildingDAO();
        dao.create(b);
    }
}
