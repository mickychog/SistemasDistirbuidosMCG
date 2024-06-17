
mutation {
    prestarLibro(idLector: 1,idLibro: 1) {
        nombre
    		libroPrestado
    }
}

mutation {
    agregarLector(nombre:"Jorge Perez") {
        nombre
    }
}

mutation {
    agregarLibro(titulo:"Metro Last Ligth", autor:"Gregory Slerlenko") {
        titulo
				autor
    }
}