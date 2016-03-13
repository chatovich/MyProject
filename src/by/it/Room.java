package by.it;

import java.util.Collection;

/**
 * Класс описания характеристик помещения
 */
public class Room {
    String position;//позиция помещения
    String name;//Наименование помещения
    Double square;//площадь помещения
    Double height;//высота помещения
    Double perimeter;//периметр помещения
    Double volume;//объем помещения (возможен автом. расчет)
    Double squareOfConstruction;//площадь строительных конструкций (возможен автом. расчет)
    Collection<Aperture> AperturesOfRoom;
    public Room(String position, String name, String square,String height,String perimeter, String volume, String squareOfConstruction, Collection<Aperture> AperturesOfRoom){
        this.position=position;
        this.name=name;
        this.square=Double.valueOf(square);
        this.height=Double.valueOf(height);
        this.perimeter=Double.valueOf(perimeter);
        this.volume=Double.valueOf(volume);
        this.squareOfConstruction=Double.valueOf(squareOfConstruction);
        this.AperturesOfRoom =AperturesOfRoom;
    }
    public Room(String position, String name, String square,String height,String perimeter, Collection<Aperture> AperturesOfRoom){
        this.position=position;
        this.name=name;
        this.square=Double.valueOf(square);
        this.height=Double.valueOf(height);
        this.perimeter=Double.valueOf(perimeter);
        this.volume=(Double.valueOf(perimeter)/2)*Double.valueOf(height);//объем помещения=половина периметра * высоту
        this.squareOfConstruction=Double.valueOf(perimeter)*Double.valueOf(height);//площадь строит. констр.=периметр * высоту
        this.AperturesOfRoom =AperturesOfRoom;
    }
}
