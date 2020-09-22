package MH;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class StoryScreen extends BaseScreen {

    Scene scene;
    Background background;
    Kelsoe kelsoe;
    DialogBox dialogBox;
    BaseActor continueKey;
    Table buttonTable;
    BaseActor theEnd;

    @Override
    public void initialize() {

        background = new Background(0,0, mainStage);
        background.setOpacity(0);
        BaseActor.setWorldBounds(background);

        kelsoe = new Kelsoe(0,0, mainStage);

        dialogBox = new DialogBox(0, 0, uiStage);
        dialogBox.setDialogSize(600, 150);
        dialogBox.setBackgroundColor( new Color(0.2f, 0.2f, 0.2f, 1));
        dialogBox.setVisible(false);

        continueKey = new BaseActor(0,0, uiStage);
        continueKey.loadTexture("assets/key-C.png");
        continueKey.setSize(32,32);
        continueKey.setVisible(false);

        dialogBox.addActor( continueKey );
        continueKey.setPosition( dialogBox.getWidth() - continueKey.getWidth(), 0);
        buttonTable = new Table();
        buttonTable.setVisible(false);

        uiTable.add().expandY();
        uiTable.row();
        uiTable.add(buttonTable);
        uiTable.row();
        uiTable.add(dialogBox);

        theEnd = new BaseActor(0,0, mainStage);
        theEnd.loadTexture("assets/the-end.png");
        theEnd.centerAtActor(background);
        theEnd.setScale(2);
        theEnd.setOpacity(0);

        scene = new Scene();
        mainStage.addActor(scene);
        hallway();
    }

    public void hallway() {

        background.setAnimation( background.hallway );
        dialogBox.setText("");
        kelsoe.addAction( SceneActions.moveToOutsideLeft(0) );

        scene.addSegment( new SceneSegment( background, Actions.fadeIn(1) ));
    }

    public void classroom() {

    }

    public void scienceLab() {

    }

    public void library() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public boolean keyDown(int keycode) {

        if ( keycode == Keys.C )
            scene.loadNextSegment();

        return false;
    }

    public void addTextSequence(String s){

        scene.addSegment( new SceneSegment( dialogBox, SceneActions.typewriter(s) ));
        scene.addSegment( new SceneSegment( continueKey, Actions.show() ));
        scene.addSegment( new SceneSegment( background, SceneActions.pause() ));
        scene.addSegment( new SceneSegment( continueKey, Actions.hide() ));
    }
}
