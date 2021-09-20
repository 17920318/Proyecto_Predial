import org.junit.Test
import kotlin.collections.ArrayList
import java.time.LocalDate


class Persona(nombre: String, fechaNacimiento: String, madreSoltera: Boolean) { //clase persona y sus parametros

    public val nombrePersona = nombre //atributos tipo publico para tener un acceso mas facil a ellos
    public val fechaNac = fechaNacimiento
    public val esMadreSoltera = madreSoltera //se crea un atributo tipo bolean para ingresar si es verdadero o falso  que es madre soltera
    public var edad = this.calcularEdad() //inicializamos la funcion calcularEdad

    var terrenos: ArrayList<Terreno> =
        arrayListOf()//se crea un array donde obtengan los datos de su clase

    fun calcularEdad(): Int {

        val fechaNacimiento = LocalDate.parse(this.fechaNac) //se crea val tipo localDate
        print(fechaNacimiento)
        val fechaActual = LocalDate.now()// el now es para indicar que es la fecha de ahora
        print(fechaActual)
        val edad =
            fechaActual.getYear() - fechaNacimiento.getYear() //se realiza la operacion de resta
        print(edad)
        return edad //se imprime
    }

}







