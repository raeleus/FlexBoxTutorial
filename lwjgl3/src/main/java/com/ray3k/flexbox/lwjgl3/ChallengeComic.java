package com.ray3k.flexbox.lwjgl3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import dev.lyze.flexbox.FlexBox;
import io.github.orioncraftmc.meditate.enums.YogaAlign;
import io.github.orioncraftmc.meditate.enums.YogaEdge;
import io.github.orioncraftmc.meditate.enums.YogaFlexDirection;
import io.github.orioncraftmc.meditate.enums.YogaJustify;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ChallengeComic extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;
    
    public static void main(String[] args) {
        createApplication();
    }
    
    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new ChallengeComic(), getDefaultConfiguration());
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
        FlexBox flexBox = new FlexBox();
        flexBox.setFillParent(true);
        flexBox.getRoot()
                .setFlexDirection(YogaFlexDirection.COLUMN)
                .setPaddingPercent(YogaEdge.HORIZONTAL, 20)
                .setJustifyContent(YogaJustify.SPACE_AROUND)
                .setAlignItems(YogaAlign.FLEX_END);
        stage.addActor(flexBox);
    
        //Panel1 Image
        Image image = new Image(skin.getDrawable("panel1"));
        image.setScaling(Scaling.fit);
        flexBox.add(image)
                .setHeightPercent(30)
                .setAspectRatio(2.5f);
    
        //Panel2 Image
        image = new Image(skin.getDrawable("panel2"));
        image.setScaling(Scaling.fit);
        flexBox.add(image)
                .setAlignSelf(YogaAlign.FLEX_START)
                .setHeightPercent(30)
                .setAspectRatio(2.5f);
    
        //Panel3 Image
        image = new Image(skin.getDrawable("panel3"));
        image.setScaling(Scaling.fit);
        flexBox.add(image)
                .setHeightPercent(30)
                .setAspectRatio(2.5f);
    }
    
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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