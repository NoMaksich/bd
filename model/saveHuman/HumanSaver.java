package model.saveHuman;

import java.io.IOException;
import model.human.Human;

public interface HumanSaver {
    void saveHuman(Human human) throws IOException;
}
