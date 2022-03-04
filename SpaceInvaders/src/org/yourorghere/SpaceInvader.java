package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.j2d.TextRenderer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.sound.sampled.*;
import javax.swing.*;

/**
 * SpaceInvader.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class SpaceInvader implements GLEventListener {

    public static int ban = 0;
    public static int bans = 0;
    public static Clip clipFondo;
    static final GLCanvas canvas = new GLCanvas();

    private static final JMenuBar jMenuBar = new JMenuBar();
    private static final JMenu jMOriginal = new JMenu();
    private static final JMenu jMTraslacion = new JMenu();
    private static final JMenu jMEscalacion = new JMenu();
    private static final JMenu jMEscalacion_menos = new JMenu();
    private static final JMenu jMEscalacion_pf = new JMenu();
    private static final JMenu jMRotacion_iz = new JMenu();
    private static final JMenu jMRotacion_der = new JMenu();
    private static final JMenu jMRotacion_pf = new JMenu();
    private static final JMenu jMCorte_hor = new JMenu();
    private static final JMenu jMCorte_ver = new JMenu();
    private static final JMenu jMReeflexion_x = new JMenu();
    private static final JMenu jMReeflexion_y = new JMenu();
    private static final JMenu jMReeflexion_origen = new JMenu();
    private static final JMenu jMReeflexion_recta = new JMenu();
    private static final JMenu jMSonidoON = new JMenu();
    private static final JMenu jMSonidoOFF = new JMenu();
    private static final JMenu jMAcerca = new JMenu();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Helicoptero");

        jMOriginal.setText("Original");
        jMenuBar.add(jMOriginal);
        jMTraslacion.setText("Traslacion");
        jMenuBar.add(jMTraslacion);
        jMEscalacion.setText("+ Escalacion");
        jMenuBar.add(jMEscalacion);
        jMEscalacion_menos.setText("- Escalacion");
        jMenuBar.add(jMEscalacion_menos);
        jMEscalacion_pf.setText("Escalacion pf");
        jMenuBar.add(jMEscalacion_pf);
        jMRotacion_iz.setText("Rotacion Iz");
        jMenuBar.add(jMRotacion_iz);
        jMRotacion_der.setText("Rotacion Der");
        jMenuBar.add(jMRotacion_der);
        jMRotacion_pf.setText("Rotacion pf");
        jMenuBar.add(jMRotacion_pf);
        jMCorte_hor.setText("Corte hor");
        jMenuBar.add(jMCorte_hor);
        jMCorte_ver.setText("Corte ver");
        jMenuBar.add(jMCorte_ver);
        jMReeflexion_x.setText("Reflexion x");
        jMenuBar.add(jMReeflexion_x);
        jMReeflexion_y.setText("Reflexion y");
        jMenuBar.add(jMReeflexion_y);
        jMReeflexion_origen.setText("Reflexion origen");
        jMenuBar.add(jMReeflexion_origen);
        jMReeflexion_recta.setText("Reflexion recta");
        jMenuBar.add(jMReeflexion_recta);
        jMSonidoON.setText("Sonido ON");
        jMenuBar.add(jMSonidoON);
        jMSonidoOFF.setText("Sonido OFF");
        jMenuBar.add(jMSonidoOFF);
        jMAcerca.setText("Acerca de");
        jMenuBar.add(jMAcerca);

        jMOriginal.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMOriginalMouseClicked(evt);
            }
        });

        jMTraslacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMTraslacionMouseClicked(evt);
            }
        });

        jMEscalacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMEscalacionMouseClicked(evt);
            }
        });

        jMEscalacion_menos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMEscalacion_menosMouseClicked(evt);
            }
        });

        jMEscalacion_pf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMEscalacion_pfMouseClicked(evt);
            }
        });

        jMRotacion_iz.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMRotacion_izMouseClicked(evt);
            }
        });

        jMRotacion_der.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMRotacion_derMouseClicked(evt);
            }
        });

        jMRotacion_pf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMRotacion_pfMouseClicked(evt);
            }
        });

        jMCorte_hor.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMCorte_horMouseClicked(evt);
            }
        });

        jMCorte_ver.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMCorte_verMouseClicked(evt);
            }
        });

        jMReeflexion_x.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMReeflexion_xMouseClicked(evt);
            }
        });

        jMReeflexion_y.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMReeflexion_yMouseClicked(evt);
            }
        });

        jMReeflexion_origen.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMReeflexion_origenMouseClicked(evt);
            }
        });

        jMReeflexion_recta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMReeflexion_rectaMouseClicked(evt);
            }
        });

        jMSonidoON.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMSonidoON_pfMouseClicked(evt);
            }
        });

        jMSonidoOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMSonidoOFF_pfMouseClicked(evt);
            }
        });

        jMAcerca.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMAcercaMouseClicked(evt);
            }
        });

        frame.setJMenuBar(jMenuBar);

        GLCanvas canvas1 = new GLCanvas();

        canvas1.addGLEventListener(new SpaceInvader());
        frame.add(canvas1);
        frame.setSize(1350, 750);
        final Animator animator = new Animator(canvas1);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    @Override
    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-8, 7, -8, 7);
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);

        if (ban == 1) {
            // Ala izquierda
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.647f, 0.5843f, 0.5843f);
            gl.glVertex2f(2, 1); //A
            gl.glVertex2f(3, 2); //B
            gl.glVertex2f(3, 4); //C
            gl.glVertex2f(2, 5); //D
            gl.glVertex2f(1, 4); //E
            gl.glVertex2f(1, 2); //F
            gl.glEnd();

            // Ala izquierda 2
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
            gl.glVertex2f(2, 1.5f); //A
            gl.glVertex2f(2.65f, 2.25f); //B
            gl.glVertex2f(2.65f, 3.80f); //C
            gl.glVertex2f(2, 4.5f); //D
            gl.glVertex2f(1.35f, 3.80f); //E
            gl.glVertex2f(1.35f, 2.20f); //f
            gl.glEnd();

            // Motor Izquierdo 1
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(9.25f, 0.0705f, 0.0705f);
            gl.glVertex2f(1.35f, 2.20f);
            gl.glVertex2f(2, 1.5f);
            gl.glVertex2f(2, 0.8f);
            gl.glVertex2f(1, 1.8f);
            gl.glEnd();

            // Motor Izquierdo 2
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.925f, 0.0705f, 0.0705f);
            gl.glVertex2f(2, 1.5f);
            gl.glVertex2f(2.65f, 2.25f);
            gl.glVertex2f(3, 1.8f);
            gl.glVertex2f(2, 0.8f);
            gl.glEnd();

            // Ala Derecha
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.647f, 0.5843f, 0.5843f);
            gl.glVertex2f(6, 1); //A
            gl.glVertex2f(7, 2); //B
            gl.glVertex2f(7, 4); //C
            gl.glVertex2f(6, 5); //D
            gl.glVertex2f(5, 4); //E
            gl.glVertex2f(5, 2); //F
            gl.glEnd();

            // Ala Derecho 2
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
            gl.glVertex2f(6, 1.5f); //A
            gl.glVertex2f(6.65f, 2.25f); //B
            gl.glVertex2f(6.65f, 3.80f); //C
            gl.glVertex2f(6, 4.5f); //D
            gl.glVertex2f(5.35f, 3.80f); //E
            gl.glVertex2f(5.35f, 2.20f); //f
            gl.glEnd();

            // Motor Derecho 1
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(9.25f, 0.0705f, 0.0705f);
            gl.glVertex2f(5.35f, 2.20f);
            gl.glVertex2f(6, 1.5f);
            gl.glVertex2f(6, 0.8f);
            gl.glVertex2f(5, 1.8f);
            gl.glEnd();

            // Motor Derecho 2
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(0.925f, 0.0705f, 0.0705f);
            gl.glVertex2f(6, 1.5f);
            gl.glVertex2f(6.65f, 2.25f);
            gl.glVertex2f(7, 1.8f);
            gl.glVertex2f(6, 0.8f);
            gl.glEnd();

            //Cuerpo
            gl.glBegin(GL.GL_POLYGON);
            gl.glColor3f(1.0f, 1.0f, 1.0f);
            gl.glVertex2f(4, 3); //A
            gl.glVertex2f(6, 5); //B
            gl.glVertex2f(6, 7); //C
            gl.glVertex2f(4, 9); //D
            gl.glVertex2f(2, 7); //E
            gl.glVertex2f(2, 5); //F
            gl.glEnd();
            gl.glFlush();
        }
        else {
            Transformaciones2D obj = new Transformaciones2D();
            switch (ban) {
                case 2: {
                    //Cuerpo
                    float t[][] = obj.mTraslacion(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mTraslacion(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mTraslacion(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mTraslacion(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mTraslacion(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mTraslacion(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mTraslacion(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mTraslacion(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mTraslacion(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 3: {
                    //Cuerpo
                    float t[][] = obj.mEscalacion_mas(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mEscalacion_mas(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mEscalacion_mas(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mEscalacion_mas(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mEscalacion_mas(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mEscalacion_mas(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mEscalacion_mas(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mEscalacion_mas(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mEscalacion_mas(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 4: {
                    //Cuerpo
                    float t[][] = obj.mEscalacion_menos(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mEscalacion_menos(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mEscalacion_menos(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mEscalacion_menos(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mEscalacion_menos(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mEscalacion_menos(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mEscalacion_menos(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mEscalacion_menos(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mEscalacion_menos(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 5: {
                    //Cuerpo
                    float t[][] = obj.mEscalacion_pf(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mEscalacion_pf(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mEscalacion_pf(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mEscalacion_pf(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mEscalacion_pf(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mEscalacion_pf(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mEscalacion_pf(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mEscalacion_pf(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mEscalacion_pf(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 6: {
                    //Cuerpo
                    float t[][] = obj.mRotacion_iz(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mRotacion_iz(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mRotacion_iz(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mRotacion_iz(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mRotacion_iz(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mRotacion_iz(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mRotacion_iz(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mRotacion_iz(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mRotacion_iz(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 7: {
                    //Cuerpo
                    float t[][] = obj.mRotacion_der(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mRotacion_der(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mRotacion_der(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mRotacion_der(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mRotacion_der(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mRotacion_der(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mRotacion_der(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mRotacion_der(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mRotacion_der(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 8: {
                    //Cuerpo
                    float t[][] = obj.mEscalacion_pf(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mEscalacion_pf(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mEscalacion_pf(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mEscalacion_pf(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mEscalacion_pf(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mEscalacion_pf(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mEscalacion_pf(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mEscalacion_pf(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mEscalacion_pf(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 9: {
                    //Cuerpo
                    float t[][] = obj.mCorte_ver(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mCorte_ver(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mCorte_ver(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mCorte_ver(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mCorte_ver(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mCorte_ver(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mCorte_ver(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mCorte_ver(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mCorte_ver(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 10: {
                    //Cuerpo
                    float t[][] = obj.mCorte_hor(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mCorte_hor(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mCorte_hor(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mCorte_hor(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mCorte_hor(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mCorte_hor(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mCorte_hor(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mCorte_hor(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mCorte_hor(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 11: {
                    //Cuerpo
                    float t[][] = obj.mReflexion_y(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mReflexion_y(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mReflexion_y(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mReflexion_y(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mReflexion_y(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mReflexion_y(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mReflexion_y(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mReflexion_y(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mReflexion_y(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 12: {
                    //Cuerpo
                    float t[][] = obj.mReflexion_x(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mReflexion_x(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mReflexion_x(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mReflexion_x(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mReflexion_x(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mReflexion_x(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mReflexion_x(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mReflexion_x(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mReflexion_x(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 13: {
                    //Cuerpo
                    float t[][] = obj.mReflexion_origen(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mReflexion_origen(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mReflexion_origen(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mReflexion_origen(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mReflexion_origen(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mReflexion_origen(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mReflexion_origen(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mReflexion_origen(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mReflexion_origen(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 14: {
                    //Cuerpo
                    float t[][] = obj.mReflexion_recta(4, 3, 6, 5, 6, 7, 4, 9, 2, 7, 2, 5);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t[0][0], t[0][1]); //A
                    gl.glVertex2f(t[1][0], t[1][1]); //B
                    gl.glVertex2f(t[2][0], t[2][1]); //C
                    gl.glVertex2f(t[3][0], t[3][1]); //D
                    gl.glVertex2f(t[4][0], t[4][1]); //E
                    gl.glVertex2f(t[5][0], t[5][1]); //F
                    gl.glEnd();

                    //Ala izquierda 1
                    float t1[][] = obj.mReflexion_recta(2, 1, 3, 2, 3, 4, 2, 5, 1, 4, 1, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t1[0][0], t1[0][1]); //A
                    gl.glVertex2f(t1[1][0], t1[1][1]); //B
                    gl.glVertex2f(t1[2][0], t1[2][1]); //C
                    gl.glVertex2f(t1[3][0], t1[3][1]); //D
                    gl.glVertex2f(t1[4][0], t1[4][1]); //E
                    gl.glVertex2f(t1[5][0], t1[5][1]); //F
                    gl.glEnd();

                    //Ala Izquierda 2
                    float t3[][] = obj.mReflexion_recta(2, 1.5, 2.65, 2.25, 2.65, 3.8, 2, 4.5, 1.35, 3.8, 1.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t3[0][0], t3[0][1]); //A
                    gl.glVertex2f(t3[1][0], t3[1][1]); //B
                    gl.glVertex2f(t3[2][0], t3[2][1]); //C
                    gl.glVertex2f(t3[3][0], t3[3][1]); //D
                    gl.glVertex2f(t3[4][0], t3[4][1]); //E
                    gl.glVertex2f(t3[5][0], t3[5][1]); //F
                    gl.glEnd();

                    //Motor Izquierdo 1
                    float t4[][] = obj.mReflexion_recta(1.35, 2.2, 2, 1.5, 2, 0.8, 1, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t4[0][0], t4[0][1]); //A
                    gl.glVertex2f(t4[1][0], t4[1][1]); //B
                    gl.glVertex2f(t4[2][0], t4[2][1]); //C
                    gl.glVertex2f(t4[3][0], t4[3][1]); //D
                    gl.glEnd();

                    //Motor Izquierdo 2
                    float t6[][] = obj.mReflexion_recta(2, 1.5, 2.65, 2.25, 3, 1.8, 2, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t6[0][0], t6[0][1]); //A
                    gl.glVertex2f(t6[1][0], t6[1][1]); //B
                    gl.glVertex2f(t6[2][0], t6[2][1]); //C
                    gl.glVertex2f(t6[3][0], t6[3][1]); //D
                    gl.glEnd();

                    //Ala Derecha 1
                    float t2[][] = obj.mReflexion_recta(6, 1, 7, 2, 7, 4, 6, 5, 5, 4, 5, 2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.647f, 0.5843f, 0.5843f);
                    gl.glVertex2f(t2[0][0], t2[0][1]); //A
                    gl.glVertex2f(t2[1][0], t2[1][1]); //B
                    gl.glVertex2f(t2[2][0], t2[2][1]); //C
                    gl.glVertex2f(t2[3][0], t2[3][1]); //D
                    gl.glVertex2f(t2[4][0], t2[4][1]); //E
                    gl.glVertex2f(t2[5][0], t2[5][1]); //F
                    gl.glEnd();

                    //Ala derecha 2
                    float t5[][] = obj.mReflexion_recta(6, 1.5, 6.65, 2.25, 6.65, 3.80, 6, 4.5, 5.35, 3.8, 5.35, 2.2);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
                    gl.glVertex2f(t5[0][0], t5[0][1]); //A
                    gl.glVertex2f(t5[1][0], t5[1][1]); //B
                    gl.glVertex2f(t5[2][0], t5[2][1]); //C
                    gl.glVertex2f(t5[3][0], t5[3][1]); //D
                    gl.glVertex2f(t5[4][0], t5[4][1]); //E
                    gl.glVertex2f(t5[5][0], t5[5][1]); //F
                    gl.glEnd();

                    //Motor Derecho 1
                    float t7[][] = obj.mReflexion_recta(5.35, 2.2, 6, 1.5, 6, 0.8, 5, 1.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t7[0][0], t7[0][1]); //A
                    gl.glVertex2f(t7[1][0], t7[1][1]); //B
                    gl.glVertex2f(t7[2][0], t7[2][1]); //C
                    gl.glVertex2f(t7[3][0], t7[3][1]); //D
                    gl.glEnd();

                    //Motor Derecho 2
                    float t8[][] = obj.mReflexion_recta(6, 1.5, 6.65, 2.25, 7, 1.8, 6, 0.8, 0, 0, 0, 0);
                    gl.glBegin(GL.GL_POLYGON);
                    gl.glColor3f(0.925f, 0.0705f, 0.0705f);
                    gl.glVertex2f(t8[0][0], t8[0][1]); //A
                    gl.glVertex2f(t8[1][0], t8[1][1]); //B
                    gl.glVertex2f(t8[2][0], t8[2][1]); //C
                    gl.glVertex2f(t8[3][0], t8[3][1]); //D
                    gl.glEnd();

                    gl.glFlush();
                    break;
                }
                case 15:
                    TextRenderer txt = new TextRenderer(new Font("Arial", Font.BOLD, 30));
                    txt.beginRendering(1000, 500);
                    txt.setColor(Color.WHITE);
                    txt.draw("Graficacion", 430, 400);
                    txt.draw("Joab Jaaziel Pulido Ambriz", 300, 300);
                    txt.draw("Ismael Santillan", 400, 200);
                    txt.draw("Grupo S5", 445, 100);
                    txt.endRendering();
                    break;
                default:
                    break;
            }

        }

        // Flush all drawing operations to the graphics card
        gl.glFlush();

        // Done Drawing The Quad
        gl.glEnd();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    private static void jMOriginalMouseClicked(MouseEvent evt) {
        ban = 1;
        canvas.repaint();
    }

    private static void jMTraslacionMouseClicked(MouseEvent evt) {
        ban = 2;
        canvas.repaint();
    }

    private static void jMEscalacionMouseClicked(MouseEvent evt) {
        ban = 3;
        canvas.repaint();
    }

    private static void jMEscalacion_menosMouseClicked(MouseEvent evt) {
        ban = 4;
        canvas.repaint();
    }

    private static void jMEscalacion_pfMouseClicked(MouseEvent evt) {
        ban = 5;
        canvas.repaint();
    }

    private static void jMRotacion_izMouseClicked(MouseEvent evt) {
        ban = 6;
        canvas.repaint();
    }

    private static void jMRotacion_derMouseClicked(MouseEvent evt) {
        ban = 7;
        canvas.repaint();
    }

    private static void jMRotacion_pfMouseClicked(MouseEvent evt) {
        ban = 8;
        canvas.repaint();
    }

    private static void jMCorte_horMouseClicked(MouseEvent evt) {
        ban = 9;
        canvas.repaint();
    }

    private static void jMCorte_verMouseClicked(MouseEvent evt) {
        ban = 10;
        canvas.repaint();
    }

    private static void jMReeflexion_xMouseClicked(MouseEvent evt) {
        ban = 11;
        canvas.repaint();
    }

    private static void jMReeflexion_yMouseClicked(MouseEvent evt) {
        ban = 12;
        canvas.repaint();
    }

    private static void jMReeflexion_origenMouseClicked(MouseEvent evt) {
        ban = 13;
        canvas.repaint();
    }

    private static void jMReeflexion_rectaMouseClicked(MouseEvent evt) {
        ban = 14;
        canvas.repaint();
    }

    private static void jMAcercaMouseClicked(MouseEvent evt) {
        ban = 15;
        canvas.repaint();
    }

    private static void jMSonidoON_pfMouseClicked(MouseEvent evt) {
        if (bans == 0) {
            sonidoFondo();
            bans = 1;
        }
        else {
            clipFondo.start();
        }
        canvas.repaint();
    }

    private static void jMSonidoOFF_pfMouseClicked(MouseEvent evt) {
        clipFondo.stop();
        canvas.repaint();
    }

    public static synchronized void sonidoFondo() {
        new Thread(new Runnable() {
            public void run() {
                File d = new File("src/sonidos/helicoptero.wav");
                try {
                    clipFondo = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(d);
                    clipFondo.open(inputStream);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
