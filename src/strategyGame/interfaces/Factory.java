package strategyGame.interfaces;

import strategyGame.mvp.Player;

public interface Factory {

    void createMobileUnit(Player player, int positionX, int positionY);
}
