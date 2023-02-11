package tecnicasDeProgramacao.aula8.data.model

import tecnicasDeProgramacao.aula8.enum.Gender
import java.time.LocalDate

abstract class Person(
  firstName : String,
  lastName : String,
  birth : LocalDate,
  numTelephone : String,
  gender : Gender,
  email : String
)