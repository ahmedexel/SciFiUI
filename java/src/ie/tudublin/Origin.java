package ie.tudublin;

public class Origin
{
    UI ui;
    float x, y, width, height;
    String build;

    int counter;

    float offset = 240;
    float size = 400;

    public Origin(UI ui, float x, float y, float width, float height)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        build = Float.toString(x + y);
    }

    public void render()
    {
        ui.fill(0);
        ui.stroke(255);
        ui.rect(x, y, width, height, 30);
        drawShip();
        displayDetails();
    }

    public void update()
    {

    }

    public void drawShip()
    {
        ui.noFill();
        for(int i = 0; i < 3; i++)
        {
            // Body
            ui.fill(20);
            ui.ellipse(x + offset, y + offset, size, size);

            // 2 Guns
            ui.rect(x + 150, y + 40, 40, 120);
            ui.rect(x + 160, y + 35, 20, 5);    // Left gun
            ui.rect(x + 270, y + 40, 40, 120);
            ui.rect(x + 280, y + 35, 20, 5);    // Right gun
            // Inner Body
            ui.ellipse(x + offset, y + offset, size - 30, size - 30);
            ui.strokeWeight(3);
            ui.line(x + 64, y + offset, x + 415, y + offset);
            ui.strokeWeight(2);

            // Window
            ui.fill(204,255,255);
            ui.ellipse(x + offset, y + offset - 1, 240, 120);
        }
    }

    public void displayDetails()
    {
        int gap = 50;
        String s = "This machine was built to immediatley elimanate unknown species from our galaxy such as foreign creatures in an instant.";
        
        ui.textSize(16);
        ui.text("Model: XLR8", x + offset * 2, y + gap);
        ui.text("Created: August 2022", x + offset * 2 + 30, y + gap * 2);

        ui.text(s, x + offset + 220, y + 130, 150, 440);
    }
}