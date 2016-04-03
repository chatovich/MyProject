package by.it.start;

import java.util.Collection;

/**
 * Класс описания характеристик помещения
 */
public class Room {
    String position;//позиция помещения////
    String name;//Наименование помещения
    Double square;//площадь помещения (S)
    Double height;//высота помещения
    Double perimeter;//периметр помещения
    Double volume;//объем помещения (возможен автом. расчет) (V)
    Double squareOfConstruction;//площадь ограждающих конструкций помещений (возможен автом. расчет) (Sk)///////////
    Collection<Aperture> aperturesOfRoom;//все проемы помещения
    Double[] selectedСs=new Double[10];//выбранные значения из таблицы для коэффициента С
    Double specifyingCoefficientС5;//уточняющий коэффициент для с5 (умножаем на него), изначально равен 1
    Double specificFireLoad;//Удельная пожарная нагрузка, МДж∙м-2 (q) вводится для нахождения Расчетной пожарной нагрузки (qp)//
    Double[] amountOfCombustionAir=new Double[5];//выбирается количество воздуха, необходимое для сгорания 1 кг материала i-й пожарной нагрузки (V0i), м3/кг
    Double[] combustionHeat =new Double[5];//выбранные горючие вещества в помещении (их низшая теплота сгорания (Qh))
    Double[] weight =new Double[5];//масса выбранных горючих веществ помещения (P)
    Double selectedTemperatureOfRegion;//начальная среднеобъемная температура для выбранного района (тут список районов, value=значение температуры) (T0)
    Double[] averageSpeedBurnout =new Double[5];//средняя скорость выгорания i-го компонента твердого горючего или трудногорючего материала (ns?)
    /////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    Double reducedHeightOfApertures;//приведенная высота проемов в вертикальных ограждающих конструкциях помещения (h0)
    Double generalSquareOfApertures;//общая площадь проемов (A)
    Double ventilationParameter;//параметр вентиляции помещения (F0)
    Double coefficientK;//коэффициент К (k)
    Double coefficientA=1.0;
    Double coefficientB;//коэффициент B (b)
    Double coefficientС;//коэффициент C (c)
    Double estimatedFireLoad;//Расчетная пожарная нагрузка(qp)/////////
    Double proemnostOfRoom;//проемность помещения
    Double averageAmountOfCombustionAir;//среднее количество воздуха для сгорания (V0)
    Double specificCriticalAmountOfFireLoad;//удельное критическое количество пожарной нагрузки (qкр.к), для кубического помещения объемом V, равным объему исследуемого помещения
    Double specificValueOfFireLoad;//удельное значение пожарной нагрузки (qк)
    boolean PRN;//true - если ПРН, false - если ПРВ//
    Double maximumMeanBulkTemperature;//максимальная среднеобъемная температура (Tmax)
    Double durationOfFireSurround;//характерная продолжительность объемного пожара (tп)
    Double timeReachMaximumMeanBulkTemperature;//время достижения максимального значения среднеобъемной температуры (tmax)
    Double[] changesInMeanBulkTemperature=new Double[121];//изменение среднеобъемной температуры при объемном свободно развивающемся пожаре (T) - для графика
    Double maximumAverageTemperatureOfWallSurface;//максимальная усредненная температура поверхности стен (Twmax)
    Double timeToReachMaximumTemperatureOfWallSurface;//время достижения максимального значения усредненной температуры поверхности стен (tmax)
    Double[] changeInAverageTemperatureOfWalls=new Double[121];//изменение средней температуры стен (Tw) - для графика
    Double averageMaximumTemperatureOfSlab;//максимальной усредненной температуры поверхности перекрытия (Twmax)
    Double timeToReachMaximumTemperatureOfSlabSurface;//время достижения максимального значения усредненной температуры поверхности перекрытия (tmax)
    Double[] changeInAverageTemperatureOfSlab=new Double[121];//изменение средней температуры поверхности перекрытия (Tw) - для графика
    /**
     * Конструктор объекта помещения с указанием объема и площадью ограждающих конструкций помещения
     */
    public Room(){

    }
    /**
     * Конструктор объекта помещения без указания объема и площади ограждающих конструкций помещения
     */
    public Room(String position, String name, String square,String height,String perimeter, Collection<Aperture> aperturesOfRoom){

    }

}
