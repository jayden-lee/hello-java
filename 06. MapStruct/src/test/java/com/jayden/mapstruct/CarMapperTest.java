package com.jayden.mapstruct;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CarMapperTest {

    @Test
    public void shouldMapCarToDto() {
        // given
        Car car = new Car( "Morris", 5, CarType.SEDAN );

        //when
        CarDto carDto = CarMapper.INSTANCE.carToCarDto( car );

        //then
        assertNotNull(carDto);
        assertEquals("Morris", carDto.getMake());
        assertEquals(5, carDto.getSeatCount());
        assertEquals("SEDAN", carDto.getType());
    }
}