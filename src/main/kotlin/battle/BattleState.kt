package battle

sealed class BattleState {

    object Progress : BattleState(){
        fun info(team1: Team, team2: Team){
            println("""||First team:
                |Total health team = ${team1.totalHealthTeam()}
                |Sum of alive warriors = ${team1.sumAliveWarriors()}
                |${team1.infoAboutTeam}
                |----------------------------
                |||Second team:
                |Total health team = ${team2.totalHealthTeam()}
                |Sum of alive warriors = ${team2.sumAliveWarriors()}
                |${team2.infoAboutTeam}
                |###################################
                |
            """.trimMargin())
        }
    }

    abstract class TheEnd : BattleState()

    object WinFirstTeam : TheEnd()
    object WinSecondTeam : TheEnd()
    object NobodyWin : TheEnd()


}
