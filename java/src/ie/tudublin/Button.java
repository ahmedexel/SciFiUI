package ie.tudublin;

import processing.core.PApplet;

public class Button
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;

    private int colour;

    public Button(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render()
    {
        ui.fill(colour);
        ui.stroke(255);
        ui.strokeWeight(2);
        ui.rect(x, y, width, height);

        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.fill(51,255,51);
        ui.textSize(48);
        ui.text(text, x + 190, y + 50);
        ui.textSize(20);
    }

    public void update()
    {
        if (hovering(x, y, width, height))
        {
            colour = 70;
        }
        else
        {
            colour = 0;
        }
    }

    boolean hovering(float x, float y, float width, float height)
    {
        if (ui.mouseX >= x && ui.mouseX <= x+width && ui.mouseY >= y && ui.mouseY <= y+height)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}