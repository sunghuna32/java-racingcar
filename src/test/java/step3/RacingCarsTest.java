package step3;

import CarRacing.domain.Car;
import CarRacing.domain.RacingCars;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        final List<Car> carList =  Lists.newArrayList();
        carList.add(new Car("jinwoo", 3));
        carList.add(new Car("minho", 2));
        carList.add(new Car("charse",1));

        racingCars = new RacingCars(carList);
    }

    @DisplayName("차 3대가 잘 만들어졌는지 확인")
    @Test
    void createRacingCarsTest() {
        assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
    }
}