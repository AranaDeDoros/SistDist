/*    */ package analizadorlexico;
/*    */ 
/*    */ import javax.swing.JOptionPane;
/*    */ import javax.swing.UIManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AnalizadorLexico
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 23 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
/*    */     } catch (Exception ex) {
/* 25 */       JOptionPane o = new JOptionPane(Integer.valueOf(0));
/* 26 */       o.setVisible(true);
/*    */     }
/* 28 */     PaneL panel = new PaneL();
/* 29 */     OyenteL oyente = new OyenteL(panel);
/* 30 */     Frame f = new Frame("Analizador Léxico de Ruby", panel);
/* 31 */     panel.addEventos(oyente);
/* 32 */     f.setLocation(300, 140);
/* 33 */     f.setSize(1000, 500);
/* 34 */     f.setDefaultCloseOperation(3);
/* 35 */     f.setResizable(false);
/* 36 */     f.setContentPane(panel);
/* 37 */     f.setVisible(true);
/*    */   }
/*    */ }


/* Location:              C:\Users\HP\Documents\Chingaderas\Analizadores\Lexer\AnalizadorLexico.jar!\analizadorlexico\AnalizadorLexico.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */