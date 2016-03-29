package by.it.generate.functional;

import by.it.generate.Aperture;
import by.it.generate.Building;
import by.it.generate.Room;
import static java.lang.Math.*;

/**
 * Класс вычисления параметров расчетной пожарной нагрузки
 */
public class DefinitionOfParametersOfCalculatedFireLoad1 {
    private Room myRoom;
    private Building myBuilding;

    public void getBuilding(Building building){
        this.myBuilding=building;
    }
    public void getRoom(Room room){
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
        for (Aperture temp:myRoom.getAperture()){
            numerator+=((temp.getHeight()*temp.getSquareOfAperture())*temp.getCount());//сумма: высота*площадь*количество
            denominator+=(temp.getSquareOfAperture()*temp.getCount());//сумма площадь*количество
            result=numerator/denominator;
        }
        myRoom.getParametersCalculatedFireLoad().setReducedHeightOfApertures(result);//приведенная высота проемов
        myRoom.getParametersCalculatedFireLoad().setGeneralSquareOfApertures(denominator);//общая площадь проемов
    }
    /**
     * Функция нахождения параметра вентиляции
     */
    public void findVentilationParameter(){
        myRoom.getParametersCalculatedFireLoad().setVentilationParameter(
                (myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()*
                        (sqrt(myRoom.getParametersCalculatedFireLoad().getReducedHeightOfApertures())))/
                        myRoom.getCommonParameters().getSquareOfConstruction());
    }
    /**
     * Функция нахождения коэффициента К
     */
    public void findCoefficientK(){//коэффициент необходим для конечного вычисления коэффициента В
        if (myRoom.getParametersCalculatedFireLoad().getVentilationParameter()<=0.03){
            myRoom.getParametersCalculatedFireLoad().setCoefficientK(2.31*
                    pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(),0.84));
        }else if (myRoom.getParametersCalculatedFireLoad().getVentilationParameter()>0.03){
            myRoom.getParametersCalculatedFireLoad().setCoefficientK(((0.3*
                    (pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(),0.8)))-
                    (0.002*(pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(),-1)))+
                    (log10(myRoom.getParametersCalculatedFireLoad().getVentilationParameter()))+2.25)*(1/5.5));
        }
    }
    /**
     * Функция нахождения коэффициента B
     */
    public void findCoefficientB(){
        myRoom.getParametersCalculatedFireLoad().setCoefficientB((myRoom.getCommonParameters().getSquare()*
                myRoom.getParametersCalculatedFireLoad().getCoefficientK())/
                (myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()*
                        (sqrt(myRoom.getParametersCalculatedFireLoad().getReducedHeightOfApertures()))));
    }
    /**
     * Функция нахождения коэффициента С
     */
    public void findCoefficientС(){
        Double coefficientС=1.0;
        myBuilding.getCoefficientSForBuild().set
                (2,myBuilding.getCoefficientSForBuild().get(2)*
                        myBuilding.getSpecifyingCoefficientS5());//нужно умножить на уточняющий коэффициент для пятого пункта
        for (Double temp:myRoom.getParametersCalculatedFireLoad().getSelectedSs())
            coefficientС*=temp;
        for (Double temp1:myBuilding.getCoefficientSForBuild())
            coefficientС*=temp1;
        myRoom.getParametersCalculatedFireLoad().setCoefficientS(coefficientС);
    }
    /**
     * Функция нахождения расчетной пожарной нагрузки
     */
    public void findEstimatedFireLoad(){//перемножаем коэффициенты А В С и удельную пожарную нагрузку
        myRoom.getParametersCalculatedFireLoad().setEstimatedFireLoad(
                myRoom.getParametersCalculatedFireLoad().getSpecificFireLoad()*
                        myRoom.getParametersCalculatedFireLoad().getCoefficientA()*
                        myRoom.getParametersCalculatedFireLoad().getCoefficientB()*
                        myRoom.getParametersCalculatedFireLoad().getCoefficientS());
    }
}
