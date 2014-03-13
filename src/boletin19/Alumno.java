package boletin19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.swing.JOptionPane;

public class Alumno implements Comparable {

    private String nome;
    private int nota;

    public Alumno() {
    }

    public Alumno(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    public static void introAlumno(ArrayList<Alumno> nomearray) {
        int not;
        String nom;
        String saida = "0";

        do {
            nom = JOptionPane.showInputDialog("Introduce nome do alumno " + (nomearray.size() + 1));
            do {
                not = Integer.parseInt(JOptionPane.showInputDialog("Introduce nota do alumno " + (nomearray.size() + 1)));
                if (not == 0 || not >= 10) {
                    JOptionPane.showMessageDialog(null, "a nota a de estar comprendida entre 1 e 10");
                }
            } while (not == 0 || not >= 10);
            nomearray.add(new Alumno(nom, not));
            saida = (JOptionPane.showInputDialog("0-Sair \nCalquera tecla- introducir outro alumno"));
        } while (saida.compareTo("0") != 0);

    }

    @Override
    public String toString() {
        String res = (" nome: " + nome + " \tnota: " + this.getNota());
        return res;
    }

    public static void verFor(ArrayList<Alumno> nomearray) {
        for (int i = 0; i < nomearray.size(); i++) {
            System.out.println(nomearray.get(i));
        }
        System.out.println("");
    }

    public static void verForeach(ArrayList<Alumno> nomearray) {
        
        for (Alumno i : nomearray) {
            System.out.println(i);
            
        }
        System.out.println("");
    }

    public static void verIterator(ArrayList<Alumno> nomearray) {
        Iterator it = nomearray.iterator(); 
        while (it.hasNext()) 
        {
            System.out.println(it.next());        
        }
        System.out.println("");
    }

    public static void verNota(ArrayList<Alumno> nomearray) {
        int posicion = -1;
        do {
            String nom = JOptionPane.showInputDialog("Introduce nome do alumno do cal queres saber a nota");
            for (int i = 0; i < nomearray.size(); i++) {
                if (nom.equalsIgnoreCase(nomearray.get(i).getNome())) {
                    posicion = i;
                }
            }
            if (posicion == -1) {
                JOptionPane.showMessageDialog(null, "o alumno" + nom + " non está na lista");
            }
        } while (posicion == -1);
        JOptionPane.showMessageDialog(null, nomearray.get(posicion));
          }

    public static void borraAlumno(ArrayList<Alumno> nomearray) {
        int posicion = -1;
        String nom = JOptionPane.showInputDialog("Introduce nome do alumno que queres eliminar");
        Alumno obx = new Alumno(nom, 0);
        
         for (Alumno i : nomearray) {
         if (i.compareTo(obx) == 0) {
         posicion = nomearray.indexOf(i);
         }
         }
         

        if (posicion == -1) {
            JOptionPane.showMessageDialog(null, "o alumno" + nom + " non está na lista");
        } else {
            nomearray.remove(posicion);
            JOptionPane.showMessageDialog(null, "o alumno " + nom + " foi borrado");

  
        }

    }

    public static void ordear(ArrayList<Alumno> nomearray) {
        Collections.sort(nomearray);
 
    }
  
    public static void consultaAlumno(ArrayList<Alumno> nomearray) {
        int posicion = -1;
        String nom = JOptionPane.showInputDialog("Introduce nome do alumno que queres saber se está");
        Alumno obx = new Alumno(nom, 0);
        
         for (Alumno i : nomearray) {
         if (i.compareTo(obx) == 0) {
         posicion = nomearray.indexOf(i);
         }
         }

         if (posicion == -1) {
         JOptionPane.showMessageDialog(null, "o alumno" + nom + " non está na lista");
         } else {
        JOptionPane.showMessageDialog(null, "o alumno " + nomearray.get(posicion) + " está na lista");

         }

    }

    @Override
    public int compareTo(Object o) {
        Alumno al = (Alumno) o;
        if (this.nome.compareToIgnoreCase(al.nome) == 0) {
            return 0;
        } else if (this.nome.compareToIgnoreCase(al.nome) > 0) {
            return 1;
        } else {
            return -1;
        }
    }


  

}