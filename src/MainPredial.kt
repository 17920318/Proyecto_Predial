import org.junit.Test
import java.util.Scanner

class MainPredial { //se crea una clase principal donde se mostraran los datos en consola
    @Test //es necesario poner un test para realizar las pruebas necesarias
    fun main() {


        //se obtiene la clase persona, la cual nos dara los datos para calcular el predial
        val persona: Persona =
            Persona(nombre = "Pedro", fechaNacimiento = "1946-12-13", madreSoltera = false)//tambien es necesario mandar a llamar a la clase zona, la cual contiene el catalogo de zonas

        val zona: Zonas = Zonas(clave = "URB", zona = "Urbano", costo = 10.00)

        val predial: Predial = Predial(persona = persona, zonas = zona)  //otra clase principal a llamar seria predial, el cual contiene datos de persona y zona para calcular el impuesto

        persona.terrenos.add(Terreno("RUR", tamaño = 678.0)) //persona necesita obtener los datos de terreno
        println(predial.calcularImpuesto(persona.terrenos.get(0))) //tambien se necesita obtener el metodo calcularDescuento
        // predial.CalcularDescuento(persona = persona,  mes = 1)
        predial.calcularImporteFinal(persona = persona, persona.terrenos.get(0), mes = 1)//se obtiene el metodo calcularImporte


    }


}