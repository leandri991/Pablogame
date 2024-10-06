package com.dinadisotteo.haxballsuper.elementos;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Pelota {
	private Texture texture;
    private Sprite sprite;
    private Body body;
    
    public Pelota(World world, float x, float y, float radius) {
        texture = new Texture("pelota1.png");
        sprite = new Sprite(texture);
        sprite.setSize(radius * 5, radius * 5);
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x, y);
        body = world.createBody(bodyDef);
        CircleShape shape = new CircleShape();
        shape.setRadius(radius);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0.1f;
        fixtureDef.friction = 0.25f;
        fixtureDef.restitution = 0.75f;
        body.createFixture(fixtureDef);
        shape.dispose();
    }

    public void update() {
    }

    public void render(SpriteBatch batch) {
    	sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
        sprite.draw(batch);
    }

    public void dispose() {
    }
}
