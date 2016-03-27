package by.it;

import static java.lang.Math.*;

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

    public void findAverageAmountOfCombustionAir(){
        Double numerator=0.0;
        Double denominator=0.0;
        for (int i=0;i<myRoom.selectedWeightOfFlammableSubstances.length;i++){
            numerator+=myRoom.selectedWeightOfFlammableSubstances[i]*myRoom.amountOfCombustionAir[i];
            denominator+=myRoom.selectedWeightOfFlammableSubstances[i];
        }
        myRoom.averageAmountOfCombustionAir=numerator/denominator;
    }
    /**
     * Функция нахождения удельного критического количества пожарной нагрузки
     */
    public void findSpecificCriticalAmountOfFireLoad(){
        Double firstFraction;
        Double secondFraction;
        firstFraction=((4500*pow(myRoom.proemnostOfRoom,3))/(1+(500*pow(myRoom.proemnostOfRoom,3))));
        secondFraction=(pow(myRoom.volume,0.333))/(6*myRoom.averageAmountOfCombustionAir);
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
        else{
            Double q=myRoom.estimatedFireLoad/13.8;
            Double temp=4.7*pow(10,-3)*(q-30);//степень экспоненты
            myRoom.maximumMeanBulkTemperature=940*pow(Math.E,temp);
        }
    }
    /**
     * Функция нахождения характерной продолжительности объемного пожара
     */
    public void findDurationOfFireSurround(){
        Double numerator=0.0;Double denominator;
        Double firstFraction;Double secondFraction;
        for (int i=0;i<myRoom.selectedFlammableSubstances.length;i++)
            numerator+=(myRoom.selectedFlammableSubstances[i]*myRoom.selectedWeightOfFlammableSubstances[i]);
        denominator=6258*myRoom.generalSquareOfApertures*sqrt(myRoom.reducedHeightOfApertures);
        firstFraction=numerator/denominator;

        numerator=0.0;denominator=0.0;
        for (int i=0;i<myRoom.selectedWeightOfFlammableSubstances.length;i++)
            numerator+=(myRoom.selectedWeightOfFlammableSubstances[i]);
        numerator*=2.4;
        for (int i=0;i<myRoom.selectedWeightOfFlammableSubstances.length;i++)
            denominator+=(myRoom.selectedWeightOfFlammableSubstances[i]*myRoom.selectedAverageSpeedBurnout[i]);
        secondFraction=numerator/denominator;
        Double temp=firstFraction*secondFraction;
        if ((0.15<temp)&(temp<1.22))
            myRoom.durationOfFireSurround=temp;
        else if (temp<=0.15)
            myRoom.durationOfFireSurround=0.15;
        else if (temp>=1.22)
            myRoom.durationOfFireSurround=1.22;
    }
    /**
     * Функция нахождения времени достижения максимального значения среднеобъемной температуры
     */
    public void findTimeReachMaximumMeanBulkTemperature(){
        if (myRoom.PRN) {
            Double firstValue=(8.1 * pow(myRoom.specificValueOfFireLoad, 3.2));
            Double secondValue=pow(Math.E, (-0.92 * myRoom.specificValueOfFireLoad));
            myRoom.timeReachMaximumMeanBulkTemperature = 32 - (firstValue * secondValue);
        }else
            myRoom.timeReachMaximumMeanBulkTemperature=myRoom.durationOfFireSurround;
    }
    /**
     * Функция нахождения изменения среднеобъемной температуры при объемном свободно развивающемся пожаре
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangesInMeanBulkTemperature(){
        Double denominator=myRoom.maximumMeanBulkTemperature-myRoom.selectedTemperatureOfRegion;
        for (int i=0;i<myRoom.changesInMeanBulkTemperature.length;i++){//i - здесь будет в качестве текущего времени
            Double fraction=(i/myRoom.timeReachMaximumMeanBulkTemperature);
            Double firstValue=115.6*pow(fraction,4.75);
            Double secondValue=pow(Math.E,((-4.75)*fraction));
            myRoom.changesInMeanBulkTemperature[i]=((firstValue*secondValue)*denominator)+myRoom.selectedTemperatureOfRegion;
        }
    }
    /**
     * Функция нахождения максимальная усредненная температура поверхности стен
     */
    public void findMaximumAverageTemperatureOfWallSurface(){
        if (myRoom.PRN) {
            Double summand = myRoom.selectedTemperatureOfRegion;
            myRoom.maximumAverageTemperatureOfWallSurface = (115 * pow(myRoom.specificValueOfFireLoad, 0.64)) + summand;
        }else {
            if ((myRoom.durationOfFireSurround>=0.15)&(myRoom.durationOfFireSurround<0.8)) {
                Double firstValue =(1750 * myRoom.durationOfFireSurround);
                Double secondValue =(1250 * pow(myRoom.durationOfFireSurround, 2));
                myRoom.maximumAverageTemperatureOfWallSurface = 250 + firstValue - secondValue ;
            }else if ((myRoom.durationOfFireSurround>0.8)&(myRoom.durationOfFireSurround<=1.22))
                myRoom.maximumAverageTemperatureOfWallSurface=850.0;
        }
    }
    /**
     * Функция нахождения времени достижения максимального значения усредненной температуры поверхности стен
     */
    public void findTimeToReachMaximumTemperatureOfWallSurface(){
        if (myRoom.PRN) {
            Double firstValue =9.3*pow(myRoom.specificValueOfFireLoad,1.55);
            Double secondValue =pow(Math.E,(-0.455*myRoom.specificValueOfFireLoad));
            myRoom.timeToReachMaximumTemperatureOfWallSurface=35-(firstValue*secondValue);
        }else
            myRoom.timeToReachMaximumTemperatureOfWallSurface=1.1*myRoom.durationOfFireSurround;
    }
    /**
     * Функция нахождения изменения средней температуры стен
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangeInAverageTemperatureOfWalls(){
        Double denominator=myRoom.maximumAverageTemperatureOfWallSurface-myRoom.selectedTemperatureOfRegion;
        for (int i=0;i<myRoom.changeInAverageTemperatureOfWalls.length;i++){//i - здесь будет в качестве текущего времени
            Double fraction=(i/myRoom.timeToReachMaximumTemperatureOfWallSurface);
            Double firstValue=233*pow(fraction,5.45);
            Double secondValue=pow(Math.E,((-5.45)*fraction));
            myRoom.changeInAverageTemperatureOfWalls[i]=((firstValue*secondValue)*denominator)+myRoom.selectedTemperatureOfRegion;
        }
    }
    /**
     * Функция нахождения максимальной усредненной температуры поверхности перекрытия
     */
    public void findAverageMaximumTemperatureOfSlab(){
        if (myRoom.PRN) {
            Double value=pow(myRoom.specificValueOfFireLoad,0.64);
            myRoom.averageMaximumTemperatureOfSlab=(130*value)+myRoom.selectedTemperatureOfRegion;
        }else {
            Double q=myRoom.estimatedFireLoad/13.8;
            Double temp=5*pow(10,-3)*(q-30);//степень экспоненты
            myRoom.averageMaximumTemperatureOfSlab= 915 * pow(Math.E, temp);
        }
    }
    /**
     * Функция нахождения времени достижения максимального значения усредненной температуры поверхности перекрытия
     */
    public void findTimeToReachMaximumTemperatureOfSlabSurface(){
        if (myRoom.PRN) {
            Double firstValue=17.3*pow(myRoom.specificValueOfFireLoad,1.32);
            Double secondValue=pow(Math.E,((-0.4)*myRoom.specificValueOfFireLoad));
            myRoom.timeToReachMaximumTemperatureOfSlabSurface=40-(firstValue*secondValue);
        }else {
            myRoom.timeToReachMaximumTemperatureOfSlabSurface=myRoom.durationOfFireSurround;
        }
    }
    /**
     * Функция нахождения изменения средней температуры стен
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangeInAverageTemperatureOfSlab(){
        Double denominator=myRoom.averageMaximumTemperatureOfSlab-myRoom.selectedTemperatureOfRegion;
        for (int i=0;i<myRoom.changeInAverageTemperatureOfSlab.length;i++){//i - здесь будет в качестве текущего времени
            Double fraction=(i/myRoom.timeToReachMaximumTemperatureOfSlabSurface);
            Double firstValue=1043*pow(fraction,6.95);
            Double secondValue=pow(Math.E,((-6.95)*fraction));
            myRoom.changeInAverageTemperatureOfSlab[i]=((firstValue*secondValue)*denominator)+myRoom.selectedTemperatureOfRegion;
        }
    }
}
