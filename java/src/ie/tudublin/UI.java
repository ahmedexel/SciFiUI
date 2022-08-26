package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;


public class UI extends PApplet {
    public int selection;
    public boolean loaded;

 
    Button weaponsButton;
    Button detailsButton;

    core base;
    PImage backgroundImage;

    scanner weaponsAmmo;
    UltraRadar weaponsRadar;


    Origin sysInfo;

    boolean[] keys = new boolean[1024];

    public void keyPressed() {
        keys[keyCode] = true;
    }

    public void keyReleased() {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c) {
        return keys[c] || keys[Character.toUpperCase(c)];
    }

    public void settings() {
        size(1200, 800);
    }

    public void setup() {
        backgroundImage = loadImage("background.jpg");


        // Initialising objects
        base = new core(this);

        weaponsButton = new Button(this, -5, 310, 485, 130, "Weapon");
        weaponsAmmo = new Ammo(this, 1050, 220, 45, 9000);
        weaponsRadar = new UltraRadar(this, 1, 675, 250, 120, "Ultra Radar");

        detailsButton = new Button(this, -5, 570, 485, 130, "System Origin");
        sysInfo = new Origin(this, 530, 140, 630, 600);
    }

    public void draw() // Called 60 times a second
    {
        // Set up elements
        background(backgroundImage);
        base.render();
        
        
        // Weapons Information
        weaponsButton.render();
        weaponsButton.update();
        if(selection == 1)
        {
            weaponsAmmo.render();
            weaponsAmmo.update();

            weaponsRadar.render();
            weaponsRadar.update();

        }
        
       

        // System Information
        detailsButton.update();
        detailsButton.render();
        if(selection == 2)
        {
            sysInfo.render();
            sysInfo.update();
        }
    }

    public void mouseClicked()
    {

        if(weaponsButton.hovering(-5, 310, 485, 130) == true)
        {
            if (selection == 1)
            {
                selection = 0;
            }
            else
            {
                selection = 1;
            }
        }
        
        if(detailsButton.hovering(-5, 570, 485, 130) == true)
        {
            if (selection == 2)
            {
                selection = 0;
            }
            else
            {
                selection = 2;
            }
        }
    }
}

