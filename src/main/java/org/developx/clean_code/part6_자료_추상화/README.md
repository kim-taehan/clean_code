## 자료 추상화
- 구현을 감추려면 추상화가 필요하다. 
- 추상 인터페이스를 제공하여 사용자가 구현을 모른 채 자료의 핵심을 조작할 수 있어야 한다.

```java
public interface Point {

    double getX();
    double getY();
    
    void setCartesian(double x, double y);
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}
```

## 자료/객체 비대칭
- 절차적인 코드는 새오운 자료 구조를 추가하기 어렵다.
- 객체 지향 코드는 새로운 함수를 추가하기 어렵다. 그러려면 모든 클래스를 수정해야 된다.
  (default 메서드로 일부 해소 가능)
- 떄로는 단순한 자료 구조와 절차적인 코드가 가장 적합한 상황도 있다.

```java
public interface Shape {
    double area();
}
```
```java
public abstract class AbstractShape implements Shape {

    private final Point topLeft;

    protected AbstractShape(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getTopLeft() {
        return topLeft;
    }
}
```
```java
public class Square extends AbstractShape {

    private final double side;

    public Square(Point topLeft, double side) {
        super(topLeft);
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
```


## 디미터 법칙
- 모듈은 자신이 조작하는 객체의 속사정을 몰라야 한다는 법칙

### 기차 충돌
- 개인적으로 이러한 코드가 맘에 들지 않는다.
```java
final String outputDir = ctxt.getOptions().getScratchDir().getAbsolutePath();
```

### 구조체 감추기 
- 가능하다면 객체에게 요청하는 방식으로 하는 것이 좋다.
```java
BufferdOutputStream bos = ctxt.createScratchFileStream(classFileName);
```

## 자료 전달 객체 
- DTO: 공개 변수만 있고 함수가 없는 클래스이다.
### 활성레코드: 
- 기본적인 DTO 기능에 find, save 같은 탐색 함수도 제공
- 여기에 비지니스 규칙 메서드를 추가해 이런 자료 구조를 객체로 취급하는 개발은 바람직하지 않다.

