import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rat extends Personagem{
    
    int x, y;
    static String imagens[] = { "a_front0.png", "a_front1.png", "a_front2.png",
                         "a_left0.png" , "a_left1.png" , "a_left2.png",
                         "a_right0.png", "a_right1.png", "a_right2.png",
                         "a_back0.png" , "a_back1.png" , "a_back2.png"};
       
                         
   boolean init = false;
    public Rat(){
        super(imagens);
    }   
    
    @Override
    public void movimentacao(){
       Personagem p = Personagem.getInstance("current");
        if(p.gety() <= this.y){
             this.animacao(1);
            y -= 2;
           
        }
        if(p.gety() >= this.y){
            this.animacao(2);               
            y += 2; 
            
        }
        if(p.getx() <= this.x){
            this.animacao(3);
            x -= 2;
        }
        if(p.getx() >= this.x){
           this.animacao(4);
           x += 2;
        }
        
        setLocation(x,y);
       
    }
}
