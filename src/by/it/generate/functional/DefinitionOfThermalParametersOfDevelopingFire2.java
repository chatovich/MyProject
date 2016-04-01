package by.it.generate.functional;

import by.it.generate.Aperture;
import by.it.generate.Building;
import by.it.generate.FlammableSubstance;
import by.it.generate.Room;

import static by.it.Utils.Rounding.myRound;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Класс вычисления интегральных теплотехнических параметров объемного свободно развивающегося пожара в помещении
 */
public class DefinitionOfThermalParametersOfDevelopingFire2 {
    private Building myBuilding;

    public DefinitionOfThermalParametersOfDevelopingFire2(Building build){
        myBuilding=build;
    }
    /**
     * Функция нахождения проемности помещения
     */
    public void findThermalParameters(Room myRoom){
        myRoom.getDetermineTheTypeOfFire().setProemnostOfRoom(findProemnost(myRoom));

        myRoom.getDetermineTheTypeOfFire().setAverageAmountOfCombustionAir(findAverageAmountOfCombustionAir(myRoom));

        myRoom.getDetermineTheTypeOfFire().setSpecificCriticalAmountOfFireLoad(findSpecificCriticalAmountOfFireLoad(myRoom));

        myRoom.getDetermineTheTypeOfFire().setSpecificValueOfFireLoad(findSpecificValueOfFireLoad(myRoom));

        myRoom.getDetermineTheTypeOfFire().setPRN(findTypeOfFire(myRoom));

        myRoom.getIntegratedThermalAndTechnicalParameters().setDurationOfFireSurround(findDurationOfFireSurround(myRoom));

        myRoom.getIntegratedThermalAndTechnicalParameters().setMaximumMeanBulkTemperature(findMaximumMeanBulkTemperature(myRoom));

        myRoom.getIntegratedThermalAndTechnicalParameters().setTimeReachMaximumMeanBulkTemperature(findTimeReachMaximumMeanBulkTemperature(myRoom));

        findChangesInMeanBulkTemperature(myRoom);///////////////////////////////////

        myRoom.getIntegratedThermalAndTechnicalParameters().setMaximumAverageTemperatureOfWallSurface(findMaximumAverageTemperatureOfWallSurface(myRoom));

        myRoom.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfWallSurface(findTimeToReachMaximumTemperatureOfWallSurface(myRoom));

        findChangeInAverageTemperatureOfWalls(myRoom);////////////////////////////////////

        myRoom.getIntegratedThermalAndTechnicalParameters().setAverageMaximumTemperatureOfSlab(findAverageMaximumTemperatureOfSlab(myRoom));

        myRoom.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfSlabSurface(findTimeToReachMaximumTemperatureOfSlabSurface(myRoom));

        findChangeInAverageTemperatureOfSlab(myRoom);////////////////////////////////////
    }

