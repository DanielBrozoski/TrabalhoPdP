import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Spawner trollSpawner;
    Spawner ratSpawner;
    Personagem p;
    public MyWorld()
    {    
        super(790, 560, 1); 
        init();
    }
    
    private void init(){
        setBackground(new GreenfootImage("mainWindow.png"));
        AbstractFactory playerFactory = FactoryProducer.getFactory("PLAYABLEFACTORY");
        AbstractFactory mobFactory = FactoryProducer.getFactory("MOBFACTORY");
        
        p = Personagem.getInstance("knight");
        addObject(p, p.getx(),p.gety());
               
        Personagem trollPrototype = mobFactory.getMob("troll");
        Personagem ratPrototype = mobFactory.getMob("rat");
        
        trollSpawner = new Spawner(trollPrototype);
        ratSpawner = new Spawner(ratPrototype);
        
        addObject(trollSpawner, 56, 56);
        addObject(ratSpawner, 400, 234);
        
        //addObject(trollSpawner.spawnMonster(), trollSpawner.getX(),trollSpawner.getY());
        //addObject(ratSpawner.spawnMonster(), ratSpawner.getX(),trollSpawner.getY());         
    }
    
    public void act(){
        HUD();
        welldone(p.getLevel());
        
    }
    
    
    public void welldone(int level){
        if(level == 1 && (getObjects(Troll.class).isEmpty()))
            for(int i = 0; i < level; i++)
                addObject(this.trollSpawner.spawnMonster(), trollSpawner.getX(), trollSpawner.getY());
           
         if(level == 2 && (getObjects(Troll.class).isEmpty())) 
            for(int i = 0; i < level; i++)
                addObject(this.trollSpawner.spawnMonster(), trollSpawner.getX(), trollSpawner.getY());
            
          if(level == 3 && (getObjects(Rat.class).isEmpty()))
            for(int i = 0; i < level; i++)
                addObject(this.ratSpawner.spawnMonster(), ratSpawner.getX(), ratSpawner.getY());    
       }
       
    public void HUD(){
       showText(""+p.getLevel(), 755, 402);
          
        if(p.getExp() < 1000)
            showText(""+p.getExp(), 755, 377);
        else
            showText(""+p.getExp(), 740, 377);
    }
   }

