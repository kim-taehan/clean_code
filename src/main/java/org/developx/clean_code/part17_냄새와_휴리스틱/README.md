## 주석

### C1: 부적절한 정보
- 다른 시스템(소스 코드 관리 시스템) 저장할 정보는 주석으로 적절하지 못하다.
- 변경이력은 장황한 날짜와 따분한 내용으로 소스 코드만 번잡하게 한다.

### C2: 쓸모없는 주석
- 쓸모 없어질 주석은 아예 달지 않는 편이 가장 좋다. 

### C3: 중복된 주석
- 코드만으로 충분한데 구구절절 설명하는 주석이 중복된 주석이다. 

### C4: 성의 없는 주석
- 안연한 소리를 반복하지 않는다. 간결하고 명료하게 작성한다.

### C5: 주석 처리된 코드
- 주석으로 처리된 코드를 발견하면 즉각 지워라.

## 환경

### E1: 여러 단계로 빌드해야 한다
- 빌드는 간단한 한 단계로 끝나야 한다.
- 한 명령으로 전체를 체크아웃해서 한 명령으로 빌드할 수 있어야 한다.

### E2: 여러 단계로 테스트해야 한다
- 모든 단위 테스틑 한 명령으로 돌려야 한다.

## 함수

### F1: 너무 많은 인수
- 함수에서 인수 개수는 작을수록 좋다. 아예 없으면 가장 좋다.

### F2: 출력 인수
- 출력 인수는 직관을 정면으로 위해한다.
- 함수에서 뭔가의 상태를 변경해야 한다면 함수가 속한 객체의 상태를 변경하자.

### F3: 플레그 인수
- 플래그 인수보다 함수를 나누는 방법을 고려하자.

### F4: 죽은 함수
- 아무도 호출하지 않는 함수는 삭제한다.
- 소스 코드 관리 시스템이 모두 기억하므로 걱정할 필요없다.

## 일반
### G1: 한 소스 파일에 여러 언어를 사용하면 안된다
- 소스 파일 하나에 언어 하나만 사용하는 방식이 가장 좋다.

### G2: 당연한 동작을 구현해야 한다
- 함수나 클래스는 다른 프로그래머가 당연하게 여길 만한 동작과 기능을 제공해야 한다.

### G3: 경게를 올바로 처리해야 한다
- 직관에 의지하지 말고, 경계 조건을 찾아내고, 테스트하는 테스트 케이스를 작성하라.

### G4: 안전 절차 무시
- 실패하는 테스트 케이스를 나중으로 미루는 태도는 위험하다.

### G5: 중복
- 코드에서 중복을 발견할 때마다 추상화할 기회로 간주하라.
- if/switch문으로 조건을 확인하는 중복은 다형성으로 대체
- 알고리즘이 유사하나 코드가 다른 중복은 Template method, 전략패턴으로 제거

### G6: 추상화 수준이 올바르지 못한다

### G7: 기초 클래스가 파생 클래스의 의존한다.
- 기초 클래스는 파생 클래스를 아예 몰라야 한다.

### G8: 과도한 정보
- 잘 저의된 인터페이스는 많은 함수를 제공하지 않는다.
- 자료를 숨겨라
- 유틸리티 함수를 숨겨라
- 상수와 임시 변수를 숨겨라
- 메서드나 인스턴스 변수가 넘쳐나느 클래스는 피하라
- 인터페이스를 매우 작게 그리고 매우 깐깐하게 만들어라

### G9: 죽은 코드 
- 실행되지 않은 코드는 제거하라.

### G10: 수직 분리 
- 변수와 함수는 사용되는 위치에 가깝게 정의
- 지역변수는 처음으로 사용하기 직전에 선언하며 수직으로 가까운 곳에 위치
- 비공개 함수는 처음으로 호출한 직후에 정의해야 한다

### G11: 일관성 부족
- 어떤 개념을 특정 방식으로 구현했다면 유사한 개념도 같은 방식으로 구현한다

### G12: 잡동사니
- 아무도 사용하지 않는 함수, 정보를 제공하지 못하는 조석등의 잡동사니를 없애라

### G13: 인위적 결함
- 서로 무관한 개념을 인위적으로 결함하지 않는다.
- 함수, 상수, 변수를 선언할 때는 시간을 들여 올바른 위치를 고민해야 한다.

### G14: 기능 욕심
- 클래스 메서드는 자기 클래스의 변수와 함수에 관심을 가져야지 다른 클래스에 관심을 가져서는 안된다.
- 메서드가 다른 객체의 참조자와 변경자를 사용해 그 객체 내용을 조작하면 메서드가 욕심내는 것이다.

### G15: 선택자 인수
- boolean, int, enum 등을 인수로 함수동작어 제어하기 보다 새로운 함수를 만들자.

### G16: 모호한 의동
- 독자에게 의도를 분명히 표현하도록 시간을 투자할 가치가 있다.
- 코드를 짤 때는 의도를 최대한 분명히 밝힌다.

### G17: 잘못 지운 책임
- 코드를 배치하는 위치는 중요한 결정중에 하나이다.
- 코드는 독자가 자연스럽게 기대할 위치에 배치한다.

### G18: 부적절한 static 함수
- 재정의할 가능성이 있는 경우 static 함수로 정의하지 말자.

