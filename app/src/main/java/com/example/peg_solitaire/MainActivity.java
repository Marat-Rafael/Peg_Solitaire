package com.example.peg_solitaire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    TextView textView00,textView01,textView02,textView03,textView04,textView05,textView06;
//    TextView textView10,textView11,textView12,textView13,textView14,textView15,textView16;
//    TextView textView20,textView21,textView22,textView23,textView24,textView25,textView26;
//    TextView textView30,textView31,textView32,textView33,textView34,textView35,textView36;
//    TextView textView40,textView41,textView42,textView43,textView44,textView45,textView46;
//    TextView textView50,textView51,textView52,textView53,textView54,textView55,textView56;
//    TextView textView60,textView61,textView62,textView63,textView64,textView65,textView66;

    // 0 - inactivo
    // 1 - casilla ocupada
    // 2 - casilla vacia
//    public int[][] matrix = new int[][]{
//            {0,0,1,1,1,0,0},
//            {0,0,1,1,1,0,0},
//            {0,0,1,1,1,0,0},
//            {0,0,1,2,1,0,0},
//            {0,0,1,1,1,0,0},
//            {0,0,1,1,1,0,0},
//            {0,0,1,1,1,0,0},
//    };

    public TextView[][] matrixTextView;

    public ArrayList<TextView> arrayListCasillasJugables;
    public ArrayList<TextView> arrayListCassillasVacias;
    public ArrayList<TextView> arrayListCassillasSaltoPermitido;

    public TextView casillaElegida;

    public static boolean casillaEligida = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListCasillasJugables = new ArrayList<>();
        arrayListCassillasVacias = new ArrayList<>();
        arrayListCassillasSaltoPermitido = new ArrayList<>();

        // creamos matriz
        matrixTextView = new TextView[][]{
                {findViewById(R.id.tv_00), findViewById(R.id.tv_01), findViewById(R.id.tv_02), findViewById(R.id.tv_03), findViewById(R.id.tv_04), findViewById(R.id.tv_05), findViewById(R.id.tv_06)},
                {findViewById(R.id.tv_10), findViewById(R.id.tv_11), findViewById(R.id.tv_12), findViewById(R.id.tv_13), findViewById(R.id.tv_14), findViewById(R.id.tv_15), findViewById(R.id.tv_16)},
                {findViewById(R.id.tv_20), findViewById(R.id.tv_21), findViewById(R.id.tv_22), findViewById(R.id.tv_23), findViewById(R.id.tv_24), findViewById(R.id.tv_25), findViewById(R.id.tv_26)},
                {findViewById(R.id.tv_30), findViewById(R.id.tv_31), findViewById(R.id.tv_32), findViewById(R.id.tv_33), findViewById(R.id.tv_34), findViewById(R.id.tv_35), findViewById(R.id.tv_36)},
                {findViewById(R.id.tv_40), findViewById(R.id.tv_41), findViewById(R.id.tv_42), findViewById(R.id.tv_43), findViewById(R.id.tv_44), findViewById(R.id.tv_45), findViewById(R.id.tv_46)},
                {findViewById(R.id.tv_50), findViewById(R.id.tv_51), findViewById(R.id.tv_52), findViewById(R.id.tv_53), findViewById(R.id.tv_54), findViewById(R.id.tv_55), findViewById(R.id.tv_56)},
                {findViewById(R.id.tv_60), findViewById(R.id.tv_61), findViewById(R.id.tv_62), findViewById(R.id.tv_63), findViewById(R.id.tv_64), findViewById(R.id.tv_65), findViewById(R.id.tv_66)},
        };

        juegoBase();

    }

    /**
     * metodo que contiene todos metodos del juego
     */
    public void juegoBase() {
        llenarMatrix();
        eliminarCasillasEsquina();
        generarCasillaVaciaEnCentro();
        buscarTodasCasillasJugables();
        detectarPulsada();

        // hay que volver a buscar casillas jugables, NO VA BE !?
        buscarTodasCasillasJugables();

    }


