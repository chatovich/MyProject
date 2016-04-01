package by.it.generate.functional;

import by.it.generate.Aperture;
import by.it.generate.Building;
import by.it.generate.Room;

import static by.it.Utils.Rounding.myRound;
import static java.lang.Math.*;

/**
 * Класс вычисления параметров расчетной пожарной нагрузки
 */
public class DefinitionOfParametersOfCalculatedFireLoad1 {
    private Building myBuilding;

    public DefinitionOfParametersOfCalculatedFireLoad1(Building build){
        myBuilding=build;
    }

    /**
     * Функция для вычисления всех функций класса и запись их в объект
     * сделано для возможности реализации тестировки
     */
    public void findCalculatedParemetres(Room myRoom){
        Double[] res=findReducedHeightOfApertures(myRoom);
        myRoom.getParametersCalculatedFireLoad().setReducedHeightOfApertures(res[0]);//приведенная высота проемов
        myRoom.getParametersCalculatedFireLoad().setGeneralSquareOfApertures(res[1]);//общая площадь проемов

        myRoom.getParametersCalculatedFireLoad().setVentilationParameter(findVentilationParameter(myRoom));

        myRoom.getParametersCalculatedFireLoad().setCoefficientK(findCoefficientK(myRoom));

        myRoom.getParametersCalculatedFireLoad().setCoefficientB(findCoefficientB(myRoom));

        myRoom.getParametersCalculatedFireLoad().setCoefficientS(findCoefficientС(myRoom));

        myRoom.getParametersCalculatedFireLoad().setEstimatedFireLoad(findEstimatedFireLoad(myRoom));
    }
    /**
     * Функция нахождения приведенной высоты проемов в вертикальных ограждающих конструкциях помещения
     * и общей площади проемов в наружных стенах помещения
     */
    public Double[] findReducedHeightOfApertures(Room myRoom){
        Double numerator=0.0;//числитель
        Double denominator=0.0;//знаменатель
        Double result=0.0;//приведенная высота проемов
        for (Aperture temp:myRoom.getAperture()){
            numerator+=((temp.getHeight()*temp.getSquareOfAperture())*temp.getCount());//сумма: высота*площадь*количество
            denominator+=(temp.getSquareOfAperture()*temp.getCount());//сумма площадь*количество
            result=numerator/denominator;
        }
        Double[] res=new Double[2];
        res[0]=result;//приведенная высота проемов
        res[1]=denominator;//общая площадь проемов
        res[0]=myRound(res[0]);
        res[1]=myRound(res[1]);
        return res;
    }
    /**
     * Функция нахождения параметра вентиляции
     */
    public Double findVentilationParameter(Room myRoom){
        return myRound((myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()*
                (sqrt(myRoom.getParametersCalculatedFireLoad().getReducedHeightOfApertures())))/
        myRoom.getCommonParameters().getSquareOfConstruction());
    }
    /**
     * Функция нахождения коэффициента К
     */
    public Double findCoefficientK(Room myRoom){//коэффициент необходим для конечного вычисления коэффициента В
        if (myRoom.getParametersCalculatedFireLoad().getVentilationParameter()<=0.03){
            return myRound(2.31*
                    pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(),0.84));
        }else if (myRoom.getParametersCalculatedFireLoad().getVentilationParameter()>0.03){
            return myRound(((0.3*
                    (pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(),0.8)))-
                    (0.002*(pow(myRoom.getParametersCalculatedFireLoad().getVentilationParameter(),-1)))+
                    (log10(myRoom.getParametersCalculatedFireLoad().getVentilationParameter()))+2.25)*(1/5.5));
        }
        return null;
    }
    /**
     * Функция нахождения коэффициента B
     */
    public Double findCoefficientB(Room myRoom){
        return myRound((myRoom.getCommonParameters().getSquare()*
                myRoom.getParametersCalculatedFireLoad().getCoefficientK())/
                (myRoom.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()*
                        (sqrt(myRoom.getParametersCalculatedFireLoad().getReducedHeightOfApertures()))));
    }
    /**
     * Функция нахождения коэффициента С
     */
    public Double findCoefficientС(Room myRoom){
        Double coefficientС=1.0;
        myBuilding.getCoefficientSForBuild().set
                (2,myBuilding.getCoefficientSForBuild().get(2)*
                        myBuilding.getSpecifyingCoefficientS5());//нужно умножить на уточняющий коэффициент для пятого пункта
        for (Double temp:myRoom.getParametersCalculatedFireLoad().getSelectedSs())
            coefficientС*=temp;
        for (Double temp1:myBuilding.getCoefficientSForBuild())
            coefficientС*=temp1;
        return myRound(coefficientС);
    }
    /**
     * Функция нахождения расчетной пожарной нагрузки
     */
    public Double findEstimatedFireLoad(Room myRoom){//перемножаем коэффициенты А В С и удельную пожарную нагрузку
        return myRound(myRoom.getParametersCalculatedFireLoad().getSpecificFireLoad()*
                        myRoom.getParametersCalculatedFireLoad().getCoefficientA()*
                        myRoom.getParametersCalculatedFireLoad().getCoefficientB()*
                        myRoom.getParametersCalculatedFireLoad().getCoefficientS());
    }
}
