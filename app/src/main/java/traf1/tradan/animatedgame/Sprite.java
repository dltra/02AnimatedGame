package traf1.tradan.animatedgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

class Sprite extends RectF {
    private int dX, dY, color;
    public Sprite() {
        this(1,2, Color.RED);
    }
    public Sprite(int dX, int dY, int color) {
        this(1,1,11,11,dX,dY,color);
    }

    public Sprite(float left, float top, float right, float bottom) {
        this(left, top, right, bottom,1,2,Color.RED);
    }

    public Sprite(float left, float top, float right, float bottom, int dX, int dY, int color) {
        super(left, top, right, bottom);
        this.dX = dX;
        this.dY = dY;
        this.color = color;
    }
    public void update(Canvas canvas){
        if(left+dX<0||right+dX>canvas.getWidth())//if next step hits boundary
            dX*=-1; //bounce off left and right boundaries
        if(top+dY>canvas.getHeight())//if next step puts off bottom of screen
            offsetTo(left,-height());//teleport to top of screen
        if(bottom+dY<0)
            offsetTo(left,canvas.getHeight());
        offset(dX,dY);//moves dX to the right and dY downwards
    }
    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(color);//sets its color
        canvas.drawCircle(centerX(), centerY(), width() / 2, paint);//draws circle
    }

    public int getdX() {
        return dX;
    }

    public void setdX(int dX) {
        this.dX = dX;
    }

    public int getdY() {
        return dY;
    }

    public void setdY(int dY) {
        this.dY = dY;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void grow(int i) {
        right=right+i;
        bottom=bottom+i;
    }
}
