package POO_Santander_Coders.Exercicios.Solid

fun main(args: Array<String>) {

}

fun interface DataSource{
    fun getDataSource()
}

//Cada função podem implementar uma interface funcional também
internal fun createDataSource(): DataSource = TODO("Provide a datasource")


//Outro Exemplo


abstract class Robot(
    open var nameRobot:String,
    open var color:String
)

data class SimpleRobot(
    override var nameRobot: String,
    override var color: String,
    override val aim: Int
): Robot(nameRobot, color),
    RobotAim {
    override fun aimRobot() {
        TODO("Not yet implemented")
    }
}

//Neste caso utilizar se todas as outras interfaces tiverem algo em comum
interface IRobot{
}

interface RobotAim:IRobot{
    val aim:Int
    fun aimRobot()
}

interface RobotSpin{
    val rotation:Int
    fun rotateArms()
}

interface RobotAntenna{
    val widthAntenna:Int
    fun wiggleAntenna()
}