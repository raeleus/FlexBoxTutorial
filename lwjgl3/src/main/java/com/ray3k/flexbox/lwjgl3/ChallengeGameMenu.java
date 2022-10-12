package com.ray3k.flexbox.lwjgl3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import dev.lyze.flexbox.FlexBox;
import io.github.orioncraftmc.meditate.YogaNode;
import io.github.orioncraftmc.meditate.enums.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ChallengeGameMenu extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;
    private FlexBox flexBox;
    private Image logo;
    
    public static void main(String[] args) {
        createApplication();
    }
    
    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new ChallengeGameMenu(), getDefaultConfiguration());
    }
    
    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("Challenge Comic");
        configuration.useVsync(true);
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate);
        configuration.setMaximized(true);
        return configuration;
    }
    
    @Override
    public void create() {
        skin = new Skin(Gdx.files.internal("skin.json"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
    
        //FlexBox
        flexBox = new FlexBox();
        flexBox.setFillParent(true);
        flexBox.getRoot()
                .setFlexDirection(YogaFlexDirection.COLUMN)
                .setBackground(skin.getDrawable("capitalist-bg-tile"));
        stage.addActor(flexBox);
        
        //Top Row
        YogaNode node = flexBox.add()
                .setFlexDirection(YogaFlexDirection.ROW)
                .setPadding(YogaEdge.TOP, 10);
    
        //Title Image
        Image image = new Image(skin.getDrawable("capitalist-title"));
        image.setScaling(Scaling.fit);
        flexBox.addAsChild(node, image)
                .setFlexGrow(1)
                .setMargin(YogaEdge.HORIZONTAL, 10)
                .setMinHeight(123);
    
        //New Game Button
        TextButton textButton = new TextButton("New Game", skin, "capitalist");
        flexBox.addAsChild(node, textButton)
                .setMargin(YogaEdge.RIGHT, 10)
                .setHeight(0)
                .setAlignSelf(YogaAlign.CENTER);
    
        //Options Button
        textButton = new TextButton("Options", skin, "capitalist");
        flexBox.addAsChild(node, textButton)
                .setMargin(YogaEdge.RIGHT, 10)
                .setHeight(0)
                .setAlignSelf(YogaAlign.CENTER);
    
        //Quit Button
        textButton = new TextButton("Quit", skin, "capitalist");
        flexBox.addAsChild(node, textButton)
                .setMargin(YogaEdge.RIGHT, 10)
                .setHeight(0)
                .setAlignSelf(YogaAlign.CENTER);
    
        //Logo Image
        logo = new Image(skin.getDrawable("capitalist-logo"));
        logo.setScaling(Scaling.fit);
        flexBox.add(logo)
                .setFlexGrow(1)
                .setPadding(YogaEdge.ALL, 20);
        
        //Copyright Label
        Label label = new Label("Copyright New World Order Illuminati 2022", skin, "capitalist-copyright");
        label.setAlignment(Align.center);
        flexBox.add(label).setPadding(YogaEdge.ALL, 10);
        
        //Set the origin and rotation of the logo (for funsies)
        flexBox.pack();
        logo.setOrigin(Align.center);
        logo.addAction(Actions.forever(Actions.rotateBy(-30, 1f)));
    }
    
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        
        //The rotation origin must be recalculated every time the window is resized
        flexBox.pack();
        logo.setOrigin(Align.center);
    }
    
    @Override
    public void render() {
        ScreenUtils.clear(Color.WHITE);
        stage.act();
        stage.draw();
    }
    
    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}