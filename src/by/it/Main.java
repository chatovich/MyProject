package by.it;

import by.it.Utils.MyChart;
import by.it.generate.*;
import by.it.generate.functional.AllDefinition;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        Building b=new Building();
        Room r=new Room();
        b.getRoom().add(r);
        b.setNameOfBuilding("Bikini Bottom");
        b.getCoefficientSForBuild().add(1.0);
        b.getCoefficientSForBuild().add(0.7);
        b.getCoefficientSForBuild().add(0.8);
        b.getCoefficientSForBuild().add(0.73);
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
        r.getParametersCalculatedFireLoad().getSelectedSs().add(1.0);
        r.getParametersCalculatedFireLoad().getSelectedSs().add(1.0);
        r.getParametersCalculatedFireLoad().getSelectedSs().add(1.0);
        r.getParametersCalculatedFireLoad().getSelectedSs().add(1.0);
        r.getParametersCalculatedFireLoad().getSelectedSs().add(1.0);
        r.getParametersCalculatedFireLoad().getSelectedSs().add(1.0);
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
        List<Double> res=b.getRoom().get(0).getIntegratedThermalAndTechnicalParameters().getChangeInAverageTemperatureOfSlab();
        for (Double temp:res)
            System.out.print(temp+" ");
        System.out.println();
        List<Double> res1=b.getRoom().get(0).getIntegratedThermalAndTechnicalParameters().getChangeInAverageTemperatureOfWalls();
        for (Double temp:res1)
            System.out.print(temp+" ");System.out.println();
        List<Double> res2=b.getRoom().get(0).getIntegratedThermalAndTechnicalParameters().getChangesInMeanBulkTemperature();
        for (Double temp:res2)
            System.out.print(temp+" ");
    }
}
