## 외부 코드 사용하기
- 
```java
Map<String, Sensor> sensors = new HashMap();
Sensor sensor = sensors.get(sensorId);
```
```java
import java.util.HashMap;

public class Sensors {
    private Map<String, Sensor> sensors = new HashMap<>();

    public Sensor getById(String id) {
        return sensors.get(id);
    }
}
```

## 경계 살피고 익히기
- 학습테스트를 통해 외부 라이브러리를 학습하고, 검증하는 시스템을 구축한다.

## 학습 테스트는 공짜 이상이다. 
- 학습 테스트는 패키지가 예상대로 도는지 검증한다. (패키지 버전 업데이트에 대한 반영이 쉽다.)

## 아직 존재하지 않는 코드를 사용하기
- 1. Client가 바라는 기능을 인터페이스로 생성한다.
- 2. 인터페이스를 구현한 fake 구현체를 생성한다.
- 3. 추후 라이브러리가 나오게 되면 adapter를 통해 외부 라이브러리를 구현해라.

```java
public interface Transmitter {
    void transmit(String frequency, String stream);
}
```

```java
public class FakeTransmitter implements Transmitter {
    @Override
    public void transmit(String frequency, String stream) {
        // fake logic
    }
}
```

```java
public class TransmitterAdapter implements Transmitter {
    @Override
    public void transmit(String frequency, String stream) {
        // 외부 라이브러리 호출
    }
}
```