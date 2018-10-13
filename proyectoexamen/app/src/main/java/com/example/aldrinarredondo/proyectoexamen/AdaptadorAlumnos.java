package com.example.aldrinarredondo.proyectoexamen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorAlumnos extends RecyclerView.Adapter<AdaptadorAlumnos.AdaptadorAlumnosViewHold>{

    private ArrayList<Alumno> alumnos;
    private ArrayList<Integer> asistencias;

    //private RecyclerViewOnItemClickListener listener;


    public AdaptadorAlumnos(ArrayList<Alumno> alumnos, ArrayList<Integer> asistencias) {
        this.alumnos = alumnos;
        this.asistencias = asistencias;
    }

    @NonNull
    @Override
    public AdaptadorAlumnos.AdaptadorAlumnosViewHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.modelo_alumno, viewGroup, false);
        return new AdaptadorAlumnosViewHold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdaptadorAlumnos.AdaptadorAlumnosViewHold adaptadorAlumosViewHold, final int i) {
        final Alumno alumno = alumnos.get(i);
        adaptadorAlumosViewHold.foto.setImageResource(alumno.getFoto());
        adaptadorAlumosViewHold.nombre.setText(alumno.getNombre());
        adaptadorAlumosViewHold.matricula.setText(alumno.getMatricula());
        adaptadorAlumosViewHold.asistencia.setChecked(alumno.isAsistencia());

        adaptadorAlumosViewHold.asistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alumno.setAsistencia(adaptadorAlumosViewHold.asistencia.isChecked());
                if(alumno.isAsistencia())
                    asistencias.set(i, 1);
                else {
                    asistencias.set(i, 0);
                }

                Log.d("Asistencia: ", ""+asistencias);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public class AdaptadorAlumnosViewHold extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView nombre;
        private TextView matricula;
        private CheckBox asistencia;


        public AdaptadorAlumnosViewHold(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.fotoAlumno);
            nombre = itemView.findViewById(R.id.nombre);
            matricula = itemView.findViewById(R.id.matricula);
            asistencia = itemView.findViewById(R.id.estrella);

        }
    }
}
