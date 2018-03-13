/*     */ package analizadorlexico;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.util.regex.Matcher;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class PaneL extends JPanel
/*     */ {
/*     */   private boolean reg;
/*     */   private boolean db;
/*     */   private JTextArea areaExpresion;
/*     */   private JButton botonAnalizar;
/*     */   private JTextField campoExpresion;
/*     */   private JLabel etiquetaExp;
/*     */   private JLabel etiquetaIng;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private JPanel panelNorte;
/*     */   private JPanel panelSur;
/*     */   
/*     */   public PaneL()
/*     */   {
/*  27 */     initComponents();
/*  28 */     this.botonAnalizar.setEnabled(false);
/*     */   }
/*     */   
/*     */   public void addEventos(OyenteL oyente) {
/*  32 */     this.campoExpresion.addActionListener(oyente);
/*     */   }
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
/*  44 */     this.panelSur = new JPanel();
/*  45 */     this.etiquetaExp = new JLabel();
/*  46 */     this.panelNorte = new JPanel();
/*  47 */     this.etiquetaIng = new JLabel();
/*  48 */     this.campoExpresion = new JTextField();
/*  49 */     this.botonAnalizar = new JButton();
/*  50 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*  51 */     this.areaExpresion = new JTextArea();
/*     */     
/*  53 */     setLayout(new java.awt.BorderLayout());
/*     */     
/*  55 */     this.etiquetaExp.setFont(new java.awt.Font("Tahoma", 1, 18));
/*  56 */     this.etiquetaExp.setHorizontalAlignment(0);
/*  57 */     this.etiquetaExp.setToolTipText("Expresión ingresada");
/*  58 */     this.panelSur.add(this.etiquetaExp);
/*     */     
/*  60 */     add(this.panelSur, "South");
/*     */     
/*  62 */     this.etiquetaIng.setText("Ingrese Expresión");
/*  63 */     this.panelNorte.add(this.etiquetaIng);
/*     */     
/*  65 */     this.campoExpresion.setColumns(50);
/*  66 */     this.campoExpresion.addFocusListener(new java.awt.event.FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/*  68 */         PaneL.this.campoExpresionFocusGained(evt);
/*     */       }
/*  70 */     });
/*  71 */     this.panelNorte.add(this.campoExpresion);
/*     */     
/*  73 */     this.botonAnalizar.setText("Analizar");
/*  74 */     this.botonAnalizar.setName("botonAnalizar");
/*  75 */     this.botonAnalizar.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  77 */         PaneL.this.botonAnalizarActionPerformed(evt);
/*     */       }
/*  79 */     });
/*  80 */     this.panelNorte.add(this.botonAnalizar);
/*     */     
/*  82 */     add(this.panelNorte, "First");
/*     */     
/*  84 */     this.jScrollPane2.setVerticalScrollBarPolicy(22);
/*     */     
/*  86 */     this.areaExpresion.setColumns(20);
/*  87 */     this.areaExpresion.setRows(5);
/*  88 */     this.areaExpresion.addFocusListener(new java.awt.event.FocusAdapter() {
/*     */       public void focusGained(FocusEvent evt) {
/*  90 */         PaneL.this.areaExpresionFocusGained(evt);
/*     */       }
/*  92 */     });
/*  93 */     this.jScrollPane2.setViewportView(this.areaExpresion);
/*     */     
/*  95 */     add(this.jScrollPane2, "Center");
/*     */   }
/*     */   
/*     */ 
/*     */   private void botonAnalizarActionPerformed(ActionEvent evt)
/*     */   {
/* 101 */     getCampoExpresion().setText("");
/* 102 */     String regex = "([A-Z][a-z_]+[A-Z][a-z_]+)|(\\.|__ENCODING__|__LINE__|__FILE__|BEGIN|END)|(alias|and|begin|break|catch|case|class|defined|def|do|dir|else|elsif|end|ensure|false|for|if|initialize|in|load|module|next|new|nil|not|or|raise|require|redo|rescue|retry|return|self|super|then|true|throw|undef|unless|until|when|while|yield)|(TRUE|FALSE|NIL|ARGF|ARGV|DATA|ENV|RUBY_PLATFORM|RUBY_RELEASE_DATE|RUBY_VERSION|STDERR|STDIN|STDOUT|TOPLEVEL_BINDING|puts)|(\\$!|\\$@|\\$\\/|\\$\\\\|\\$,|\\$;|\\$\\.|\\$<|\\$>|\\$0|\\$\\$|\\$\\?|\\$:|\\$DEBUG|\\$defout|\\$FILENAME|\\$F|\\$LOAD_PATH|\\$SAFE|\\$stdin|\\$stdout|\\$stderr|\\$VERBOSE|\\$-x|\\$-0|\\$-a|\\$-d|\\$-F|\\$-i|\\$-I|\\$-l|\\$-p|\\$_|\\$~|\\$n|\\$&|\\$'|\\$\\+|\\$`|\\$\\d|`)|(\\*\\*|\\+|-|\\*|\\/)|(<=>|===|>=|<=|==|!=|\\.eql\\?|equal\\?|>|<)|(\\.\\.\\.|\\.\\.)|(#|=begin\\b|=end\\b)|(public|protected|private)|(\\$[a-zA-Z_]*)|(@@[a-zA-Z_]*)|(@[a-zA-Z_]*)|(_[a-z][a-zA-Z_]*)|([a-z][a-zA-Z_]*)|([0-9]+)|(\\[|\\])|(\\{|\\})|(and|or|&&|\\|\\||!|not)|(<<|>>|&|\\||\\^|~)|(\\(|\\))|(\\s)+|(=)|(,)|(\")|([A-Z]+[0-9]*)|(\\:)|(\\D|\\S|Ç|ç)";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */     java.util.regex.Pattern pat = java.util.regex.Pattern.compile(regex);
/* 112 */     String entrada = getAreaExpresion().getText();
/* 113 */     Matcher matcher = pat.matcher(entrada);
/* 114 */     System.out.println(entrada);
/*     */     
/*     */ 
/* 117 */     if (getAreaExpresion().getText() != null) {
/* 118 */       this.reg = true;
/*     */     }
/* 120 */     if (this.reg) {
/* 121 */       getAreaExpresion().setText("");
/*     */     }
/*     */     
/*     */ 
/* 125 */     while (matcher.find()) {
/* 126 */       String token1 = matcher.group(2);
/* 127 */       if (token1 != null) {
/* 128 */         getCampoExpresion().setText("");
/* 129 */         getAreaExpresion().append("Palabra Reservada: " + token1 + "\n");
/*     */       }
/*     */       
/*     */ 
/* 133 */       String token2 = matcher.group(3);
/* 134 */       if (token2 != null) {
/* 135 */         getCampoExpresion().setText("");
/* 136 */         getAreaExpresion().append("Palabra Reservada: " + token2 + "\n");
/*     */       }
/*     */       
/* 139 */       String token3 = matcher.group(4);
/* 140 */       if (token3 != null) {
/* 141 */         getCampoExpresion().setText("");
/* 142 */         getAreaExpresion().append("Constantes predefinidas: " + token3 + "\n");
/*     */       }
/*     */       
/* 145 */       String token4 = matcher.group(5);
/* 146 */       if (token4 != null) {
/* 147 */         getCampoExpresion().setText("");
/* 148 */         getAreaExpresion().append("Variables predefinidas: " + token4 + "\n");
/*     */       }
/*     */       
/* 151 */       String token5 = matcher.group(6);
/* 152 */       if (token5 != null) {
/* 153 */         getCampoExpresion().setText("");
/* 154 */         getAreaExpresion().append("Operadores aritmeticos: " + token5 + "\n");
/*     */       }
/*     */       
/* 157 */       String token6 = matcher.group(7);
/* 158 */       if (token6 != null) {
/* 159 */         getCampoExpresion().setText("");
/* 160 */         getAreaExpresion().append("Operadores comparativos: " + token6 + "\n");
/*     */       }
/*     */       
/* 163 */       String token7 = matcher.group(8);
/* 164 */       if (token7 != null) {
/* 165 */         getCampoExpresion().setText("");
/* 166 */         getAreaExpresion().append("Operadores de rango:" + token7 + "\n");
/*     */       }
/*     */       
/* 169 */       String token8 = matcher.group(9);
/* 170 */       if (token8 != null) {
/* 171 */         getCampoExpresion().setText("");
/* 172 */         getAreaExpresion().append("Comentario: " + token8 + "\n");
/*     */       }
/*     */       
/* 175 */       String token9 = matcher.group(10);
/* 176 */       if (token9 != null) {
/* 177 */         getCampoExpresion().setText("");
/* 178 */         getAreaExpresion().append("Visibilidad: " + token9 + "\n");
/*     */       }
/*     */       
/* 181 */       String token10 = matcher.group(11);
/* 182 */       if (token10 != null) {
/* 183 */         getCampoExpresion().setText("");
/* 184 */         getAreaExpresion().append("Variable Global: " + token10 + "\n");
/*     */       }
/*     */       
/* 187 */       String token11 = matcher.group(12);
/* 188 */       if (token11 != null) {
/* 189 */         getCampoExpresion().setText("");
/* 190 */         getAreaExpresion().append("Variable de Clase: " + token11 + "\n");
/*     */       }
/*     */       
/* 193 */       String token12 = matcher.group(13);
/* 194 */       if (token12 != null) {
/* 195 */         getCampoExpresion().setText("");
/* 196 */         getAreaExpresion().append("Variable Instanciada: " + token12 + "\n");
/*     */       }
/*     */       
/* 199 */       String token13 = matcher.group(14);
/* 200 */       if (token13 != null) {
/* 201 */         getCampoExpresion().setText("");
/* 202 */         getAreaExpresion().append("Variable Local: " + token13 + "\n");
/*     */       }
/*     */       
/* 205 */       String token14 = matcher.group(15);
/* 206 */       if (token14 != null) {
/* 207 */         getCampoExpresion().setText("");
/* 208 */         getAreaExpresion().append("Variable Local " + token14 + "\n");
/*     */       }
/*     */       
/* 211 */       String token15 = matcher.group(16);
/* 212 */       if (token15 != null) {
/* 213 */         getCampoExpresion().setText("");
/* 214 */         getAreaExpresion().append("Numero: " + token15 + "\n");
/*     */       }
/*     */       
/* 217 */       String token16 = matcher.group(17);
/* 218 */       if (token16 != null) {
/* 219 */         getCampoExpresion().setText("");
/* 220 */         getAreaExpresion().append("Corchete: " + token16 + "\n");
/*     */       }
/*     */       
/* 223 */       String token17 = matcher.group(18);
/* 224 */       if (token17 != null) {
/* 225 */         getCampoExpresion().setText("");
/* 226 */         getAreaExpresion().append("Llave: " + token17 + "\n");
/*     */       }
/*     */       
/* 229 */       String token18 = matcher.group(19);
/* 230 */       if (token18 != null) {
/* 231 */         getCampoExpresion().setText("");
/* 232 */         getAreaExpresion().append("Operador Lógico: " + token18 + "\n");
/*     */       }
/*     */       
/* 235 */       String token19 = matcher.group(20);
/* 236 */       if (token19 != null) {
/* 237 */         getCampoExpresion().setText("");
/* 238 */         getAreaExpresion().append("Operadores de bits: " + token19 + "\n");
/*     */       }
/*     */       
/* 241 */       String token20 = matcher.group(21);
/* 242 */       if (token20 != null) {
/* 243 */         getCampoExpresion().setText("");
/* 244 */         getAreaExpresion().append("Paréntesis: " + token20 + "\n");
/*     */       }
/*     */       
/* 247 */       String token21 = matcher.group(22);
/* 248 */       if (token21 != null) {
/* 249 */         getCampoExpresion().setText("");
/* 250 */         getAreaExpresion().append("Espacio en blanco: " + token21 + "\n");
/*     */       }
/* 252 */       String token22 = matcher.group(23);
/* 253 */       if (token22 != null) {
/* 254 */         getCampoExpresion().setText("");
/* 255 */         getAreaExpresion().append("Operador de asignación: " + token22 + "\n");
/*     */       }
/*     */       
/* 258 */       String token23 = matcher.group(24);
/* 259 */       if (token23 != null) {
/* 260 */         getCampoExpresion().setText("");
/* 261 */         getAreaExpresion().append("Coma: " + token23 + "\n");
/*     */       }
/*     */       
/* 264 */       String token24 = matcher.group(25);
/* 265 */       if (token24 != null) {
/* 266 */         getCampoExpresion().setText("");
/* 267 */         getAreaExpresion().append("Comilla: " + token24 + "\n");
/*     */       }
/*     */       
/* 270 */       String token26 = matcher.group(27);
/* 271 */       if (token26 != null) {
/* 272 */         getCampoExpresion().setText("");
/* 273 */         getAreaExpresion().append("Símbolo: " + token26 + "\n");
/*     */       }
/*     */       
/* 276 */       String token25 = matcher.group(26);
/* 277 */       if (token25 != null) {
/* 278 */         getCampoExpresion().setText("");
/* 279 */         getAreaExpresion().append("Constante: " + token25 + "\n");
/*     */       }
/*     */       
/* 282 */       String token27 = matcher.group(28);
/* 283 */       if (token27 != null) {
/* 284 */         getCampoExpresion().setText("");
/* 285 */         getAreaExpresion().append("ERROR Caracter no válido: " + token27 + "\n");
/*     */       }
/*     */       
/* 288 */       String token28 = matcher.group(1);
/* 289 */       if (token28 != null) {
/* 290 */         getCampoExpresion().setText("");
/* 291 */         getAreaExpresion().append("Identificador de Clase: " + token28 + "\n");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void areaExpresionFocusGained(FocusEvent evt)
/*     */   {
/* 303 */     this.botonAnalizar.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void campoExpresionFocusGained(FocusEvent evt) {
/* 307 */     this.botonAnalizar.setEnabled(false);
/*     */   }
/*     */   
/*     */   public JTextField getCampoExpresion() {
/* 311 */     return this.campoExpresion;
/*     */   }
/*     */   
/*     */   public JTextArea getAreaExpresion() {
/* 315 */     return this.areaExpresion;
/*     */   }
/*     */   
/*     */   public JLabel getEtiquetaExp() {
/* 319 */     return this.etiquetaExp;
/*     */   }
/*     */ }


/* Location:              C:\Users\HP\Documents\Chingaderas\Analizadores\Lexer\AnalizadorLexico.jar!\analizadorlexico\PaneL.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */