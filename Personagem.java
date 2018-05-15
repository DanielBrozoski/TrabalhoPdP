import greenfoot.*; 

public class Personagem extends Actor implements Mob, Cloneable{
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

    private int xp, exp, level, life;
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

        this.x = 50;
        this.y = 236;

        this.level = 1;
        this.xp = 0;
        this.exp = 0;
        this.life = 500;

       
        setImage(direita);   
        tempoAni = 0;
    } 

    public void act() 
    {
        tempoAni++;
        
        if(tempoAni == 18) 
            tempoAni = 0;
        
        movimentacao();

        World mundo = getWorld();       
       
        checaColisao();
    }    

    public int getx(){
        return this.x;
    }

    public int gety(){
        return this.y;
    }

    public void movimentacao(){

        if(Greenfoot.isKeyDown("up" ) && y > 22){
            this.animacao(1);
            y -= velocidade;          
        }
        if(Greenfoot.isKeyDown("down") && y < 404){
            this.animacao(2);               
            y += velocidade; 

        }
        if(Greenfoot.isKeyDown("left") && x < 575){
            this.animacao(3);
            x -= velocidade;
        }
        if(Greenfoot.isKeyDown("right") && x > 25){
            this.animacao(4);
            x += velocidade;
        }
        setLocation(x,y);

    }

    public void checaColisao(){
        if(this.isTouching(Troll.class)){
            removeTouching(Troll.class);
            exp += 225;
            level(exp);
        }
        
        if(this.isTouching(Rat.class)){
            removeTouching(Rat.class);
            exp += 250;
            level(exp);
        }
    }

    public void level(int exp){
        if( exp >= 250 && exp < 700){            
            level = 2;            
        }
        else if (exp >= 700 && exp < 1500)
            level = 3;
        else if (exp >= 1500 && exp < 5000)
            level = 4;
        else if (exp >= 5000 && exp < 8250)
            level =5;
        else if(exp >= 8250 && exp < 12050)
            level =6;
        else if(exp >= 12050 && exp < 25000)
            level =7;
        else if(exp >= 25000)
            level = 8;
       
    }

    // public void life(int dano){
        // Actor player;
        // player = getOneObjectAtOffset (0, 0, Player.class);

        // life -= dano;
        // if (life <=0){
            // World mundo;
            // mundo = getWorld();
            // mundo.removeObject(p1);
            // mundo.addObject(new YouAreDead(),
                // mundo.getWidth()/2, mundo.getHeight()/2);
        // }
    // }

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

    public void ataque(){}

    public static Personagem getInstance(String choice){
        if(p1 == null){
            AbstractFactory playerFactory = FactoryProducer.getFactory("PLAYABLEFACTORY");
            p1 = playerFactory.getPlayable(choice);
        }else if(choice.equals("current"))
            return p1;

        return p1;      
    }

    public Object clone() {
        Personagem clone = null;

        try {
            clone = (Personagem)super.clone();

            if(clone.getWorld() != null){
                clone.getWorld().removeObject(clone);
                getWorld().addObject(clone, getX(), getY());
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

    public int getLevel(){
        return level;
    }
    
    public int getExp(){
        return exp;
    }
}
