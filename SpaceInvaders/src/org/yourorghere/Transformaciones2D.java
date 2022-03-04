/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

/**
 *
 * @author Fer
 */

/*
//Traslación
//Escalación (aumentar, disminuir)
//Escalación con punto fijo
//Rotación  (izquierda, derecha)
//Rotación con punto fijo
//Corte Horizontal
//Corte Vertical
//Reflexión en X
//Reflexión en Y
//Reflexión en el Origen
//Reflexión sobre la Recta
//Original
//Sonido (encendido y apagado)
Acerca de (quien lo desarrollo)
 */
public class Transformaciones2D {

    double traslacion[][] = {
        {1, 0, 0},
        {0, 1, 0},
        {-4, -5, 1}
    };
    double escalacion_mas[][] = {
        {2, 0, 0},
        {0, 2, 0},
        {0, 0, 1}
    };
    double escalacion_menos[][] = {
        {0.3, 0, 0},
        {0, 0.3, 0},
        {0, 0, 1}
    };
    double escalacion_pf[][] = {//pf(-8,-2)
        {2, 0, 0},
        {0, 2, 0},
        {(-8 * (1 - 2)), (-2 * (1 - 2)), 1}
    };
    double rotacion_iz[][] = {//45 grados
        {0.5253219888, 0.8509035245, 0},
        {-0.8509035245, 0.5253219888, 0},
        {0, 0, 1}
    };
    double rotacion_der[][] = {//-45 grados
        {0.707106781, -0.707106781, 0},
        {0.707106781, 0.707106781, 0},
        {0, 0, 1}
    };
    double rotacion_pf[][] = {//45 grados  pf (6.1,3.3)
        {0.5253219888, 0.8509035245, 0},
        {-0.8509035245, 0.5253219888, 0},
        {5.703517499, -3.624074063, 1}
    };
    double corte_hor[][] = {//sesgo(2,2)
        {1, 2, 0},
        {0, 1, 0},
        {0, 0, 1}
    };
    double corte_ver[][] = {//sesgo(2,2)
        {1, 0, 0},
        {2, 1, 0},
        {0, 0, 1}
    };
    double reflexion_x[][] = {
        {1, 0, 0},
        {0, -1, 0},
        {0, 0, 1}
    };
    double reflexion_y[][] = {
        {-1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
    };
    double reflexion_origen[][] = {
        {0, 1, 0},
        {1, 0, 0},
        {0, 0, 1}
    };
    double reflexion_recta[][] = {
        {-1, 0, 0},
        {0, -1, 0},
        {0, 0, 1}
    };

    public float[][] mTraslacion(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        double mOriginal[][] = {
            {x0, y0, 1},
            {x1, y1, 1},
            {x2, y2, 1},
            {x3, y3, 1},
            {x4, y4, 1},
            {x5, y5, 1}
        };

        float mT[][] = new float[mOriginal.length][traslacion[0].length];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mT[i][j] += (mOriginal[i][k] * traslacion[k][j]);
                }
            }
        }
        return mT;
    }

    public float[][] mEscalacion_mas(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mEs[][] = new float[mOriginal.length][escalacion_mas[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mEs[i][j] += (mOriginal[i][k] * escalacion_mas[k][j]);
                }
            }
        }
        return mEs;
    }

    public float[][] mEscalacion_menos(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mEs[][] = new float[mOriginal.length][escalacion_menos[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mEs[i][j] += (mOriginal[i][k] * escalacion_menos[k][j]);
                }
            }
        }
        return mEs;
    }

    public float[][] mEscalacion_pf(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mEs[][] = new float[mOriginal.length][escalacion_pf[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mEs[i][j] += (mOriginal[i][k] * escalacion_pf[k][j]);
                }
            }
        }
        return mEs;
    }

    public float[][] mRotacion_iz(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mRi[][] = new float[mOriginal.length][rotacion_iz[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mRi[i][j] += (mOriginal[i][k] * rotacion_iz[k][j]);
                }
            }
        }
        return mRi;
    }

    public float[][] mRotacion_der(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mRd[][] = new float[mOriginal.length][rotacion_der[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mRd[i][j] += (mOriginal[i][k] * rotacion_der[k][j]);
                }
            }
        }
        return mRd;
    }

    public float[][] mRotacion_pf(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mRpf[][] = new float[mOriginal.length][rotacion_pf[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mRpf[i][j] += (mOriginal[i][k] * rotacion_pf[k][j]);
                }
            }
        }
        return mRpf;
    }

    public float[][] mCorte_hor(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mCh[][] = new float[mOriginal.length][corte_hor[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mCh[i][j] += (mOriginal[i][k] * corte_hor[k][j]);
                }
            }
        }
        return mCh;
    }

    public float[][] mCorte_ver(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mCv[][] = new float[mOriginal.length][corte_ver[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mCv[i][j] += (mOriginal[i][k] * corte_ver[k][j]);
                }
            }
        }
        return mCv;
    }

    public float[][] mReflexion_x(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mR[][] = new float[mOriginal.length][reflexion_x[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mR[i][j] += (mOriginal[i][k] * reflexion_x[k][j]);
                }
            }
        }
        return mR;
    }

    public float[][] mReflexion_y(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mR[][] = new float[mOriginal.length][reflexion_y[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mR[i][j] += (mOriginal[i][k] * reflexion_y[k][j]);
                }
            }
        }
        return mR;
    }

    public float[][] mReflexion_origen(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mR[][] = new float[mOriginal.length][reflexion_origen[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mR[i][j] += (mOriginal[i][k] * reflexion_origen[k][j]);
                }
            }
        }
        return mR;
    }

    public float[][] mReflexion_recta(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mR[][] = new float[mOriginal.length][reflexion_recta[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mR[i][j] += (mOriginal[i][k] * reflexion_recta[k][j]);
                }
            }
        }
        return mR;
    }

     public float[][] rotacion_iz(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5) {
        float mOriginal[][] = mTraslacion(x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);

        float mRi[][] = new float[mOriginal.length][rotacion_iz[0].length];
        for (int i = 0; i < mOriginal.length; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    mRi[i][j] += (mOriginal[i][k] * rotacion_iz[k][j]);
                }
            }
        }
        return mRi;
    }

}
