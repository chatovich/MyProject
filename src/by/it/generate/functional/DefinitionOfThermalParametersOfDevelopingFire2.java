package by.it.generate.functional;

import by.it.generate.Aperture;
import by.it.generate.Building;
import by.it.generate.FlammableSubstance;
import by.it.generate.Room;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Класс вычисления интегральных теплотехнических параметров объемного свободно развивающегося пожара в помещении
 */
public class DefinitionOfThermalParametersOfDevelopingFire2 {
    private Room myRoom;
    private Building myBuilding;

    public void getBuilding(Building building){
        this.myBuilding=building;
    }
    public void getRoom(Room room){
        this.myRoom=room;
    }

    /**
     * Функция нахождения проемности помещения
     */
    public void findProemnost(){
        Double numerator = 0.0;
        for (Aperture temp : myRoom.getAperture()) {
            numerator += ((temp.getSquareOfAperture() * sqrt(temp.getHeight())) *
                    temp.getCount());//сумма: высота*площадь*количество
        }
        if (myRoom.getCommonParameters().getVolume()<=1000)
            myRoom.getDetermineTheTypeOfFire().setProemnostOfRoom(numerator/
                    (pow(myRoom.getCommonParameters().getVolume(),0.667)));//делим на объем в степени 0.667
        else
            myRoom.getDetermineTheTypeOfFire().setProemnostOfRoom(numerator/
                    myRoom.getCommonParameters().getSquare());//делим на площадь
    }
    /**
     * Функция нахождения среднего количества воздуха для сгорания
     */
    public void findAverageAmountOfCombustionAir(){
        Double numerator=0.0;
        Double denominator=0.0;
        for (FlammableSubstance temp:myRoom.getFlammableSubstance()){
            numerator+=temp.getWeight()*temp.getAmountOfCombustionAir();
            denominator+=temp.getWeight();
        }
        myRoom.getDetermineTheTypeOfFire().setAverageAmountOfCombustionAir(numerator/denominator);
    }
    /**
     * Функция нахождения удельного критического количества пожарной нагрузки
     */
    public void findSpecificCriticalAmountOfFireLoad(){
        Double firstFraction;
        Double secondFraction;
        firstFraction=((4500*pow(myRoom.getDetermineTheTypeOfFire().getProemnostOfRoom(),3))/(1+(500*pow(myRoom.getDetermineTheTypeOfFire().getProemnostOfRoom(),3))));
        secondFraction=(pow(myRoom.getCommonParameters().getVolume(),0.333))/
                (6*myRoom.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir());
        myRoom.getDetermineTheTypeOfFire().setSpecificCriticalAmountOfFireLoad(firstFraction+secondFraction);
    }
    /**
     * Функция нахождения удельного значения пожарной нагрузки
     */
    public void findSpecificValueOfFireLoad(){
        Double numerator=0.0;
        Double denominator;
        for (FlammableSubstance temp:myRoom.getFlammableSubstance())
            numerator+=(temp.getCombustionHeat()*temp.getWeight());
        denominator=(((6*pow(myRoom.getCommonParameters().getVolume(),0.667))-
                myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures())*13.8);
        myRoom.getDetermineTheTypeOfFire().setSpecificValueOfFireLoad(numerator/denominator);
        if (myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()<myRoom.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad())
            myRoom.getDetermineTheTypeOfFire().setPRN(true);
        else if (myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()>=myRoom.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad())
            myRoom.getDetermineTheTypeOfFire().setPRN(false);
    }
    /**
     * Функция нахождения максимальной среднеобъемной температуры
     */
    public void findMaximumMeanBulkTemperature(){
        if (myRoom.getDetermineTheTypeOfFire().isPRN())
            myRoom.getIntegratedThermalAndTechnicalParameters().setMaximumMeanBulkTemperature(
                    myBuilding.getSelectedTemperatureOfRegion()+
                            (224*pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(),0.528)));
        else{
            Double q=myRoom.getParametersCalculatedFireLoad().getEstimatedFireLoad()/13.8;
            Double temp=4.7*pow(10,-3)*(q-30);//степень экспоненты
            myRoom.getIntegratedThermalAndTechnicalParameters().setMaximumMeanBulkTemperature(940*pow(Math.E,temp));
        }
    }
    /**
     * Функция нахождения характерной продолжительности объемного пожара
     */
    public void findDurationOfFireSurround(){
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
            myRoom.getIntegratedThermalAndTechnicalParameters().setDurationOfFireSurround(temp);
        else if (temp<=0.15)
            myRoom.getIntegratedThermalAndTechnicalParameters().setDurationOfFireSurround(0.15);
        else if (temp>=1.22)
            myRoom.getIntegratedThermalAndTechnicalParameters().setDurationOfFireSurround(1.22);
    }
    /**
     * Функция нахождения времени достижения максимального значения среднеобъемной температуры
     */
    public void findTimeReachMaximumMeanBulkTemperature(){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double firstValue=(8.1 * pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(), 3.2));
            Double secondValue=pow(Math.E, (-0.92 * myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()));
            myRoom.getIntegratedThermalAndTechnicalParameters().setTimeReachMaximumMeanBulkTemperature(
                    32-(firstValue * secondValue));
        }else
            myRoom.getIntegratedThermalAndTechnicalParameters().setTimeReachMaximumMeanBulkTemperature(
                    myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
    }
    /**
     * Функция нахождения изменения среднеобъемной температуры при объемном свободно развивающемся пожаре
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangesInMeanBulkTemperature(){
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
    public void findMaximumAverageTemperatureOfWallSurface(){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double summand = myBuilding.getSelectedTemperatureOfRegion();
            myRoom.getIntegratedThermalAndTechnicalParameters().setMaximumAverageTemperatureOfWallSurface(
                    (115 * pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(), 0.64)) + summand);
        }else {
            if ((myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()>=0.15)&
                    (myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()<0.8)) {
                Double firstValue =(1750 * myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
                Double secondValue =(1250 * pow(myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround(), 2));
                myRoom.getIntegratedThermalAndTechnicalParameters().setMaximumAverageTemperatureOfWallSurface(250 +
                        firstValue - secondValue);
            }else if ((myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()>0.8)&
                    (myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()<=1.22))
                myRoom.getIntegratedThermalAndTechnicalParameters().setMaximumAverageTemperatureOfWallSurface(850.0);
        }
    }
    /**
     * Функция нахождения времени достижения максимального значения усредненной температуры поверхности стен
     */
    public void findTimeToReachMaximumTemperatureOfWallSurface(){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double firstValue =9.3*pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(),1.55);
            Double secondValue =pow(Math.E,(-0.455*myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()));
            myRoom.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfWallSurface(35-(firstValue*secondValue));
        }else
            myRoom.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfWallSurface(1.1*
                    myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
    }
    /**
     * Функция нахождения изменения средней температуры стен
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangeInAverageTemperatureOfWalls(){
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
    public void findAverageMaximumTemperatureOfSlab(){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double value=pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(),0.64);
            myRoom.getIntegratedThermalAndTechnicalParameters().setAverageMaximumTemperatureOfSlab((130*value)+myBuilding.getSelectedTemperatureOfRegion());
        }else {
            Double q=myRoom.getParametersCalculatedFireLoad().getEstimatedFireLoad()/13.8;
            Double temp=5*pow(10,-3)*(q-30);//степень экспоненты
            myRoom.getIntegratedThermalAndTechnicalParameters().setAverageMaximumTemperatureOfSlab(915 * pow(Math.E, temp));
        }
    }
    /**
     * Функция нахождения времени достижения максимального значения усредненной температуры поверхности перекрытия
     */
    public void findTimeToReachMaximumTemperatureOfSlabSurface(){
        if (myRoom.getDetermineTheTypeOfFire().isPRN()) {
            Double firstValue=17.3*pow(myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad(),1.32);
            Double secondValue=pow(Math.E,((-0.4)*myRoom.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()));
            myRoom.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfSlabSurface(40-(firstValue*secondValue));
        }else {
            myRoom.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfSlabSurface(myRoom.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround());
        }
    }
    /**
     * Функция нахождения изменения средней температуры стен
     * (на каждую минуту в течение 120 минут), на основе результатов строится график
     */
    public void findChangeInAverageTemperatureOfSlab(){
        Double denominator=myRoom.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab()-myBuilding.getSelectedTemperatureOfRegion();
        for (int i=0;i<121;i++){//i - здесь будет в качестве текущего времени
            Double fraction=(i/myRoom.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface());
            Double firstValue=1043*pow(fraction,6.95);
            Double secondValue=pow(Math.E,((-6.95)*fraction));
            myRoom.getIntegratedThermalAndTechnicalParameters().getChangeInAverageTemperatureOfSlab().add(((firstValue*secondValue)*denominator)+myBuilding.getSelectedTemperatureOfRegion());
        }
    }
}
