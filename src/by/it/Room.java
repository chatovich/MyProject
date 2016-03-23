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
    Double reducedHeightOfApertures;//приведенная высота проемов в вертикальных ограждающих конструкциях помещения (h0)
    Double generalSquareOfApertures;//общая площадь проемов (A)
    Double ventilationParameter;//параметр вентиляции помещения (F0)
    Double coefficientK;//коэффициент К (k)
    Double coefficientB;//коэффициент B (b)
    /**
     * Конструктор объекта помещения с указанием объема и площадью технологических конструкций помещения
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
     * Конструктор объекта помещения без указания объема и площади технологических конструкций помещения
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
