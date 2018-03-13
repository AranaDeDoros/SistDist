/*     */ package analizadorlexico;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.GridLayout;
/*     */ import javax.accessibility.AccessibleContext;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class AcercaDe
/*     */   extends JDialog
/*     */ {
/*  17 */   ImageIcon itv = new ImageIcon("/IMG/itver.png");
/*  18 */   JProgressBar current = new JProgressBar();
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   
/*  22 */   public AcercaDe() { this.current.setValue(0);
/*  23 */     this.current.setStringPainted(true);
/*  24 */     setModal(true);
/*  25 */     setLocation(450, 200);
/*  26 */     initComponents();
/*     */   }
/*     */   
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel8;
/*     */   private JPanel panelCentro;
/*     */   private JPanel panelNorte;
/*     */   private JPanel panelSur;
/*     */   private void initComponents() {
/*  39 */     this.panelNorte = new JPanel();
/*  40 */     this.jLabel5 = new JLabel();
/*  41 */     this.jLabel8 = new JLabel();
/*  42 */     this.panelSur = new JPanel();
/*  43 */     this.panelCentro = new JPanel();
/*  44 */     this.jLabel4 = new JLabel();
/*  45 */     this.jLabel7 = new JLabel();
/*  46 */     this.jLabel6 = new JLabel();
/*  47 */     this.jLabel1 = new JLabel();
/*  48 */     this.jLabel2 = new JLabel();
/*  49 */     this.jLabel3 = new JLabel();
/*     */     
/*  51 */     setDefaultCloseOperation(2);
/*  52 */     setTitle("Acerca de...");
/*  53 */     setIconImage(null);
/*  54 */     setPreferredSize(new Dimension(500, 250));
/*  55 */     setResizable(false);
/*  56 */     setSize(getPreferredSize());
/*     */     
/*  58 */     this.jLabel5.setHorizontalAlignment(0);
/*  59 */     this.jLabel5.setIcon(new ImageIcon(getClass().getResource("/IMG/itver.png")));
/*  60 */     this.panelNorte.add(this.jLabel5);
/*     */     
/*  62 */     this.jLabel8.setIcon(new ImageIcon(getClass().getResource("/IMG/ruby_box.png")));
/*  63 */     this.panelNorte.add(this.jLabel8);
/*     */     
/*  65 */     getContentPane().add(this.panelNorte, "First");
/*     */     
/*     */ 
/*  68 */     getContentPane().add(this.panelSur, "Last");
/*     */     
/*  70 */     this.panelCentro.setLayout(new GridLayout(6, 1));
/*     */     
/*  72 */     this.jLabel4.setFont(new Font("Tahoma", 1, 14));
/*  73 */     this.jLabel4.setHorizontalAlignment(0);
/*  74 */     this.jLabel4.setText("INSTITUTO TECNOLÓGICO DE VERACRUZ");
/*  75 */     this.panelCentro.add(this.jLabel4);
/*     */     
/*  77 */     this.jLabel7.setFont(new Font("Tahoma", 2, 12));
/*  78 */     this.jLabel7.setHorizontalAlignment(0);
/*  79 */     this.jLabel7.setText("| Analizador Léxico de Ruby| Lenguajes y Autómatas |");
/*  80 */     this.panelCentro.add(this.jLabel7);
/*     */     
/*  82 */     this.jLabel6.setFont(new Font("Tahoma", 2, 12));
/*  83 */     this.jLabel6.setHorizontalAlignment(0);
/*  84 */     this.jLabel6.setText("Elaborado Por:");
/*  85 */     this.panelCentro.add(this.jLabel6);
/*     */     
/*  87 */     this.jLabel1.setFont(new Font("Tahoma", 0, 12));
/*  88 */     this.jLabel1.setHorizontalAlignment(0);
/*  89 */     this.jLabel1.setText("Ricardo David Rojas Flores");
/*  90 */     this.panelCentro.add(this.jLabel1);
/*     */     
/*  92 */     this.jLabel2.setFont(new Font("Tahoma", 0, 12));
/*  93 */     this.jLabel2.setHorizontalAlignment(0);
/*  94 */     this.jLabel2.setText("Josué Yépez Ponce");
/*  95 */     this.panelCentro.add(this.jLabel2);
/*     */     
/*  97 */     this.jLabel3.setFont(new Font("Tahoma", 0, 12));
/*  98 */     this.jLabel3.setHorizontalAlignment(0);
/*  99 */     this.jLabel3.setText("Demian Guiot Peña");
/* 100 */     this.panelCentro.add(this.jLabel3);
/*     */     
/* 102 */     getContentPane().add(this.panelCentro, "Center");
/*     */     
/* 104 */     getAccessibleContext().setAccessibleParent(null);
/*     */     
/* 106 */     pack();
/*     */   }
/*     */ }


/* Location:              C:\Users\HP\Documents\Chingaderas\Analizadores\Lexer\AnalizadorLexico.jar!\analizadorlexico\AcercaDe.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */