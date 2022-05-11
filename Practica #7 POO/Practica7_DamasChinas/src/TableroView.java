import java.awt.Color;
import java.util.ArrayList;

public class TableroView {
    public static final Canvas CANVAS=new Canvas("CHECKERS", 800,800,new Color(229,202,162));
    private Square base;
    
    public TableroView(){
        base=new Square(500,150,150,"ch3",CANVAS);
        CANVAS.setVisible(true);
    }
    
    public void dibujarFichas(Jugador jugador){
        ArrayList<Ficha> fichas=jugador.getFichas();
        
        for(Ficha ficha:fichas){
            ficha.makeVisible();
        }
    }
    
    public void dibujarTablero(){
        base.makeVisible();
        
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                TableroControl.getCasillas()[i][j].makeVisible();
    }
}
