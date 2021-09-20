import org.junit.Test
import java.time.LocalDate

class Predial(persona: Persona, zonas: Zonas) { //predial solicita los datos de persona y zona
    public var tamaño = 0.0
    public var descuento = 0.0

    var Personas: ArrayList<Persona> = arrayListOf()//se crea un array persona

    var zonas = arrayOf( //se agrega un array zona donde insertamos los datos del catalogo
        Zonas(clave = "MAR", zona = "Marginado", costo = 2.00),
        Zonas(clave = "RUR", zona = "Rural", costo = 8.00),
        Zonas(clave = "URB", zona = "Urbano", costo = 10.00),
        Zonas(clave = "RES", zona = "Residencial", costo = 25.00)
    )

    fun calcularDescuento(persona: Persona, mes: Int): Double {//en este metodo se calcula la edad, descuento y si es madre soltera
        var edad = persona.calcularEdad() //se crea variable edad y pide prestado el metodo calcularEdad de la clase persona

        val madreSoltera = persona.esMadreSoltera // la val madreSoltera es llamada de la clase persona
        if (edad >= 70 && mes <= 2 || madreSoltera.equals(true) && mes <= 2) { //si edad es mayor o igual a 70 años y mes es <= a 2 (2 indica los meses enero y febrero, omadreSoltera es "TRUE" en este caso verdadero y el mes debe ser <=2 (enero y febrero)
            println(" " + "Tendra un descuento de 70%") //tendra un descuento
            descuento = 0.70 //es igual al 70%


        } else if (edad >= 70 && mes > 2 || madreSoltera.equals(true) && mes > 2) { //edad >=70 y mes es mayor a 2 o madreSoltera es TRUE y mes es mayor a 2
            println(" " + "Tendra un descuento del 50%")
            descuento = 0.50 //tiene un descuento del 50%
        }
        else if (edad < 70 && mes <= 2 || madreSoltera.equals(false) && mes <= 2) { // si la edad es menor a 70 y mes es >= 2 o madresoltera es FALSE y mes es >=2
            println(" " + "Tendra un descuento del 40%")
            descuento = 0.40  //tendra un descuento de 40%
        }
        else { //entonces si no se cumple no tendra descuento
            println(" " + "No tendra un descuento ")
            descuento = 0.0
        }

        return descuento //se retorna descuento
    }

    var Predio: ArrayList<Predial> = arrayListOf() //creamos un array predio para mandar a llamar algunos atributos

    fun propiedades(predial: Predial) {
        Predio.add(predial)
    }

    fun calcularImpuesto(terreno: Terreno): Double {//se crea la funcion de impuesto y se manda a llamar a la clase terreno
        var resultado: Double = 0.0 //inicializacion de variable resultado
        zonas.forEach { zona: Zonas ->//recorre todos los elementos del arreglo de el catalogo zonas
            if (zona.clave == terreno.zona) { //si clave de la clase zona es == zona de la clase terreno

                resultado = zona.costo * terreno.tamaño//costo de la clase zona * tamaño de la clase terreno
                return resultado //retorna resultado
            }
        }

        return resultado
    }

    fun calcularImporteFinal(persona: Persona, terreno: Terreno, mes: Int): Double { //se crea funcion importe y se manda a llamar las clases persona y terreno

        var descuentoFinal = calcularDescuento(persona, mes) * calcularImpuesto(terreno) //se calcula descuento de la clase persona y el mes * el impuesto del terreno
        println(" su descuento es: " + descuentoFinal)//se concatena descuentofinal
        println("su importe total es:" + (calcularImpuesto(terreno) - descuentoFinal)) //calcularImpuesto de la clase terreno - descuentofinal

        return calcularImpuesto(terreno) - descuentoFinal //se retorna la operacion
    }


}

/*var Zona: ArrayList<Zonas> = arrayListOf()

fun calcularCosto(zonas: Zonas): Double {
    return zonas.calcularCosto(tamaño)

}*/

/* fun importeTotal(): Double {
     var sumaPredios = 0.0
     Predio.forEach { predial ->
         sumaPredios += predial.calcularCosto()
     }
     return sumaPredios
 }

}
*/