//    public void identificarTextView(){
//        textView00 = findViewById(R.id.tv_00);
//        textView01 = findViewById(R.id.tv_01);
//        textView02 = findViewById(R.id.tv_02);
//        textView03 = findViewById(R.id.tv_03);
//        textView04 = findViewById(R.id.tv_04);
//        textView05 = findViewById(R.id.tv_05);
//        textView06 = findViewById(R.id.tv_06);
//
//        textView10 = findViewById(R.id.tv_10);
//        textView11 = findViewById(R.id.tv_11);
//        textView12 = findViewById(R.id.tv_12);
//        textView13 = findViewById(R.id.tv_13);
//        textView14 = findViewById(R.id.tv_14);
//        textView15 = findViewById(R.id.tv_15);
//        textView16 = findViewById(R.id.tv_16);
//
//        textView20 = findViewById(R.id.tv_20);
//        textView21 = findViewById(R.id.tv_21);
//        textView22 = findViewById(R.id.tv_22);
//        textView23 = findViewById(R.id.tv_23);
//        textView24 = findViewById(R.id.tv_24);
//        textView25 = findViewById(R.id.tv_25);
//        textView26 = findViewById(R.id.tv_26);
//
//        textView30 = findViewById(R.id.tv_30);
//        textView31 = findViewById(R.id.tv_31);
//        textView32 = findViewById(R.id.tv_32);
//        textView33 = findViewById(R.id.tv_33);
//        textView34 = findViewById(R.id.tv_34);
//        textView35 = findViewById(R.id.tv_35);
//        textView36 = findViewById(R.id.tv_36);
//
//        textView40 = findViewById(R.id.tv_40);
//        textView41 = findViewById(R.id.tv_41);
//        textView42 = findViewById(R.id.tv_42);
//        textView43 = findViewById(R.id.tv_43);
//        textView44 = findViewById(R.id.tv_44);
//        textView45 = findViewById(R.id.tv_45);
//        textView46 = findViewById(R.id.tv_46);
//
//        textView50 = findViewById(R.id.tv_50);
//        textView51 = findViewById(R.id.tv_51);
//        textView52 = findViewById(R.id.tv_52);
//        textView53 = findViewById(R.id.tv_53);
//        textView54 = findViewById(R.id.tv_54);
//        textView55 = findViewById(R.id.tv_55);
//        textView56 = findViewById(R.id.tv_56);
//
//        textView60 = findViewById(R.id.tv_60);
//        textView61 = findViewById(R.id.tv_61);
//        textView62 = findViewById(R.id.tv_62);
//        textView63 = findViewById(R.id.tv_63);
//        textView64 = findViewById(R.id.tv_64);
//        textView65 = findViewById(R.id.tv_65);
//        textView66 = findViewById(R.id.tv_66);
//
//    }


    public void crearMatrix() {
        matrixTextView = new TextView[][]{
                {findViewById(R.id.tv_00), findViewById(R.id.tv_01), findViewById(R.id.tv_02), findViewById(R.id.tv_03), findViewById(R.id.tv_04), findViewById(R.id.tv_05), findViewById(R.id.tv_06)},
                {findViewById(R.id.tv_10), findViewById(R.id.tv_11), findViewById(R.id.tv_12), findViewById(R.id.tv_13), findViewById(R.id.tv_14), findViewById(R.id.tv_15), findViewById(R.id.tv_16)},
                {findViewById(R.id.tv_20), findViewById(R.id.tv_21), findViewById(R.id.tv_22), findViewById(R.id.tv_23), findViewById(R.id.tv_24), findViewById(R.id.tv_25), findViewById(R.id.tv_26)},
                {findViewById(R.id.tv_30), findViewById(R.id.tv_31), findViewById(R.id.tv_32), findViewById(R.id.tv_33), findViewById(R.id.tv_34), findViewById(R.id.tv_35), findViewById(R.id.tv_36)},
                {findViewById(R.id.tv_40), findViewById(R.id.tv_41), findViewById(R.id.tv_42), findViewById(R.id.tv_43), findViewById(R.id.tv_44), findViewById(R.id.tv_45), findViewById(R.id.tv_46)},
                {findViewById(R.id.tv_50), findViewById(R.id.tv_51), findViewById(R.id.tv_52), findViewById(R.id.tv_53), findViewById(R.id.tv_54), findViewById(R.id.tv_55), findViewById(R.id.tv_56)},
                {findViewById(R.id.tv_60), findViewById(R.id.tv_61), findViewById(R.id.tv_62), findViewById(R.id.tv_63), findViewById(R.id.tv_64), findViewById(R.id.tv_65), findViewById(R.id.tv_66)},
        };
    }

    public void llenarMatrix() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                cambiarBackground(matrixTextView[i][j], R.drawable.casilla_rellena);
                matrixTextView[i][j].setText(i + " " + j);
            }
        }
    }

    public void eliminarCasillasEsquina() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                // primera esquina
                if ((i == 0 && j == 0) || (i == 0 && j == 1) || (i == 1 && j == 1) || (i == 1 && j == 0)) {
                    convertirCasilla_A_Disable(matrixTextView[i][j]);
                }
                // segunda esquina
                if ((i == 0 && j == 5) || (i == 0 && j == 6) || (i == 1 && j == 5) || (i == 1 && j == 6)) {
                    convertirCasilla_A_Disable(matrixTextView[i][j]);
                }
                // tercera esquina
                if ((i == 5 && j == 0) || (i == 5 && j == 1) || (i == 6 && j == 0) || (i == 6 && j == 1)) {
                    convertirCasilla_A_Disable(matrixTextView[i][j]);
                }
                // cuarta esquina
                if ((i == 5 && j == 5) || (i == 5 && j == 6) || (i == 6 && j == 5) || (i == 6 && j == 6)) {
                    convertirCasilla_A_Disable(matrixTextView[i][j]);
                }
            }
        }

    }


    public void generarCasillaVaciaEnCentro() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                if ((i == 3 && j == 3) && (matrixTextView[i][j].isEnabled())) {
                    convertirCasilla_A_Vacia(matrixTextView[i][j]);
                    arrayListCassillasVacias.add(matrixTextView[i][j]);
                }
            }
        }
    }


    public void buscarTodasCasillasJugables() {
        comprobarDosProximasCasillas_I();
        comprobarDosProximasCasillas_J();
        comprobarDosAnterioresCasillas_I();
        comprobarDosAnterioresCasillas_J();
    }

    /**
     * recorremos matris y comparamos todos 'i'
     * comprabamos si casilla esta vacia ( background casilla_vacia ) y si es asi
     * miramos PROXIMOS dos, si ambas son llenas de color ( background casilla_rellena )
     * la segunda, despues de vacia ( i + 2 ) marcamos como casilla que puede jugar ( background casilla_jugable )
     * < 0 1 1 >
     */
    public void comprobarDosProximasCasillas_I() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                // para comparar drawable usamos getConstantState !!!
                // aqui buscamos casilla vacia comparando lo que esta en background
                if (matrixTextView[i][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_vacia, null).getConstantState())) {
                    // Toast.makeText(this, "casilla libre " + i + j, Toast.LENGTH_SHORT).show();
                    // comprobamos que i + 2 no sale fuera de la matriz y es casilla activa
                    if ((i + 2 < matrixTextView.length) && (matrixTextView[i + 2][j].isEnabled())) {
                        // comparamos que la proxima i esta llena
                        if (matrixTextView[i + 1][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                            // comparamos que si casilla tiene background de llena - asi que sin disponible para jugar
                            if (matrixTextView[i + 2][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                                convertirCasilla_A_Jugable(matrixTextView[i + 2][j]);
                                //animarRotate(matrixTextView[i+2][j]);
                                arrayListCasillasJugables.add(matrixTextView[i + 2][j]);

                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * recorremos matris y comparamos todos 'i'
     * comprabamos si casilla esta vacia ( background casilla_vacia ) y si es asi
     * miramos dos ANTERIORES, si ambas son llenas de color ( background casilla_rellena )
     * la segunda, despues de vacia (i - 2) marcamos como casilla que puede jugar ( background casilla_jugable )
     * < 1 1 0 >
     */
    public void comprobarDosAnterioresCasillas_I() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                // para comparar drawable usamos getConstantState !!!
                // aqui buscamos casilla vacia
                if (matrixTextView[i][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_vacia, null).getConstantState())) {
                    // Toast.makeText(this, "casilla libre " + i + j, Toast.LENGTH_SHORT).show();
                    // comprobamos que la casiila no sale del campo y es enabled
                    if ((i - 2 >= 0) && matrixTextView[i - 2][j].isEnabled()) {
                        // comparamos que la proxima i esta llena
                        if (matrixTextView[i - 1][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                            // comparamos que segunda i esta llena, es la casiila que puede ser jugada
                            if (matrixTextView[i - 2][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                                convertirCasilla_A_Jugable(matrixTextView[i - 2][j]);
                                // animarRotate(matrixTextView[i-2][j]);
                                arrayListCasillasJugables.add(matrixTextView[i - 2][j]);
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * recorremos matris y comparamos todos 'J'
     * comprabamos si casilla esta vacia ( background casilla_vacia ) y si es asi
     * miramos PROXIMAS dos, si ambas son llenas de color ( background casilla_rellena )
     * la segunda, despues de vacia ( j + 2 ) marcamos como casilla que puede jugar ( background casilla_jugable )
     * < 0 >
     * < 1 >
     * < 1 >
     */
    public void comprobarDosProximasCasillas_J() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                // para comparar drawable usamos getConstantState !!!
                // aqui buscamos casilla vacia
                if (matrixTextView[i][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_vacia, null).getConstantState())) {
                    // Toast.makeText(this, "casilla libre " + i + j, Toast.LENGTH_SHORT).show();
                    // comprobamos que no sale del campo y isEnabled
                    if ((j + 2 < matrixTextView[0].length) && (matrixTextView[i][j + 2].isEnabled())) {
                        // comparamos que la proxima i esta llena
                        if (matrixTextView[i][j + 1].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                            // comparamos que segunda i esta llena, es la casiila que puede ser jugada
                            if (matrixTextView[i][j + 2].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                                convertirCasilla_A_Jugable(matrixTextView[i][j + 2]);
                                // animarRotate(matrixTextView[i][j + 2]);
                                arrayListCasillasJugables.add(matrixTextView[i][j + 2]);
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * recorremos matris y comparamos todos 'J'
     * comprabamos si casilla esta vacia ( background casilla_vacia ) y si es asi
     * miramos dos ANTERIORES, si ambas son llenas de color ( background casilla_rellena )
     * la segunda, despues de vacia ( j - 2 )  marcamos como casilla que puede jugar ( background casilla_jugable )
     * < 1 >
     * < 1 >
     * < 0 >
     */
    public void comprobarDosAnterioresCasillas_J() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                // para comparar drawable usamos getConstantState !!!
                // aqui buscamos casilla vacia
                if (matrixTextView[i][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_vacia, null).getConstantState())) {
                    // Toast.makeText(this, "casilla libre " + i + j, Toast.LENGTH_SHORT).show();
                    // comprobamos que no sale del campo de juego y isEnabled
                    if ((j - 2 >= 0) && (matrixTextView[i][j - 2].isEnabled())) {
                        // comparamos que la proxima i esta llena
                        if (matrixTextView[i][j - 2].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                            // comparamos que segunda i esta llena, es la casiila que puede ser jugada
                            if (matrixTextView[i][j - 2].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                                convertirCasilla_A_Jugable(matrixTextView[i][j - 2]);
                                // animarRotate(matrixTextView[i][j - 2]);
                                arrayListCasillasJugables.add(matrixTextView[i][j - 2]);
                            }
                        }
                    }
                }
            }
        }
    }

    private void animarRotate(TextView textView) {

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.scale2);
        textView.startAnimation(animation2);

    }

    // metodo obsoleto
    public void detectarCasillaPulsada() {

        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {

                int finalI = i;
                int finalJ = j;

                matrixTextView[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // si es una casilla con dravable casilla_jugable la marcamos de otro color
                        if (matrixTextView[finalI][finalJ].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_jugable, null).getConstantState())) {
                            convertirCasilla_A_Selecionada(matrixTextView[finalI][finalJ]);
                            // otra vez recorremos toda matriz y convertimos resto de jugables en casillas rellenas
                            for (int i = 0; i < matrixTextView.length; i++) {
                                for (int j = 0; j < matrixTextView[0].length; j++) {
                                    if (matrixTextView[finalI][finalJ].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_jugable, null).getConstantState())) {

                                        convertirCasilla_A_Rellenas(matrixTextView[finalI][finalJ]);
                                    }
                                }

                            }

                        }
                    }
                });
            }
        }


    }

    public void detectarPulsada() {
        for (int i = 0; i < arrayListCasillasJugables.size(); i++) {

            int finalI = i;
            arrayListCasillasJugables.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // casilla elegida coje valor de la casilla pulsada
                    casillaElegida = findViewById(arrayListCasillasJugables.get(finalI).getId());

                    // resto de casillas vonvertimos en casillas rellenas
                    for (int i = 0; i < arrayListCasillasJugables.size(); i++) {
                        convertirCasilla_A_Rellenas(arrayListCasillasJugables.get(i));
                    }
                    // convertimos en la casilla_selecionada
                    convertirCasilla_A_Selecionada(casillaElegida);

                    // quitamos a listaDecasiilasJugables listener
                    eliminarListenerAlArrayList(arrayListCasillasJugables);

                    calcularMovimientosDisponiblesParaCasillaElegida();

                }
            });
        }
    }

    /**
     * Al arrayList borramos  OnClicklistener
     *
     * @param arrayList
     */
    public void eliminarListenerAlArrayList(ArrayList<TextView> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setOnClickListener(null);
        }
    }

    private void calcularMovimientosDisponiblesParaCasillaElegida() {
        calcularMovimientosDisponibles_I_masDos();
        calcularMovimientosDisponibles_J_masDos();
        calcularMovimientosDisponibles_I_menosDos();
        calcularMovimientosDisponibles_J_menosDos();

    }

    private void calcularMovimientosDisponibles_I_masDos() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                if (matrixTextView[i][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_selecionada, null).getConstantState())) {
                    //comprobamos i + 2, que no sale de la pantalla y esta habilitada
                    if (i + 2 < matrixTextView.length) {
                        // comprobamos primera casilla. tiene que ser rellena
                        if (matrixTextView[i + 1][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                            // comprobamos que la segunda casilla esta libre
                            if (matrixTextView[i + 2][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_vacia, null).getConstantState())) {
                                matrixTextView[i + 2][j].setBackgroundResource(R.drawable.casilla_salto_permitido);
                                // añadimos al arrayDeSaltoPermitido para poner a la escucha
                                arrayListCassillasSaltoPermitido.add(matrixTextView[i + 2][j]);
                                // realizamos movimiento
                                realizarSalto();
                            }
                        }
                    }
                }
            }
        }
    }

    private void calcularMovimientosDisponibles_I_menosDos() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                if (matrixTextView[i][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_selecionada, null).getConstantState())) {
                    //comprobamos i - 2, que no sale de la pantalla y esta habilitada
                    if (i - 2 >= 0) {
                        // comprobamos primera casilla. tiene que ser rellena
                        if (matrixTextView[i - 1][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                            // comprobamos que la segunda casilla esta libre
                            if (matrixTextView[i - 2][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_vacia, null).getConstantState())) {
                                matrixTextView[i - 2][j].setBackgroundResource(R.drawable.casilla_salto_permitido);
                                // añadimos al arrayDeSaltoPermitido para poner a la escucha
                                arrayListCassillasSaltoPermitido.add(matrixTextView[i - 2][j]);
                                // realizamos movimiento
                                realizarSalto();

                            }
                        }
                    }
                }
            }
        }
    }

    private void calcularMovimientosDisponibles_J_masDos() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                if (matrixTextView[i][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_selecionada, null).getConstantState())) {
                    //comprobamos i + 2, que no sale de la pantalla y esta habilitada
                    if (j + 2 < matrixTextView[0].length) {
                        // comprobamos primera casilla. tiene que ser rellena
                        if (matrixTextView[i][j + 1].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                            // comprobamos que la segunda casilla esta libre
                            if (matrixTextView[i][j + 2].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_vacia, null).getConstantState())) {
                                matrixTextView[i][j + 2].setBackgroundResource(R.drawable.casilla_salto_permitido);
                                // añadimos al arrayDeSaltoPermitido para poner a la escucha
                                arrayListCassillasSaltoPermitido.add(matrixTextView[i][j + 2]);
                                // realizamos movimiento
                                realizarSalto();

                            }
                        }
                    }
                }
            }
        }
    }

    private void calcularMovimientosDisponibles_J_menosDos() {
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                if (matrixTextView[i][j].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_selecionada, null).getConstantState())) {
                    //comprobamos j - 2, que no sale de la pantalla y esta habilitada
                    if (j - 2 >= 0) {
                        // comprobamos primera casilla. tiene que ser rellena
                        if (matrixTextView[i][j - 1].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_rellena, null).getConstantState())) {
                            // comprobamos que la segunda casilla esta libre
                            if (matrixTextView[i][j - 2].getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.casilla_vacia, null).getConstantState())) {
                                matrixTextView[i][j - 2].setBackgroundResource(R.drawable.casilla_salto_permitido);
                                // añadimos al arrayDeSaltoPermitido para poner a la escucha
                                arrayListCassillasSaltoPermitido.add(matrixTextView[i][j - 2]);
                                // realizamos movimiento
                                realizarSalto();

                            }
                        }
                    }
                }
            }
        }
    }

    private void realizarSalto() {

        for (int i = 0; i < arrayListCassillasSaltoPermitido.size(); i++) {
            arrayListCassillasSaltoPermitido.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // recoremos matriz para identificar casilla del origen
                    int[] coordenadasOrigen = identificarCasillaEnMatriz(casillaElegida);
                    // recorremos matrix para identificar casilla del destino
                    int[] coordenadasDestino = identificarCasillaEnMatriz(view);

                    int[] coordenadasCasillaBorrar = devuelveCasillaParaBorrar(coordenadasOrigen,coordenadasDestino);
                    // repintamos  background de los tres a vacio
                    matrixTextView[coordenadasCasillaBorrar[0]][coordenadasCasillaBorrar[1]].setBackgroundResource(R.drawable.casilla_vacia);
                    matrixTextView[coordenadasOrigen[0]][coordenadasOrigen[1]].setBackgroundResource(R.drawable.casilla_vacia);
                    matrixTextView[coordenadasDestino[0]][coordenadasDestino[1]].setBackgroundResource(R.drawable.casilla_vacia);

                }
            });
        }

    }

    public int[] devuelveCasillaParaBorrar(int[] origen, int[] destino) {
        int i_origen = origen[0];
        int j_origen = origen[1];

        int i_destino = destino[0];
        int j_destino = destino[1];

        int i_resultado = -1;
        int j_resultado = -1;

        int[] listaCoordenadasAdevolver = new int[2];

        if (i_origen == i_destino) { // estamos en la misma fila
            i_resultado = i_origen;
            if (j_origen > j_destino) {
                j_resultado = j_origen - 1;
            } else {
                j_resultado = j_origen + 1;
            }
        } else if (j_origen == j_destino) { // estan en la misma columna
            j_resultado = j_origen;
            if (i_origen > i_destino) {
                i_resultado = i_origen - 1;
            } else {
                i_resultado = i_origen + 1;
            }
        }
        listaCoordenadasAdevolver[0] = i_resultado;
        listaCoordenadasAdevolver[1] = j_resultado;
        return listaCoordenadasAdevolver;
    }


    /**
     * metodo para identificar una casilla en el matriz
     *
     * @param view vista
     * @return devuelve vector coordenadas
     */
    private int[] identificarCasillaEnMatriz(View view) {
        int[] listacoordenadas = new int[2];
        for (int i = 0; i < matrixTextView.length; i++) {
            for (int j = 0; j < matrixTextView[0].length; j++) {
                if (matrixTextView[i][j].getId() == view.getId()) {
                    listacoordenadas[0] = i;
                    listacoordenadas[1] = j;
                }
            }
        }
        // mostrarToast("i=" + listacoordenadas[0] + " j=" + listacoordenadas[1]);
        return listacoordenadas;
    }


    private void cambiarBackground(@NonNull TextView textView, int idRes) {
        textView.setBackgroundResource(idRes);
    }

    public void convertirCasilla_A_Rellenas(TextView textView) {
        cambiarBackground(textView, R.drawable.casilla_rellena);
    }

    public void convertirCasilla_A_Vacia(TextView textView) {
        cambiarBackground(textView, R.drawable.casilla_vacia);
    }

    public void convertirCasilla_A_Jugable(TextView textView) {
        cambiarBackground(textView, R.drawable.casilla_jugable);
    }

    public void convertirCasilla_A_Selecionada(TextView textView) {
        cambiarBackground(textView, R.drawable.casilla_selecionada);
    }

    private void convertirCasilla_A_Disable(TextView textView) {
        textView.setBackgroundColor(Color.GRAY);
        textView.setEnabled(false);
    }

    public void mostrarToast(String texto) {
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
    }

}

/*

                                if (matrixTextView[i][j].getId() == v.getId()) {            // casilla destino
                                    destino_i = i;
                                    destino_j = j;
                                        mostrarToast("i="+i+" j="+j);
                                    mostrarToast("i="+destino_i+" j="+destino_j);
                                    if (origin_i == destino_i) { // si i son iguales estan en la misma linea, comparamos j(columna)
                                        borrar_i = origin_i;
                                        if (origen_j > destino_j) {
                                            borrar_j = origen_j - 1;
                                        } else {
                                            borrar_j = destino_j + 1;
                                        }

                                    } else if (origen_j == destino_j) { // si j son iguales estan en la misma columna
                                        borrar_j = origen_j;
                                        if (origen_j > destino_j) {
                                            borrar_j = origen_j - 1;
                                        } else {
                                            borrar_j = origen_j + 1;
                                        }

                                    }
                                    String string = "i="+borrar_i+" j="+borrar_j;
                                    Toast.makeText(getApplicationContext(), "hola", Toast.LENGTH_SHORT).show();
                                    matrixTextView[borrar_i][borrar_j].setBackgroundResource(R.drawable.casilla_vacia);
                                }
 */