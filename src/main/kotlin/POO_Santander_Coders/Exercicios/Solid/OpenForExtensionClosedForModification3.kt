package POO_Santander_Coders.Exercicios.Solid

public interface Shape {
    fun getArea():Double;
}

public class Rectangle: Shape {
    private var length:Double = 0.0;
    private var height:Double = 0.0;
    // getters/setters ...
    override fun  getArea(): Double {
        return (length * height);
    }
}

public class Circle : Shape{
    private var radius:Double = 0.0;
    // getters/setters ...
    override fun getArea() : Double {
        return (radius * radius * Math.PI);
    }
}

public class AreaFactory {
    fun calculateArea(shapes: ArrayList<Shape>): Double {
        var area: Double = 0.toDouble();
        for (shape in shapes) {
            area += shape.getArea();
        }
        return area;
    }
}