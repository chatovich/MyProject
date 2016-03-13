package by.it;

/**
 * Класс описания проемов
 */
public class Aperture {
    Double width;//ширина проема
    Double height;//высота проема
    Integer amount;//количество проемов
    String typeOfAperture;//тип дверь\окно\технолог.проем

    public Aperture(String name, String width, String height, String amount){
        this.width=Double.valueOf(width);
        this.height=Double.valueOf(height);
        this.amount=Integer.valueOf(amount);
        this.typeOfAperture=name;
    }
}
