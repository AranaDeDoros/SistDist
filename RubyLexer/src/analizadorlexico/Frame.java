/*     */ package analizadorlexico;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.KeyStroke;
/*     */ 
/*     */ public class Frame extends javax.swing.JFrame
/*     */ {
/*     */   private final PaneL pan;
/*     */   private JMenuItem Limpiar;
/*     */   private JMenuItem abrir;
/*     */   private JMenu acercaDe;
/*     */   private JMenuBar barraMenu;
/*     */   private JMenuItem guardar;
/*     */   private JMenu lex;
/*     */   private JMenu menuArchivo;
/*     */   private JMenuItem salir;
/*     */   private javax.swing.JPopupMenu.Separator separador;
/*     */   
/*     */   Frame(String analizador_Léxico_de_Ruby, PaneL pan)
/*     */   {
/*  29 */     setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage(getClass().getResource("/IMG/icon.png")));
/*  30 */     initComponents();
/*  31 */     this.pan = pan;
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
/*  43 */     this.barraMenu = new JMenuBar();
/*  44 */     this.menuArchivo = new JMenu();
/*  45 */     this.abrir = new JMenuItem();
/*  46 */     this.guardar = new JMenuItem();
/*  47 */     this.Limpiar = new JMenuItem();
/*  48 */     this.separador = new javax.swing.JPopupMenu.Separator();
/*  49 */     this.salir = new JMenuItem();
/*  50 */     this.lex = new JMenu();
/*  51 */     this.acercaDe = new JMenu();
/*     */     
/*  53 */     setDefaultCloseOperation(3);
/*  54 */     setTitle("Analizador Léxico de Ruby");
/*     */     
/*  56 */     this.menuArchivo.setText("Archivo");
/*     */     
/*  58 */     this.abrir.setAccelerator(KeyStroke.getKeyStroke(65, 8));
/*  59 */     this.abrir.setText("Abrir");
/*  60 */     this.abrir.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  62 */         Frame.this.abrirActionPerformed(evt);
/*     */       }
/*  64 */     });
/*  65 */     this.menuArchivo.add(this.abrir);
/*     */     
/*  67 */     this.guardar.setAccelerator(KeyStroke.getKeyStroke(71, 8));
/*  68 */     this.guardar.setText("Guardar");
/*  69 */     this.guardar.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  71 */         Frame.this.guardarActionPerformed(evt);
/*     */       }
/*  73 */     });
/*  74 */     this.menuArchivo.add(this.guardar);
/*     */     
/*  76 */     this.Limpiar.setAccelerator(KeyStroke.getKeyStroke(67, 8));
/*  77 */     this.Limpiar.setText("Limpiar");
/*  78 */     this.Limpiar.setName("limpiar");
/*  79 */     this.Limpiar.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  81 */         Frame.this.LimpiarActionPerformed(evt);
/*     */       }
/*  83 */     });
/*  84 */     this.menuArchivo.add(this.Limpiar);
/*  85 */     this.menuArchivo.add(this.separador);
/*     */     
/*  87 */     this.salir.setAccelerator(KeyStroke.getKeyStroke(83, 8));
/*  88 */     this.salir.setText("Salir");
/*  89 */     this.salir.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  91 */         Frame.this.salirActionPerformed(evt);
/*     */       }
/*  93 */     });
/*  94 */     this.menuArchivo.add(this.salir);
/*     */     
/*  96 */     this.barraMenu.add(this.menuArchivo);
/*     */     
/*  98 */     this.lex.setText("Léxico");
/*  99 */     this.lex.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 101 */         Frame.this.lexMouseClicked(evt);
/*     */       }
/* 103 */     });
/* 104 */     this.barraMenu.add(this.lex);
/*     */     
/* 106 */     this.acercaDe.setText("Acerca de...");
/* 107 */     this.acercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 109 */         Frame.this.acercaDeMouseClicked(evt);
/*     */       }
/* 111 */     });
/* 112 */     this.barraMenu.add(this.acercaDe);
/*     */     
/* 114 */     setJMenuBar(this.barraMenu);
/*     */     
/* 116 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 117 */     getContentPane().setLayout(layout);
/* 118 */     layout.setHorizontalGroup(layout
/* 119 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 120 */       .addGap(0, 723, 32767));
/*     */     
/* 122 */     layout.setVerticalGroup(layout
/* 123 */       .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 124 */       .addGap(0, 279, 32767));
/*     */     
/*     */ 
/* 127 */     pack();
/*     */   }
/*     */   
/*     */ 
/* 131 */   private void salirActionPerformed(ActionEvent evt) { System.exit(3); }
/*     */   
/*     */   private void abrirActionPerformed(ActionEvent evt) {
/* 134 */     this.pan.getEtiquetaExp().setText("");
/* 135 */     JFileChooser ch = new JFileChooser();
/* 136 */     ch.setFileSelectionMode(0);
/* 137 */     ch.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Ruby Source File", new String[] { "rb" }));
/* 138 */     ch.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text File", new String[] { "txt" }));
/* 139 */     int res = ch.showOpenDialog(this);
/* 140 */     if (res == 0) {
/* 141 */       java.io.File archivo = ch.getSelectedFile();
/* 142 */       String ruta = archivo.getAbsolutePath();
/*     */       try {
/* 144 */         FileReader fr = new FileReader(archivo);Throwable localThrowable3 = null;
/* 145 */         try { String cadena = "";
/* 146 */           int valor = fr.read();
/* 147 */           while (valor != -1) {
/* 148 */             cadena = cadena + (char)valor;
/* 149 */             valor = fr.read();
/*     */           }
/* 151 */           this.pan.getAreaExpresion().setText(cadena);
/*     */         }
/*     */         catch (Throwable localThrowable1)
/*     */         {
/* 144 */           localThrowable3 = localThrowable1;throw localThrowable1;
/*     */ 
/*     */ 
/*     */         }
/*     */         finally
/*     */         {
/*     */ 
/*     */ 
/* 152 */           if (fr != null) if (localThrowable3 != null) try { fr.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else fr.close();
/*     */         }
/*     */       } catch (java.io.IOException localIOException) {}
/*     */     }
/*     */   }
/*     */   
/* 158 */   private void guardarActionPerformed(ActionEvent evt) { this.pan.getEtiquetaExp().setText("");
/* 159 */     JFileChooser ch = new JFileChooser();
/* 160 */     ch.setFileSelectionMode(0);
/* 161 */     ch.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Ruby Source File .rb", new String[] { "rb" }));
/* 162 */     ch.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text File .txt", new String[] { "txt" }));
/* 163 */     int res = ch.showSaveDialog(this);
/* 164 */     if (res == 0) {
/* 165 */       java.io.File archivo = ch.getSelectedFile();
/* 166 */       String ruta = archivo.getAbsolutePath();
/*     */       try {
/* 168 */         FileWriter fr = new FileWriter(archivo);Throwable localThrowable3 = null;
/* 169 */         try { fr.write(this.pan.getAreaExpresion().getText() + "\n");
/*     */         }
/*     */         catch (Throwable localThrowable1)
/*     */         {
/* 168 */           localThrowable3 = localThrowable1;throw localThrowable1;
/*     */         } finally {
/* 170 */           if (fr != null) if (localThrowable3 != null) try { fr.close(); } catch (Throwable localThrowable2) { localThrowable3.addSuppressed(localThrowable2); } else fr.close();
/*     */         }
/*     */       } catch (java.io.IOException localIOException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   private void LimpiarActionPerformed(ActionEvent evt) {
/* 177 */     this.pan.getAreaExpresion().setText("");
/* 178 */     this.pan.getEtiquetaExp().setText("");
/*     */   }
/*     */   
/*     */   private void acercaDeMouseClicked(MouseEvent evt) {
/* 182 */     AcercaDe about = new AcercaDe();
/* 183 */     about.setVisible(true);
/*     */   }
/*     */   
/* 186 */   private void lexMouseClicked(MouseEvent evt) { Vista v = new Vista();
/* 187 */     v.setVisible(true);
/*     */   }
/*     */ }


/* Location:              C:\Users\HP\Documents\Chingaderas\Analizadores\Lexer\AnalizadorLexico.jar!\analizadorlexico\Frame.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */