# [MapStruct](https://mapstruct.org/) Example
> 자바 빈 클래스를 위한 매퍼 라이브러리
 
## 자동 생성된 매퍼 클래스 코드

```java
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-17T19:14:58+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (AdoptOpenJDK)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDto carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setSeatCount( car.getNumberOfSeats() );
        carDto.setMake( car.getMake() );
        if ( car.getType() != null ) {
            carDto.setType( car.getType().name() );
        }

        return carDto;
    }
}
```