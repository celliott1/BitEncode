/**
 * Created by Chris on 11/1/2016.
 *
 * Program for encoding Genome Sequences using BitSets
 *
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import static java.lang.System.out;
import java.util.BitSet;
import java.lang.String;


public class BitEncode {
    public static void main(String[] args)throws IOException {
        BitEncode BE = new BitEncode();
        Scanner input = new Scanner(System.in);
        out.println("Please enter the name of the Genome Sequence File. Please include \".txt\"");
        String filename = input.nextLine();
        StringBuilder genome = BE.reader(filename);

        BE.encode1(genome);
        BE.encode2(genome);

    }
    public StringBuilder reader(String file_name)throws IOException{
        StringBuilder genome = new StringBuilder();
        Path way = Paths.get(file_name);
        Charset set = StandardCharsets.UTF_8;
        Scanner reader =  new Scanner(way, set.name());
            while (reader.hasNextLine()) {
                genome.append(reader.nextLine());
            }
        return genome;
    }

    public void encode1(StringBuilder genome){
        BitSet engene = new BitSet();
        int counter = 0;
        int ones = 0;

        for(int i = 0; i < (genome.length()); i++){
            if(genome.charAt(i) == 'A'){
                engene.set(counter,false);
                counter ++;
                engene.set(counter,false);
                counter ++;
            }
            if(genome.charAt(i) == 'C'){
                engene.set(counter,false);
                counter ++;
                engene.set(counter,true);
                counter ++;
                ones ++;
            }
            if(genome.charAt(i) == 'G'){
                engene.set(counter,true);
                counter ++;
                ones ++;
                engene.set(counter,false);
                counter ++;
            }
            if(genome.charAt(i) == 'T'){
                engene.set(counter,true);
                counter ++;
                ones ++;
                engene.set(counter,true);
                counter ++;
                ones ++;
            }
        }
        out.println("Encoding Method 1");
        out.println("The amount of the number '1' in the sequence is: " + ones);
        out.println("The amount of bits in use for the sequence is: " + genome.length()*2);
}

   public void encode2(StringBuilder genome) {
       BitSet engene = new BitSet();
       int counter = 0;
       int counter2 = counter + 1;
       int loop = 0;
       int ones = 0;

       for (int i = 0; i < (genome.length()); i++) {
           if (genome.charAt(i) == 'A') {
               counter2 = counter + 1;
               loop = 0;
               engene.set(counter, false);
               counter++;
               engene.set(counter, false);
               counter++;
               while (counter2 < genome.length() && genome.charAt(counter2) == 'A' && loop != 3) {
                   counter2++;
                   loop++;
                   i++;
               }
               if (loop == 0) {
                   engene.set(counter, false);
                   counter++;
                   engene.set(counter, true);
                   counter++;
                   ones++;
               } else if (loop == 1) {
                   engene.set(counter, true);
                   counter++;
                   ones++;
                   engene.set(counter, false);
                   counter++;
               } else if (loop == 2) {
                   engene.set(counter, true);
                   counter++;
                   ones++;
                   engene.set(counter, true);
                   counter++;
                   ones++;
               } else if (loop == 3) {
                   engene.set(counter, false);
                   counter++;
                   engene.set(counter, false);
                   counter++;
               }
           } else if (genome.charAt(i) == 'C') {
               counter2 = counter + 1;
               loop = 0;
               engene.set(counter, false);
               counter++;
               engene.set(counter, true);
               counter++;
               ones++;
               while (counter2 < genome.length() && genome.charAt(counter2) == 'C' && loop != 3) {
                   counter2++;
                   loop++;
                   i++;
               }
               if (loop == 0) {
                   engene.set(counter, false);
                   counter++;
                   engene.set(counter, true);
                   counter++;
                   ones++;
               } else if (loop == 1) {
                   engene.set(counter, true);
                   counter++;
                   ones++;
                   engene.set(counter, false);
                   counter++;
               } else if (loop == 2) {
                   engene.set(counter, true);
                   counter++;
                   ones++;
                   engene.set(counter, true);
                   counter++;
                   ones++;
               } else if (loop == 3) {
                   engene.set(counter, false);
                   counter++;
                   engene.set(counter, false);
                   counter++;
               }
           } else if (genome.charAt(i) == 'G') {
               counter2 = counter + 1;
               loop = 0;
               engene.set(counter, true);
               counter++;
               ones++;
               engene.set(counter, false);
               counter++;
               while (counter2 < genome.length() && genome.charAt(counter2) == 'G' && loop != 3) {
                   counter2++;
                   loop++;
                   i++;
               }
               if (loop == 0) {
                   engene.set(counter, false);
                   counter++;
                   engene.set(counter, true);
                   counter++;
                   ones++;
               } else if (loop == 1) {
                   engene.set(counter, true);
                   counter++;
                   ones++;
                   engene.set(counter, false);
                   counter++;
               } else if (loop == 2) {
                   engene.set(counter, true);
                   counter++;
                   ones++;
                   engene.set(counter, true);
                   counter++;
                   ones++;
               } else if (loop == 3) {
                   engene.set(counter, false);
                   counter++;
                   engene.set(counter, false);
                   counter++;
               }
           } else if (genome.charAt(i) == 'T') {
               counter2 = counter + 1;
               loop = 0;
               engene.set(counter, true);
               counter++;
               ones++;
               engene.set(counter, true);
               counter++;
               ones++;
               while (counter2 < genome.length() && genome.charAt(counter2) == 'T' && loop != 3) {
                   counter2++;
                   loop++;
                   i++;
               }
               if (loop == 0) {
                   engene.set(counter, false);
                   counter++;
                   engene.set(counter, true);
                   counter++;
                   ones++;
               } else if (loop == 1) {
                   engene.set(counter, true);
                   counter++;
                   ones++;
                   engene.set(counter, false);
                   counter++;
               } else if (loop == 2) {
                   engene.set(counter, true);
                   counter++;
                   ones++;
                   engene.set(counter, true);
                   counter++;
                   ones++;
               } else if (loop == 3) {
                   engene.set(counter, false);
                   counter++;
                   engene.set(counter, false);
                   counter++;
               }
           }
       }
       out.println("---------------------");
       out.println("Encoding Method 2");
       out.println("The amount of the number '1' in the sequence is: " + ones);
       out.println("The amount of bits in use for the sequence is: " + counter);
   }
}