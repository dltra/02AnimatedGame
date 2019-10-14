package traf1.tradan.animatedgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    Paint paint=new Paint();
    Sprite sprite = new Sprite();
    Sprite foodSprite;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //note, at this point, getWidth() and getHeight() will have access the the dimensions
        foodSprite = generateSprite();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.GRAY);//set paint to gray
        canvas.drawRect(getLeft(),0,getRight(),getBottom(),paint);//paint background gray
        paint.setColor(Color.RED);//set paint to red
        //sprite updates itself
        sprite.update(canvas);
        foodSprite.update(canvas);
        if(RectF.intersects(sprite, foodSprite)){
            foodSprite=generateSprite();
            sprite.grow(10);
        }
        //sprite draws itself
        sprite.draw(canvas);
        foodSprite.draw(canvas);
        invalidate();  //redraws screen, invokes onDraw()
    }
    private Sprite generateSprite(){
        float x = (float)(Math.random()*getWidth()-.1*getWidth());
        float y = (float)(Math.random()*getHeight()-.1*getHeight());
        int dX = (int)(Math.random()*11-5);
        int dY = (int)(Math.random()*11-5);
        return new Sprite(x,y,x+.1f*getWidth(),y+.1f*getWidth(),dX,dY,Color.MAGENTA);
    }
}
