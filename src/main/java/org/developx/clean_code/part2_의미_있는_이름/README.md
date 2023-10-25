## 의도를 분명히 밝혀라
> 좋은 이름을 지으려면 시간이 걸리지만 좋은 이름으로 절약하는 시간이 훨씬 더 많다.

### FLAG  
```java
public class BoardGame {
    
    public List<Cell> getFlaggedCell() {
        List<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : gameBoard) {
            if (cell.isFlag()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
}
```

## 그릇된 정보를 피하라
- 널리 쓰이는 의미가 있는 단어를 다른 의미로 사용해도 안된다. (hp, aiz, sco)
- 프로그래머에게 List라는 단어는 특수한 의미다. 실제 list가 아닌 경우 사용하지 말자.
- 서로 흡사한 이름을 사용하지 말자.
- 소문자 L이나 대문자 O 변수는 0,1 처럼 보인다. 

## 의미 있게 구분하라
- 연속된 숫자를 덧붙인 이름(a1, a2, ... aN)은 의도적인 이름과 정반대다.
- 불용어(분석에 큰 의미가 없는 단어를 지칭)는 사용을 자제하자. (data, info, String, table)

## 발음하기 쉬운 이름을 사용하라
- `genymdhms` 같은 약어는 사용하지 말자.(generate date, year, month, day, hour, minute, sec)
- `genymdhms` -> `geerationTimestamp`

## 검색하기 쉬운 이름을 사용하라
- `7`, 'e' 같은 변수는 검색하기 쉽지 않다.

## 인코딩을 피하라
- 헝가리식 표기법: phoneString, phoneInt 같이 사용하지 마라.
- 멤버변수 접두어: m_phone -> phone 
- 인터페이스 클래스와 구현 클래스: 둘중 하나랄 인코딩 한다면 구현클래스를 인코딩하자(Impl)

## 자신의 기억력을 자랑하지 마라
- 문자 하나만 사용하는 변수 이름을 사용하지 말자 (단순 반복문에는 i, j, k는 관례상 허용)
- 남들이 이해할 수 있는 코드를 내놓아야 한다.

## 클래스 이름 
- 클래스 이름과 객체 이름은 명사나 명사구가 적합하다.
- 좋은예: Customer, WikiPage, Account, AddressParser 
- 나쁜예: Manager, Processor, Data, Info

## 메서드 이름
- 메서드 이름은 동사나 동사구가 적합하다.(postPayment, deletePage, save)
- javaBean 표준: 접근자(get), 변경자(set), 조건자(is)

## 기발한 이름은 피하라
- 재미난 이름보다는 명료한 이름을 선택하라.

## 한 개념에 한 단어를 사용하라
- 추상적인 개념 하나에 단어 하나를 선택해 이를 고수하자 (get, fetch, retrieve)

## 해법 영역에서 가져온 이름을 사용하라
- 코드를 읽을 사람도 프로그래머이므로, 전산용어, 알고리즘 이름, 패턴 이름등을 사용해도 된다.
- visitor, adapter 등등

## 의미 있는 맥락을 추가하라
- 스스로 의미가 분명하지 않는 이름은 클래스, 함수 이름으로 맥락을 부여하라
- 마지막 수단으로 접두어를 붙여도 된다. (firstName -> addrFirstName)

```java
public class GuessStatisticsMessage {

    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count) {
        createPluralDependentMessageParts(count);
        return String.format(
                "There %s %s %s%s",
                verb, number, candidate, pluralModifier
        );
    }

    private void createPluralDependentMessageParts(int count) {
        MessageState.fromValue(count).run();
    }

    @RequiredArgsConstructor(access = PRIVATE)
    private static enum MessageState implements Runnable {
        ZERO(0 ){
            @Override
            public void run() {
                // ...
            }
        },
        ONE(1){
            @Override
            public void run() {
                // ...
            }
        },
        ETC(Integer.MAX_VALUE){
            @Override
            public void run() {
                // ...
            }
        };
        private final int value;

        public static MessageState fromValue(int value) {
            return Arrays.stream(MessageState.values())
                    .filter(messageState -> messageState.value == value)
                    .findFirst()
                    .orElseGet(() -> ETC);
        }
    }
}
```

## 불필요한 맥락을 없애라
- 일반적으로 짧은 이름이 긴 이름보다 좋다. 단 의미가 분명한 경우에 한해서다.