    /**
     * Функция нахождения проемности помещения
     */
    public Double findProemnost(Room myRoom){
        Double numerator = 0.0;
        for (Aperture temp : myRoom.getAperture()) {
            numerator += ((temp.getSquareOfAperture() * sqrt(temp.getHeight())) *
                    temp.getCount());//сумма: высота*площадь*количество
        }
        if (myRoom.getCommonParameters().getVolume()<=1000)
            return myRound(numerator/
                    (pow(myRoom.getCommonParameters().getVolume(),0.667)));//делим на объем в степени 0.667
        else
            return myRound(numerator/
                    myRoom.getCommonParameters().getSquare());//делим на площадь
    }
    /**
     * Функция нахождения среднего количества воздуха для сгорания
     */
    public Double findAverageAmountOfCombustionAir(Room myRoom){
        Double numerator=0.0;
        Double denominator=0.0;
        for (FlammableSubstance temp:myRoom.getFlammableSubstance()){
            numerator+=temp.getWeight()*temp.getAmountOfCombustionAir();
            denominator+=temp.getWeight();
        }
        return myRound(numerator/denominator);
    }
    /**
     * Функция нахождения удельного критического количества пожарной нагрузки
     */
    public Double findSpecificCriticalAmountOfFireLoad(Room myRoom){
        Double firstFraction;
        Double secondFraction;
        firstFraction=((4500*pow(myRoom.getDetermineTheTypeOfFire().getProemnostOfRoom(),3))/
                (1+(500*pow(myRoom.getDetermineTheTypeOfFire().getProemnostOfRoom(),3))));
        secondFraction=(pow(myRoom.getCommonParameters().getVolume(),0.333))/
                (6*myRoom.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir());
        return myRound(firstFraction+secondFraction);
    }
    /**
     * Функция нахождения удельного значения пожарной нагрузки
     */
    public Double findSpecificValueOfFireLoad(Room myRoom){
        Double numerator=0.0;
        Double denominator;
        for (FlammableSubstance temp:myRoom.getFlammableSubstance())
            numerator+=(temp.getCombustionHeat()*temp.getWeight());
        denominator=(((6*pow(myRoom.getCommonParameters().getVolume(),0.667))-
                myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures())*13.8);
        return myRound(numerator/denominator);
    }
    /**
     * Функция определения типа возможного пожара ПРН/ПРВ
     */
    public Boolean findTypeOfFire(Room myRoom){
        return  (myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()<myRoom.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad());
    }
    /**
     * Функция нахождения характерной продолжительности объемного пожара
     */
    public Double findDurationOfFireSurround(Room myRoom){
        Double numerator=0.0;Double denominator;
        Double firstFraction;Double secondFraction;
        for (FlammableSubstance temp:myRoom.getFlammableSubstance())
            numerator+=(temp.getCombustionHeat()*temp.getWeight());

        denominator=6258*myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()*
                sqrt(myRoom.getParametersCalculatedFireLoad().getReducedHeightOfApertures());
        firstFraction=numerator/denominator;

        numerator=0.0;denominator=0.0;
        for (FlammableSubstance temp:myRoom.getFlammableSubstance())
            numerator+=(temp.getWeight());

        numerator*=2.4;
        for (FlammableSubstance temp:myRoom.getFlammableSubstance())
            denominator+=(temp.getWeight()*temp.getAverageSpeedBurnout());

        secondFraction=numerator/denominator;
        Double temp=firstFraction*secondFraction;
        if ((0.15<temp)&(temp<1.22))
            return myRound(temp);
        else if (temp<=0.15)
            return (0.15);
        else if (temp>=1.22)
            return (1.22);
        return 0.0;
    }
    /**
     * Функция нахождения максимальной среднеобъемной температуры
     */
    public Double findMaximumMeanBulkTemperature(Room myRoom){
        if (myRoom.getDetermineTheTypeOfFire().isPRN())
            return myRound(myBuilding.getSelectedTemperatureOfRegion()+
                            (224*pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(),0.528)));
        else{
            Double q=myRoom.getParametersCalculatedFireLoad().getEstimatedFireLoad()/13.8;
            Double temp=4.7*pow(10,-3)*(q-30);//степень экспоненты
            return myRound(940*pow(Math.E,temp));
        }
    }
    /**
     * Функция нахождения времени достижения максимального значения среднеобъемной температуры
     */
    public Double findTimeReachMaximumMeanBulkTemperature(Room myRoom){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double firstValue=(8.1 * pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(), 3.2));
            Double secondValue=pow(Math.E, (-0.92 * myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()));
            return myRound(32-(firstValue * secondValue));
        }else
            return myRound(myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
    }
    /**
     * Функция нахождения изменения среднеобъемной температуры при объемном свободно развивающемся пожаре
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangesInMeanBulkTemperature(Room myRoom){
        Double denominator=myRoom.getIntegratedThermalAndTechnicalParameters().getMaximumMeanBulkTemperature()-
                myBuilding.getSelectedTemperatureOfRegion();
        for (int i=0;i<121;i++){//i - здесь будет в качестве текущего времени
            Double fraction=(i/myRoom.getIntegratedThermalAndTechnicalParameters().getTimeReachMaximumMeanBulkTemperature());
            Double firstValue=115.6*pow(fraction,4.75);
            Double secondValue=pow(Math.E,((-4.75)*fraction));
            myRoom.getIntegratedThermalAndTechnicalParameters().getChangesInMeanBulkTemperature().add(
                    ((firstValue*secondValue)*denominator)+myBuilding.getSelectedTemperatureOfRegion());
        }
    }
    /**
     * Функция нахождения максимальная усредненная температура поверхности стен
     */
    public Double findMaximumAverageTemperatureOfWallSurface(Room myRoom){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double summand = myBuilding.getSelectedTemperatureOfRegion();
            return myRound((115 * pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(), 0.64)) + summand);
        }else {
            if ((myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()>=0.15)&
                    (myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()<0.8)) {
                Double firstValue =(1750 * myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
                Double secondValue =(1250 * pow(myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround(), 2));
                return myRound(250 + firstValue - secondValue);
            }else if ((myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()>0.8)&
                    (myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()<=1.22))
                return (850.0);
        }
        return 0.0;
    }
    /**
     * Функция нахождения времени достижения максимального значения усредненной температуры поверхности стен
     */
    public Double findTimeToReachMaximumTemperatureOfWallSurface(Room myRoom){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double firstValue =9.3*pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(),1.55);
            Double secondValue =pow(Math.E,(-0.455*myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()));
            return myRound(35-(firstValue*secondValue));
        }else
            return myRound(1.1*myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
    }
    /**
     * Функция нахождения изменения средней температуры стен
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangeInAverageTemperatureOfWalls(Room myRoom){
        Double denominator=myRoom.getIntegratedThermalAndTechnicalParameters().getMaximumAverageTemperatureOfWallSurface()
                -myBuilding.getSelectedTemperatureOfRegion();
        for (int i=0;i<121;i++){//i - здесь будет в качестве текущего времени
            Double fraction=(i/myRoom.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfWallSurface());
            Double firstValue=233*pow(fraction,5.45);
            Double secondValue=pow(Math.E,((-5.45)*fraction));
            myRoom.getIntegratedThermalAndTechnicalParameters().getChangeInAverageTemperatureOfWalls().add(
                    ((firstValue*secondValue)*denominator)+myBuilding.getSelectedTemperatureOfRegion());
        }
    }
    /**
     * Функция нахождения максимальной усредненной температуры поверхности перекрытия
     */
    public Double findAverageMaximumTemperatureOfSlab(Room myRoom){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double value=pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(),0.64);
            return myRound((130*value)+myBuilding.getSelectedTemperatureOfRegion());
        }else {
            Double q=myRoom.getParametersCalculatedFireLoad().getEstimatedFireLoad()/13.8;
            Double temp=5*pow(10,-3)*(q-30);//степень экспоненты
            return myRound(915 * pow(Math.E, temp));
        }
    }
    /**
     * Функция нахождения времени достижения максимального значения усредненной температуры поверхности перекрытия
     */
    public Double findTimeToReachMaximumTemperatureOfSlabSurface(Room myRoom){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double firstValue=17.3*pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(),1.32);
            Double secondValue=pow(Math.E,((-0.4)*myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()));
            return myRound(40-(firstValue*secondValue));
        }else {
            return myRound(myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
        }
    }
    /**
     * Функция нахождения изменения средней температуры стен
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangeInAverageTemperatureOfSlab(Room myRoom){
        Double denominator=myRoom.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab()-myBuilding.getSelectedTemperatureOfRegion();
        for (int i=0;i<121;i++){//i - здесь будет в качестве текущего времени
            Double fraction=(i/myRoom.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface());
            Double firstValue=1043*pow(fraction,6.95);
            Double secondValue=pow(Math.E,((-6.95)*fraction));
            myRoom.getIntegratedThermalAndTechnicalParameters().getChangeInAverageTemperatureOfSlab().add(((firstValue*secondValue)*denominator)+myBuilding.getSelectedTemperatureOfRegion());
        }
    }
}
