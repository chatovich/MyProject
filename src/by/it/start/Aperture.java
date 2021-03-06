package by.it.start;

/**
 * Класс описания проемов
 */
public class Aperture {
    String typeOfAperture;//тип дверь\окно\технолог.проем
    Double width;//ширина проема
    Double height;//высота проема
    Double squareOfAperture;//площадь проема (возможен автом. расчет)
    Integer count;//количество проемов
    /**
     * Конструктор объекта проема с указанием количества проемов
     */
    public Aperture(String name, String width, String height, String count){
        this.width=Double.valueOf(width);
        this.height=Double.valueOf(height);
        this.count=Integer.valueOf(count);
        this.typeOfAperture=name;
        squareOfAperture=this.height*this.width;//площадь проема
    }
    /**
     * Конструктор объекта проема без указанием количества проемов (стандартно 1)
     */
    public Aperture(String name, String width, String height, String count, String square){
        this.width=Double.valueOf(width);
        this.height=Double.valueOf(height);
        this.count=Integer.valueOf(count);
        this.typeOfAperture=name;
        squareOfAperture=Double.valueOf(square);//площадь проема
    }

}
