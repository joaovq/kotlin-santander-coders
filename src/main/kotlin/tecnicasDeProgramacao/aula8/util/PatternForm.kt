package tecnicasDeProgramacao.aula8.util

enum class PatternForm(val pattern:String) {
    CPF("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$"),
    RG("^\\d{2}\\.\\d{3}\\.\\d{3}-\\d{2}$"),
    EMAIL("^[a-zA-Z\\d^~'`]{3,30}@[a-zA-Z\\d]{3,30}\\.com" +
            "|[a-zA-Z0-9^~'`]{3,30}@[a-zA-Z\\d]{3,30}\\.com\\.br$"),
    BIRTH("dd/MM/yyyy"),
    TELEPHONE("\\(\\d{2}\\)\\s9\\d{4}-\\d{4}")
}
