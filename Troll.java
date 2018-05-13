import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Troll extends Personagem{
     static String imagens[] = { "b_front0.png", "b_front1.png", "b_front2.png",
                         "b_left0.png" , "b_left1.png" , "b_left2.png",
                         "b_right0.png", "b_right1.png", "b_right2.png",
                         "b_back0.png" , "b_back1.png" , "b_back2.png"};
                         
   public Troll(){
       super(imagens, "troll");
    }   
    
    @Override
    public void movimentacao(){
        move(1);
        if (Greenfoot.getRandomNumber(100)< 10)
        {
           turn(Greenfoot.getRandomNumber(90)-45);
        }
        
        if (getX() <= 5 || getX() >= 
        getWorld().getWidth()-5)
        {
           turn(180);
        }
        
        if (getY() <= 5 || getY() >= 
        getWorld().getHeight()-5)
        {
           turn(180);
        }
    }
}
