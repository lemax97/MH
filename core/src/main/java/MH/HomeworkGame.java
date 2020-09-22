package MH;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class HomeworkGame extends BaseGame {

    @Override
    public void create() {
        super.create();
        setActiveScreen( new MenuScreen());
    }
}