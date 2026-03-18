package edl.fila.exercicios;
public class q6 {
    public static void main(String[] args){
        Fila fila_pacientes = new Fila(1);
        for(char i = 'a'; i < 'h'; i++){
            fila_pacientes.enfileirar(i);
        }
        fila_pacientes.desenfileirar();
        System.out.println("Próximo paciente:");
        System.out.println(fila_pacientes.inicio());
        System.out.println("Pacientes na fila:");
        System.out.println(fila_pacientes.tamanho());
    }
}
