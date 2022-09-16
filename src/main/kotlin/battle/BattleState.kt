package battle

sealed class BattleState {

    object Progress : BattleState(){
        fun info(team1: Team, team2: Team){
            println("""||First team:
                |Total health team = ${team1.totalHealthTeam()}
                |Sum of alive warriors = ${team1.sumAliveWarriors()}
                |----------------------------
                |||Second team:
                |Total health team = ${team2.totalHealthTeam()}
                |Sum of alive warriors = ${team2.sumAliveWarriors()}
            """.trimMargin())
        }
    }

    abstract class TheEnd : BattleState()

    object WinFirstTeam : TheEnd()
    object WinSecondTeam : TheEnd()
    object NobodyWin : TheEnd()

//    data class Progress(val team: battle.Team) : battle.BattleState() {
//        fun getProgress(){
//            println("В команде $team.")
//        }
//    }

}
