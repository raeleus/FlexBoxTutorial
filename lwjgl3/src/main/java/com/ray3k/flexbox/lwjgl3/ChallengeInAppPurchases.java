package com.ray3k.flexbox.lwjgl3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import dev.lyze.flexbox.FlexBox;
import io.github.orioncraftmc.meditate.YogaNode;
import io.github.orioncraftmc.meditate.enums.YogaAlign;
import io.github.orioncraftmc.meditate.enums.YogaEdge;
import io.github.orioncraftmc.meditate.enums.YogaFlexDirection;
import io.github.orioncraftmc.meditate.enums.YogaJustify;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class ChallengeInAppPurchases extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;
    
    public static void main(String[] args) {
        createApplication();
    }
    
    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new ChallengeInAppPurchases(), getDefaultConfiguration());
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
                .setFlexDirection(YogaFlexDirection.ROW)
                .setPadding(YogaEdge.ALL, 20)
                .setJustifyContent(YogaJustify.CENTER)
                .setAlignItems(YogaAlign.CENTER);
        stage.addActor(flexBox);
    
        //Silver Package
        YogaNode node = flexBox.add()
                .setFlexDirection(YogaFlexDirection.COLUMN)
                .setMargin(YogaEdge.RIGHT, 10)
                .setBackground(skin.getDrawable("silver-background-tile"));
    
        Label label = new Label("Silver Package", skin, "package-title-silver");
        label.setAlignment(Align.center);
        flexBox.addAsChild(node, label)
                .setMargin(YogaEdge.BOTTOM, 10);
    
        Image image = new Image(skin.getDrawable("silver-medal"));
        image.setScaling(Scaling.fit);
        flexBox.addAsChild(node, image)
                .setMargin(YogaEdge.BOTTOM, 10)
                .setHeightPercent(30);
    
        label = new Label("For lame, poor people that can't afford a real package. Gives the bare minimum access " +
                "necessitated by the trite gameplay, but will soon prove to be worthless in the next update.", skin, "package-silver");
        label.setWrap(true);
        label.setAlignment(Align.center);
        flexBox.addAsChild(node, label)
                .setMargin(YogaEdge.BOTTOM, 10);
    
        Button button = new Button(skin, "package-silver");
        flexBox.addAsChild(node, button);
        
        //Diamond Package
        node = flexBox.add()
                .setFlexDirection(YogaFlexDirection.COLUMN)
                .setMargin(YogaEdge.RIGHT, 10)
                .setBackground(skin.getDrawable("diamond-background-tile"));
    
        label = new Label("Diamond Package", skin, "package-title-diamond");
        label.setAlignment(Align.center);
        flexBox.addAsChild(node, label)
                .setMargin(YogaEdge.BOTTOM, 10);
    
        image = new Image(skin.getDrawable("diamond-medal"));
        image.setScaling(Scaling.fit);
        flexBox.addAsChild(node, image)
                .setMargin(YogaEdge.BOTTOM, 10)
                .setHeightPercent(40);
    
        label = new Label("A whale is an elusive creature said to buy insane amounts of in-app purchases in " +
                "free-to-play games. This is your target demographic which basically comprises less than 1% of your " +
                "player base and 50% of your revenue. In other words, dumb ass kids with rich ass parents.", skin,
                "package-silver");
        label.setWrap(true);
        label.setAlignment(Align.center);
        flexBox.addAsChild(node, label)
                .setMargin(YogaEdge.BOTTOM, 10);
    
        button = new Button(skin, "package-diamond");
        flexBox.addAsChild(node, button);
    
        //Gold Package
        node = flexBox.add()
                .setFlexDirection(YogaFlexDirection.COLUMN)
                .setMargin(YogaEdge.RIGHT, 10)
                .setBackground(skin.getDrawable("gold-background-tile"));
    
        label = new Label("Gold Package", skin, "package-title-gold");
        label.setAlignment(Align.center);
        flexBox.addAsChild(node, label)
                .setMargin(YogaEdge.BOTTOM, 10);
    
        image = new Image(skin.getDrawable("gold-medal"));
        image.setScaling(Scaling.fit);
        flexBox.addAsChild(node, image)
                .setMargin(YogaEdge.BOTTOM, 10)
                .setHeightPercent(30);
    
        label = new Label("This is the real package we want people to purchase. By raising the price of diamond to " +
                "ridiculous levels, people won't realize that this is overpriced trash in relative comparison.", skin,
                "package-gold");
        label.setWrap(true);
        label.setAlignment(Align.center);
        flexBox.addAsChild(node, label)
                .setMargin(YogaEdge.BOTTOM, 10);
    
        button = new Button(skin, "package-gold");
        flexBox.addAsChild(node, button);
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