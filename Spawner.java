import greenfoot.*;
public class Spawner extends Actor{
    
    private Personagem prototipo;
    private GreenfootImage frame01;
    private GreenfootImage frame02;
    private GreenfootImage frame03;
    private int tempoAni;
    
    public Spawner(Personagem prototipo){
        this.prototipo = prototipo;
        frame01 = new GreenfootImage("a06.png");
        frame02 = new GreenfootImage("a07.png");
        frame03 = new GreenfootImage("a08.png");
        
        setImage(frame01);
    }
    
    public void act(){
        tempoAni++;
        
        if(tempoAni == 18) tempoAni = 0;
            animacao();
       

    }
           
    public Personagem spawnMonster(){
        return (Personagem)prototipo.clone();
    }
    
    public void animacao(){
        if(tempoAni == 0)
                    setImage(frame01);
                if(tempoAni == 9)
                    setImage(frame02);
                if(tempoAni == 18)
                    setImage(frame03);
        
    }
    
       
}
