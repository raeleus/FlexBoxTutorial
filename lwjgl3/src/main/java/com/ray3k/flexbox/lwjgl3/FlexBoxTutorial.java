package com.ray3k.flexbox.lwjgl3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import dev.lyze.flexbox.FlexBox;
import io.github.orioncraftmc.meditate.enums.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class FlexBoxTutorial extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;
    private FlexBox flexBox;
    
    public static void main(String[] args) {
        createApplication();
    }
    
    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new FlexBoxTutorial(), getDefaultConfiguration());
    }
    
    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("FlexBox Tutorial");
        configuration.useVsync(true);
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate);
        return configuration;
    }
    
    @Override
    public void create() {
        skin = new Skin(Gdx.files.internal("skin.json"));
        stage = new Stage(new ScreenViewport());
        stage.setDebugAll(true);
    
        flexBox = new FlexBox();
        flexBox.setFillParent(true);
        flexBox.getRoot()
                .setFlexDirection(YogaFlexDirection.ROW)
                .setWrap(YogaWrap.WRAP)
                .setPadding(YogaEdge.ALL, 20)
                /*.setBackground(skin.getDrawable("some-drawable"))*/;
        stage.addActor(flexBox);
    
        Label label = new Label("Item 1", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
                /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 2", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setWidth(100)
                .setHeight(100)
                /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 3", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 4", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 5", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 6", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 7", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 8", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 9", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 10", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 11", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    
        label = new Label("Item 12", skin);
        label.setAlignment(Align.center);
        flexBox.add(label)
                .setSize(100)
        /*.setBackground(skin.getDrawable("some-other-drawable"))*/;
    }
    
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }
    
    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);
        stage.act();
        stage.draw();
    }
    
    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}