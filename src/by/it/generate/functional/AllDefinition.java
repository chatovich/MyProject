package by.it.generate.functional;

import by.it.generate.Building;
import by.it.generate.Room;

/**
 * Класс, в котором реализован весь расчет по всему зданию
 */
public class AllDefinition {

    public void setALlParemeters(Building build){
        DefinitionOfParametersOfCalculatedFireLoad1 firstPart=new DefinitionOfParametersOfCalculatedFireLoad1(build);
        DefinitionOfThermalParametersOfDevelopingFire2 secondPart=new DefinitionOfThermalParametersOfDevelopingFire2(build);
        for (Room temp: build.getRoom()) {
            firstPart.findCalculatedParemetres(temp);//вызывается функция, в которой реализована
            // полная функциональность первого класса
            secondPart.findThermalParameters(temp);//аналогично для второго класса
        }
    }
}
