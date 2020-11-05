package racingcar;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    List<Memento> mementos;
    private CarGroup carGroup;
    private int currRaceNum;
    private int maxRaceNum;

    public RacingGame(String nameCsv, int maxRaceNum) {
        MoveStrategy defaultStrategy = RandomStrategy.getInstance();
        this.carGroup = new CarGroup(nameCsv, defaultStrategy);
        this.maxRaceNum = maxRaceNum;
        this.mementos = new LinkedList<>();
    }

    public void setStrategy(MoveStrategy strategy) {
        this.carGroup.setStrategy(strategy);
    }

    protected boolean checkGameOver() {
        return this.currRaceNum >= this.maxRaceNum;
    }

    protected void race() {
        if (this.checkGameOver()) {
            return;
        }
        this.currRaceNum++;
        this.carGroup.moveCar();
        this.mementos.add(
                this.carGroup.createMemento()
        );
    }

    public void play() {
        while (!this.checkGameOver()) {
            this.race();
        }
    }

    public List<List<Car>> getHistory() {
        return this.mementos.stream()
                .map(memento -> memento.getCars())
                .collect(Collectors.toList());
    }

    public List<Car> getWinners() {
        return this.carGroup.getWinners();
    }
}
