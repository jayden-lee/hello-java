# Design Pattern
> Java 언어로 배우는 디자인 패턴 입문 책을 학습하고 정리한 내용입니다.

## Contents
1. Iterator 패턴

2. Adapter 패턴
    - 클래스 상속, 인터페이스 구현을 통한 어댑터 패턴 구현
    - 위임을 통한 어댑터 패턴 구현
    
3. Template Method 패턴
    - 추상 클래스에서는 템플릿 메서드를 구현하고 추상 메서드를 선언
    - 구현 클래스에서는 추상 메서드를 구체적으로 구현
    
4. Factory Method 패턴
    - 인스턴스를 생성하는 방법을 상위 클래스에서 선언
    - 구체적인 인스턴스에 대한 내용은 하위 클래스에서 구현
    - 특정 인스턴스를 직접 생성하는 것이 아닌 Factory 클래스를 통해 생성
    
5. Singleton 패턴
    - 인스턴스의 수를 1개로 제한하기 위해서 사용
    - 외부에서 new 키워드를 이용하여 인스턴스를 생성하는 것이 아닌 Singleton 내부적으로 인스턴스를 생성
    - Singleton 클래스를 사용할 때 초기화가 이루어지고 유일한 인스턴스를 생성
    
6. Prototype 패턴
    - 생성해야 하는 클래스 종류가 너무 많은 경우에 Prototype 패턴을 사용
    - 클래스로부터 인스턴스 생성이 어려운 경우에 인스턴스로부터 새로운 인스턴스를 생성
    
7. Builder 패턴
    - 필요한 기능을 담고 있는 Builder 추상 클래스를 선언
    - Builder 클래스를 사용하는 클라이언트 클래스는 구현 여부와 관계 없이 Builder 클래스를 이용해서 작업
    - 구체적인 작업은 Builder 클래스의 하위 클래스에 구현
    
8. Abstract Factory 패턴
    - 서로 연관되거나 의존적인 객체들의 조합을 만드는 인터페이를 제공
    - 관련성 있는 여러 종류의 객체를 일관된 방식으로 생성하는 경우에 유용하다
    
9. Bridge 패턴
    - 기능과 구현에 대해서 두 개의 별도의 클래스로 구현
    - Abstraction(추상화)는 기능 계층의 최상위 클래스로써 구현 부분에 해당하는 클래스의 인스턴스를 가지고 있다
    - Implementor(구현자)는 Abstraction(추상화) 기능을 구현하기 위한 인터페이스를 정의
    
10. Strategy 패턴
    - Strategy 인터페이스를 통해 느슨하게 연결하고 알고리즘을 쉽게 교환할 수 있다
    - 알고리즘이 변경될 경우에 Strategy 인터페이스를 구현한 클래스에서만 변경하므로 변경 범위가 적다
    - 동적으로 알고리즘 교체 가능
    
11. Composite 패턴
    - 동일한 인터페이스를 통해 복합 객체와 단일 객체를 클라이언트 입장에서 구별 없이 사용할 수 있다
    - Component는 Leaf와 Composite 클래스의 공통 인터페이스 정의
    - Leaf는 Component 구현 클래스이며, Composite 클래스의 부품으로 사용
    - Composite는 Component 구현 클래스이며, 복수 개의 Component를 가지고 있다
    - 재귀적인 구조 (트리 구조)로 된 데이터 구조는 Composite 패턴에 해당한다
    
12. Decorator 패턴
    - ConcreteComponent 객체의 내용을 변경하지 않고 새로운 기능을 추가할 수 있다
    - Decorator는 자신이 장식할 구성요소(Component)와 같은 인터페이스를 구현한다
    
13. Visitor 패턴
    - 데이터 구조와 처리를 분리한다
    - Vistor(방문자) 클래스는 방문하는 데이터 구조에 의존한다
    - Element는 Visitor를 <code>accept</code>하고, Visitor는 Element를 <code>visit</code>한다
    - Visitor 패턴은 처리(로직)을 데이터 구조에서 분리할 수 있으므로 유연한 장점이 있다
    - [JSQLParser](https://github.com/JSQLParser/JSqlParser)는 Visitor 패턴을 사용해서 SQL 구문이 파싱된 계층 결과를 탐색한다
    
14. Chain of Responsibility 패턴
    - 복수의 오브젝트(객체)를 사슬(chain)처럼 연결하면, 오브젝트의 사슬을 차례로 돌아다니면서 목적한 오브젝트를 결정하는 방법이다
    - Handler, ConcreteHandler, Client 3개의 클래스가 등장한다
    - Handler는 요구를 처리하는 인터페이스를 결정하는 역할을 담당한다
    - ConcreteHandler는 요구를 처리하는 구체적인 역할을 담당한다
    - Client는 ConcreteHandler 역할에 요구(요청)을 하는 일을 담당한다
    - Chain of Responsibility 패턴은 요구하는 객체와 요구를 처리하는 객체를 유연하게 연결하는 것이 특징이다
    
15. Facade 패턴
    - 복잡하게 얽혀 있는 로직을 정리해서 높은 수준의 인터페이스로 제공하는 패턴이다
    - Facade 역할(PageMaker)을 맡는 클래스는 여러 복잡한 클래스를 순서에 맞춰서 호출한다
    - 호출되는 클래스들은 Facade 역할의 클래스를 호출할 일은 없으며 자신이 맡은 역할만 수행한다
    - 클라이언트는 특정 기능을 수행하기 위해서 필요한 인터페이스를 적게 알아도 되는 장점이 있다
    
16. Mediator 패턴
    - 다수의 오브젝트(객체) 사이를 조정해야 할 경우 Mediator 패턴을 이용한다
    - 오브젝트 간에 통신하는 것이 아닌 중개인을 두고 중개인하고만 통신하도록 설계한다
    - Mediator 역할은 Colleague 역할과 통신을 해서 조정을 실행하기 위한 인터페이스를 결정한다
    - Colleague 역할은 Mediator 역할과 통신을 실행할 인터페이스를 결정한다
    - 여러 객체를 제어하는 로직이 한 곳에 모여 있기 때문에 디버깅 및 수정하기에 용이하다
    - Mediator는 양방향이지만, Facade는 단방향이다
    
17. Observer 패턴
    - 관찰 대상의 상태가 변화하면 관찰자에게 알려준다.
    - 상태 변화에 따른 처리를 구현할 때 사용한다.
    - Observer 패턴은 Publish-Subscribe 패턴이라고도 한다.