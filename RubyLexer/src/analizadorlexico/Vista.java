/*     */ package analizadorlexico;
/*     */ 
/*     */ import java.awt.Container;
/*     */ import java.awt.Cursor;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class Vista extends JDialog
/*     */ {
/*     */   PaneL panel;
/*     */   OyenteL o;
/*     */   private JTextArea areaF;
/*     */   private JScrollPane jScrollPane1;
/*     */   
/*     */   public Vista()
/*     */   {
/*  22 */     initComponents();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  36 */     this.jScrollPane1 = new JScrollPane();
/*  37 */     this.areaF = new JTextArea();
/*     */     
/*  39 */     setDefaultCloseOperation(2);
/*  40 */     setTitle("Gramática");
/*  41 */     setCursor(new Cursor(0));
/*  42 */     setIconImages(null);
/*  43 */     setLocation(new java.awt.Point(300, 100));
/*  44 */     setResizable(false);
/*  45 */     setSize(new java.awt.Dimension(1000, 115));
/*  46 */     setType(java.awt.Window.Type.POPUP);
/*     */     
/*  48 */     this.areaF.setEditable(false);
/*  49 */     this.areaF.setColumns(20);
/*  50 */     this.areaF.setRows(5);
/*  51 */     this.areaF.setText("Identificador de Clase: [A-Z][a-z_]+[A-Z][a-z_]+\nPalabra Reservada: \"(__ENCODING__|__LINE__|__FILE__|BEGIN|END)\"\nPalabra Reservada: \"(alias|and|begin|break|catch|case|class|defined|def|do|dir|else|elsif|end|ensure|false|for|if|initialize|in|load|module|next|new|nil|not|or|raise|require|redo|rescue|retry|return|self|super|then|true|throw|undef|unless|until|when|while|yield)\"\nConstante Predefinida: \"(TRUE|FALSE|NIL|ARGF|ARGV|DATA|ENV|RUBY_PLATFORM|RUBY_RELEASE_DATE|RUBY_VERSION|STDERR|STDIN|STDOUT|TOPLEVEL_BINDING|puts)\"\nVariable Predefinida: \"(\\\\$!|\\\\$@|\\\\$\\\\/|\\\\$\\\\\\\\|\\\\$,|\\\\$;|\\\\$\\\\.|\\\\$<|\\\\$>|\\\\$0|\\\\$\\\\$|\\\\$\\\\?|\\\\$:|\\\\$DEBUG|\\\\$defout|\\\\$FILENAME|\\\\$F|\\\\$LOAD_PATH|\\\\$SAFE|\\\\$stdin|\\\\$stdout|\\\\$stderr|\\\\$VERBOSE|\\\\$-x|\\\\$-0|\\\\$-a|\\\\$-d|\\\\$-F|\\\\$-i|\\\\$-I|\\\\$-l|\\\\$-p|\\\\$_|\\\\$~|\\\\$n|\\\\$&|\\\\$'|\\\\$\\\\+|\\\\$`|\\\\$\\\\d|`)|\"\nOperador Aritmético: \"(\\\\*\\\\*|\\\\+|-|\\\\*|\\\\/)\"\nOperador Relacional: \"(<=>|===|>=|<=|==|!=|\\\\.eql\\\\?|equal\\\\?|>|<)\"\nOperador de Rango: \"(\\\\.\\\\.\\\\.|\\\\.\\\\.)\"\nComentario: \"(#|=begin\\\\b|=end\\\\b)\"\nVisibilidad: \"(public|protected|private)\"\nVariable Global: \"(\\\\$[a-zA-Z_]*)\"\nVariable de Clase: \"(@@[a-zA-Z_]*)\"\nVariable Instanciada: \"(@[a-zA-Z_]*)\"\nVariable Local: \"(_[a-z][a-zA-Z_]*)\"\nVariable Local: \"([a-z][a-zA-Z_]*)\"\nNúmero: \"([0-9]+)\"\nCorchetes: \"(\\\\[|\\\\])\"\nLlaves: \"(\\\\{|\\\\})\"\nOperador Lógico: \"(and|or|&&|\\\\|\\\\||!|not)\"\nOperador de Bits: \"(<<|>>|&|\\\\||\\\\^|~)\"\nParéntesis: \"(\\\\(|\\\\))\"\nEspacio en blanco: \"(\\\\s)+\"\nOperador de asignación: \"(=)\"\nComa \"(,)\"\nComilla \"(\")\"\nConstante: [A-Z]+[0-9]*\nSimbolo: \\\\:\nError: \"(\\\\D|\\\\S|Ç|ç)\"");
/*  52 */     this.areaF.setCursor(new Cursor(2));
/*  53 */     this.areaF.setName("areaF");
/*  54 */     this.jScrollPane1.setViewportView(this.areaF);
/*     */     
/*  56 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  57 */     getContentPane().setLayout(layout);
/*  58 */     layout.setHorizontalGroup(layout
/*  59 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  60 */       .addGroup(layout.createSequentialGroup()
/*  61 */       .addContainerGap()
/*  62 */       .addComponent(this.jScrollPane1, -1, 700, 32767)
/*  63 */       .addContainerGap()));
/*     */     
/*  65 */     layout.setVerticalGroup(layout
/*  66 */       .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  67 */       .addGroup(layout.createSequentialGroup()
/*  68 */       .addContainerGap()
/*  69 */       .addComponent(this.jScrollPane1, -1, 501, 32767)
/*  70 */       .addContainerGap()));
/*     */     
/*     */ 
/*  73 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public JTextArea getAreaF()
/*     */   {
/* 121 */     return this.areaF;
/*     */   }
/*     */ }


/* Location:              C:\Users\HP\Documents\Chingaderas\Analizadores\Lexer\AnalizadorLexico.jar!\analizadorlexico\Vista.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */