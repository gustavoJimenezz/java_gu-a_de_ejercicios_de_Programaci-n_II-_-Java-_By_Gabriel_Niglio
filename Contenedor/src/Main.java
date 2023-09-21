public class Main {
    public static void main(String[] args) {

        ContenedorString miContenedor = new ContenedorString();

        miContenedor.agregarElemento("Pepe");
        miContenedor.agregarElemento("Gabriel");
        miContenedor.agregarElemento("Gabriela");

        for (int i = 0; i < miContenedor.getCantElemento(); i++) {
            System.out.println(miContenedor.getElemento(i));
        }

    }
}