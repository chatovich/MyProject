package by.it;

import java.util.Collection;

/**
 * Класс описания характеристик помещения
 */
public class Room {
    String position;//позиция помещения
    String name;//Наименование помещения
    Double square;//площадь помещения (S)
    Double height;//высота помещения
    Double perimeter;//периметр помещения
    Double volume;//объем помещения (возможен автом. расчет) (V)
    Double squareOfConstruction;//площадь ограждающих конструкций помещений (возможен автом. расчет) (Sk)
    Collection<Aperture> aperturesOfRoom;//все проемы помещения
    Double[] selectedСs=new Double[10];//выбранные значения из таблицы для коэффициента С
    Double specifyingCoefficientС5;//уточняющий коэффициент для с5 (умножаем на него), изначально равен 1
    Double specificFireLoad;//Удельная пожарная нагрузка, МДж∙м-2 (q) вводится для нахождения Расчетной пожарной нагрузки (qp)
    /////////////////////////////////////////////////// \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    Double reducedHeightOfApertures;//приведенная высота проемов в вертикальных ограждающих конструкциях помещения (h0)
    Double generalSquareOfApertures;//общая площадь проемов (A)
    Double ventilationParameter;//параметр вентиляции помещения (F0)
    Double coefficientK;//коэффициент К (k)
    Double coefficientA=1.0;
    Double coefficientB;//коэффициент B (b)
    Double coefficientС;//коэффициент C (c)
    Double estimatedFireLoad;//Расчетная пожарная нагрузка(qp)
    Double proemnostOfRoom;
    /**
     * Конструктор объекта помещения с указанием объема и площадью ограждающих конструкций помещения
     */
    public Room(String position, String name, String square,String height,String perimeter, String volume, String squareOfConstruction, Collection<Aperture> aperturesOfRoom){
        this.position=position;
        this.name=name;
        this.square=Double.valueOf(square);
        this.height=Double.valueOf(height);
        this.perimeter=Double.valueOf(perimeter);
        this.volume=Double.valueOf(volume);
        this.squareOfConstruction=Double.valueOf(squareOfConstruction);
        this.aperturesOfRoom =aperturesOfRoom;
    }
    /**
     * Конструктор объекта помещения без указания объема и площади ограждающих конструкций помещения
     */
    public Room(String position, String name, String square,String height,String perimeter, Collection<Aperture> aperturesOfRoom){
        this.position=position;
        this.name=name;
        this.square=Double.valueOf(square);
        this.height=Double.valueOf(height);
        this.perimeter=Double.valueOf(perimeter);
        this.volume=(Double.valueOf(square))*Double.valueOf(height);//объем помещения=площадь * высоту
        this.squareOfConstruction=(Double.valueOf(perimeter)*Double.valueOf(height))+((Double.valueOf(square))*2);//площадь строит. констр.=периметр * высоту + 2 * площадь
        this.aperturesOfRoom =aperturesOfRoom;
    }

}
