package app.model;

import app.entities.StandartGame;

import java.util.ArrayList;
import java.util.List;

public class SingletonModel {
    //создадим сингтон, который будет хранить список наших игр и производить с ними манипуляции
    //добавим синхронизацию, чтобы безопасно работать со списком в разных потоках

    private static List<StandartGame> games = new ArrayList<StandartGame>();
    private static SingletonModel model;

    public SingletonModel() {
        addGames(new StandartGame("Game1", 12, "RPG"));
        addGames(new StandartGame("Game2", 15, "FPS"));
    }

    public static synchronized SingletonModel getModel() {
        if (model==null) {
            model = new SingletonModel();
        }
        return model;
    }

    public static synchronized List<StandartGame> getList() {
        return games;
    }

    public static synchronized void addGames(StandartGame ... gamez) {
        for (StandartGame gm : gamez) {
            games.add(gm);
        }
    }
}
