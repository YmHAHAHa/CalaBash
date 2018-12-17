package Strategy;

import BattleField.Field;

public class ZhanfaManager {
    private Changshe cs;
    private Field field;

    public ZhanfaManager(Field f) {
        cs = new Changshe();
        field = f;
    }

    public void apply() {
        cs.applyHulu(field);
        cs.applyYaoguai(field);
    }
}
