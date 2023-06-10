
langs = ['C++': 'Stroustrup', 'Java': 'Goslign', 'Lisp': 'McCarthy']
println langs.getClass().name
println langs['C++']
println langs['Groovy']
println langs.Java
println langs.'C++'

langs.each {e ->
    println "$e.key:$e.value"
}
println langs

println langs.collect {l, a -> 
    l.replaceAll('[+]', 'P')
}

println langs.find {e -> e.key == 'C++'}

println langs.find {k, v -> k == 'C++'}