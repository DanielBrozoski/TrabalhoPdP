import greenfoot.*; 

public class Personagem extends Actor implements Mob, Cloneable
{
   private GreenfootImage frente;
   private GreenfootImage frente1;
   private GreenfootImage frente2;
   
   private GreenfootImage esquerda;
   private GreenfootImage esquerda1;
   private GreenfootImage esquerda2;
   
   private GreenfootImage direita;
   private GreenfootImage direita1;
   private GreenfootImage direita2;
   
   private GreenfootImage baixo;
   private GreenfootImage baixo1;
   private GreenfootImage baixo2;
   
   
   private String nome;
   
   int id;
   
   private int x,y;
   private int velocidade = 3;
   private int tempoAni;
   
   private static Personagem p1 = null;

   
   public Personagem(String[] imagens){
       this.frente = new GreenfootImage(imagens[0]);
       this.frente1 = new GreenfootImage(imagens[1]);
       this.frente2 = new GreenfootImage(imagens[2]);
       
       this.esquerda = new GreenfootImage(imagens[3]);
       this.esquerda1 = new GreenfootImage(imagens[4]);
       this.esquerda2 = new GreenfootImage(imagens[5]);
       
       this.direita = new GreenfootImage(imagens[6]);
       this.direita1 = new GreenfootImage(imagens[7]);
       this.direita2 = new GreenfootImage(imagens[8]);
       
       this.baixo = new GreenfootImage(imagens[9]);
       this.baixo1 = new GreenfootImage(imagens[10]);
       this.baixo2 = new GreenfootImage(imagens[11]);
       
       setImage(frente);   
       tempoAni = 0;
   } 
   
    public void act() 
    {
        tempoAni++;
        if(tempoAni == 18) tempoAni = 0;
        movimentacao();
    }    
    
    public int getx(){
        return this.x;
    }
    
    public int gety(){
        return this.y;
    }
    public void movimentacao(){
         if(Greenfoot.isKeyDown("up")){
            this.animacao(1);
            y -= velocidade;
           
        }
        if(Greenfoot.isKeyDown("down")){
            this.animacao(2);               
            y += velocidade; 
            
        }
        if(Greenfoot.isKeyDown("left")){
            this.animacao(3);
            x -= velocidade;
        }
        if(Greenfoot.isKeyDown("right")){
           this.animacao(4);
           x += velocidade;
        }
        
        setLocation(x,y);
    }
    public void ataque(){
    
    }
    
    public void animacao(int animacao){
        switch(animacao){
            case 1:
                if(tempoAni == 0)
                    setImage(baixo);
                if(tempoAni == 9)
                    setImage(baixo1);
                if(tempoAni == 18)
                    setImage(baixo2);
            break;
            
            case 2:
                if(tempoAni == 0)
                    setImage(frente);
                if(tempoAni == 9)
                    setImage(frente1);
                if(tempoAni == 18)
                    setImage(frente2);
            break;
            
            case 3:
                if(tempoAni == 0)
                    setImage(esquerda);
                if(tempoAni == 9)
                    setImage(esquerda1);
                if(tempoAni == 18)
                    setImage(esquerda2);
            break;
            
            case 4:
                if(tempoAni == 0)
                    setImage(direita);
                if(tempoAni == 9)
                    setImage(direita1);
                if(tempoAni == 18)
                    setImage(direita2);
            break;
        
        }
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public static Personagem getInstance(String choice){
        if(p1 == null){
            AbstractFactory playerFactory = FactoryProducer.getFactory("PLAYABLEFACTORY");
            p1 = playerFactory.getPlayable(choice);
        }else if(choice.equals("current"))
            return p1;

        return p1;      
    }
    
    public Object clone() {
      Object clone = null;
      
      try {
         clone = super.clone();
         
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }
}
