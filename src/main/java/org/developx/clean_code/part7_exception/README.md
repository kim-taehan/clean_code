## 오류 코드보다 예외를 사용하라
- 오류 코드를 전달하여 처리하는 것보다 예외처리가 더 깔끔하다.

### 오류 코드 처리
```java
public class DeviceController {
    ...
    public void shutdown() {
        DeviceHandle handle = getHandle();
        if (handel != DeviceHandle.INVALID) {
            closeDevice(handel);
        }
    }

    private DeviceHandle getHandle() {
        ...
        if (checkState) {
            return DeviceHandle.VALID;
        }
        else {
            return DeviceHandle.INVALID;
        }
    }
}
```

### 예외처리
```java
public class DeviceController {
    ...
    public void shutdown() {
        try {
            DeviceHandle handle = getHandle();
            closeDevice(handel);
        } catch (IllegalStateException e) {
            // exception 처리
        }
    }

    private DeviceHandle getHandle() {
        ...
        if (!checkState) {
            throw new IllegalStateException();
        }
       
    }
}
```

## try 문부터 작성하라.
- 먼저 강제로 예외를 일으키는 테스트 케이스를 작성한 후 테스트를 통과하게 코드를 작성하는 방법을 사용하자.
- 자연스럽데 try 블록의 트랜잭션 범위부터 구현하게 되므로 범위 내에서 트랜잭션 본질을 유지하기 쉬워진다.

## 미확인(unchecked) 예외를 사용하라
- 확인예외는 OCP을 위반한다. catch 블럭 위치에 따라 상위 단계 메서드 선언부를 수정해야 된다. 
- 하위 클래스에서 던지는 예외를 상위 클래스에서 알아야 되므로 캡슐화도 깨진다.

## 예외의 의미를 제공하라
- 오류 메시지에 정보를 담아 던진다. (실패한 연산 이름과 실패 유형까지 언급)
- 로깅 기능으로 오류를 항상 기록하자. 

## 호출자를 고려해 예외 클래스를 정의하라 
- 특정 API에서 여러가지의 예외를 발생하는 경우 상위 클래스에서 처리 방식이 같은데 전부 정의하는 방식이 복잡하다
- 방법 1 감싸기(wrapper) 클래스에서 예외를 던지거나
- 방법 2 | 처리 방식으로 통해 예외를 처리하자 (IllegalArgumentException|..Exception e)

## null을 반환하지 마라
## null을 전달하지 마라