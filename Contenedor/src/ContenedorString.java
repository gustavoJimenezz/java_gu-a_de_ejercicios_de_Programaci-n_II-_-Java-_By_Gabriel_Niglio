public class ContenedorString {
     private int cantElemento;
     private String[] vecElemento;

     public ContenedorString(){
         this.cantElemento = 0;
         this.vecElemento = new String[100];
     }

     public boolean agregarElemento(String elemento){
         int primerPosicionLibre = this.cantElemento;
         this.vecElemento[primerPosicionLibre] = elemento;
         this.incrementarCantidad();
         return true;
     }

     public void incrementarCantidad(){
         this.cantElemento ++;
     }

     public  String getElemento(int posicion){
         return this.vecElemento[posicion];
     }

    public int getCantElemento() {
        return this.cantElemento;
    }

    public boolean hayEspacio(){
         int limiteVec = this.vecElemento.length;
         return this.cantElemento < limiteVec;
     }


}
