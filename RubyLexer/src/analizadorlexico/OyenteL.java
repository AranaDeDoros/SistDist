/*     */ package analizadorlexico;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.PrintStream;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OyenteL
/*     */   implements ActionListener
/*     */ {
/*     */   private final PaneL panel;
/*     */   private boolean reg;
/*     */   private String cad;
/*     */   
/*     */   public OyenteL(PaneL panel)
/*     */   {
/*  27 */     this.panel = panel;
/*     */   }
/*     */   
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/*  32 */     encontrarC();
/*     */   }
/*     */   
/*     */ 
/*     */   public void encontrarC()
/*     */   {
/*  38 */     String regex = "([A-Z][a-z_]+[A-Z][a-z_]+)|(\\.|__ENCODING__|__LINE__|__FILE__|BEGIN|END)|(alias|and|begin|break|catch|case|class|defined|def|do|dir|else|elsif|end|ensure|false|for|if|initialize|in|load|module|next|new|nil|not|or|raise|require|redo|rescue|retry|return|self|super|then|true|throw|undef|unless|until|when|while|yield)|(TRUE|FALSE|NIL|ARGF|ARGV|DATA|ENV|RUBY_PLATFORM|RUBY_RELEASE_DATE|RUBY_VERSION|STDERR|STDIN|STDOUT|TOPLEVEL_BINDING|puts)|(\\$!|\\$@|\\$\\/|\\$\\\\|\\$,|\\$;|\\$\\.|\\$<|\\$>|\\$0|\\$\\$|\\$\\?|\\$:|\\$DEBUG|\\$defout|\\$FILENAME|\\$F|\\$LOAD_PATH|\\$SAFE|\\$stdin|\\$stdout|\\$stderr|\\$VERBOSE|\\$-x|\\$-0|\\$-a|\\$-d|\\$-F|\\$-i|\\$-I|\\$-l|\\$-p|\\$_|\\$~|\\$n|\\$&|\\$'|\\$\\+|\\$`|\\$\\d|`)|(\\*\\*|\\+|-|\\*|\\/)|(<=>|===|>=|<=|==|!=|\\.eql\\?|equal\\?|>|<)|(\\.\\.\\.|\\.\\.)|(#.|=begin.+=end)|(public|protected|private)|(\\$[a-zA-Z_]*)|(@@[a-zA-Z_]*)|(@[a-zA-Z_]*)|(_[a-z][a-zA-Z_]*)|([a-z][a-zA-Z_]*)|([0-9]+)|(\\[|\\])|(\\{|\\})|(and|or|&&|\\|\\||!|not)|(<<|>>|&|\\||\\^|~)|(\\(|\\))|(\\s)+|(=)|(,)|(\")|([A-Z]+[0-9]*)|(\\:)|(\\D|\\S|Ç|ç)";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  47 */     Pattern pat = Pattern.compile(regex);
/*  48 */     String entrada = this.panel.getCampoExpresion().getText();
/*  49 */     Matcher matcher = pat.matcher(entrada);
/*     */     
/*     */ 
/*  52 */     if (this.panel.getAreaExpresion().getText() != null) {
/*  53 */       this.reg = true;
/*     */     }
/*  55 */     if (this.reg) {
/*  56 */       this.panel.getAreaExpresion().setText("");
/*     */     }
/*     */     
/*     */ 
/*  60 */     while (matcher.find()) {
/*  61 */       String token1 = matcher.group(2);
/*  62 */       if (token1 != null) {
/*  63 */         this.panel.getCampoExpresion().setText("");
/*  64 */         this.panel.getAreaExpresion().append("Palabra Reservada: " + token1 + "\n");
/*     */       }
/*     */       
/*     */ 
/*  68 */       String token2 = matcher.group(3);
/*  69 */       if (token2 != null) {
/*  70 */         this.panel.getCampoExpresion().setText("");
/*  71 */         this.panel.getAreaExpresion().append("Palabra Reservada: " + token2 + "\n");
/*     */       }
/*     */       
/*  74 */       String token3 = matcher.group(4);
/*  75 */       if (token3 != null) {
/*  76 */         this.panel.getCampoExpresion().setText("");
/*  77 */         this.panel.getAreaExpresion().append("Constantes predefinidas: " + token3 + "\n");
/*     */       }
/*     */       
/*  80 */       String token4 = matcher.group(5);
/*  81 */       if (token4 != null) {
/*  82 */         this.panel.getCampoExpresion().setText("");
/*  83 */         this.panel.getAreaExpresion().append("Variables predefinidas: " + token4 + "\n");
/*     */       }
/*     */       
/*  86 */       String token5 = matcher.group(6);
/*  87 */       if (token5 != null) {
/*  88 */         this.panel.getCampoExpresion().setText("");
/*  89 */         this.panel.getAreaExpresion().append("Operadores aritmeticos: " + token5 + "\n");
/*     */       }
/*     */       
/*  92 */       String token6 = matcher.group(7);
/*  93 */       if (token6 != null) {
/*  94 */         this.panel.getCampoExpresion().setText("");
/*  95 */         this.panel.getAreaExpresion().append("Operadores comparativos: " + token6 + "\n");
/*     */       }
/*     */       
/*  98 */       String token7 = matcher.group(8);
/*  99 */       if (token7 != null) {
/* 100 */         this.panel.getCampoExpresion().setText("");
/* 101 */         this.panel.getAreaExpresion().append("Operadores de rango:" + token7 + "\n");
/*     */       }
/*     */       
/* 104 */       String token8 = matcher.group(9);
/* 105 */       if (token8 != null) {
/* 106 */         this.panel.getCampoExpresion().setText("");
/* 107 */         this.panel.getAreaExpresion().append("Comentario: " + token8 + "\n");
/*     */       }
/*     */       
/* 110 */       String token9 = matcher.group(10);
/* 111 */       if (token9 != null) {
/* 112 */         this.panel.getCampoExpresion().setText("");
/* 113 */         this.panel.getAreaExpresion().append("Visibilidad: " + token9 + "\n");
/*     */       }
/*     */       
/* 116 */       String token10 = matcher.group(11);
/* 117 */       if (token10 != null) {
/* 118 */         this.panel.getCampoExpresion().setText("");
/* 119 */         this.panel.getAreaExpresion().append("Variable Global: " + token10 + "\n");
/*     */       }
/*     */       
/* 122 */       String token11 = matcher.group(12);
/* 123 */       if (token11 != null) {
/* 124 */         this.panel.getCampoExpresion().setText("");
/* 125 */         this.panel.getAreaExpresion().append("Variable de Clase: " + token11 + "\n");
/*     */       }
/*     */       
/* 128 */       String token12 = matcher.group(13);
/* 129 */       if (token12 != null) {
/* 130 */         this.panel.getCampoExpresion().setText("");
/* 131 */         this.panel.getAreaExpresion().append("Variable Instanciada: " + token12 + "\n");
/*     */       }
/*     */       
/* 134 */       String token13 = matcher.group(14);
/* 135 */       if (token13 != null) {
/* 136 */         this.panel.getCampoExpresion().setText("");
/* 137 */         this.panel.getAreaExpresion().append("Variable Local: " + token13 + "\n");
/*     */       }
/*     */       
/* 140 */       String token14 = matcher.group(15);
/* 141 */       if (token14 != null) {
/* 142 */         this.panel.getCampoExpresion().setText("");
/* 143 */         this.panel.getAreaExpresion().append("Variable Local " + token14 + "\n");
/*     */       }
/*     */       
/* 146 */       String token15 = matcher.group(16);
/* 147 */       if (token15 != null) {
/* 148 */         this.panel.getCampoExpresion().setText("");
/* 149 */         this.panel.getAreaExpresion().append("Numero: " + token15 + "\n");
/*     */       }
/*     */       
/* 152 */       String token16 = matcher.group(17);
/* 153 */       if (token16 != null) {
/* 154 */         this.panel.getCampoExpresion().setText("");
/* 155 */         this.panel.getAreaExpresion().append("Corchete: " + token16 + "\n");
/*     */       }
/*     */       
/* 158 */       String token17 = matcher.group(18);
/* 159 */       if (token17 != null) {
/* 160 */         this.panel.getCampoExpresion().setText("");
/* 161 */         this.panel.getAreaExpresion().append("Llave: " + token17 + "\n");
/*     */       }
/*     */       
/* 164 */       String token18 = matcher.group(19);
/* 165 */       if (token18 != null) {
/* 166 */         this.panel.getCampoExpresion().setText("");
/* 167 */         this.panel.getAreaExpresion().append("Operador Lógico: " + token18 + "\n");
/*     */       }
/*     */       
/* 170 */       String token19 = matcher.group(20);
/* 171 */       if (token19 != null) {
/* 172 */         this.panel.getCampoExpresion().setText("");
/* 173 */         this.panel.getAreaExpresion().append("Operadores de bits: " + token19 + "\n");
/*     */       }
/*     */       
/* 176 */       String token20 = matcher.group(21);
/* 177 */       if (token20 != null) {
/* 178 */         this.panel.getCampoExpresion().setText("");
/* 179 */         this.panel.getAreaExpresion().append("Paréntesis: " + token20 + "\n");
/*     */       }
/*     */       
/* 182 */       String token21 = matcher.group(22);
/* 183 */       if (token21 != null) {
/* 184 */         this.panel.getCampoExpresion().setText("");
/* 185 */         this.panel.getAreaExpresion().append("Espacio en blanco: " + token21 + "\n");
/*     */       }
/* 187 */       String token22 = matcher.group(23);
/* 188 */       if (token22 != null) {
/* 189 */         this.panel.getCampoExpresion().setText("");
/* 190 */         this.panel.getAreaExpresion().append("Operador de asignación: " + token22 + "\n");
/*     */       }
/*     */       
/* 193 */       String token23 = matcher.group(24);
/* 194 */       if (token23 != null) {
/* 195 */         this.panel.getCampoExpresion().setText("");
/* 196 */         this.panel.getAreaExpresion().append("Coma: " + token23 + "\n");
/*     */       }
/*     */       
/* 199 */       String token24 = matcher.group(25);
/* 200 */       if (token24 != null) {
/* 201 */         this.panel.getCampoExpresion().setText("");
/* 202 */         this.panel.getAreaExpresion().append("Comilla: " + token24 + "\n");
/*     */       }
/*     */       
/* 205 */       String token26 = matcher.group(27);
/* 206 */       if (token26 != null) {
/* 207 */         this.panel.getCampoExpresion().setText("");
/* 208 */         this.panel.getAreaExpresion().append("Símbolo: " + token26 + "\n");
/*     */       }
/*     */       
/* 211 */       String token25 = matcher.group(26);
/* 212 */       if (token25 != null) {
/* 213 */         this.panel.getCampoExpresion().setText("");
/* 214 */         this.panel.getAreaExpresion().append("Constante: " + token25 + "\n");
/*     */       }
/*     */       
/* 217 */       String token27 = matcher.group(28);
/* 218 */       if (token27 != null) {
/* 219 */         this.panel.getCampoExpresion().setText("");
/* 220 */         this.panel.getAreaExpresion().append("ERROR Caracter no válido: " + token27 + "\n");
/*     */       }
/*     */       
/* 223 */       String token28 = matcher.group(1);
/* 224 */       if (token28 != null) {
/* 225 */         this.panel.getCampoExpresion().setText("");
/* 226 */         this.panel.getAreaExpresion().append("Identificador de Clase: " + token28 + "\n");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 233 */     this.panel.getEtiquetaExp().setText("Expresión evaluada: " + entrada);
/*     */   }
/*     */   
/*     */   public String retText()
/*     */   {
/* 238 */     this.cad = this.panel.getAreaExpresion().getText();
/* 239 */     System.out.println(this.cad);
/* 240 */     return this.cad;
/*     */   }
/*     */ }


/* Location:              C:\Users\HP\Documents\Chingaderas\Analizadores\Lexer\AnalizadorLexico.jar!\analizadorlexico\OyenteL.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */