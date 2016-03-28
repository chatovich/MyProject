package by.it.start;

import static java.lang.Math.*;

/**
 * Класс вычисления параметров расчетной пожарной нагрузки
 */
public class DefinitionOfParametersOfCalculatedFireLoad1 {
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
    public void findCoefficientK(){//коэффициент необходим для конечного вычисления коэффициента В
        if (myRoom.ventilationParameter<=0.03){
            myRoom.coefficientK=2.31*pow(myRoom.ventilationParameter,0.84);
        }else if (myRoom.ventilationParameter>0.03){
            myRoom.coefficientK=(((0.3*(pow(myRoom.ventilationParameter,0.8)))-(0.002*(pow(myRoom.ventilationParameter,-1)))+(log10(myRoom.ventilationParameter))+2.25)*(1/5.5));
        }
    }
    /**
     * Функция нахождения коэффициента B
     */
    public void findCoefficientB(){
        myRoom.coefficientB=((myRoom.square*myRoom.coefficientK)/(myRoom.generalSquareOfApertures*(sqrt(myRoom.reducedHeightOfApertures))));
    }
    /**
     * Функция нахождения коэффициента С
     */
    public void findCoefficientС(){
        myRoom.selectedСs[4]*=myRoom.specifyingCoefficientС5;//нужно умножить на уточняющий коэффициент для пятого пункта
        for (Double temp:myRoom.selectedСs)
        myRoom.coefficientС*=temp;
    }
    /**
     * Функция нахождения расчетной пожарной нагрузки
     */
    public void findEstimatedFireLoad(){//перемножаем коэффициенты А В С и удельную пожарную нагрузку
        myRoom.estimatedFireLoad=myRoom.specificFireLoad*myRoom.coefficientA*myRoom.coefficientB*myRoom.coefficientС;
    }
}
