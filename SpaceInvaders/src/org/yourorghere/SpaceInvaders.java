package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;



/**
 * SpaceInvaders.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class SpaceInvaders implements GLEventListener {

    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new SpaceInvaders());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

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
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);

        // Ala izquierda
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0.647f, 0.5843f, 0.5843f);
        gl.glVertex2f(0.2f, 0.1f); //A
        gl.glVertex2f(0.3f, 0.2f); //B
        gl.glVertex2f(0.3f, 0.4f); //C
        gl.glVertex2f(0.2f, 0.5f); //D
        gl.glVertex2f(0.1f, 0.4f); //E
        gl.glVertex2f(0.1f, 0.2f); //F
        gl.glEnd();
        
        // Ala izquierda 2
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0.1019f, 0.0156f, 0.7490f);
        gl.glVertex2f(0.2f, 0.15f); //A
        gl.glVertex2f(0.265f, 0.225f); //B
        gl.glVertex2f(0.265f, 0.380f); //C
        gl.glVertex2f(0.2f, 0.45f); //D
        gl.glVertex2f(0.135f, 0.380f); //E
        gl.glVertex2f(0.135f, 0.220f); //f
        gl.glEnd();
        
        // Motor Izquierdo 1
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0.925f, 0.0705f, 0.0705f);
        gl.glVertex2f(0.135f, 0.220f);
        gl.glVertex2f(0.2f, 0.15f);
        gl.glVertex2f(0.2f, 0.08f);
        gl.glVertex2f(0.1f, 0.18f);
        gl.glEnd();
        
        // Motor Izquierdo 2
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0.925f, 0.0705f, 0.0705f);
        gl.glVertex2f(0.2f, 0.15f);
        gl.glVertex2f(0.265f, 0.225f);
        gl.glVertex2f(0.3f, 0.18f);
        gl.glVertex2f(0.2f, 0.08f);
        gl.glEnd();
        
        // Ala Derecha
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0.647f, 0.5843f, 0.5843f);
        gl.glVertex2f(0.6f, 0.1f); //A
        gl.glVertex2f(0.7f, 0.2f); //B
        gl.glVertex2f(0.7f, 0.4f); //C
        gl.glVertex2f(0.6f, 0.5f); //D
        gl.glVertex2f(0.5f, 0.4f); //E
        gl.glVertex2f(0.5f, 0.2f); //F
        gl.glEnd();

        //Cuerpo
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2f(0.4f, 0.3f); //A
        gl.glColor3f(0.647f, 0.5843f, 0.5843f);
        gl.glVertex2f(0.6f, 0.5f); //B
        gl.glColor3f(0.647f, 0.5843f, 0.5843f);
        gl.glVertex2f(0.6f, 0.7f); //C
        gl.glColor3f(0.647f, 0.5843f, 0.5843f);
        gl.glVertex2f(0.4f, 0.9f); //D
        gl.glColor3f(0.647f, 0.5843f, 0.5843f);
        gl.glVertex2f(0.2f, 0.7f); //E
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glVertex2f(0.2f, 0.5f); //F
        gl.glEnd();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

