import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //Spawner spawner;

    public MyWorld()
    {    
        super(600, 400, 1); 
        init();
    }
    
    private void init(){
        AbstractFactory playerFactory = FactoryProducer.getFactory("PLAYABLEFACTORY");
        AbstractFactory mobFactory = FactoryProducer.getFactory("MOBFACTORY");
        int quant = 35;
        MobCache.loadCache("troll", quant);
        spawnerTroll(quant);
                           
        Actor p = Personagem.getInstance("knight");
        addObject(p, 345,444);  
         
        
    }
    
    public void spawnerTroll(int quant){ 
            for(int i = 0; i < quant;i++){
                Personagem lol = (Troll) MobCache.getMob(i);
            addObject(lol, 222,222);
            }
            
    
    }
}
