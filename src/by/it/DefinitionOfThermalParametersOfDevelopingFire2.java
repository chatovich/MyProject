package by.it;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Класс вычисления интегральных теплотехнических параметров объемного свободно развивающегося пожара в помещении
 */
public class DefinitionOfThermalParametersOfDevelopingFire2 {
    private Room myRoom;

    public void SetRoom(Room room){
        this.myRoom=room;
    }

    /**
     * Функция нахождения проемности помещения
     */
    public void findProemnost(){
        Double numerator = 0.0;
        for (Aperture temp : myRoom.aperturesOfRoom) {
            numerator += ((temp.squareOfAperture * sqrt(temp.height)) * temp.count);//сумма: высота*площадь*количество
        }
        if (myRoom.volume<=1000)
            myRoom.proemnostOfRoom =numerator/(pow(myRoom.volume,0.667));//делим на объем в степени 0.667
        else
            myRoom.proemnostOfRoom =numerator/myRoom.square;//делим на площадь
    }
    /**
     * Функция нахождения удельного критического количества пожарной нагрузки
     */
    public void findSpecificCriticalAmountOfFireLoad(){
        Double firstFraction;
        Double secondFraction;
        firstFraction=((4500*pow(myRoom.proemnostOfRoom,3))/(1+(500*pow(myRoom.proemnostOfRoom,3))));
        secondFraction=(pow(myRoom.volume,0.333))/(6*myRoom.amountOfCombustionAir);
        myRoom.specificCriticalAmountOfFireLoad=firstFraction+secondFraction;
    }
    /**
     * Функция нахождения удельного значения пожарной нагрузки
     */
    public void findSpecificValueOfFireLoad(){
        Double numerator=0.0;
        Double denominator;
        for (int i=0;i<myRoom.selectedFlammableSubstances.length;i++)
            numerator+=(myRoom.selectedFlammableSubstances[i]*myRoom.selectedWeightOfFlammableSubstances[i]);
        denominator=(((6*pow(myRoom.volume,0.667))-myRoom.generalSquareOfApertures)*13.8);
        myRoom.specificValueOfFireLoad=numerator/denominator;
        if (myRoom.specificValueOfFireLoad<myRoom.specificCriticalAmountOfFireLoad)
            myRoom.PRN=true;
        else if (myRoom.specificValueOfFireLoad>=myRoom.specificCriticalAmountOfFireLoad)
            myRoom.PRN=false;
    }
    /**
     * Функция нахождения максимальной среднеобъемной температуры
     */
    public void findMaximumMeanBulkTemperature(){
        if (myRoom.PRN)
            myRoom.maximumMeanBulkTemperature=myRoom.selectedTemperatureOfRegion+(224*pow(myRoom.specificValueOfFireLoad,0.528));
    }
}
