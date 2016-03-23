package by.it;

import static java.lang.Math.*;

/**
 * Класс вычисления параметров помещения до коэффициента b
 */
public class FindRoomParametresB {
    private Room myRoom;

    public void SetRoom(Room room){
        this.myRoom=room;
    }

    /**
     * Функция нахождения приведенной высоты проемов в вертикальных ограждающих конструкциях помещения
     * и общей площади проемов в наружных стенах помещения
     */
    public void findReducedHeightOfApertures(){
        Double numerator=0.0;//числитель
        Double denominator=0.0;//знаменатель
        Double result=0.0;//приведенная высота проемов
        for (Aperture temp:myRoom.aperturesOfRoom){
            numerator+=((temp.height*temp.squareOfAperture)*temp.count);//сумма: высота*площадь*количество
            denominator+=(temp.squareOfAperture*temp.count);//сумма площадь*количество
            result=numerator/denominator;
        }
        myRoom.reducedHeightOfApertures=result;//приведенная высота проемов
        myRoom.generalSquareOfApertures=denominator;//общая площадь проемов
    }
    /**
     * Функция нахождения параметра вентиляции
     */
    public void findVentilationParameter(){
        myRoom.ventilationParameter=((myRoom.generalSquareOfApertures*(sqrt(myRoom.reducedHeightOfApertures)))/myRoom.squareOfConstruction);
    }
    /**
     * Функция нахождения коэффициента К
     */
    public void findCoefficientK(){//используется логарифм по основании 10
        if (myRoom.ventilationParameter<=0.03){
            myRoom.coefficientK=2.31*pow(myRoom.ventilationParameter,0.84);
        }else if (myRoom.ventilationParameter>0.03){
            myRoom.coefficientK=(((0.3*(pow(myRoom.ventilationParameter,0.8)))-(0.002*(pow(myRoom.ventilationParameter,-1)))+(log10(myRoom.ventilationParameter))+2.25)*(1/5.5));
        }
    }
    /**
     * Функция нахождения коэффициента B
     */
    public void findCoefficientB(){//в качестве общей площади участка размещения пожарной нагрузки используется площадь помещения
        myRoom.coefficientB=((myRoom.square*myRoom.coefficientK)/(myRoom.generalSquareOfApertures*(sqrt(myRoom.reducedHeightOfApertures))));
    }

}