### G19: 서술적 변수
- 서술적이 변수 이름으로 프로그램 가독성을 높일 수 있다. 
- 하나의 계산을 나누너 중간 값으로 서술적인 변수 이름을 사용하자.

### G20: 이름과 기능이 일치하는 함수
- 함수 기능을 함수 이름만으로 알 수 있게 이름을 만들자.

### G21: 알고리즘을 이해해라
- 함수가 돌아가는 방식을 확실히 이해하는지 확인하라.
- 작성자가 알고리즘이 올바르다는 사실을 알아야 한다.

### G22: 논리적 의존성은 물리적으로 드러내라
- 의존하는 모든 정보를 명시적으로 요청하는 편이 좋다.

### G23: if/switch 문보다 다형성을 사용하라

### G24: 표준 표기법을 따르라

### G25: 매직 숫자는 명명된 상수를 교체하라

### G26: 정확하라
- 코드에서 모호성과 부정확은 의견차나 게으름의 결과다.
- 부동소수점으로 통화를 표현하는 행동의 범죄다.
- 검색 결과 중 첫 번째 결과만 유일한 결과로 간주하면 순진하다.

### G27: 관례보다는 구조를 사용하라
- enum 변수가 멋진 switch 문보다 추상 클래스가 있는 기초 클래스가 더 좋다.

### G28: 조건을 캡슐화하라
### G29: 부정 조건은 피하라
### G30: 함수는 한 가지만 해야 한다
- 3가지를 처리하는 함수
```java
class ThreeJob {
    public void pay() {
        for (Employee e : employees) {
            if (e.isPayDay()) {
                Money pay = e.calculatePay();
                e.deliverPay(pay);
            }
        }
    }
}
```
- 1가지만 처리하는 함수들
```java
class OneJob {
    
    public void pay() {
        for (Employee e : employees) {
            payIfNecessary(e);
        }
    }
    
    private void payIfNecessary(Employee e){
        if (e.isPayDay()) {
            calculateAndDeliverPay(e);
        }
    }
    
    private void calculateAndDeliverPay(Employee e) {
        Money pay = e.calculatePay();
        e.deliverPay(pay);
    }
}
```

### G31 숨겨진 시간적인 결함
- 시간적인 결합을 숨겨서는 안 된다.
- 함수를 짤 때는 함수 인수를 적절히 배치해 함수가 호출되는 순서를 명백히 드러낸다.

### G32: 일관성을 유지하라
- 코드 구조를 잡을 때는 이유를 고민하고, 일관성을 유지하여 작성하자

### G33: 경계 조건을 캡슐화하라
- 경계 조건은 한 곳에 별로도 처리한다.

### G34: 함수는 추상화 수준을 한 단계만 내려가야 한다
- 함수 내 모든 문장은 추상화 수준이 동일해야 한다.
- 그리고 그 추상화 수준은 함수 이름이 의미하는 작업보다 한 단계만 낮아야 한다.

### G35: 설정 정보는 최상위 단계야 둬라
- 기본값 상수나 설정 관련 상수를 저차원 함수에 숨겨서는 안된다

### G36: 추이적 탐색을 피하라
- A->B->C 라고 하더라도 A가 C를 알아야 할 필요는 없다. (A.getB().getC().doSomething())
- 디미터 법칙이라고 부른다. 

## 자바
### J1: 긴 import 목록을 피하고 와일드카드를 사용하라
- 패키지에서 클래스를 둘 이상 사용한다면 와일드카드를 사용해 패키지 전체를 가져오라.

### J2: 상수는 상속하지 않는다.

### J3: 상수 대 enum
```java
public enum HourlyPayGrade {
    APPRENTICE {
        @Override
        public double rete() {
            return 1.0;
        }
    },
    MASTER {
        @Override
        public double rete() {
            return 2.0;
        }
    };
    public abstract double rete();
}
```

## 이름
### N1: 서술적인 이름을 사용하라
- 소프트웨어의 가독성의 90%는 이름이다.

### N2: 적절한 추상화 수준에서 이름을 선택하라
### N3: 가능하다면 표준 명명법을 사용하라
### N4: 명확한 이름
- 함수나 변수의 목적을 명확히 밝히는 이름을 선택한다.
### N5: 긴 범위는 긴 이름을 사용하라
- 범위가 작으면 아주 짧은 이름을 사용해도 괜찮다 (i,j,k)

### N6: 인코딩을 피하라
- 멤버변수 접두어 m_ 이런거 하지 말자

### 이름으로 부수 효과를 설명하라
- 함수, 변수, 클래스가 하는 일을 모두 길술하는 이름을 사용하라. 이름에 부수효과를 숨기지 말자

## 테스트
### T1: 불충분한 테스트
### T2: 커버리지 도구를 사용하라
### T3: 사소한 테스트를 건너뛰지 마라
### T4: 무시한 테스트는 모호함을 뜻한다
### T5: 경계 조건을 테스트하라
### T6: 버그 주변은 철저히 테스트 하라: 버그는 서로 모이는 경향이 있다
### T7: 실패 패턴을 살펴라
### T8: 테스트 커버리지 패턴을 살펴라
### T9: 테스트는 빨라야 된다

