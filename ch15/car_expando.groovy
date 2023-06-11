
def carA = new Expando()
def carB = new Expando(year: 2012, miles: 0)
carA.year = 2022
carA.miles = 100

println "carA ${carA}"
println "carB ${carB}"

def carC = new Expando(year: 2012, miles: 0, turn: {println "turning..."})
carC.drive = {
    miles += 10
    println "$miles miles driven"
}
carC.turn()
carC.drive()
carC.drive()