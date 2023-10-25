## 작게 만들어라
- 함수를 만드는 첫째 규칙은 `작게`다. 둘째 규칙은 `더 작게`다.
- 함수에서 if,for,try 문에 들어가는 블록은 한 줄이어야 한다.

## 한 가지만 해라
- 함수는 한 가지를 해야한다. 그 한 가지를 잘 해야 한다. 그 한 가지만을 해야 한다.

## 함수 당 추상화 수준은 하나로!
- 함수가 확실한 `한 가지` 작업만 하려면 함수 내 모든 문장의 추상화 수준이 동일해야 한다.

## switch 문 
- switch 문을 저차원 클래스에 숨기고 절대로 반복하지 말자 (다형성 이용)
- 다형성 객체를 생성하는 코드안에서만 switch 문을 사용하도록 하자.
```java
public class EmployeeFactory {

    public Employee makeEmployee(EmployeeRecord record) {
        return switch (record) {
            case COMMISSIONED -> new CommissionedEmployee();
            case HOURLY -> new HourlyEmployee();
            case SALARIED -> new SalariedEmployee();
        };
    }
}
```

```java
class EmployeeTest {

    @DisplayName("COMMISSIONED 직원의 월급을 계산")
    @Test
    void calculatorPayTest(){
        // given
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Employee employee = employeeFactory.makeEmployee(EmployeeRecord.COMMISSIONED);

        Assertions.assertThat(employee.calculatorPay()).isEqualTo(10000);
    }
}
```

## 서술적인 이름을 사용하라
- 길고 서술적인 이름이 짧고 어려운 이름보다 좋다. 
- 이름을 붙일 때는 일관성이 있어야 한다. 모듈 내에서 함수 이름은 같은 문구, 명사, 동사를 사용

## 함수 인수 
- 함수에서 이상적인 인수 개수는 0개다. 3항 이상은 피하도록 하자.

### 많이 쓰는 단항 형식 
- 인수에 질문을 던지는 경우 boolean isExists("myFile")
- 인수를 뭔가로 변환해 결과를 반환하는 경우 InputStream fileOpen("myFile)
- 이벤트 함수 (입력 인수만 있고 반환값이 없는 경우)는 이벤트라는 사실에 코드에 나타나야 한다.
- 변환 함수에서 출력인수를 사용하지 말자 (만약 그렇다면 반환값으로 돌려주자) StringBuffer transForm(StringBuffer in)
- flag 함수는 만들지 말고 차라리 함수를 2개를 만들어라.

### 인수 개수를 줄이는 방법
- 메서드를 인수 클래스의 구성원으로 만들어 인수를 줄인다.
- 새 클래스를 만들어 구성자에서 인수를 받고 메서드는 구성한다.
- 인수 2-3개의 공통점이 있다면 클래스 변수로 만들어 줄인다.


## 부수효과를 만들지마라
- 함수에서 한가지를 하겠다고 약속하고 남몰래 다른 짓을 하지마라.
- 예) boolean checkPassword() 로 해놓고 세션 초기화 함수 호출 같은 짓

## 출력인수
- 객체지향 함수에서는 출력인수(반환값이 존재하는)가 있는 메서드를 만들 필요가 없다.
- 상태를 변경해야 된다면 함수가 속한 객체의 상태를 변경하는 방식이 좋다. 

## 명령과 조회를 분리하라.
- 함수는 뭔가를 수행하거나 뭔가에 답하거나 둘 중 하나만 해야한다.
- set, get을 같이쓰는 짓을 하지마라 (함수를 나눠버리자)

## 오류 코드보다 예외를 사용하라
- try, catch 문은 별도의 함수로 뽑아내자.
- 새 오류코드를 추가하는 대신 기존 오류코드를 사용하자.

## 구조적 프로그램밍 
- 함수는 return 문이 하나야한다. 루프안에서 break, continue를 사용을 지양하자.
- goto 문은 사용하지 말자

