package ie.tudublin;

public class core
{
    UI ui;

    public core(UI ui)
    {
        this.ui = ui;
    }

    public void render()
    {
        // Text
        ui.textSize(40);
        ui.fill(255,255,0);
        ui.text("The Ultimate CatastrophicMobile", 600, 60);

        // Left Panel
        ui.stroke(255);
        ui.strokeWeight(2);

        
        ui.line(480, 700, 440, 740);
        ui.line(40, 740, 440, 740);
        ui.line(40, 740, 0, 780);
    }

    public void update()
    {
        
    }
}