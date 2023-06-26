package Abstraction.Interface;

enum  geometry{LINE , POLYGON, POINT}
enum color{BLACK, BLUE, RED , YELLOW,PINK}
enum  pointMarket{DASH,DOTTED,SOLID}
public interface Mappable {
    String JSON_PROPERTY= """
            "properties" :{%s}""";

String getLabel();
geometry getShape();
String getMarker();

    default String toJSON(){return """
            "type":"%s" ,"label": {%s}, "marker": "%s"
            """.formatted(getShape(),getLabel(),getMarker());

    }

    static void mapIt(Mappable mappable){
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }




}
